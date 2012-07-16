package com.sinosoft.platform.platformDemo.controllers.user_group;


import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Portal;

@Path("portal")
public class UserGroupPortalController {

	@Get("/main")
	public String portalViews(Portal p){
		p.addWindow("p1", "/account/user/p1");
		p.addWindow("p2", "/account/group/p2");
		return "user_group_portal";
	}
}
