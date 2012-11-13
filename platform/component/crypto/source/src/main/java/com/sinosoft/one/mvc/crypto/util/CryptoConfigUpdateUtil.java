package com.sinosoft.one.mvc.crypto.util;

import com.sinosoft.one.mvc.crypto.config.Crypto;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.crypto.config.UnCrypto;
import com.sinosoft.one.mvc.crypto.filter.CryptoFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 更新Crypto配置的工具类
 * User: Morgan
 * Date: 12-11-13
 * Time: 下午2:38
 */
public final class CryptoConfigUpdateUtil {

	private static Log logger = LogFactory.getLog(CryptoConfigUpdateUtil.class);

	private static final String UNCRYPTO_ELEMENT_NAME = "uncrypto";
	private static final String CRYPTO_ELEMENT_NAME = "crypto";
	private static final String CRYPTO_CHILD_NAME = "property";
	private static final String CRYPTO_CHILD_ATTR_INCLUDES = "includes";
	private static final String CRYPTO_CHILD_ATTR_EXCLUDES = "excludes";
	private static final String CRYPTO_CHILD_ATTR_NAME = "name";

	static String tempPath = "D:/git-source/platform-repo/platform/component/crypto/demo/src/main/webapp/WEB-INF/crypto/crypto_config.xml";

	public static void main(String[] args) {


		try {
//			saveUnCryptoConfig("/demo/test/save4","/demo/test/save2","/demo/test/save3");
//			deleteUnCryptoConfig("/demo/test/save");
//			List<Crypto> list = new ArrayList<Crypto>();
//			list.add(new Crypto("/demo/views/a.jsp","id,name",null,"testname"));
//			list.add(new Crypto("/demo/views/a.jsp",null,"id,name","testname"));
//			list.add(new Crypto("/demo/views/a.jsp","id,name",null,"testname"));
//			saveCryptoConfig("/demo/views/a.jsp", list);
			deleteCryptoConfigs("/demo/views/a.jsp","/demo/ajax");
		} catch (FileNotFoundException e) {

		}


	}

	public static void deleteCryptoConfigs(String... urls) throws FileNotFoundException {
		InputStream is = new FileInputStream(tempPath);
		XMLWriter writer = null;
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(is);
			Element root = document.getRootElement();
			for( String url : urls ) {
				boolean canDelete = false;
				for(Iterator<Element> it = root.elementIterator();it.hasNext();){
					Element el = it.next();
					String oldurl = el.attributeValue(new QName("url"));
					if(el.getName().equalsIgnoreCase(CRYPTO_ELEMENT_NAME) && url.equals(oldurl)){
						canDelete = true;
						root.remove(el);
					}
				}
				if(canDelete){
					CryptoConfig.getInstance().deleteCrypto(url);
				}
			}
			writer = new XMLWriter(new FileWriter(tempPath), getOutPutFormat());
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public static void saveCryptoConfig(String url,List<Crypto> cryptos) throws FileNotFoundException {
		InputStream is = new FileInputStream(tempPath);
		XMLWriter writer = null;
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(is);
			Element root = document.getRootElement();

			boolean isOld = false;
			for(Iterator<Element> it = root.elementIterator();it.hasNext();){
				Element el = it.next();
				String oldurl = el.attributeValue(new QName("url"));
				if(url.equals(oldurl) && el.getName().equalsIgnoreCase(CRYPTO_ELEMENT_NAME)){
					isOld = true;
					break;
				}
			}
			if(!isOld) {
				Element ecrypto = root.addElement(CRYPTO_ELEMENT_NAME).addAttribute("url", url);
				for( Crypto cry : cryptos ) {
					CryptoConfig.getInstance().addCrypto(url, cry);
					Element property = ecrypto.addElement(CRYPTO_CHILD_NAME).addAttribute(CRYPTO_CHILD_ATTR_NAME, cry.getName());
					if(cry.getIncludes() != null) {
						property.addAttribute(CRYPTO_CHILD_ATTR_INCLUDES,cry.getIncludes());
					} else if(cry.getExcludes() != null) {
						property.addAttribute(CRYPTO_CHILD_ATTR_EXCLUDES,cry.getExcludes());
					}

				}
			}

			writer = new XMLWriter(new FileWriter(tempPath), getOutPutFormat());
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	private static OutputFormat getOutPutFormat() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");// 设置XML文件的编码格式
		format.setIndentSize(4);
		return format;
	}

	public static void deleteUnCryptoConfigs(String... urls) throws FileNotFoundException {
		InputStream is = new FileInputStream(tempPath);
		XMLWriter writer = null;
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(is);
			Element root = document.getRootElement();
			for( String url : urls ) {
				boolean canDelete = false;
				for(Iterator<Element> it = root.elementIterator();it.hasNext();){
					Element el = it.next();
					String oldurl = el.attributeValue(new QName("url"));
					if(el.getName().equalsIgnoreCase(UNCRYPTO_ELEMENT_NAME) && url.equals(oldurl)){
						canDelete = true;
						root.remove(el);

					}
				}
				if(canDelete){
					CryptoConfig.getInstance().deleteUnCrypto(url);
				}
			}
			writer = new XMLWriter(new FileWriter(tempPath), getOutPutFormat());
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public static void saveUnCryptoConfig(String... urls) throws FileNotFoundException {
		InputStream is = new FileInputStream(tempPath);
		XMLWriter writer = null;
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");// 设置XML文件的编码格式

		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(is);
			Element root = document.getRootElement();
			for( String url : urls ) {
				boolean isOld = false;
				for(Iterator<Element> it = root.elementIterator();it.hasNext();){
					Element el = it.next();
					String oldurl = el.attributeValue(new QName("url"));
					if(url.equals(oldurl)){
						isOld = true;
						break;
					}
				}
				if(isOld)
					continue;

				UnCrypto unCrypto = new UnCrypto(url);
				CryptoConfig.getInstance().addUnCrypto(url, unCrypto);
				root.addElement(UNCRYPTO_ELEMENT_NAME).addAttribute("url", url);
			}
			writer = new XMLWriter(new FileWriter(tempPath), format);
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
