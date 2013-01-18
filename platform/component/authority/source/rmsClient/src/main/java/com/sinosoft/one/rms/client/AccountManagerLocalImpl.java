package com.sinosoft.one.rms.client;


import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.User;
import com.sinosoft.one.rms.facade.RmsClientService;

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
	
    public User findUserByLoginName(String loginUserCode, String comCode,String sysFlag) {
    	User user=rmsClientService.login(loginUserCode,  comCode,sysFlag);
    	return user;
    }

	public void setRmsClientService(RmsClientService rmsClientService) {
		this.rmsClientService = rmsClientService;
	}

	public RmsClientService getRmsClientService() {
		return rmsClientService;
	}



	public com.sinosoft.one.rms.client.webservice.User findUserByLoginNameWs(
			String loginName, String comCode, String sysFlag) {
		return null;
	}

    
}
