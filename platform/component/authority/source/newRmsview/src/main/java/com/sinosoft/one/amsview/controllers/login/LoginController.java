/**
 * 
 */
package com.sinosoft.one.amsview.controllers.login;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.ams.User;
import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Employe;
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
	private EmployeeService  employeeService;
	
	
	@Get
	@Post
	public String login(Invocation inv) {

//		Employe checkUser = employeeService.findEmployeByUserCode(user.getUserName());
//
//		if (checkUser != null
//				&& checkUser.getPassword().equals(user.getPassword())) {
//			inv.getRequest().getSession().setAttribute("user", checkUser);
//			return "index";
//		} else {
//			return "login";
//		}
		
		@SuppressWarnings("unused")
		User user = ShiroLoginUser.getLoginUser();
		
		
		return "index";

	}
	
	@Post("selectCom/{userCode}")
	public Reply selectCom(@Param("userCode")String userCode, Invocation inv){
		Company com = employeeService.findComByUserCode(userCode);
		System.out.println(com.getComCode());
		
		return Replys.with(com).as(Json.class);
	}

}
