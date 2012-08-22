package com.sinosoft.one.mvc.mock.controllers.intercetorsAnnotatedBySuper;

import com.sinosoft.one.mvc.web.annotation.rest.Get;

public class AllowController extends AllowBaseController {

    @Get
	public void index() {

	}
}
