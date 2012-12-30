package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;

/**
 * service-claim模块异常
 * 
 * @author zhujinwei
 * 
 */
public class ClaimServiceException extends BusinessException {
	private static final String subuserexceptionCode = "010005";

	private ClaimServiceException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
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
			Throwable cause, ExceptionLevel level) {
		return new ClaimServiceException(null, msg, cause, level);
	}

	private static final long serialVersionUID = ClaimServiceException.class
			.hashCode();

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}
}
