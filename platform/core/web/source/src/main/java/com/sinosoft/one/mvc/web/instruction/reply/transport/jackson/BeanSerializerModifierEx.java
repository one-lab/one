package com.sinosoft.one.mvc.web.instruction.reply.transport.jackson;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

final class BeanSerializerModifierEx extends BeanSerializerModifier {
	private static BeanSerializerModifierEx instance = new BeanSerializerModifierEx();
	private BeanSerializerModifierEx() {}
	private String[] propertyNames;
	private PropertyFilterType type;
	
	public static BeanSerializerModifierEx getInstance() {
		return instance;
	}
	
	public void setPropertyNames(String[] propertyNames) {
		this.propertyNames = propertyNames;
	}
	public void setType(PropertyFilterType type) {
		this.type = type;
	}
	
	
	@Override
	public List<BeanPropertyWriter> changeProperties(
			SerializationConfig config, BeanDescription beanDesc,
			List<BeanPropertyWriter> beanProperties) {
		for(Iterator<BeanPropertyWriter> it = beanProperties.iterator(); it.hasNext();) {
			String propertyName = it.next().getName();
			boolean isContains = ArrayUtils.contains(propertyNames, propertyName);
			if(this.type == PropertyFilterType.EXCLUDE && isContains) {
				it.remove();
			} else if(this.type == PropertyFilterType.INCLUDE && !isContains) {
				it.remove();
			}
		}
		return super.changeProperties(config, beanDesc, beanProperties);
	}
}
