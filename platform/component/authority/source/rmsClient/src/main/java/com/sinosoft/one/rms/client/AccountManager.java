package com.sinosoft.one.rms.client;

import com.sinosoft.one.rms.User;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 7/23/12
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AccountManager {
	
    User findUserByLoginName(String loginName,String comCode,String sysFlag);
    
    com.sinosoft.one.rms.client.webservice.User findUserByLoginNameWs(String loginName,String comCode,String sysFlag);
}
