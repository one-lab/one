package com.sinosoft.one.uiutil;

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
    private Converter converter;
    private String result;
    private T t;

    public AbstractRender(Converter converter, T t) {
        this.converter = converter;
        this.t = t;
    }

    public void render(HttpServletResponse response) {
        try {
            response.getWriter().write(result);
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Render as(UIType uiType) {
        if (uiType == UIType.Json) {
            result = converter.toJson(t);
            System.out.println("结果："+"\n"+result);
        } else if (uiType == UIType.Xml) {
            result = converter.toXml(t);
        }
        return this;
    }
}
