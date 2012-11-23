package com.sinosoft.one.rms.clientService.facade;


import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.service.facade.GetUserService;

/**
 * 外部调用实现类、webService接口实现类
 * 创建登陆用户
 * @author Administrator
 *
 */
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
