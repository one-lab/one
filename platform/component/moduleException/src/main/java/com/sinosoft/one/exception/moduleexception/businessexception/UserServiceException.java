package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * service-User模块异常
 * 
 * @author zhujinwei
 * 
 */
public class UserServiceException extends BusinessException {
	private static final String subuserexceptionCode = "010000";

	private UserServiceException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static UserServiceException newInstanceCode(
			String concreteExceptionCode) {
		return new UserServiceException(concreteExceptionCode, null,
				null, null);
	}

	public static UserServiceException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new UserServiceException(concreteExceptionCode, null,
				cause, null);
	}

	public static UserServiceException newInstanceMsg(String msg) {
		return new UserServiceException(null, msg, null, null);
	}

	public static UserServiceException newInstanceMsg(String msg,
			Throwable cause) {
		return new UserServiceException(null, msg, cause, null);
	}

	public static UserServiceException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new UserServiceException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
