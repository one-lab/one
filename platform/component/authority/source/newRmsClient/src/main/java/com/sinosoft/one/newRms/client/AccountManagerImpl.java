package com.sinosoft.one.newRms.client;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.User;
import com.sinosoft.one.ams.facade.RmsClientService;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.repositories.UserDao;

@Component
public class AccountManagerImpl implements AccountManager{
	
	
	private RmsClientService newRmsClientService;	
//	@Autowired
//	private UserDao userDao;

	public User findUserByLoginName(String loginName, String comCode,
			String sysFlag) {
		User checkUser = newRmsClientService.login(loginName, comCode, sysFlag);
		return checkUser;
	}

//	public UserDao getUserDao() {
//		return userDao;
//	}
//
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}

	public RmsClientService getNewRmsClientService() {
		return newRmsClientService;
	}

	@Autowired
	public void setNewRmsClientService(RmsClientService newRmsClientService) {
		this.newRmsClientService = newRmsClientService;
	}

	
	
}
