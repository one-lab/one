package com.sinosoft.one.exception.moduleexception;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionConfig;
import com.sinosoft.one.ebusiness.sys.exception.ExceptionConfigInit;
import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.XmlConcreteException;
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
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("userģ������쳣����000", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.MORESERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_2();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("userģ������쳣����001", e.getMsg());
			Assert.assertNotNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.SERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_3();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_4();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_5();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_6();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_7();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_8();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_9();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("Ͷ���쳣", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());
		}
		try {
			ExceptionTestService.method_10();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("Ͷ���쳣", e.getMsg());
			Assert.assertNotNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_11();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("Ͷ���쳣", e.getMsg());
			Assert.assertNotNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.MORESERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_12();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_13();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_14();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_15();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_16();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("Ͷ���쳣", e.getMsg());
			Assert.assertNotNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_17();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_18();
		} catch (UserServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_19();
		} catch (MaintainServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("service-maintainģ���쳣����000", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.UNSERIOUS, e.getGrade());

		}
		try {
			ExceptionTestService.method_20();
		} catch (MaintainServiceException e) {
			System.out.println("�쳣��Ϣ�ǣ�" + e.getMsg());
			Assert.assertEquals("service-maintainģ���쳣����001", e.getMsg());
			Assert.assertNull(e.getCause());
			Assert.assertEquals(ExceptionGrade.SERIOUS, e.getGrade());

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
		 * ��������ļ�---�쳣���ݼ����Ƿ���ȷ
		 */
		XmlConcreteException xce = ExceptionConfig.getXmlConcreteException(
				"01", "0100", "010000", "000");
		System.out.println("010001:000 " + xce.getExceptionDesc() + " "
				+ xce.getGrade().toString());
		Assert.assertEquals("userģ������쳣����000", xce.getExceptionDesc());
		Assert.assertEquals("2", xce.getGrade().toString());
		
		/*
		 * ��������ļ� --���?ʽ���ݼ����Ƿ���ȷ
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
		 * ��������ļ� --���?�����ݼ����Ƿ���ȷ
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
