package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;

/**
 * service-User模块异常
 * 
 * @author zhujinwei
 * 
 */
public class InterfacePortalException extends BusinessException {
	private static final String subuserexceptionCode = "010020";

	private InterfacePortalException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
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
			Throwable cause, ExceptionLevel level) {
		return new InterfacePortalException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
