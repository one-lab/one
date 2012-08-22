package com.sinosoft.one.rms.clientService.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.model.Company;
import com.sinosoft.one.rms.service.facade.ClientService;

public class RmsClientServiceImpl implements RmsClientService{
	@Autowired
	private ClientService clientService;

	public User login(String userCode, String comCode) {
		return clientService.getUserByUserCodeComCode(userCode, comCode);
	}
	
	public List<Company> findCompanysByUserCodeAndPassword(String userCode,
			String passWord) {
		return clientService.findCompanysByUserCodeAnyPassword(userCode, passWord);
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	

}
