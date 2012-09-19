package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test;

import com.sinosoft.one.mvc.web.annotation.Intercepted;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Intercepted(allow = { "block", "hack" })
@Path("block")
public class BlockController {

    @Get({ "", "index" })
	public Object index() {
		return "block-index";
	}
}
