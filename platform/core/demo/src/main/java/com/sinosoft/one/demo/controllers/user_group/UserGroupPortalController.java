package com.sinosoft.one.demo.controllers.user_group;


import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.portal.Portal;

@Path("portal")
public class UserGroupPortalController {

	@Get("/main")
	public String portalViews(Portal p){
		p.addWindow("p1", "/account/user/p1");
		p.addWindow("p2", "/account/group/p2");
		return "user_group_portal";
	}
}
