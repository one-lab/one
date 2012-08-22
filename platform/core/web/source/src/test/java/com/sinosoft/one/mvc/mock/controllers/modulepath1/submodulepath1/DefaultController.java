package com.sinosoft.one.mvc.mock.controllers.modulepath1.submodulepath1;

import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("")
public class DefaultController {

    @Get
    public Object index() {
        return getClass();
    }
}
