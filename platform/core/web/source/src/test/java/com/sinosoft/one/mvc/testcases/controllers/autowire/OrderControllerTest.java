package com.sinosoft.one.mvc.testcases.controllers.autowire;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.mock.controllers.DefController;
import com.sinosoft.one.mvc.testcases.AbstractControllerTest;
import com.sinosoft.one.mvc.web.impl.module.ModuleAppContext;

import org.springframework.context.ApplicationContext;

public class OrderControllerTest extends AbstractControllerTest {

    public void testOk() throws ServletException, IOException  {
        Object obj = invoke("/autowire/order/ok");
        assertEquals("ok", obj);
    }

    public void testGet() throws ServletException, IOException {
        Object obj = invoke("/autowire/order");
        assertTrue("obj=" + obj, AutowireBean2.class.isInstance(obj));
    }

    public void testDef() throws ServletException, IOException {
        Object obj = invoke("/autowire/order/def");
        assertTrue("obj=" + obj, DefController.class.isInstance(obj));
    }

    public void testAutowireBean() throws ServletException, IOException {
        Object obj = invoke("/autowire/order/autowireBean");
        assertTrue("obj=" + obj, AutowireBean.class.isInstance(obj));
    }

    public void testCtx() throws ServletException, IOException {
        Object obj = invoke("/autowire/order/ctx");
        assertTrue(ApplicationContext.class.isInstance(obj));
        assertEquals("obj=" + obj, ModuleAppContext.class, obj.getClass());
    }
}
