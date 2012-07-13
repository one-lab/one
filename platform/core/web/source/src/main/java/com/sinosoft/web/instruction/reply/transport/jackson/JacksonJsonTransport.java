package com.sinosoft.web.instruction.reply.transport.jackson;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinosoft.web.instruction.reply.transport.Json;

/**
 * @author Dhanji R. Prasanna (dhanji@gmail.com)
 */
//@Component
class JacksonJsonTransport extends Json {

	private final JsonObjectMapper objectMapper = new JsonObjectMapper();

	public JacksonJsonTransport() {

	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public <T> void out(OutputStream out, T data) {
		objectMapper.setDateFormat(getDateFormat());
		try {
			String[] propertyNames = getExcludes();
			boolean hasPropertyNames = false;
			if(ArrayUtils.isNotEmpty(propertyNames)) {
				objectMapper.withExcludes(propertyNames);
				hasPropertyNames = true;
			} 
			propertyNames = getIncludes();
			if(ArrayUtils.isNotEmpty(propertyNames)) {
				objectMapper.withIncludes(propertyNames);
				hasPropertyNames = true;
			}
			
			if(!hasPropertyNames) {
				objectMapper.withNothing();
			}
			objectMapper.flushCachedSerializers();
			objectMapper.writeValue(out, data);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
