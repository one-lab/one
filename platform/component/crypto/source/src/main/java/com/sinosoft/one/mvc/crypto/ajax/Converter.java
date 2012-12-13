package com.sinosoft.one.mvc.crypto.ajax;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-12
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
public class Converter {
    private HttpServletRequest request;
    private String cryptoAttributes;
    private Object obj;
    private String result;

    public Converter(HttpServletRequest request, String cryptoAttributes, Object obj) {
        this.request = request;
        this.cryptoAttributes = cryptoAttributes;
        this.obj = obj;
    }

    public Converter toJson(){
        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        //ajaxCryptoAttrNames是一个标志属性，它的属性值是后台加密的那些属性名（以逗号隔开），通知前端哪些属性需要解密
        jsonObject.put("ajaxCryptoAttrNames",cryptoAttributes);
        jsonArray.add(obj);
        jsonArray.add(jsonObject);
        result=jsonArray.toString();
        System.out.println(result);
        return this;
    }

    public void render(HttpServletResponse response) throws IOException {
        response.getWriter().write(result);
        response.flushBuffer();
    }
}
