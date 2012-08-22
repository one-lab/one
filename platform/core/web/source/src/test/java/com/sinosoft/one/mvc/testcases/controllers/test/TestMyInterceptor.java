package com.sinosoft.one.mvc.testcases.controllers.test;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

public class TestMyInterceptor extends AbstractControllerTest{
	
    public void testAdvancedIndex() throws ServletException, IOException {
         invoke("/test/test/test111");
    }
}
