package com.sinosoft.one.rmsdemo.dao;

import com.sinosoft.one.rmsdemo.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-20
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    User findByLoginName(String loginName);

}
