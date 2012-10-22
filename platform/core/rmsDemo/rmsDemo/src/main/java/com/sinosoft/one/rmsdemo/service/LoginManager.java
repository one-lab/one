package com.sinosoft.one.rmsdemo.service;

import com.sinosoft.one.rmsdemo.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-20
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
public interface LoginManager {
    User findByLoginName(String loginName);
}
