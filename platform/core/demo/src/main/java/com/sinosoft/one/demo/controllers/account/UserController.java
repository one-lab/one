package com.sinosoft.one.demo.controllers.account;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.model.account.UserInfo;
import com.sinosoft.one.demo.service.account.AccountManager;
import com.sinosoft.one.mvc.util.MvcPathUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sinosoft.one.demo.controllers.LoginRequired;
import com.sinosoft.one.demo.model.account.Group;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.validation.annotation.NotEmptyEx;
import com.sinosoft.one.mvc.web.validation.annotation.SizeEx;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

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
	@Get("list")
	public String list(Invocation inv) {
		List<User> users = accountManager.getAllUser();
		inv.addModel("users", users);
		return "userList";
	}

	@Get("create")
	@Post("errorCreate")
	public String createForm(Invocation inv) {
		inv.addModel("user", new User());
		inv.addModel("allGroups", accountManager.getAllGroup());
		return "userForm";
	}
	@Get("userInfoList/{userId}")
	public String check(@Param("userId") long userId ,Invocation inv){
		UserInfo userInfos = accountManager.findUserInfoByUserId(userId);
		inv.addModel("uesrInfos",userInfos);
		return "userInfoList";
	}
	
	@Post("save")
	public String save(@Param("groupList") List<Long> gids,
			@Validation(errorPath="a:errorCreate",
				notEmpty=@NotEmptyEx( props={"loginName","password","email","name"} ) ,
				size=@SizeEx(max=20,min=4, props={"name","loginName","email"})
			) User user, @Param("doc") MultipartFile[] docs, Invocation inv) throws IllegalStateException, IOException {
		
		List<Group> groupList = new ArrayList<Group>();
		for (Long long1 : gids) {
			Group group = new Group(long1, null);
			groupList.add(group);
		}
		user.setGroupList(groupList);
		user.setId(System.currentTimeMillis());
		user.setCreateTime(new Date());
		accountManager.saveUser(user);
		
		user.getUserInfo().setId(user.getId());
		user.getUserInfo().setStrGeneral(user.getUserInfo().getGeneral().name());
		accountManager.saveUserInfo(user.getUserInfo());
		for (MultipartFile multipartFile : docs) {
			if(multipartFile.getOriginalFilename() == null){
				continue;
			}

			multipartFile.transferTo(new File(MvcPathUtil.getDirectoryPath(inv, "/")+multipartFile.getOriginalFilename()));
		}
		
		
//		return Replys.sample().success("创建用户" + user.getLoginName() + "成功");
		return "r:/platformDemo/account/user/list";
	}

	@Get("delete/{id}")
	public String delete(@Param("id") Long id, Invocation inv) {
		accountManager.deleteUser(id);
		accountManager.deleteUerInfo(id);
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
	
	@Get("/p1")
	public String p1(Invocation inv){ 
		List<User> users = accountManager.getAllUser();
		inv.addModel("users", users);
		return "userWindow";
//		return "@ p1***********";
	}
	
	@Get("/pipe1")
	public String pipe1(Invocation inv){ 
		List<User> users = accountManager.getAllUser();
		inv.addModel("users", users);
		return "userListPipe";
	}
	
	@Post("view/{key1}/{key2}/{id}")
	public Object view(@Param("key1") Long key1, @Param("key2") Long key2,
			@Param("id") Long id, Invocation inv){
		if(key1 == 1 && key2 == 2){
			User user = accountManager.getUser(id);
			
			return Replys.with(user).as(Json.class);
		}
		return "@e";
	}
	
	@Post("viewUserInfo/{id:[0-9]+}")
	public Object viewUserInfo(@Param("id") Long id, Invocation inv){
		
		UserInfo userInfo = accountManager.findUserInfo(id);
		
		return Replys.with(userInfo).as(Json.class);
	}
}
