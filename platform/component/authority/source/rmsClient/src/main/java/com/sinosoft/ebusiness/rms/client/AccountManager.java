package com.sinosoft.ebusiness.rms.client;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 7/23/12
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AccountManager {

    User findUserByLoginName(String loginName,String password,String comCode);
}
