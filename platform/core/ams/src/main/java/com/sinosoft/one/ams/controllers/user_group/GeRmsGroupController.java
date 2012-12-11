package com.sinosoft.one.ams.controllers.user_group;

import org.springframework.beans.factory.annotation.Autowired;


import com.sinosoft.one.ams.model.GeRmsGroup;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;

@Path("group")
public class GeRmsGroupController {

	@Autowired
	private AccountManager accountManager;
	
	@Post("update/{groupId}")
	public Reply update(@Param("groupId") String groupId, Invocation inv) {
		System.out.println(groupId + "+++++++++++++++++++++++++++++++++++");
		if (groupId != null) {
			accountManager.updateGroup(groupId);
			return Replys.with("success");
		} else {
			return Replys.with("false");
		}

	}

	@Get("find/{groupId}")
	public String find(@Param("groupId") String groupId, Invocation inv) {
		System.out.println("++++++++++++++++++++++++++++++++++");
		GeRmsGroup group = accountManager.findGroupByGroupId(groupId);
		inv.addModel("name", group.getName());
		inv.addModel("des", group.getDes());
		inv.addModel("groupId", groupId);
		return "updateGroup";
	}

}
