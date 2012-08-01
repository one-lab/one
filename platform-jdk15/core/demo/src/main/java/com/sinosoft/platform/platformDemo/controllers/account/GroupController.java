package com.sinosoft.platform.platformDemo.controllers.account;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Delete;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.portal.Window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinosoft.platform.platformDemo.controllers.LoginRequired;
import com.sinosoft.platform.platformDemo.model.account.Group;
import com.sinosoft.platform.platformDemo.model.account.Permission;
import com.sinosoft.platform.platformDemo.model.account.User;
import com.sinosoft.platform.platformDemo.service.account.AccountManager;
@LoginRequired
@Path("group")
public class GroupController {

	@Autowired
	private AccountManager accountManager;

	@Get({ "list", "" })
	public String list(Invocation inv) {
		List<Group> groups = accountManager.getAllGroup();
		inv.addModel("groups", groups);
		return "groupList";
	}

	@Get("create")
	public String createForm(Invocation inv) {
		inv.addModel("group", new Group());
		inv.addModel("allPermissions", Permission.values());
		return "groupForm";
	}

	@Post("save")
	public String save(Group group, Invocation inv) {
		group.setId(System.currentTimeMillis());
		accountManager.saveGroup(group);
		inv.addFlash("message", "创建权限组" + group.getName() + "成功");
		return "r:/platformDemo/account/group/";
	}

	@Get("delete/{id}")
	public String delete(@Param("id") Long id, Invocation inv) {
		accountManager.deleteGroup(id);
		inv.addFlash("message", "删除权限组成功");
		return "r:/platformDemo/account/group/";
	}
	
	@Get("/p2")
	public String p2(Invocation inv,Window window){
		List<Group> groups = accountManager.getAllGroup();
		inv.addModel("groups", groups);
		return "groupWindow";
	}
	
	@Get("/pipe2")
	public String pipe2(Invocation inv,Window window){
		List<Group> groups = accountManager.getAllGroup();
		inv.addModel("groups", groups);
		return "groupListPipe";
	}
}
