package com.sinosoft.one.rms.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.clientService.facade.RmsClientService;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 7/23/12
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountManagerLocalImpl implements AccountManager{
	
	//引用的本地接口
	private RmsClientService rmsClientService;
	
    public User findUserByLoginName(String loginUserCode, String comCode) {
    	return rmsClientService.login(loginUserCode,  comCode);
    }


	@Autowired
	public void setRmsClientService(RmsClientService rmsClientService) {
		this.rmsClientService = rmsClientService;
	}

    
}
