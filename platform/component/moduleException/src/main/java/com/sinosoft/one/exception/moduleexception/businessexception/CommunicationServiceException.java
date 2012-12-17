package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;

import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * service-Communication模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CommunicationServiceException extends BusinessException {
	private static final String subUserExceptionCode = "010002";

	private CommunicationServiceException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
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
			Throwable cause, ExceptionGrade grade) {
		return new CommunicationServiceException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
