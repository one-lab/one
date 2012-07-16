package com.sinosoft.platform.platformDemo.controllers.user_group;


import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Pipe;

@Path("pipe")
public class UserGroupPipeController {

	@Get("/main")
	public String portalViews(Pipe p){
//		p.addWindow("p1", "/account/user/p1");
//		p.addWindow("p2", "/account/group/p2");
		
		p.addWindow("p1", "/user_group/pipe/p1");
		p.addWindow("p2", "/user_group/pipe/p2");
		return "user_group_pipe";
	}
	
	@Get("p1")
	public String p1(){
		return "@p1$$$$$$$$$$";
	}
	
	@Get("p2")
	public String p2(){
		return "@p2%%%%%%%%%%%%%%%%%";
	}
}
