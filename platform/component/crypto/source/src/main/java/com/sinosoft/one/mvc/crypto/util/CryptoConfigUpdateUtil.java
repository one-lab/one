package com.sinosoft.one.mvc.crypto.util;

import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.crypto.config.UnCrypto;
import com.sinosoft.one.mvc.crypto.filter.CryptoFilter;
import com.sinosoft.one.mvc.crypto.parser.CryptoConfigurationParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * 更新Crypto配置的工具类
 * User: Morgan
 * Date: 12-11-13
 * Time: 下午2:38
 */
public final class CryptoConfigUpdateUtil {

    private CryptoConfigUpdateUtil() {}

	private static Logger logger = LoggerFactory.getLogger(CryptoConfigUpdateUtil.class);

	private static final String UNCRYPTO_ELEMENT_NAME = "uncrypto";

	private static void writeConfigFile(Document document) throws IOException {
		XMLWriter writer = new XMLWriter(new FileWriter(CryptoConfigurationParser.getConfigFile()), getOutPutFormat());
		writer.write(document);
		writer.close();
	}


	private static OutputFormat getOutPutFormat() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");// 设置XML文件的编码格式
		format.setIndentSize(4);
		return format;
	}

	public static void deleteUnCryptoConfigs(String... urls){
		try {
			Document document = new SAXReader().read(CryptoConfigurationParser.getConfigFile());
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
			writeConfigFile(document);
		} catch (DocumentException e) {
			logger.error("deleteUnCryptoConfigs exception.", e);
		} catch (IOException e) {
            logger.error("deleteUnCryptoConfigs exception.", e);
		}
	}

	public static void saveUnCryptoConfig(String... urls) {
		try {
			Document document = new SAXReader().read(CryptoConfigurationParser.getConfigFile());
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
			writeConfigFile(document);
		} catch (DocumentException e) {
            logger.error("saveUnCryptoConfig exception.", e);
		} catch (IOException e) {
            logger.error("saveUnCryptoConfig exception.", e);
		}
	}
}
