package com.sinosoft.one.model;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-20
 * Time: 下午3:35
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String loginName;
    private String password;

    public User() {

    }

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
