package com.sinosoft.one.log.test;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 9/7/12
 * Time: 4:24 下午
 * To change this template use File | Settings | File Templates.
 */
public class TestABean {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    String password;

    TestBBean b;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TestBBean getB() {
        return b;
    }

    public void setB(TestBBean b) {
        this.b = b;
    }
}
