package com.sinosoft.one.mvc.mock.controllers.errorhandler.sub;

import com.sinosoft.one.mvc.web.annotation.rest.Get;

public class MainController {

    @Get
    public void index() {
        throw new IllegalArgumentException("main-sub");
    }
}
