package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;

import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;

/**
 * service-User模块异常
 * 
 * @author zhujinwei
 * 
 */
public class InterfacePortalException extends BusinessException {
	private static final String subUserExceptionCode = "010020";

	private InterfacePortalException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static InterfacePortalException newInstanceCode(
			String concreteExceptionCode) {
		return new InterfacePortalException(concreteExceptionCode, null, null,
				null);
	}

	public static InterfacePortalException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new InterfacePortalException(concreteExceptionCode, null, cause,
				null);
	}

	public static InterfacePortalException newInstanceMsg(String msg) {
		return new InterfacePortalException(null, msg, null, null);
	}

	public static InterfacePortalException newInstanceMsg(String msg,
			Throwable cause) {
		return new InterfacePortalException(null, msg, cause, null);
	}

	public static InterfacePortalException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new InterfacePortalException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
