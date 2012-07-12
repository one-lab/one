package com.sinosoft.web.instruction.reply.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinosoft.web.instruction.reply.transport.jackson.JsonObjectMapper;

/**
 * @author Dhanji R. Prasanna (dhanji@gmail.com)
 */
//@Component
public class JacksonJsonTransport extends Json {

	private final JsonObjectMapper objectMapper = new JsonObjectMapper();

	public JacksonJsonTransport() {

	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public <T> T in(InputStream in, Class<T> type) throws IOException {
		return objectMapper.readValue(in, type);
	}

	public <T> void out(OutputStream out, Class<T> type, T data) {
		objectMapper.setDateFormat(getDateFormat());
		try {
			String[] propertyNames = getExcludes();
			boolean hasPropertyNames = false;
			if(ArrayUtils.isNotEmpty(propertyNames)) {
				objectMapper.withExcludes(propertyNames, type);
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
