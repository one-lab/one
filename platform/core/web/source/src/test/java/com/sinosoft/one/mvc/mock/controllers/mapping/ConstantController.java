package com.sinosoft.one.mvc.mock.controllers.mapping;

import com.sinosoft.one.mvc.web.annotation.rest.Get;

public class ConstantController {

    @Get("/mn/show")
    public String xx() {
        return "xx:mn/show";
    }

    @Get("$1")
    public String def(String def) {
        return def;
    }

}
