package com.sinosoft.one.rms.clientService.facade;


import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.service.facade.ClientService;

// 服务端对外的接口 可同时发布成webService接口
public class RmsClientServiceImpl implements RmsClientService{
	@Autowired
	private ClientService clientService;

	public User login(String userCode, String comCode,String sysFlag) {
		return clientService.getUserByUserCodeComCode(userCode, comCode, sysFlag);
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	

}
