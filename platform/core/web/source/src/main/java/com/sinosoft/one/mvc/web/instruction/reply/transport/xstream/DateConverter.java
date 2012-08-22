package com.sinosoft.one.mvc.web.instruction.reply.transport.xstream;

import com.sinosoft.one.mvc.util.DateFormatMode;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-7-31
 * Time: 下午8:15
 * To change this template use File | Settings | File Templates.
 */
class DateConverter implements Converter {
    public DateConverter() {
        dateFormatString = DateFormatMode.YYYYMMDDHHMMSS.toString();
    }

    public DateConverter(String dateFormatString) {
        this.dateFormatString = dateFormatString;
    }
    private String dateFormatString;
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        if(source instanceof Date) {
            writer.setValue(DateFormatUtils.format((Date)source, dateFormatString));
        } else if(source instanceof Calendar) {
            writer.setValue(DateFormatUtils.format((Calendar)source, dateFormatString));
        }

    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean canConvert(Class type) {
        return type.isAssignableFrom(Date.class) || type.isAssignableFrom(Calendar.class);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
