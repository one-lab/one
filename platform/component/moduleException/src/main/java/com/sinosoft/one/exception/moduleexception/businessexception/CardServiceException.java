package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;

import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;

/**
 * service-card模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CardServiceException extends BusinessException {
	private static final String subUserExceptionCode = "010003";

	private CardServiceException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static CardServiceException newInstanceCode(
			String concreteExceptionCode) {
		return new CardServiceException(concreteExceptionCode, null, null, null);
	}

	public static CardServiceException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new CardServiceException(concreteExceptionCode, null, cause,
				null);
	}

	public static CardServiceException newInstanceMsg(String msg) {
		return new CardServiceException(null, msg, null, null);
	}

	public static CardServiceException newInstanceMsg(String msg,
			Throwable cause) {
		return new CardServiceException(null, msg, cause, null);
	}

	public static CardServiceException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new CardServiceException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
