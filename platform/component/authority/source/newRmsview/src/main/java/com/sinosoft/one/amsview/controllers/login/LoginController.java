/**
 * 
 */
package com.sinosoft.one.amsview.controllers.login;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.ams.Menu;
import com.sinosoft.one.ams.User;
import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.service.facade.CompanyService;
import com.sinosoft.one.ams.service.facade.EmployeeService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.newRms.client.ShiroLoginUser;

@Path
public class LoginController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmployeeService employeeService;
	
	
	@Get
	public String login(Invocation inv){
		//获得shiro已验证的登陆对象 可将其放入SESSION
		User user=ShiroLoginUser.getLoginUser();
		inv.getRequest().getSession().setAttribute("user", user);
		System.out.println(user.getUserCode());
		System.out.println(user.getLoginComCode());
		List<Menu> menus = user.getMenuList();
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("menus", menus);
		return "index";
	}
	@Get("logout")
	public String logout(Invocation inv){
		HttpSession session = inv.getRequest().getSession();
		session.removeAttribute("user");
		session.removeAttribute(session.getId());
		session.setMaxInactiveInterval(0);
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		System.out.println("logout----------------");
		return "login"; 
	}
	
	@Post("checkUserCode/{userCode}")
	public Reply checkUserCode(@Param("userCode")String userCode, Invocation inv) throws Exception {

		Employe user = employeeService.findEmployeByUserCode(userCode);
		String result = "yes";
		if(user == null){
			result = "no";
		}
		System.out.println(result);
		return Replys.with(result);
	}
	
	@Post("company/{userCode}")
	public Reply company(@Param("userCode")String userCode, Invocation inv) throws Exception {

		Company com = employeeService.findComByUserCode(userCode);
		System.out.println(com.getComCode());
		return Replys.with(com).as(Json.class);
	}


}
