package com.sinosoft.platform.platformDemo.controllers.windows;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("win1")
public class Window1Controller {
	
	@Get("m1")
	public String m1(Invocation inv){
		return "@is this portal? </br> 这就是portal吗？";
	}

}
