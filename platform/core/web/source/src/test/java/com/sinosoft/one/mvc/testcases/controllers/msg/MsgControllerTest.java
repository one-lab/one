package com.sinosoft.one.mvc.testcases.controllers.msg;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.mock.controllers.msg.MsgController;
import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

/**
 * @see MsgController
 *
 * 
 */
public class MsgControllerTest extends AbstractControllerTest {

    public void testDefaultHello() throws ServletException, IOException {
        assertEquals("你好", invoke("/msg/hello"));
    }

    public void testHello() throws ServletException, IOException {
        request.addParameter("loc", "en");
        assertEquals("Hallo", invoke("/msg/hello"));
    }

    public void testExHello() throws ServletException, IOException {
        assertEquals("另外的messages文件", invoke("/msg/ex"));
    }

}
