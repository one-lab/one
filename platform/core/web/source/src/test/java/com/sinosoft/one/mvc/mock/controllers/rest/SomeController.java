package com.sinosoft.one.mvc.mock.controllers.rest;

import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

public class SomeController {

    @Get
    public String haha() {
        return "get";
    }

    @Post
    public String gaga() {
        return "post";
    }
}
