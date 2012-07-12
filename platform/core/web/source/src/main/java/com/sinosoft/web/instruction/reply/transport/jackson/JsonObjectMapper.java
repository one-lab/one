package com.sinosoft.web.instruction.reply.transport.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;

public class JsonObjectMapper extends ObjectMapper {
	public void withExcludes(final String[] excludes, Class<?> type)
	        throws IOException, JsonGenerationException, JsonMappingException {
		BeanSerializerModifierEx excludesBeanSerializerModifierEx = BeanSerializerModifierEx.getInstance();
		excludesBeanSerializerModifierEx.setPropertyNames(excludes);
		excludesBeanSerializerModifierEx.setType(PropertyFilterType.EXCLUDE);
		_serializerFactory = _serializerFactory.withSerializerModifier(excludesBeanSerializerModifierEx);
	}
	
	public void withIncludes(final String[] includes)
	        throws IOException, JsonGenerationException, JsonMappingException {
		BeanSerializerModifierEx includesBeanSerializerModifierEx = BeanSerializerModifierEx.getInstance();
		includesBeanSerializerModifierEx.setPropertyNames(includes);
		includesBeanSerializerModifierEx.setType(PropertyFilterType.INCLUDE);
		_serializerFactory = _serializerFactory.withSerializerModifier(includesBeanSerializerModifierEx);
		
	}
	
	public void withNothing()
	        throws IOException, JsonGenerationException, JsonMappingException {
		_serializerFactory = BeanSerializerFactory.instance;
	}
	
	public void flushCachedSerializers(){
		_serializerProvider.flushCachedSerializers();
	}
	
}
