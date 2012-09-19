package com.sinosoft.one.mvc.mock.controllers.test;

import com.sinosoft.one.mvc.web.annotation.Intercepted;
//import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Intercepted//(allow = {"test1My","test2"})
//@Path("test")
public class TestController  {
	
    @Get("test111")
	public void testMethod() {
		System.out.println("invoke testMethod;");
	}
}
