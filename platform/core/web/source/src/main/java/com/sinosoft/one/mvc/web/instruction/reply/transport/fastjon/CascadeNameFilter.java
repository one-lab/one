package com.sinosoft.one.mvc.web.instruction.reply.transport.fastjon;

import com.alibaba.fastjson.serializer.NameFilter;

class CascadeNameFilter implements NameFilter {
	private String[] propertyNames;
	
	public CascadeNameFilter(String[] propertyNames) {
		this.propertyNames = propertyNames;
	}

	public String process(Object source, String name, Object value) {
		StringBuffer strBuffer = new StringBuffer();
		for(String propertyName : propertyNames) {
			if(propertyName.indexOf(name) == 0) {
				strBuffer.append(propertyName).append(",");
			}
		}
		return strBuffer.substring(0, strBuffer.lastIndexOf(","));
	}

}
