package com.sinosoft.one.mvc.mock.controllers.samepath.x;

import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("")
public class BcController {

    @Get("ab{b:*}")
    public String b() {
        return "b";
    }

    @Get("a{c:*}")
    public String c() {
        return "c";
    }
}
