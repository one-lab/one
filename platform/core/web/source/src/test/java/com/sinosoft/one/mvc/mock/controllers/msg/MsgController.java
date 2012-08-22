package com.sinosoft.one.mvc.mock.controllers.msg;

import java.util.Locale;

import com.sinosoft.one.mvc.web.InvocationLocal;
import com.sinosoft.one.mvc.web.annotation.DefValue;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

@Path("")
public class MsgController {

    @Autowired
    InvocationLocal inv;

    @Get("$1")
    public String hello(String key, String[] args, @Param("loc") @DefValue("zh_CN") Locale lo) {
        return inv.getApplicationContext().getMessage(key, args, lo);
    }
}
