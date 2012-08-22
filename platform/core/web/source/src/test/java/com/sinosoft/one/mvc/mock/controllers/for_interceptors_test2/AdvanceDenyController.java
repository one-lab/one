package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2;

import com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2.annotation.AdvanceDenyAnnotation;
import com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2.annotation.AdvanceRequiredAnnotation;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@AdvanceRequiredAnnotation
public class AdvanceDenyController {

    public static final String RETURN = "returned-by-AdvanceDenyController";

    @Get
    @AdvanceDenyAnnotation
    public String index() {
        return RETURN + ".index";
    }

    public String method() {
        return RETURN + ".method";
    }
}
