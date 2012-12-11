package com.sinosoft.one.ams.controllers.user_group;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("usergroup")
public class GeRmsUserGroupController {
	
	//将groupId传到dataQuery页面，并跳到dataQuery页面
	@Get("groupId/{groupId}")
	public String page(@Param("groupId") String groupId, Invocation inv) {
		inv.addModel("groupId", groupId);
		return "dataQuery";
	}	

}
