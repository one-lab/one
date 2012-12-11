package com.sinosoft.one.ams.controllers.staffing;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("user")
public class GeRmsUserController {
	
	@Get("userinfo/{name}/{number}")
	public String chuandi(@Param("name")String name,@Param("number")String number,Invocation inv){
		inv.addModel("name", name);
		inv.addModel("number", number);
		return "dataSet";
	}

}
