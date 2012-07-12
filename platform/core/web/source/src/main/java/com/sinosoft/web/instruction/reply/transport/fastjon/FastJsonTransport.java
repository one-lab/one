package com.sinosoft.web.instruction.reply.transport.fastjon;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.sinosoft.web.instruction.reply.transport.Json;
@Component
class FastJsonTransport extends Json {
	

	@Override
	public <T> T in(InputStream in, Class<T> type) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void out(OutputStream out, Class<T> type, T data)
			throws IOException {
		SerializeWriter writer = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(writer);
		serializer.setDateFormat(getDateFormat());
		
		String[] propertyNames = getExcludes();
		if(ArrayUtils.isNotEmpty(propertyNames)) {
			serializer.getPropertyFilters().add(new ExcludesPropertyFilter(getExcludes()));
		} 
		propertyNames = getIncludes();
		if(ArrayUtils.isNotEmpty(propertyNames)) {
			serializer.getPropertyFilters().add(new IncludesPropertyFilter(getIncludes()));
		}
		
		serializer. write(data);
		String text = serializer.toString();
		out.write(text.getBytes("UTF-8"));
		out.close();
	}
}
