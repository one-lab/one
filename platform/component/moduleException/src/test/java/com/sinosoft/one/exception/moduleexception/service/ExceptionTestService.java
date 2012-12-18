package com.sinosoft.one.exception.moduleexception.service;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.exception.moduleexception.businessexception.MaintainServiceException;
import com.sinosoft.one.exception.moduleexception.businessexception.PaymentCommonException;
import com.sinosoft.one.exception.moduleexception.businessexception.UserServiceException;

public class ExceptionTestService {

	/*
	 * code��ʽ���쳣 --��ȷ��ʽ
	 */
	public static void method_1() throws UserServiceException {
		System.out.println("code��ʽ��ȷ����1�׳��쳣");
		throw UserServiceException.newInstanceCode("000");
	}

	public static void method_2() throws UserServiceException {
		System.out.println("code��ʽ��ȷ����2�׳��쳣");
		throw UserServiceException.newInstanceCode("001",
				new Throwable());
	}

	/*
	 * code��ʽ���쳣 --����ʽ
	 */
	public static void method_3() throws UserServiceException {
		System.out.println("code��ʽ���󷽷�3�׳��쳣");
		throw UserServiceException.newInstanceCode(null);
	}

	public static void method_4() throws UserServiceException {
		System.out.println("code��ʽ���󷽷�4�׳��쳣");
		throw UserServiceException.newInstanceCode("xxxx");
	}

	public static void method_5() throws UserServiceException {
		System.out.println("code��ʽ���󷽷�5�׳��쳣");
		throw UserServiceException.newInstanceCode("");
	}

	public static void method_6() throws UserServiceException {
		System.out.println("code��ʽ���󷽷�6�׳��쳣");
		throw UserServiceException.newInstanceCode(null, null);
	}

	public static void method_7() throws UserServiceException {
		System.out.println("code��ʽ���󷽷�7�׳��쳣");
		throw UserServiceException.newInstanceCode("xxx", null);
	}

	public static void method_8() throws UserServiceException {
		System.out.println("code��ʽ���󷽷�8�׳��쳣");
		throw UserServiceException.newInstanceCode("", null);
	}

	public static void method_19() throws MaintainServiceException {
		System.out.println("code��ʽ���󷽷�19�׳��쳣  �����ļ�δ���ü�������");
		throw MaintainServiceException.newInstanceCode("000");
	}
	public static void method_20() throws MaintainServiceException {
		System.out.println("code��ʽ���󷽷�20�׳��쳣  �����ļ������������ô���");
		throw MaintainServiceException.newInstanceCode("001");
	}
	/*
	 * msg��ʽ���쳣 --��ȷ��ʽ
	 */
	public static void method_9() throws UserServiceException {
		System.out.println("msg��ʽ��ȷ����9�׳��쳣");
		throw UserServiceException.newInstanceMsg("Ͷ���쳣");
	}

	public static void method_10() throws UserServiceException {
		System.out.println("msg��ʽ��ȷ����10�׳��쳣");
		throw UserServiceException.newInstanceMsg("Ͷ���쳣",
				new Throwable());
	}

	public static void method_11() throws UserServiceException {
		System.out.println("msg��ʽ��ȷ����11�׳��쳣");
		throw UserServiceException.newInstanceMsg("Ͷ���쳣",
				new Throwable(), ExceptionGrade.MORESERIOUS);
	}

	/*
	 * msg��ʽ���쳣 --����ʽ
	 */
	public static void method_12() throws UserServiceException {
		System.out.println("msg��ʽ���󷽷�12�׳��쳣");
		throw UserServiceException.newInstanceMsg("");
	}

	public static void method_13() throws UserServiceException {
		System.out.println("msg��ʽ���󷽷�13�׳��쳣");
		throw UserServiceException.newInstanceMsg(null);
	}

	public static void method_14() throws UserServiceException {
		System.out.println("msg��ʽ����14�׳��쳣");
		throw UserServiceException.newInstanceMsg(null, null);
	}

	public static void method_15() throws UserServiceException {
		System.out.println("msg��ʽ���󷽷�15�׳��쳣");
		throw UserServiceException.newInstanceMsg(null, null, null);
	}

	public static void method_16() throws UserServiceException {
		System.out.println("msg��ʽ���󷽷�16�׳��쳣");
		throw UserServiceException.newInstanceMsg("Ͷ���쳣",
				new Throwable(), null);
	}

	public static void method_17() throws UserServiceException {
		System.out.println("msg��ʽ���󷽷�17�׳��쳣");
		throw UserServiceException.newInstanceMsg("", null);
	}

	public static void method_18() throws UserServiceException {
		System.out.println("msg��ʽ���󷽷�18�׳��쳣");
		throw UserServiceException.newInstanceMsg("", null, null);
	}
//����PaymentCommonException�쳣
	public static void method_49() throws PaymentCommonException {
//		System.out.println("msg��ʽ���󷽷�18�׳��쳣");
		throw PaymentCommonException.newInstanceCode("002");
	}
}
