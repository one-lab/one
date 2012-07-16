package com.sinosoft.platform.platformDemo.controllers.user_group;

import java.util.ArrayList;
import java.util.List;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Portal;
import net.paoding.rose.web.portal.Window;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.platform.platformDemo.model.account.User;
import com.sinosoft.platform.platformDemo.service.account.AccountManager;

@Path("portal")
public class UserGroupController {
//	
//	@Autowired
//	private AccountManager accountManager;

	@Get("/main")
	public String portalViews(Portal p){
		p.addWindow("p1", "/account/user/p1");
		p.addWindow("p2", "/account/group/p2");
		
//		p.addWindow("p1", "/user_group/portal/p1");
//		p.addWindow("p2", "/user_group/portal/p2");
//		p.addWindow("weather", "/windows/window1/m1");
//		p.addWindow("todo", "/windows/window2/m2");
		return "user_group_views";
	}
	
	
	@Get("/p1")
	public String p1(){
		
		return "@ p1***********";
	}
	
	@Get("/p2")
	public String p2(){
		
		return "@ p2&&&&&&&&&&&";
	}
}
