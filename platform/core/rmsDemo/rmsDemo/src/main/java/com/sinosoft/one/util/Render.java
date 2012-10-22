package com.sinosoft.one.rmsdemo.uiUtils;


import com.sun.deploy.net.HttpResponse;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-11
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */
public interface Render {
    void render(HttpResponse httpResponse);
    Render as(UIType uiType);
}
