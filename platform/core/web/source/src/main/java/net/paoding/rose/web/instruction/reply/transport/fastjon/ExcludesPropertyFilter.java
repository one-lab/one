package net.paoding.rose.web.instruction.reply.transport.fastjon;

import org.apache.commons.lang3.ArrayUtils;

import com.alibaba.fastjson.serializer.PropertyFilter;

public class ExcludesPropertyFilter implements PropertyFilter {
	private String[] excludes;
	
	public ExcludesPropertyFilter(String[] excludes) {
		this.excludes = excludes;
	}
	@Override
	public boolean apply(Object source, String name, Object value) {
		if(ArrayUtils.contains(excludes, name)) {
			return false;
		}
		return true;
	}

}
