package com.sinosoft.one.exception;

import com.sinosoft.one.exception.userexception.BusinessException;

public class GeUnderwriteBusinessException extends BusinessException {
	private static final String subUserExceptionCode = "010002";

	private GeUnderwriteBusinessException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
