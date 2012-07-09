package net.paoding.rose.web.instruction.reply.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.paoding.rose.web.instruction.reply.transport.jackson.XmlObjectMapper;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

/**
 * @author Dhanji R. Prasanna (dhanji@gmail.com)
 */
@Component
class JacksonXmlTransport extends Xml {
  private final XmlObjectMapper xmlMapper = new XmlObjectMapper();

  public <T> T in(InputStream in, Class<T> type) throws IOException {
    return type.cast(xmlMapper.readValue(in, type));
  }

  public <T> void out(OutputStream out, Class<T> type, T data) {
	  xmlMapper.setDateFormat(getDateFormat());
		try {
			String[] propertyNames = getExcludes();
			boolean hasPropertyNames = false;
			if(ArrayUtils.isNotEmpty(propertyNames)) {
				xmlMapper.withExcludes(propertyNames, type);
				hasPropertyNames = true;
			} 
			propertyNames = getIncludes();
			if(ArrayUtils.isNotEmpty(propertyNames)) {
				xmlMapper.withIncludes(propertyNames);
				hasPropertyNames = true;
			}
			
			if(!hasPropertyNames) {
				xmlMapper.withNothing();
			}
			xmlMapper.flushCachedSerializers();
			xmlMapper.writeValue(out, data);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
  }
}