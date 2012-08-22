package com.sinosoft.one.mvc.mock.controllers.validators;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;

@Path("")
public class DefaultController {

    public int hello(@Param("p") int p) {
        return p;
    }
}
