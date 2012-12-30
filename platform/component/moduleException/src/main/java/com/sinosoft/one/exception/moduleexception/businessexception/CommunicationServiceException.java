package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * service-Communication模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CommunicationServiceException extends BusinessException {
	private static final String subuserexceptionCode = "010002";

	private CommunicationServiceException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static CommunicationServiceException newInstanceCode(
			String concreteExceptionCode) {
		return new CommunicationServiceException(concreteExceptionCode, null,
				null, null);
	}

	public static CommunicationServiceException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new CommunicationServiceException(concreteExceptionCode, null,
				cause, null);
	}

	public static CommunicationServiceException newInstanceMsg(String msg) {
		return new CommunicationServiceException(null, msg, null, null);
	}

	public static CommunicationServiceException newInstanceMsg(String msg,
			Throwable cause) {
		return new CommunicationServiceException(null, msg, cause, null);
	}

	public static CommunicationServiceException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new CommunicationServiceException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
