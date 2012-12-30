package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * service-Policy模块异常
 * 
 * @author zhujinwei
 * 
 */
public class PolicyServiceException extends BusinessException {
	private static final String subuserexceptionCode = "010006";

	private PolicyServiceException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static PolicyServiceException newInstanceCode(
			String concreteExceptionCode) {
		return new PolicyServiceException(concreteExceptionCode, null, null,
				null);
	}

	public static PolicyServiceException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new PolicyServiceException(concreteExceptionCode, null, cause,
				null);
	}

	public static PolicyServiceException newInstanceMsg(String msg) {
		return new PolicyServiceException(null, msg, null, null);
	}

	public static PolicyServiceException newInstanceMsg(String msg,
			Throwable cause) {
		return new PolicyServiceException(null, msg, cause, null);
	}

	public static PolicyServiceException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new PolicyServiceException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
