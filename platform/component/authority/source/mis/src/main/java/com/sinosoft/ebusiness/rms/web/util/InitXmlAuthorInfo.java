package com.sinosoft.ebusiness.rms.web.util ;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;  
public class InitXmlAuthorInfo {
	//加载配置文件
	private static Document getDom(String xmlPath) {
		try {
			SAXReader reader = new SAXReader();
			Document document = null;
			document = reader.read(new File(xmlPath));
			return document;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//解析配置文件
	@SuppressWarnings("unchecked")
	public static HashMap<String, String> getAuthorityMap(String xmlPath) {
		HashMap<String, String> authorityMap = new HashMap<String, String>();
		Document document = getDom(xmlPath);
		Element rootElm = document.getRootElement();
		for (Iterator<Element> i = rootElm.elementIterator(); i.hasNext();) {
			Element element = (Element) i.next();
			String id = element.attributeValue("id");
			List<Element> temp = element.elements();
			for (int j = 0, length = temp.size(); j < length; j++) {
				String actionName = temp.get(j).attribute("name").getText();
				// action是否重名
				if (authorityMap.containsKey(actionName)) {
					authorityMap.put(actionName, authorityMap.get(actionName)
							+ " " + id);
				} else {
					authorityMap.put(actionName, id);
				}
			}
		}
		return authorityMap;
	}
}

