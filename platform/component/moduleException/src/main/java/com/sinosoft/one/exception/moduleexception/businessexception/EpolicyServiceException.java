package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;

import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * service-Epolicy模块异常
 * 
 * @author zhujinwei
 * 
 */
public class EpolicyServiceException extends BusinessException {
	private static final String subUserExceptionCode = "010004";

	private EpolicyServiceException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
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
			Throwable cause, ExceptionGrade grade) {
		return new EpolicyServiceException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
