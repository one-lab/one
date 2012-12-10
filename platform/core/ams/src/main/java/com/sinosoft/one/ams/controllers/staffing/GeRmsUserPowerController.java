package com.sinosoft.one.ams.controllers.staffing;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("userpower")
public class GeRmsUserPowerController {
	@Get("power/{name}/{userCode}")
	public String power(@Param("name")String name,@Param("userCode")String userCode, Invocation inv){
		
		inv.addModel("name", name);
		inv.addModel("userCode", userCode);
		return "permissionSettings";
		
	}
}
