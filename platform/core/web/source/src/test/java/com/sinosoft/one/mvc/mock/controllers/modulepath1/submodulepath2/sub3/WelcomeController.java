package com.sinosoft.one.mvc.mock.controllers.modulepath1.submodulepath2.sub3;

import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("")
public class WelcomeController {

    @Get
    public Object index() {
        return getClass();
    }
}
