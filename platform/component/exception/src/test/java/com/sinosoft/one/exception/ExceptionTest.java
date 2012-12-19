package com.sinosoft.one.exception;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinosoft.one.exception.service.ExceptionTestService;

/**
 * 异常测试
 */
public class ExceptionTest {

    @SuppressWarnings("unused")
    @Test
    public void exceptionTest() {

        ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-exception-test.xml");
        ExceptionConfigInit ec = (ExceptionConfigInit) beanFactory
                .getBean("exceptionConfigInit");
        try {
            ExceptionTestService.method_1();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("无满足条件的记录", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.MORESERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_2();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("没有设置参数", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.SERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_3();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_4();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_5();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_6();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_7();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_8();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_9();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
        }
        try {
            ExceptionTestService.method_10();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_11();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.MORESERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_12();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_13();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_14();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_15();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_16();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("投保异常", e.getMsg());
            Assert.assertNotNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_17();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_18();
        } catch (GeProposalBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_19();
        } catch (GeUnderwriteBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("无法核保", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

        }
        try {
            ExceptionTestService.method_20();
        } catch (GeUnderwriteBusinessException e) {
            System.out.println("异常信息是：" + e.getMsg());
            Assert.assertEquals("核保失败", e.getMsg());
            Assert.assertNull(e.getCause());
            Assert.assertEquals(ExceptionGrade.SERIOUS, e.getGrade());

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
        System.out.println(ExceptionConfig.getGradeHandle("1")
                .getExceptionGradeDesc());
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
                + xce.getGrade().toString());
        Assert.assertEquals("无满足条件的记录", xce.getExceptionDesc());
        Assert.assertEquals("2", xce.getGrade().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0100", "010001",
                "001");
        System.out.println("010001:001 " + xce.getExceptionDesc() + " "
                + xce.getGrade().toString());
        Assert.assertEquals("没有设置参数", xce.getExceptionDesc());
        Assert.assertEquals("1", xce.getGrade().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0100", "010002",
                "000");
        System.out.println("010002:000 " + xce.getExceptionDesc() + " "
                + xce.getGrade().toString());
        Assert.assertEquals("无法核保", xce.getExceptionDesc());
        Assert.assertEquals("0", xce.getGrade().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0100", "010002",
                "001");
        System.out.println("010002:001 " + xce.getExceptionDesc() + " "
                + xce.getGrade().toString());
        Assert.assertEquals("核保失败", xce.getExceptionDesc());
        Assert.assertEquals("1", xce.getGrade().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0100", "010003",
                "000");
        System.out.println("010003:000 " + xce.getExceptionDesc() + " "
                + xce.getGrade().toString());
        Assert.assertEquals("报价异常", xce.getExceptionDesc());
        Assert.assertEquals("0", xce.getGrade().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0101", "010100",
                "000");
        System.out.println("010100:000 " + xce.getExceptionDesc() + " "
                + xce.getGrade().toString());
        Assert.assertEquals("数据校验异常1", xce.getExceptionDesc());
        Assert.assertEquals("0", xce.getGrade().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0101", "010100",
                "001");
        System.out.println("010100:001 " + xce.getExceptionDesc() + " "
                + xce.getGrade().toString());
        Assert.assertEquals("数据校验异常2", xce.getExceptionDesc());
        Assert.assertEquals("0", xce.getGrade().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0102", "010200",
                "000");
        System.out.println("010200:000 " + xce.getExceptionDesc() + " "
                + xce.getGrade().toString());
        Assert.assertEquals("权限异常1", xce.getExceptionDesc());
        Assert.assertEquals("1", xce.getGrade().toString());
        xce = ExceptionConfig.getXmlConcreteException("01", "0102", "010200",
                "001");
        System.out.println("010200:001 " + xce.getExceptionDesc() + " "
                + xce.getGrade().toString());
        Assert.assertEquals("权限异常2", xce.getExceptionDesc());
        Assert.assertEquals("1", xce.getGrade().toString());
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
        String isSendEmail = ExceptionConfig.getGradeHandle("0")
                .getIsSendEmail();
        String isSendSms = ExceptionConfig.getGradeHandle("0").getIsSendSms();
        Assert.assertEquals("0", isSendEmail);
        Assert.assertEquals("0", isSendSms);
        isSendEmail = ExceptionConfig.getGradeHandle("1").getIsSendEmail();
        isSendSms = ExceptionConfig.getGradeHandle("1").getIsSendSms();
        Assert.assertEquals("1", isSendEmail);
        Assert.assertEquals("0", isSendSms);
        isSendEmail = ExceptionConfig.getGradeHandle("2").getIsSendEmail();
        isSendSms = ExceptionConfig.getGradeHandle("2").getIsSendSms();
        Assert.assertEquals("0", isSendEmail);
        Assert.assertEquals("1", isSendSms);
        isSendEmail = ExceptionConfig.getGradeHandle("3").getIsSendEmail();
        isSendSms = ExceptionConfig.getGradeHandle("3").getIsSendSms();
        Assert.assertEquals("1", isSendEmail);
        Assert.assertEquals("1", isSendSms);
    }
}
