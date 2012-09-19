package com.sinosoft.one.mvc.mock.controllers.modulepath1;

import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("")
public class IndexController {

    @Get
	public Object index() {
		return getClass();
	}
}
