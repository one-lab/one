package com.sinosoft.one.mvc.mock.controllers.samepath.s1;

import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
@Path("{d:*}")
public class DController {

    @Get
    public String xx() {
        return "d";
    }
}
