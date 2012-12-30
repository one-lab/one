package com.sinosoft.one.exception.moduleexception;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinosoft.one.exception.ExceptionConfig;
import com.sinosoft.one.exception.ExceptionConfigInit;
import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.XmlConcreteException;
import com.sinosoft.one.exception.moduleexception.businessexception.MaintainServiceException;
import com.sinosoft.one.exception.moduleexception.businessexception.PaymentCommonException;
import com.sinosoft.one.exception.moduleexception.businessexception.UserServiceException;
import com.sinosoft.one.exception.moduleexception.service.ExceptionTestService;

public class ExceptionTest {

    @SuppressWarnings("unused")
    @Test
    public void exceptionTest() {

        ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-moduleException-test.xml");
        ExceptionConfigInit ec = (ExceptionConfigInit) beanFactory
                .getBean("exceptionConfigInit");
        try {
            ExceptionTestService.method_1();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("user模块具体异常描述000", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.MORESERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_2();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("user模块具体异常描述001", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.SERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_3();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_4();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_5();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_6();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_7();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_8();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_9();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_10();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_11();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.MORESERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_12();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_13();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_14();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_15();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_16();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_17();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_18();
        } catch (UserServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_19();
        } catch (MaintainServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("service-maintain模块异常描述000", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_20();
        } catch (MaintainServiceException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("service-maintain模块异常描述001", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.SERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_49();
        } catch (PaymentCommonException e) {
            System.out.println(e.getMsg());
        }
    }

    @Test
    public void exceptionHandleTest() {
//		System.out.println(ExceptionConfig.getTelsIterator().next());
//		System.out.println(ExceptionConfig.getTelsIterator().next());
//		System.out.println(ExceptionConfig.getTelsIterator().next());
//		for (Iterator<?> it = ExceptionConfig.getTelsIterator(); it.hasNext();) {
//			System.out.println("no" + it.next());
//
//		}
//		System.out.println(ExceptionConfig.getEmailsIterator().next());
        System.out.println(ExceptionConfig.getLevelHandle("1").getExceptionLevelDesc());
    }

    @Test
    public void configTest() {
        String filePath = this.getClass().getClassLoader()
                .getResource("config/ExceptionConfig-test.xml").getPath();
        try {
            filePath = java.net.URLDecoder.decode(filePath, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("filePath=" + filePath);
		/*
		 * 检查配置文件---异常内容加载是否正确
		 */
        XmlConcreteException xce = ExceptionConfig.getXmlConcreteException(
                "01", "0100", "010000", "000");
        System.out.println("010001:000 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("user模块具体异常描述000", xce.getExceptionDesc());
        Assert.assertEquals("2", xce.getLevel().toString());
		
		/*
		 * 检查配置文件 --处理方式内容加载是否正确
		 */
//		Iterator<?> it_mail = ExceptionConfig.getEmailsIterator();
//		Assert.assertEquals("test1@163.com", it_mail.next());
//		Assert.assertEquals("test2@163.com", it_mail.next());
//		Assert.assertEquals("test3@163.com", it_mail.next());
//		Iterator<?> it_tel = ExceptionConfig.getTelsIterator();
//		Assert.assertEquals("152xxxxxxx1", it_tel.next());
//		Assert.assertEquals("152xxxxxxx2", it_tel.next());
//		Assert.assertEquals("152xxxxxxx3", it_tel.next());
		/*
		 * 检查配置文件 --处理级别内容加载是否正确
		 */

        boolean isSave = ExceptionConfig.getLevelHandle("0").isSave();
        boolean isWarning = ExceptionConfig.getLevelHandle("0").isWarning();
        Assert.assertEquals(false, isSave);
        Assert.assertEquals(false, isWarning);

        isSave = ExceptionConfig.getLevelHandle("1").isSave();
        isWarning = ExceptionConfig.getLevelHandle("1").isWarning();
        Assert.assertEquals(false, isSave);
        Assert.assertEquals(true, isWarning);

        isSave = ExceptionConfig.getLevelHandle("2").isSave();
        isWarning = ExceptionConfig.getLevelHandle("2").isWarning();
        Assert.assertEquals(true, isSave);
        Assert.assertEquals(false, isWarning);

        isSave = ExceptionConfig.getLevelHandle("3").isSave();
        isWarning = ExceptionConfig.getLevelHandle("3").isWarning();
        Assert.assertEquals(true, isSave);
        Assert.assertEquals(true, isWarning);
    }
}