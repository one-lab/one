package com.sinosoft.one.demo.controllers.user_group;


import com.sinosoft.one.demo.model.account.Group;
import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.service.account.AccountManager;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.portal.Pipe;
import com.sinosoft.one.mvc.web.portal.Window;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("pipe")
public class UserGroupPipeController {

    @Autowired
    private AccountManager accountManager;

	@Get("/main")
	public String portalViews(Pipe p,Invocation inv){

        List<User> users = accountManager.getAllUser();
        inv.addModel("users", users);

        List<Group> groups = accountManager.getAllGroup();
        inv.addModel("groups", groups);

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
