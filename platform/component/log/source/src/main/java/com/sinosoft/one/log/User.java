package com.sinosoft.one.log;

/**
 * 用于扩展记录当前登陆的用户信息
 * User: ChengQi
 * Date: 9/3/12
 * Time: 5:13 下午
 * To change this template use File | Settings | File Templates.
 */
public interface User {

    /**
     * 获取当前登陆用户代码
     * @return
     */
    String getUserCode();

    /**
     * 获取当前登陆用户的机构代码
     * @return
     */
    String getCompanyCode();
}
