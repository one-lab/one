package com.sinosoft.platform.platformDemo.controllers.user_group;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Pipe;

@Path("")
public class UserGroupController {
	

	@Get("/pipe")
	public String pipeViews(Pipe p){
//		p.addWindow("p1", "a:/account/user/list");
//		p.addWindow("p2", "a:/account/group/list");
		p.addWindow("p1", "a:/user_group/p1");
		p.addWindow("p2", "a:/user_group/p2");
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
