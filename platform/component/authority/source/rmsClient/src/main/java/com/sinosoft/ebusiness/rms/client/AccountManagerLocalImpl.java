package com.sinosoft.ebusiness.rms.client;


import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.ebusiness.rms.clientService.User;
import com.sinosoft.ebusiness.rms.clientService.facade.RmsClientService;

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
	
    @Override
    public User findUserByLoginName(String loginUserCode, String comCode) {
    	return rmsClientService.login(loginUserCode,  comCode);
    }


	@Autowired
	public void setRmsClientService(RmsClientService rmsClientService) {
		System.out.println("11111111");
		this.rmsClientService = rmsClientService;
	}

    
}
