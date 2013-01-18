package com.sinosoft.one.ams.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.User;
import com.sinosoft.one.ams.service.facade.GetUserService;


/**
 * 外部调用实现类、webService接口实现类
 * 创建登陆用户
 * @author Administrator
 *
 */
@Component
public class RmsClientServiceImpl implements RmsClientService{
	/**
	 * 创建登陆用户具体实现的接口GetUserService
	 */
	@Autowired
	private GetUserService getUserService;

	public User login(String userCode, String comCode,String sysFlag) {
		return getUserService.getUserByUserCodeComCode(userCode, comCode, sysFlag);
	}

	public GetUserService getClientService() {
		return getUserService;
	}

	public void setClientService(GetUserService clientService) {
		this.getUserService = clientService;
	}

	

}
