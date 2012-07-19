package com.sinosoft.platform.platformDemo.controllers.account;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinosoft.platform.platformDemo.controllers.LoginRequired;
import com.sinosoft.platform.platformDemo.model.account.Group;
import com.sinosoft.platform.platformDemo.model.account.Permission;
import com.sinosoft.platform.platformDemo.service.account.AccountManager;
@LoginRequired
@Path("group/")
public class GroupDetailController {

	@Autowired
	private AccountManager accountManager;

	@Get("update/{id}")
	public String updateForm(@Param("id") long id,Invocation inv) {
		inv.addModel("group", accountManager.getGroup(id));
		inv.addModel("allPermissions", Permission.values());
		return "groupForm";
	}

	@Post("save/{id}")
	public String save(Group group, Invocation inv) {
		accountManager.saveGroup(group);
		inv.addFlash("messagea", "修改权限组" + group.getName() + "成功");
		//inv.addModel("message", "修改权限组" + group.getName() + "成功");
		return "r:/platformDemo/account/group/";
	}

	@Get("group")
	public Group getGroup(@Param("id") Long id) {
		return accountManager.getGroup(id);
	}
}
