package com.sinosoft.one.rms.client.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.sinosoft.one.rms.clientService.User;

public class ShiroLoginUser {

	/**
	 * 获得shiro登陆用户对象
	 * @return
	 */
	public static User getLoginUser(){
		Subject currentUser = SecurityUtils.getSubject();
		User user=(User) currentUser.getPrincipals().getPrimaryPrincipal();
		return user;
	}
	
}
