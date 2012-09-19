package com.sinosoft.one.mvc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * 解析XML文件
 * @author kylin
 *
 */
public final class ResourceLoaderUtil {
	
	private static Log logger = LogFactory.getLog(ResourceLoaderUtil.class);
	private static Map<String,File> fileMap = new HashMap<String, File>();
	/**
	 * 解析简单的单一根节点两层结构的XML文件
	 * @param resourceLocation
	 * @param readCachePrior
	 * @return org.w3c.dom.Document
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static List<String> getResource(String resourceLocation, boolean readCachePrior) throws ParserConfigurationException, SAXException, IOException  {
		Assert.notNull(resourceLocation, "Resource fileName must not be null");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbd = dbf.newDocumentBuilder();
		File tempFile = null;
		try{
			if(readCachePrior){
				if(fileMap.isEmpty()){
					tempFile = ReadResouceFile(resourceLocation);
				}else{
					if(fileMap.get(resourceLocation).exists()){
						tempFile = fileMap.get(resourceLocation);
					}else {
						tempFile = ReadResouceFile(resourceLocation);
					}
				}
			}else{
				tempFile = ReadResouceFile(resourceLocation);
			}
		}catch (FileNotFoundException e) {
			logger.warn("FileNotFound:"+resourceLocation);
			return null;
		}
		Document doc = dbd.parse(tempFile);
		Element root = doc.getDocumentElement();
		NodeList nodes = root.getChildNodes();
		List<String> rList = new ArrayList<String>();
		for(int i = 0, len = nodes.getLength(); i<len; i++ ){
			String nodeTest = nodes.item(i).getTextContent();
			if(StringUtils.isNotBlank(nodeTest)){
				rList.add(nodeTest);
			}
		}
		
		return rList;
	}
	
	private static File ReadResouceFile(String resourceLocation) throws FileNotFoundException{
		File tempFile = ResourceUtils.getFile("classpath:"+resourceLocation);
		fileMap.put(resourceLocation, tempFile);
		return tempFile;
	}
}
