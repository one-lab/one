package com.sinosoft.one.exception;

import com.sinosoft.one.exception.userexception.BusinessException;

public class GeProposalBusinessException extends BusinessException {
	private static final String subUserExceptionCode = "010001";

	private GeProposalBusinessException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static GeProposalBusinessException newInstanceCode(
			String concreteExceptionCode) {
		return new GeProposalBusinessException(concreteExceptionCode, null,
				null, null);
	}

	public static GeProposalBusinessException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new GeProposalBusinessException(concreteExceptionCode, null,
				cause, null);
	}

	public static GeProposalBusinessException newInstanceMsg(String msg) {
		return new GeProposalBusinessException(null, msg, null, null);
	}

	public static GeProposalBusinessException newInstanceMsg(String msg,
			Throwable cause) {
		return new GeProposalBusinessException(null, msg, cause, null);
	}

	public static GeProposalBusinessException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new GeProposalBusinessException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
