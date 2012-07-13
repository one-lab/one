package com.sinosoft.platform.platformDemo.controllers.account;

import java.util.ArrayList;
import java.util.List;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Intercepted;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Delete;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinosoft.platform.platformDemo.controllers.LoginRequired;
import com.sinosoft.platform.platformDemo.model.account.Group;
import com.sinosoft.platform.platformDemo.model.account.User;
import com.sinosoft.platform.platformDemo.service.account.AccountManager;

/**
 * Urls:
 * List   page        : GET  /account/user/
 * Create page        : GET  /account/user/create
 * Create action      : POST /account/user/save
 * Update page        : GET  /account/user/update/{id}
 * Update action      : POST /account/user/save/{id}
 * Delete action      : POST /account/user/delete/{id}
 * CheckLoginName ajax: GET  /account/user/checkLoginName?oldLoginName=a&loginName=b
 * 
 * @author calvin
 *
 */
@LoginRequired
@Path("user")
public class UserController {

	@Autowired
	private AccountManager accountManager;

	@Autowired
	private GroupListEditor groupListEditor;

	@InitBinder
	public void initBinder(WebDataBinder b) {
		b.registerCustomEditor(List.class, "groupList", groupListEditor);
	}
	
	@LoginRequired
	@Get({"list","","userList"})
	public String list(Invocation inv) {
		List<User> users = accountManager.getAllUser();
		inv.addModel("users", users);
		return "userList";
	}

	@Get("create")
	public String createForm(Invocation inv) {
		inv.addModel("user", new User());
		inv.addModel("allGroups", accountManager.getAllGroup());
		return "userForm";
	}

	@Post("save")
	public String save(@Param("groupList") List<Long> gids,User user, Invocation inv) {
		List<Group> groupList = new ArrayList<Group>();
		for (Long long1 : gids) {
			Group group = new Group(long1, null);
			groupList.add(group);
		}
		user.setGroupList(groupList);
		user.setId(System.currentTimeMillis());
		accountManager.saveUser(user);
		inv.addFlash("message", "创建用户" + user.getLoginName() + "成功");
		return "r:/platformDemo/account/user/list";
	}

	@Get("delete/{id}")
	public String delete(@Param("id") Long id, Invocation inv) {
		accountManager.deleteUser(id);
		inv.addFlash("message", "删除用户成功");
		return "r:/platformDemo/account/user/list";
	}

	@Post("checkLoginName")
	public String checkLoginName(@Param("oldLoginName") String oldLoginName,
			@RequestParam("loginName") String loginName) {
		if (loginName.equals(oldLoginName)) {
			return "true";
		} else if (accountManager.findUserByLoginName(loginName) == null) {
			return "true";
		}

		return "@false";
	}
}
