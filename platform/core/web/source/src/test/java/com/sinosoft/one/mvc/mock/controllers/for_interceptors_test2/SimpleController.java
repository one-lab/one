package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2;

import com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2.annotation.RequiredAnnotation;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

public class SimpleController {

    public static final String RETURN = "returned-by-SimpleController";

    @Get
    public String index() {
        return RETURN + ".index";
    }

    @RequiredAnnotation
    public String method() {
        return RETURN + ".method";
    }
}
