package com.sinosoft.one.mvc.mock.controllers;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("{user.id}/order")
public class OrderController {

    public String list(@Param("user.id") Long userId) {
        return "list/" + userId;
    }

    @Get("$id")
    public String show(@Param("user.id") Long userId, @Param("id") String id) {
        return "show/" + userId + "/" + id;
    }

    @Get
    public String def() {
        return "def";
    }
}
