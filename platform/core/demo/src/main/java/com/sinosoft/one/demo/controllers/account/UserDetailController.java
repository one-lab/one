package com.sinosoft.one.demo.controllers.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.service.account.AccountManager;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.sinosoft.one.demo.controllers.LoginRequired;
import com.sinosoft.one.demo.model.account.Group;

/**
 * 使用@ModelAttribute, 实现Struts2 Preparable二次绑定的效果。 
 * 因为@ModelAttribute被默认执行, 而其他的action url中并没有${id}，所以需要独立出一个Controller.
 * 
 * @author calvin
 */
@LoginRequired
@Path("user")
public class UserDetailController {

	@Autowired
	private AccountManager accountManager;

	
	@Autowired
	private GroupListEditor groupListEditor;

	@InitBinder
	public void initBinder(WebDataBinder b) {
		b.registerCustomEditor(List.class, "groupList", groupListEditor);
	}
/*
 * 
 * @Get("update/{id:[0-9]+}/check/{name:[a-z]+}/{email}")
 * 
 * 
 * 
 * 
 * 
 * 
 */
	@Get("update/{id:[0-9]+}")
	public String updateForm(@Param("id") long id, Invocation inv) {
		inv.addModel("user", accountManager.getUser(id));
		inv.addModel("userInfo", accountManager.findUserInfo(id));
		inv.addModel("allGroups", accountManager.getAllGroup());
		return "userForm";
	}

	@Post("save/{id}")
	public String save(@Param("id") long id,@Param("groupList") List<Long> gids ,User user,Invocation inv) {
		
		List<Group> groupList = new ArrayList<Group>();
		for (Long long1 : gids) {
			Group group = new Group(long1, null);
			groupList.add(group);
		}
		
		user.setGroupList(groupList);
		user.setCreateTime(new Date());
		accountManager.saveUser(user);
		
		if(user.getUserInfo().getId() == null){
			user.getUserInfo().setId(user.getId());
		}
		user.getUserInfo().setStrGender(user.getUserInfo().getGender().name());
		accountManager.saveUserInfo(user.getUserInfo());
		
		inv.addFlash("message", "修改用户" + user.getLoginName() + "成功");
		return "r:/account/user/list";
	}

}
