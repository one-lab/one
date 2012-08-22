package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2;

import com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2.annotation.AdvanceRequiredAnnotation;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

public class AdvanceController {

    public static final String RETURN = "returned-by-AdvanceController";

    @Get
    public String index() {
        return RETURN + ".index";
    }

    @AdvanceRequiredAnnotation
    public String method() {
        return RETURN + ".method";
    }
}
