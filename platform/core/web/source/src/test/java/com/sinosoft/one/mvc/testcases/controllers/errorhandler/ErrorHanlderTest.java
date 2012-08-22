package com.sinosoft.one.mvc.testcases.controllers.errorhandler;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.mock.controllers.errorhandler.MainController;
import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

/**
 * @see MainController
 *
 *
 */
public class ErrorHanlderTest extends AbstractControllerTest {

    public void testIndex() throws ServletException, IOException {
        Object obj = invoke("/errorhandler/main");
        assertTrue(obj.getClass() == IllegalArgumentException.class);
        assertEquals("main", ((IllegalArgumentException) obj).getMessage());
    }

    public void testSubIndex() throws ServletException, IOException {
        Object obj = invoke("/errorhandler/sub/main");
        assertTrue(obj.getClass() == IllegalArgumentException.class);
        assertEquals("main-sub", ((IllegalArgumentException) obj).getMessage());
    }

}
