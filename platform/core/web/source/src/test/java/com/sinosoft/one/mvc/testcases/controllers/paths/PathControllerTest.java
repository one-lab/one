package com.sinosoft.one.mvc.testcases.controllers.paths;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.mock.controllers.paths.PathController;
import com.sinosoft.one.mvc.testcases.AbstractControllerTest;
import com.sinosoft.one.mvc.web.impl.thread.ActionEngine;
import com.sinosoft.one.mvc.web.impl.thread.ControllerEngine;
import com.sinosoft.one.mvc.web.impl.thread.ModuleEngine;

/**
 * @see PathController
 *
 * 
 */
public class PathControllerTest extends AbstractControllerTest {

    public void test10() throws ServletException, IOException {
        assertEquals("1/action", invoke("/paths/path/action"));
    }

    public void test11() throws ServletException, IOException {
        assertEquals("1/action/abc", invoke("/paths/path/action/abc"));
    }

    public void test12() throws ServletException, IOException {
        assertEquals("1/action", invoke("/paths/path/cc/action"));
    }

    public void test13() throws ServletException, IOException {
        assertEquals("1/action/abc", invoke("/paths/path/cc/action/abc"));
    }

    public void test20() throws ServletException, IOException {
        assertEquals("2/path", invoke("/paths/path/controller"));
    }

    public void test21() throws ServletException, IOException {
        assertEquals("2/path/cc", invoke("/paths/path/cc/controller"));
    }

    public void test30() throws ServletException, IOException {
        assertEquals("3/paths", invoke("/paths/path/module"));
    }

    public void test31() throws ServletException, IOException {
        assertEquals("3/paths", invoke("/paths/path/cc/module"));
    }

    public void test40() throws ServletException, IOException {
        assertNotNull(invoke("/paths/path/moduleEngine"));
        assertEquals(ModuleEngine.class, invoke("/paths/path/moduleEngine").getClass());
    }

    public void test41() throws ServletException, IOException {
        assertNotNull(invoke("/paths/path/controllerEngine"));
        assertEquals(ControllerEngine.class, invoke("/paths/path/controllerEngine").getClass());
    }

    public void test42() throws ServletException, IOException {
        assertNotNull(invoke("/paths/path/actionEngine"));
        assertEquals(ActionEngine.class, invoke("/paths/path/cc/actionEngine").getClass());
    }

    public void test50() throws ServletException, IOException {
        assertNotNull(invoke("/paths/path/moduleEngine"));
        assertEquals(ModuleEngine.class, invoke("/paths/path/cc/moduleEngine").getClass());
    }

    public void test51() throws ServletException, IOException {
        assertNotNull(invoke("/paths/path/controllerEngine"));
        assertEquals(ControllerEngine.class, invoke("/paths/path/cc/controllerEngine").getClass());
    }

    public void test52() throws ServletException, IOException {
        assertNotNull(invoke("/paths/path/actionEngine"));
        assertEquals(ActionEngine.class, invoke("/paths/path/cc/actionEngine").getClass());
    }

}
