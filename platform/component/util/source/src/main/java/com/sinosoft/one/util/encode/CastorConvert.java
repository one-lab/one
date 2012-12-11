package com.sinosoft.one.util.encode;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;


//import com.sinosoft.exception.SystemException;



public class CastorConvert {
	
	

	/**
	 * custor编码格式
	 */
	private String code = "GBK";
	
	public void setEncode(String code){
		this.code = code;
	}
	
	
	
	/**
	 * 缓存的文件Map数据
	 */
	private static Map fileMap = new HashMap();
	
	/**
	 * 对象转换为报文
	 * @param cardMapping
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public String  boToXml(Object xmlMapping,String fileName) {
		try {
			if (fileName==null){
				throw new IllegalArgumentException("xml映射文件名为空");
			}
			Mapping mapping = new Mapping();
			mapping.loadMapping(this.getFilePath(fileName));	        
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
			Writer writer = new OutputStreamWriter(byteArrayOutputStream, code);
			Marshaller marshaller = new Marshaller(writer);
			marshaller.setMapping(mapping);
			marshaller.setEncoding(code);
			marshaller.marshal(xmlMapping);
			return byteArrayOutputStream.toString(code);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 对象转换为报文
	 * @param cardMapping
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public String boToXml(Object xmlMapping,URL url){
		try {
	        Mapping mapping = new Mapping();
			mapping.loadMapping(url);	        
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
			Writer writer = new OutputStreamWriter(byteArrayOutputStream, code);
			Marshaller marshaller = new Marshaller(writer);
			marshaller.setMapping(mapping);
			marshaller.setEncoding(code);
			marshaller.marshal(xmlMapping);
			return byteArrayOutputStream.toString(code);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 将返回报文转换为业务对象
	 * @param responseXml
	 * @param fileName
	 * @throws Exception
	 */
	public  Object xmlToBO(String responseXml,String fileName){
		try {
			if (fileName==null){
				throw new IllegalArgumentException("xml映射文件名为空");
			}
			Mapping map = new Mapping();
			map.loadMapping(this.getFilePath(fileName));
			Reader reader = new StringReader(responseXml);
			Unmarshaller unmarshaller = new Unmarshaller(map);
			return unmarshaller.unmarshal(reader);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 将返回报文转换为业务对象
	 * @param responseXml
	 * @param fileName
	 * @throws Exception
	 */
	public Object xmlToBO(String responseXml,URL url){
		try {
			Mapping map = new Mapping();
			map.loadMapping(url);
			Reader reader = new StringReader(responseXml);
			Unmarshaller unmarshaller = new Unmarshaller(map);
			return  unmarshaller.unmarshal(reader);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取指定文件名路径
	 * @param fileName
	 * @return
	 * @throws MalformedURLException 
	 */
	public URL getFilePath(String fileName) throws MalformedURLException{
		 File file = (File)fileMap.get(fileName);
		 if(file==null){
			 File newFile = new File(fileName);
			 fileMap.put(fileName,newFile);
			 return newFile.toURL();
		 }else{
			 return file.toURL();
		 }
	}
	
	
}
