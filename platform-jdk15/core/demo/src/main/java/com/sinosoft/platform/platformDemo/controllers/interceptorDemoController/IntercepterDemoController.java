package com.sinosoft.platform.platformDemo.controllers.interceptorDemoController;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Intercepted;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
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
