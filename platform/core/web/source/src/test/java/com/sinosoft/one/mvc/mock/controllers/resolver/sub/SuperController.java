package com.sinosoft.one.mvc.mock.controllers.resolver.sub;

import com.sinosoft.one.mvc.mock.controllers.resolver.Phone;
import com.sinosoft.one.mvc.web.annotation.AsSuperController;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

// 测试超类定义的方法被子类访问时候参数Resolver是否正常
@AsSuperController
public abstract class SuperController {

    @Get
    public String get(@Param("phone") Phone phone) {
        if (phone == null) {
            return "superController.paramResolver";
        }
        return "ok";
    }
}
