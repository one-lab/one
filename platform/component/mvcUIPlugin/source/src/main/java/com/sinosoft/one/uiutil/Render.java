package com.sinosoft.one.uiutil;


import com.sinosoft.one.uiutil.exception.ConverterException;

import javax.servlet.http.HttpServletResponse;


public interface Render {

    /**
     * 获取转换结果
     * @return
     */
    String getConvertResult();

    void render(HttpServletResponse response);

    Render as(UIType uiType);

    Render encoding(String encode);
}