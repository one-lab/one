package com.sinosoft.one.newRms.client;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.sinosoft.one.ams.User;
import com.sinosoft.one.ams.model.Employe;

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
