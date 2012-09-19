package com.sinosoft.one.mvc.mock.controllers.samepath.s2;

import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
@Path("a{c:*}")
public class CController {

    @Get
    public String xx() {
        return "c";
    }
}
