package com.sinosoft.one.exception;

import com.sinosoft.one.exception.userexception.BusinessException;

public class GeUnderwriteBusinessException extends BusinessException {
	private static final String subUserExceptionCode = "010002";

	private GeUnderwriteBusinessException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static GeUnderwriteBusinessException newInstanceCode(
			String concreteExceptionCode) {
		return new GeUnderwriteBusinessException(concreteExceptionCode, null,
				null, null);
	}

	public static GeUnderwriteBusinessException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new GeUnderwriteBusinessException(concreteExceptionCode, null,
				cause, null);
	}

	public static GeUnderwriteBusinessException newInstanceMsg(String msg) {
		return new GeUnderwriteBusinessException(null, msg, null, null);
	}

	public static GeUnderwriteBusinessException newInstanceMsg(String msg,
			Throwable cause) {
		return new GeUnderwriteBusinessException(null, msg, cause, null);
	}

	public static GeUnderwriteBusinessException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new GeUnderwriteBusinessException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
