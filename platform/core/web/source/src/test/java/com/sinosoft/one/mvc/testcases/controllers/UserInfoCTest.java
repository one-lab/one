package com.sinosoft.one.mvc.testcases.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

public class UserInfoCTest extends AbstractControllerTest {


	public void testShow() throws ServletException, IOException {
		assertEquals(1234567, invoke("/userInfo/1234567"));
	}


}
