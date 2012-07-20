package com.sinosoft.one.mvc.web.instruction.reply.transport.jackson;

import java.io.IOException;
import java.io.OutputStream;

import com.google.common.base.Charsets;
import com.sinosoft.one.mvc.util.MvcObjectUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import com.sinosoft.one.mvc.web.instruction.reply.transport.Xml;

/**
 * @author Dhanji R. Prasanna (dhanji@gmail.com)
 */
@Component
class JacksonXmlTransport extends Xml {
  private final XmlObjectMapper xmlMapper = new XmlObjectMapper();

  public <T> void out(OutputStream out, T data) throws IOException {
    if(MvcObjectUtils.isPrimitiveOrString(data.getClass())) {
      out.write(String.valueOf(data).getBytes(Charsets.UTF_8));
      return;
    }
    xmlMapper.setDateFormat(getDateFormat());
    String[] propertyNames = getExcludes();
    boolean hasPropertyNames = false;
    if(ArrayUtils.isNotEmpty(propertyNames)) {
        xmlMapper.withExcludes(propertyNames);
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
  }
}