package com.sinosoft.one.mvc.web.instruction.reply.transport.fastjon;

import org.apache.commons.lang3.ArrayUtils;

import com.alibaba.fastjson.serializer.PropertyFilter;

class ExcludesPropertyFilter implements PropertyFilter {
	private String[] excludes;
	
	public ExcludesPropertyFilter(String[] excludes) {
		this.excludes = excludes;
	}
	public boolean apply(Object source, String name, Object value) {
		if(ArrayUtils.contains(excludes, name)) {
			return false;
		}
		return true;
	}

}
