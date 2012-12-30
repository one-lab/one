package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;

/**
 * service-card模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CardServiceException extends BusinessException {
	private static final String subuserexceptionCode = "010003";

	private CardServiceException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
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
			Throwable cause, ExceptionLevel level) {
		return new CardServiceException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
