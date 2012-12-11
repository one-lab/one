package com.sinosoft.one.controllers;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-25
 * Time: 下午3:26
 * To change this template use File | Settings | File Templates.
 */
@Path
public class LoginController {
    @Get("/login")
    @Post("/login")
    public String loginGet(Invocation inv) {
        return "index";
    }
}
