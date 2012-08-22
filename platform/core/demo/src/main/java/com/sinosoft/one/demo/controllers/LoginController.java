package com.sinosoft.one.demo.controllers;

import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.service.account.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Intercepted;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)
 * 
 * @author kylin
 */
@LoginRequired
@Path
public class LoginController {

	@Autowired
	private AccountManager accountManager;
	
	@Get("/login")
	@Intercepted(deny={"passport"})
	public String login(Invocation inv) {
		inv.getRequest().getSession().setAttribute("loginUserName", null);
		return "login";
	}
	
	@Post("/login")
	@Intercepted(deny={"passport"})
	public String login(User user, Invocation inv) {
		User checkuser = accountManager.findUserByLoginName(user.getLoginName());
		
		if(checkuser!=null && checkuser.getPassword().equals(user.getPassword())){
			inv.getRequest().getSession().setAttribute("loginUserName", user.getLoginName());
			return "r:account/user/list";
		} else {
			inv.addFlash("message", "用户名或者密码不对");
			return "r:/login";
		}
		
	}
	
	
	@Get("/logout")
	public String logout(Invocation inv){
		inv.getRequest().getSession().setAttribute("loginUserName", null);
		return "login";
	}
}
