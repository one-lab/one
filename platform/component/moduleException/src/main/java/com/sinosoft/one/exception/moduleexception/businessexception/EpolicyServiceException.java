package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * service-Epolicy模块异常
 * 
 * @author zhujinwei
 * 
 */
public class EpolicyServiceException extends BusinessException {
	private static final String subuserexceptionCode = "010004";

	private EpolicyServiceException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static EpolicyServiceException newInstanceCode(
			String concreteExceptionCode) {
		return new EpolicyServiceException(concreteExceptionCode, null,
				null, null);
	}

	public static EpolicyServiceException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new EpolicyServiceException(concreteExceptionCode, null,
				cause, null);
	}

	public static EpolicyServiceException newInstanceMsg(String msg) {
		return new EpolicyServiceException(null, msg, null, null);
	}

	public static EpolicyServiceException newInstanceMsg(String msg,
			Throwable cause) {
		return new EpolicyServiceException(null, msg, cause, null);
	}

	public static EpolicyServiceException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new EpolicyServiceException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
