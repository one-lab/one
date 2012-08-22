package com.sinosoft.one.mvc.testcases.app;

import junit.framework.Assert;
import junit.framework.TestCase;
import com.sinosoft.one.mvc.scanning.context.MvcAppContext;
import com.sinosoft.one.mvc.testcases.controllers.autowire.AutowireBean;
import com.sinosoft.one.mvc.testcases.controllers.autowire.AutowireBean2;

public class MvcAppContextTest extends TestCase {

    public void testMvcAppContext() {

        MvcAppContext mvc = new MvcAppContext();

        Assert.assertNotNull(mvc.getBean("autowireBean"));
        Assert.assertNotNull(mvc.getBean("autowireBean2"));

        Assert.assertEquals(AutowireBean.class, mvc.getBean("autowireBean").getClass());
        Assert.assertEquals(AutowireBean2.class, mvc.getBean("autowireBean2").getClass());

        Assert.assertEquals(mvc.getBean("autowireBean"), mvc.getBean(AutowireBean.class));
        Assert.assertEquals(mvc.getBean("autowireBean2"), mvc.getBean(AutowireBean2.class));
    }
}
