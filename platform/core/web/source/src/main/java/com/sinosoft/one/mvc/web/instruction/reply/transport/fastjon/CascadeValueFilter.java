package com.sinosoft.one.mvc.web.instruction.reply.transport.fastjon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.serializer.ValueFilter;

class CascadeValueFilter implements ValueFilter {
	private Map<String, List<String>> propertyNameMap;
	
	public CascadeValueFilter(Map<String, List<String>> propertyNameMap) {
		this.propertyNameMap = propertyNameMap;
	}

	public Object process(Object source, String name, Object value) {
		if(propertyNameMap.containsKey(name)) {
			List<String> subNames = propertyNameMap.get(name);
			if(subNames != null && subNames.size() > 0) {
				Object currentObject = value;
				Object resultObject = null;
				Map<String, Object> resultMap = new HashMap<String, Object>();
				for(int j=0, subNamesLen=subNames.size(); j<subNamesLen; j++) {
					String subName = subNames.get(j);
					String resultName = subName.substring(subName.indexOf(".") + 1);
					String[] subNameArray = subName.split("\\.");
					for(int i=1, len=subNameArray.length; i<len; i++) {
						try {
							String aSubName = subNameArray[i];
							resultObject = BeanUtils.getProperty(currentObject, aSubName);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
					resultMap.put(resultName, resultObject);
				}
				return resultMap;
			}
		}
		return value;
	}

}
