package com.sinosoft.one.uiUtils;


import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-11
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */
public interface Render {
    void render(HttpServletResponse response);

    Render as(UIType uiType);
}
