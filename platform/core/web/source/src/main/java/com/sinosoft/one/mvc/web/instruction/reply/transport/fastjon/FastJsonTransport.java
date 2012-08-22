package com.sinosoft.one.mvc.web.instruction.reply.transport.fastjon;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.one.mvc.util.MvcObjectUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Charsets;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

@Component
class FastJsonTransport extends Json {

	public <T> void out(OutputStream out, T data)
			throws IOException {

        try {
            if(MvcObjectUtils.isPrimitiveOrString(data.getClass())) {
                out.write(String.valueOf(data).getBytes(Charsets.UTF_8.displayName()));
                return;
            }
            SerializeWriter writer = new SerializeWriter();
            JSONSerializer serializer = new JSONSerializer(writer);
            serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            serializer.setDateFormat(getDateFormat());
            String[] propertyNames = getExcludes();
            Map<String, List<String>> propertyNameMap = new HashMap<String, List<String>>();
            if(ArrayUtils.isNotEmpty(propertyNames)) {
                serializer.getPropertyFilters().add(new ExcludesPropertyFilter(getExcludes()));
                propertyNameMap = getCascadeNames(propertyNames);
            }
            propertyNames = getIncludes();
            if(ArrayUtils.isNotEmpty(propertyNames)) {
                serializer.getPropertyFilters().add(new IncludesPropertyFilter(getIncludes()));
                propertyNameMap = getCascadeNames(propertyNames);
            }
            if(!propertyNameMap.isEmpty()) {
                serializer.getValueFilters().add(new CascadeValueFilter(propertyNameMap));
            }

            serializer.write(data);
            String text = serializer.toString();
            out.write(text.getBytes(Charsets.UTF_8.displayName()));
        } finally {
            if(out != null) {
                out.close();
            }
        }
	}

	private Map<String, List<String>> getCascadeNames(String[] propertyNames) {
		Map<String, List<String>> cascadeNameMap = new HashMap<String, List<String>>();
		for(final String propertyName : propertyNames) {
			if(propertyName.contains(".")) {
				final String firstName = propertyName.split("\\.")[0];
				if(cascadeNameMap.containsKey(firstName)) {
					cascadeNameMap.get(firstName).add(propertyName);
				} else {
					cascadeNameMap.put(firstName, new ArrayList<String>() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						{
							add(propertyName);
						};
					});
				}
				
			}
		}
		return cascadeNameMap;
	}
}
