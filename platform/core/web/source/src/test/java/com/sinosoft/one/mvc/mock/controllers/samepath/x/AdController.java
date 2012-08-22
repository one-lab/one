package com.sinosoft.one.mvc.mock.controllers.samepath.x;

import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("")
public class AdController {

    @Get("ab")
    public String a() {
        return "a";
    }

    @Get("{d:*}")
    public String d() {
        return "d";
    }
}
