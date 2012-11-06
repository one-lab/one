package com.sinosoft.one.uiutil;

import com.sinosoft.one.uiutil.exception.ConverterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-12
 * Time: 上午11:17
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractRender<T extends UIable> implements Render {
    private static Log log = LogFactory.getLog(AbstractRender.class);
    private Converter converter;
    private String result;
    private T t;

    public AbstractRender(Converter converter, T t) {
        this.converter = converter;
        this.t = t;
    }

    public void render(HttpServletResponse response) {
        try {
            log.info("return the json result to the client.");
            response.getWriter().write(result);
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Render as(UIType uiType) throws ConverterException {
        if (uiType == UIType.Json) {
            result = converter.toJson(t);
            log.info("the json string is:" + result);
        } else if (uiType == UIType.Xml) {
            result = converter.toXml(t);
            log.info("the json string is:" + result);
        }
        return this;
    }

    public String getResultForTest() {
        return result;
    }
}
