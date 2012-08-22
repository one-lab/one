package com.sinosoft.one.mvc.testcases.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.mock.controllers.DefController;
import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

/**
 * @see DefController
 *
 * 
 */
public class DefControllerTest extends AbstractControllerTest {

    public void testIndex() throws ServletException, IOException {
        assertEquals("index", invoke("/def"));
    }

    public void testIndex2() throws ServletException, IOException {
        assertEquals("index", invoke("/def"));
    }

    /*测试{}.html的不需要{}/.html*/
    public void testTiny() throws ServletException, IOException {
        assertEquals("yizuoyiwang", invoke("/def/t/yizuoyiwang.html"));
    }

    public void testTiny2() throws ServletException, IOException {
        assertEquals("yizuoyiwang", invoke("/def/t/yizuoyiwang.html"));
    }

    public void testMethod() throws ServletException, IOException {
        assertEquals("method", invoke("/def/method"));
    }

    public void testParam() throws ServletException, IOException {
        assertEquals("param_1234567", invoke("/def/param_1234567"));
    }
}
