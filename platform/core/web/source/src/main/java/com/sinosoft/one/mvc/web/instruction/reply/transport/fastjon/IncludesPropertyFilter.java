package com.sinosoft.one.mvc.web.instruction.reply.transport.fastjon;

import com.alibaba.fastjson.serializer.PropertyFilter;

class IncludesPropertyFilter implements PropertyFilter {
	private String[] includes;
	
	public IncludesPropertyFilter(String[] includes) {
		this.includes = includes;
	}
	public boolean apply(Object source, String name, Object value) {
		for(String include : includes) {
			if(include.trim().indexOf(name) == 0) {
				return true;
			}
		}
		return false;
	}

}
