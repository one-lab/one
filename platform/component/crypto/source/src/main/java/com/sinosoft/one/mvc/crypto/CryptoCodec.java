package com.sinosoft.one.mvc.crypto;


import com.sinosoft.one.mvc.crypto.core.ASCII;
import com.sinosoft.one.mvc.crypto.core.HEX;
import com.sinosoft.one.mvc.crypto.core.XXTEA;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.nio.IntBuffer;
import java.security.MessageDigest;
import java.util.Random;

/**
 * User: Morgan
 * Date: 12-11-7
 * Time: 上午9:34
 */
public final class CryptoCodec {

	private static Log log = LogFactory.getLog(CryptoCodec.class);

//	public static String encode(String sid,String uid,String data ) {
//
//		return encode(sid+uid,data,false);
//
//	}

//	public static String encode(String stringKey, String data, boolean isMd5) {
//		if(isMd5) {
//			return encode(stringKey,data);
//		}
//		return encode(toMD5(stringKey),data);
//
//	}

	public static String encode(String key,String data) {
		//base64一次
		data = org.apache.commons.codec.binary.Base64.encodeBase64String(data.getBytes());
		//将key转换成intbuffer
		IntBuffer intKey = HEX.decodeHexAsInts(key);

		IntBuffer java_buffer = ASCII.toIntBuffer(data);
		XXTEA.encryptInPlace(java_buffer, intKey);
		//将加密后的intbuffer base64一次
		String crpydata = com.sinosoft.one.mvc.crypto.core.Base64.encodeBase64String(java_buffer);
		if(log.isDebugEnabled()) {
			log.debug("key:"+key);
			log.debug("first base64:"+data);
			log.debug("second base64"+crpydata);
		}


		return crpydata;
	}

//	public static String decode(String key, String cryptoData, int flag) throws UnsupportedEncodingException{
//
//		return decode(toMD5(key),cryptoData);
//	}

	public static String[] decode(String md5Key,String cryptoData[]) {
		int length = cryptoData.length;
		String[] result = new String[length];
		for(int i=0;i<length;i++) {
			result[i] = decode(md5Key,cryptoData[i]);
		}
		return result;
	}

	public static String decode(String md5Key, String cryptoData){

		IntBuffer intKey = HEX.decodeHexAsInts(md5Key);
		IntBuffer java_buffer = com.sinosoft.one.mvc.crypto.core.Base64.decodeBase64(cryptoData).asIntBuffer();
		XXTEA.decryptInPlace(java_buffer, intKey);

		String java_clear = ASCII.fromIntBuffer(java_buffer);

		String clearData = null;
		try {
			clearData = new String(org.apache.commons.codec.binary.Base64.decodeBase64(java_clear),"utf-8");
		} catch (UnsupportedEncodingException e) {
			log.error("UnsupportedEncodingException",e);

		}
		if(log.isDebugEnabled()) {
			log.debug("key:"+md5Key);
			log.debug("cryptoData:"+cryptoData);
			log.debug("clearData"+java_clear);
		}
		return clearData;

	}

	private static String toMD5(String id) {
		char hexDigits[] = {'0', '1', '2', '3', '4',
				'5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F'};
		try {
			byte[] btInput = id.getBytes();
			//获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			//使用指定的字节更新摘要
			mdInst.update(btInput);
			//获得密文
			byte[] md = mdInst.digest();
			//把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getCryptoKey(String md5) {
		int random1 = (int) (new Random().nextDouble() * 16) + 16;
		int random2 = (int) (new Random().nextDouble() * 16);
		String new1 = md5.substring(random1);
		md5 = md5.substring(0,random1);
		String new2 = md5.substring(random2);
		md5 = md5.substring(0,random2);
		return  new1 + new2 + md5;
	}

	public static void main(String args[]) {
		String md5 = toMD5("1123");
		String cryptokey = getCryptoKey(md5);
	}
}
