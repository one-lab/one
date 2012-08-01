package com.sinosoft.one.demo.controllers.user_group;


import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.portal.Pipe;
import com.sinosoft.one.mvc.web.portal.Window;

@Path("pipe")
public class UserGroupPipeController {

	@Get("/main")
	public String portalViews(Pipe p){
		p.addWindow("p1", "/account/user/pipe1");
		p.addWindow("p2", "/account/group/pipe2");
		
//		p.addWindow("p1", "/user_group/pipe/p1");
//		p.addWindow("p2", "/user_group/pipe/p2");

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
