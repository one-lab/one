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
	
	/**
	 * 登录
	 * 
	 * @param inv
	 * @return
	 */
	@Get
	@Post
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
	
	/**
	 * 登出操作
	 * 
	 * @param inv
	 * @return
	 */
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
	
	/**
	 * 校验用户名和密码
	 * 
	 * @param userCode
	 * @param password
	 * @param inv
	 * @return
	 * @throws Exception
	 */
	@Post("checkUser/{userCode}/{password}")
	public Reply checkUserCode(@Param("userCode")String userCode,@Param("password")String password, Invocation inv) throws Exception {

		String result = "";
		if(true){
			Employe user = employeeService.findEmployeByUserCodePassword(userCode,null);
			if(user == null){
				result = "userCodeError";
				return Replys.with(result);
			}
		}
		Employe user = employeeService.findEmployeByUserCodePassword(userCode,password);
		if(user == null){
			result = "passwordError";
			return Replys.with(result);
		}
		return Replys.with("yes");
	}
	
	/**
	 * 查询用户已引入机构
	 * 
	 * @param userCode
	 * @param inv
	 * @return
	 * @throws Exception
	 */
	@Post("company/{userCode}")
	public Reply company(@Param("userCode")String userCode, Invocation inv) throws Exception {

		List<Company> coms = companyService.findComsByUserCode(userCode);
		return Replys.with(coms).as(Json.class);
	}


}
