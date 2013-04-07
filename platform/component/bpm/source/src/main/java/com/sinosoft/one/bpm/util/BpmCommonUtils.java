package com.sinosoft.one.bpm.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

public final class BpmCommonUtils {
	private BpmCommonUtils() {}
	
	public static String parseAttributeValue(Object bean, String attributeName) throws Exception  {
    	String value = "";
        if (BeanUtils.isSimpleProperty(bean.getClass())) {
        	value = bean.toString();
        } else {
        	if(StringUtils.isBlank(attributeName)) {
        		throw new IllegalArgumentException("the attribute value [" + attributeName + "] is invalid.");
        	}
        	value = PropertyUtils.getProperty(bean, attributeName)
                    .toString();
        }
        return value;
    }
	
	public static String parseAttributeValue(Object[] args, int attributeOffset, String attributeName) throws Exception {
		return parseAttributeValue(args[attributeOffset], attributeName);
	}
	
	public static boolean hasText(CharSequence cs, String errorMessage) {
		if(StringUtils.isBlank(cs)) {
			throw new IllegalArgumentException(
					errorMessage);
		}
		return Boolean.TRUE.booleanValue();
	}
}
