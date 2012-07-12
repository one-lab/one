package com.sinosoft.platform.platformDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Intercepted;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.annotation.rest.Put;

import com.sinosoft.platform.platformDemo.model.account.User;
import com.sinosoft.platform.platformDemo.service.account.AccountManager;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)
 * 
 * @author kylin
 */
@LoginRequired
@Path("")
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
			return "r:/platformDemo/login";
		}
		
	}
	
	
	@Get("/logout")
	public String logout(Invocation inv){
		inv.getRequest().getSession().setAttribute("loginUserName", null);
		return "login";
	}
}
