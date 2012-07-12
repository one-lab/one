package com.sinosoft.platform.platformDemo.controllers.interceptorDemoController;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Intercepted;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
@Intercepted(deny = {"FristDemoInterceptor","SecondDemoInterceptor"})
@Path("/intercepter")
public class IntercepterDemoController {
	
	@Get("/ctrlMethod")
	public String ctrlMethod(Invocation inv){
		String str = inv.getModel("ctrl")+" invoking ctrlMethod</br>";
		inv.addModel("ctrl", str);
		return "index";
	}
}
