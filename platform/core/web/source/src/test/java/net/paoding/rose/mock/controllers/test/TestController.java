package net.paoding.rose.mock.controllers.test;

import net.paoding.rose.web.annotation.Intercepted;
//import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Intercepted//(allow = {"test1My","test2"})
//@Path("test")
public class TestController  {
	
    @Get("test111")
	public void testMethod() {
		System.out.println("invoke testMethod;");
	}
}
