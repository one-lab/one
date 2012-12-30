package com.sinosoft.one.exception;

import com.sinosoft.one.exception.userexception.BusinessException;

public class GeProposalBusinessException extends BusinessException {
	private static final String subUserExceptionCode = "010001";

	private GeProposalBusinessException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
