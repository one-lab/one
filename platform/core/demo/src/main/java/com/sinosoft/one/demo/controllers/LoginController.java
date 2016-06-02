package com.sinosoft.one.demo.controllers;

import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.service.account.AccountManager;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Intercepted;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)
 * 
 * @author kylin
 */
@LoginRequired
@Path
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private AccountManager accountManager;
	
	@Get("/login")
	@Intercepted(deny={"passport"})
	public String login(Invocation inv) {
		inv.getRequest().getSession().setAttribute("loginUserName", null);
        logger.info("aa{}bb{}", 30, 20);
        List list = new ArrayList();
        list.add( DateUtils.addMonths(new Date(),7));
        list.add( DateUtils.addMonths(new Date(),8));
        inv.getRequest().setAttribute("test2", list);

        User user = new User();
        User user1 = new User();
        user.setCreateTime(DateUtils.addDays(new Date(),1));
        user1.setCreateTime(DateUtils.addDays(new Date(),2));
        List list2 = new ArrayList();
        list2.add(user);
        list2.add(user1);
        inv.getRequest().setAttribute("test3",list2);
        inv.getRequest().setAttribute("t1", new Date());
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
