package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test;

import com.sinosoft.one.mvc.web.annotation.Intercepted;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Intercepted(allow = { "advanced", "block", "hack" })
public class AdvancedController {

    @Get( { "", "index" })
    public Object index() {
        return "advanced-block-index";
    }
}
