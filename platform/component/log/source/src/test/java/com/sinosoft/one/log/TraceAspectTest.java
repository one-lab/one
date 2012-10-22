package com.sinosoft.one.log;

import com.sinosoft.one.util.test.SpringTxTestCase;
import junit.framework.Assert;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * TraceAspectTest
 * User: ChengQi
 * Date: 8/31/12
 * Time: 1:22 上午
 * To change this template use File | Settings | File Templates.
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml",
        "/spring/applicationContext-log.xml" })
// @ContextConfiguration(locations = { "/spring/applicationContext-log.xml" })
@TransactionConfiguration(transactionManager = "monitorTransactionManager")
@Transactional(isolation= Isolation.READ_COMMITTED)
public class TraceAspectTest extends SpringTxTestCase {

    @Autowired
    private LogTraceAspect traceAspect;

    /**
     * 测试环境设置是否正确
     * 严格性为：Product>Test>Development
     */
    @Test
    public void env() throws IOException {
        //测试配置文件中的环境属性可以正常注入
        Resource resource = new ClassPathResource("/application.test.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        Assert.assertEquals(props.getProperty("log.environment"), traceAspect.getEnvironment().toString());
        //测试当为生产环境的只有PRODUCT的才输出
        traceAspect.setEnvironment(Environment.PRODUCT);
        Assert.assertEquals(false, traceAspect.checkEnvironment(Environment.DEVLEOP));
        Assert.assertEquals(false, traceAspect.checkEnvironment(Environment.TEST));
        Assert.assertEquals(true, traceAspect.checkEnvironment(Environment.PRODUCT));
        //测试当为测试环境的只有TEST与DEVELOP的才输出
        traceAspect.setEnvironment(Environment.TEST);
        Assert.assertEquals(true, traceAspect.checkEnvironment(Environment.DEVLEOP));
        Assert.assertEquals(true, traceAspect.checkEnvironment(Environment.TEST));
        Assert.assertEquals(false,traceAspect.checkEnvironment(Environment.PRODUCT));
        //测试当为开发环境的时候，全部输出
        traceAspect.setEnvironment(Environment.DEVLEOP);
        Assert.assertEquals(true,traceAspect.checkEnvironment(Environment.DEVLEOP));
        Assert.assertEquals(true,traceAspect.checkEnvironment(Environment.TEST));
        Assert.assertEquals(true,traceAspect.checkEnvironment(Environment.PRODUCT));

   }


    @Test
    public void expression() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        //普通描述，无任何参数场景
        Assert.assertEquals("测试一下",traceAspect.formatDescription("测试一下",null));
        Assert.assertEquals("测试一下1",traceAspect.formatDescription("测试一下${[0]}",new Object[]{"1"}));
        String expression = "测试一下${[0]}，再继续测试下${[1]}";
        Object[] argument = new Object[]{"1",2};
        Assert.assertEquals("测试一下1，再继续测试下2",traceAspect.formatDescription(expression,argument));
        TestABean a = new TestABean();
        a.setName("jack");
        Assert.assertEquals(BeanUtils.getProperty(a,"name"),a.getName());
        TestBBean b = new TestBBean();
        b.setSex("1");
        a.setB(b);
        String expression2 = "测试一下${[0]:name}，再继续测试下${[0]:b.sex}";
        Object[] argument2 = new Object[]{a,b};
        Assert.assertEquals("测试一下jack，再继续测试下1",traceAspect.formatDescription(expression2,argument2));

        
    }
    

}