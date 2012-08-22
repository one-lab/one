package com.sinosoft.one.mvc.mock.controllers.intercetorsAnnotatedBySuper;

import com.sinosoft.one.mvc.web.annotation.Intercepted;

@Intercepted(allow = "tail")
public abstract class AllowBaseController {

}
