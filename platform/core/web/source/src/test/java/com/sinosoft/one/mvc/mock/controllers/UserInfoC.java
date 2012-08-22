package com.sinosoft.one.mvc.mock.controllers;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

public class UserInfoC {

    @Get("{id:[0-9]+}")
    public int show(@Param("id") Integer id) {
        return id;
    }
}
