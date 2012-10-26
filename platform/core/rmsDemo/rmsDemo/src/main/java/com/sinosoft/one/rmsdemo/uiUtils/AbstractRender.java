package com.sinosoft.one.rmsdemo.uiUtils;

import org.webbitserver.HttpResponse;
import com.sun.xml.internal.ws.client.AsyncResponseImpl;
import org.springframework.beans.factory.ListableBeanFactory;
import org.webbitserver.wrapper.HttpResponseWrapper;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-12
 * Time: 上午11:17
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractRender<T extends UIable> implements Render {
    private Converter converter;
    private String result;
    private T t;

    public AbstractRender(Converter converter, T t){
        this.converter = converter;
        this.t = t;
    }

    public void render(HttpResponse httpResponse) {
        HttpResponse response = new HttpResponseWrapper(httpResponse);
        response.write(result);
    }

    public Render as(UIType uiType) {
        if (uiType == UIType.Json){
            result=converter.toJson(t);
        }else if(uiType == UIType.Xml){
            result=converter.toXml(t);
        }
        return this;
    }
}
