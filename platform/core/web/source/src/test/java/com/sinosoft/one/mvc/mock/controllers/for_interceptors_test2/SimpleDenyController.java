package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2;

import com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2.annotation.DenyAnnotation;
import com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2.annotation.RequiredAnnotation;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@RequiredAnnotation
public class SimpleDenyController {

    public static final String RETURN = "returned-by-SimpleDenyController";

    @Get
    @DenyAnnotation
    public String index() {
        return RETURN + ".index";
    }

    public String method() {
        return RETURN + ".method";
    }
}
