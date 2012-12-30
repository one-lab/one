package com.sinosoft.one.exception;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinosoft.one.exception.service.ExceptionTestService;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * 异常测试
 */
@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-exception.xml",
        "/spring/applicationContext-notification.xml", "/spring/applicationContext-exception-test.xml" })
public class ExceptionTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ExceptionConfigInit ec;
    @SuppressWarnings("unused")
    @Test
    public void exceptionTest() {
        try {
            ExceptionTestService.method_1();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("无满足条件的记录", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.MORESERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_2();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("没有设置参数", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.SERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_3();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_4();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_5();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_6();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_7();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_8();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_9();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());
        }
        try {
            ExceptionTestService.method_10();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_11();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.MORESERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_12();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_13();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_14();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_15();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_16();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_17();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_18();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_19();
        } catch (GeUnderwriteBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("无法核保", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.UNSERIOUS, e.getLevel());

        }
        try {
            ExceptionTestService.method_20();
        } catch (GeUnderwriteBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("核保失败", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionLevel.SERIOUS, e.getLevel());

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
                "01", "0100", "010001", "000");
        System.out.println("010001:000 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("无满足条件的记录", xce.getExceptionDesc());
        Assert.assertEquals("2", xce.getLevel().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0100", "010001",
                "001");
        System.out.println("010001:001 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("没有设置参数", xce.getExceptionDesc());
        Assert.assertEquals("1", xce.getLevel().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0100", "010002",
                "000");
        System.out.println("010002:000 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("无法核保", xce.getExceptionDesc());
        Assert.assertEquals("0", xce.getLevel().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0100", "010002",
                "001");
        System.out.println("010002:001 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("核保失败", xce.getExceptionDesc());
        Assert.assertEquals("1", xce.getLevel().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0100", "010003",
                "000");
        System.out.println("010003:000 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("报价异常", xce.getExceptionDesc());
        Assert.assertEquals("0", xce.getLevel().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0101", "010100",
                "000");
        System.out.println("010100:000 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("数据校验异常1", xce.getExceptionDesc());
        Assert.assertEquals("0", xce.getLevel().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0101", "010100",
                "001");
        System.out.println("010100:001 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("数据校验异常2", xce.getExceptionDesc());
        Assert.assertEquals("0", xce.getLevel().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0102", "010200",
                "000");
        System.out.println("010200:000 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("权限异常1", xce.getExceptionDesc());
        Assert.assertEquals("1", xce.getLevel().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0102", "010200",
                "001");
        System.out.println("010200:001 " + xce.getExceptionDesc() + " "
                + xce.getLevel().toString());
        Assert.assertEquals("权限异常2", xce.getExceptionDesc());
        Assert.assertEquals("1", xce.getLevel().toString());
        /*
           * 检查配置文件 --处理方式内容加载是否正确
           */
//		Iterator<?> it_mail = ExceptionConfig.getEmailsIterator();
//		Assert.assertEquals("test1@163.com", it_mail.next());
//		Assert.assertEquals("test2@163.com", it_mail.next());
//		Assert.assertEquals("test3@163.com", it_mail.next());
//		Iterator<?> it_tel = ExceptionConfig.getTelsIterator();
//		Assert.assertEquals("15210609387", it_tel.next());
        /*
           * 检查配置文件 --处理级别内容加载是否正确
           */
        boolean isSave = ExceptionConfig.getLevelHandle("0").isSave();
        Assert.assertEquals(false, isSave);
        boolean isWarning = ExceptionConfig.getLevelHandle("0").isWarning();
        Assert.assertEquals(false, isWarning);

        isSave = ExceptionConfig.getLevelHandle("1").isSave();
        Assert.assertEquals(false, isSave);
        isWarning = ExceptionConfig.getLevelHandle("1").isWarning();
        Assert.assertEquals(true, isWarning);

        isSave = ExceptionConfig.getLevelHandle("2").isSave();
        Assert.assertEquals(true, isSave);
        isWarning = ExceptionConfig.getLevelHandle("2").isWarning();
        Assert.assertEquals(true, isWarning);

        isSave = ExceptionConfig.getLevelHandle("3").isSave();
        Assert.assertEquals(true, isSave);
        isWarning = ExceptionConfig.getLevelHandle("3").isWarning();
        Assert.assertEquals(true, isWarning);
    }
}
