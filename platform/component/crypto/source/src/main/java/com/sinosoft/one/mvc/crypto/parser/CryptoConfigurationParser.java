package com.sinosoft.one.mvc.crypto.parser;

import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.crypto.config.UnCrypto;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-28
 * Time: 上午12:32
 * To change this template use File | Settings | File Templates.
 */
public class CryptoConfigurationParser {
    private static File configFile;
    public static File getConfigFile() {
        return configFile;
    }
    private Logger logger = LoggerFactory.getLogger(CryptoConfigurationParser.class);
    public void parserCryptoConfiguration(String configLocation) {
        try {
            CryptoConfig cryptoConfig = CryptoConfig.getInstance();
            cryptoConfig.getUncryptoMap().clear();
            File file = ResourceUtils.getFile(configLocation);
            if(file.exists()) {
                configFile = file;
            } else {
                throw new IllegalArgumentException("the config location [" + configLocation +"] is not exists");
            }
            SAXReader reader = new SAXReader();

            Document document = reader.read(file);
            Element root = document.getRootElement();
            for(Iterator<Element> it = root.elementIterator();it.hasNext();){
                Element el = it.next();
                String url = el.attributeValue(new QName("url"));
                if(el.getName().equalsIgnoreCase("uncrypto")) {
                    UnCrypto unCrypto = new UnCrypto(url);
                    cryptoConfig.addUnCrypto(url, unCrypto);
                }
            }
        } catch (Exception e) {
            logger.error("parser crypto config file error. the file location is " + configLocation, e);
        }
    }
}
