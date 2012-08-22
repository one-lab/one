package com.sinosoft.one.mvc.mock.controllers;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

public class UserInfoAction {

    @Get("hello/{id:[0-9]+}")
    public int hello(@Param("id") Integer id) {
        return id;
    }
}
