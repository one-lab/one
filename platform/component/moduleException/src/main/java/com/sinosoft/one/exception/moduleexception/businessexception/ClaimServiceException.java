package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;

import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;

/**
 * service-claim模块异常
 * 
 * @author zhujinwei
 * 
 */
public class ClaimServiceException extends BusinessException {
	private static final String subUserExceptionCode = "010005";

	private ClaimServiceException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static ClaimServiceException newInstanceCode(
			String concreteExceptionCode) {
		return new ClaimServiceException(concreteExceptionCode, null, null,
				null);
	}

	public static ClaimServiceException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new ClaimServiceException(concreteExceptionCode, null, cause,
				null);
	}

	public static ClaimServiceException newInstanceMsg(String msg) {
		return new ClaimServiceException(null, msg, null, null);
	}

	public static ClaimServiceException newInstanceMsg(String msg,
			Throwable cause) {
		return new ClaimServiceException(null, msg, cause, null);
	}

	public static ClaimServiceException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new ClaimServiceException(null, msg, cause, grade);
	}

	private static final long serialVersionUID = ClaimServiceException.class
			.hashCode();

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}
}
