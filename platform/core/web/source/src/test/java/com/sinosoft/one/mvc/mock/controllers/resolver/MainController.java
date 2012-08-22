package com.sinosoft.one.mvc.mock.controllers.resolver;

import com.sinosoft.one.mvc.mock.resolvers.Bean;
import com.sinosoft.one.mvc.mock.resolvers.BeanEx;
import com.sinosoft.one.mvc.mock.resolvers.Interface;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

import org.springframework.context.ApplicationContext;

public class MainController {

    @Get
    public String index(@Param("phone") Phone phone) {
        return phone.getId();
    }

    public String intf(Interface intf) {
        return intf.get();
    }

    public ApplicationContext ctx(ApplicationContext ctx) {
        return ctx;
    }

    public String bean(Bean bean) {
        return bean.get();
    }

    public Object beanex(BeanEx bean) {
        return bean;
    }
}
