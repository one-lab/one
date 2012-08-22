package com.sinosoft.one.mvc.testcases.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

public class UserInfoActionTest extends AbstractControllerTest {

    public void testHello() throws ServletException, IOException {
        assertEquals(1234567, invoke("/userInfo/hello/1234567"));
    }

}
