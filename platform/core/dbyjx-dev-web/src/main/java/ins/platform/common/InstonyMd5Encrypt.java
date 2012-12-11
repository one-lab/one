package ins.platform.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密算法
 */
public class InstonyMd5Encrypt {
	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	/**
	 * 检查校验MD5值，此方法会将最后一个值自动替换 ZhongTianzongConfig.KEY
	 * @param text 文本内容
	 * @param sign 分隔符
	 * @param key  银行保险双方约定key值串
	 * @return md5值
	 */
	public static String checkMd5(String text,String key, String sign) {
		StringBuffer sb = new StringBuffer();
		String[] str = text.split(sign);
		str[str.length-1] = key;		
		for (int i = 0;  i< str.length; i++) {
			str[i] = null==str[i]?"":str[i];
			sb.append(str[i]);
		}
		return md5(sb.toString());
	}
	
	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param text
	 *            明文
	 * 
	 * @return 密文
	 */
	public static String md5(String text) {
		MessageDigest msgDigest = null;
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(
					"System doesn't support MD5 algorithm.");
		}
		try {
			msgDigest.update(text.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(
					"System doesn't support your  EncodingException.");
		}
		byte[] bytes = msgDigest.digest();
		String md5Str = new String(encodeHex(bytes));
		return md5Str;
	}
	public static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}
	
//	public static void main(String[] args) {
//		//System.out.println("0cc175b9c0f1b6a831c399e269772661: \t"+InstonyMd5Encrypt.md5("a"));
////		System.out.println("d41d8cd98f00b204e9800998ecf8427e: \t"+InstonyMd5Encrypt.md5(""));
////		System.out.println("900150983cd24fb0d6963f7d28e17f72: \t"+InstonyMd5Encrypt.md5("abc"));
////		System.out.println("f96b697d7cb7938d525a2f31aaf161d0: \t"+InstonyMd5Encrypt.md5("message digest"));
////		System.out.println("c3fcd3d76192e4007dfb496cca67e13b: \t"+InstonyMd5Encrypt.md5("abcdefghijklmnopqrstuvwxyz"));
//		//System.out.println("f3aaf6f1cf87555e7242efcdf562c7cf: \t"+InstonyMd5Encrypt.md5("汉字a"));		
//	}
}
