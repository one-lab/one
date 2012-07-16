package com.sinosoft.platform.platformDemo.controllers.user_group;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Portal;

@Path("userGroup")
public class UserGroupController {
	

	@Get("/portal")
	public String pipeViews(Portal portal){
//		p.addWindow("p1", "a:/account/user/list");
//		p.addWindow("p2", "a:/account/group/list");
		portal.addWindow("p1", "/account/user/list");
		portal.addWindow("p2", "/account/group/list");
		return "user_group_views";
	}
	
	@Get("/p1")
	public String p1(){
		return "@ p1";
	}
	
	@Get("/p2")
	public String p2(){
		return "@ p2";
	}
}
