package com.sinosoft.one.mvc.web.instruction.reply.transport.xstream;

import com.google.common.base.Charsets;
import com.sinosoft.one.mvc.util.MvcObjectUtils;
import com.sinosoft.one.mvc.web.instruction.reply.transport.AbstractTransport;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Xml;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

/**
 * xstream xml transport
 * User: carvin
 * Date: 12-7-31
 * Time: 下午8:08
 * The transport not implements Collection's excludes and includes
 */
@Component
class XStreamXmlTransport extends Xml {
    private XStream stream = new XStream();
    public <T> void out(OutputStream out, T data) throws IOException {
        try {
            if(MvcObjectUtils.isPrimitiveOrString(data.getClass())) {
                out.write(String.valueOf(data).getBytes(Charsets.UTF_8.displayName()));
                return;
            }
            String[] propertyNames = getExcludes();
            Class<T> clazz = (Class<T>) data.getClass();
            stream.registerConverter(new DateConverter(getDateFormatString()));
            if(ArrayUtils.isNotEmpty(propertyNames)) {
                for(String propertyName : propertyNames) {
                    stream.omitField(clazz, propertyName);
                }
            }
            stream.toXML(data, out);
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }
}
