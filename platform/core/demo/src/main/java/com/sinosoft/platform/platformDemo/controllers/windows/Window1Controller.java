package com.sinosoft.platform.platformDemo.controllers.windows;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("win1")
public class Window1Controller {
	
	@Get("m1")
	public String m1(Invocation inv){
		return "@is this portal? </br> 这就是portal吗？";
	}

}
