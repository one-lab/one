package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * service-Maintain模块异常
 * 
 * @author zhujinwei
 * 
 */
public class MaintainServiceException extends BusinessException {
	private static final String subuserexceptionCode = "010001";

	private MaintainServiceException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static MaintainServiceException newInstanceCode(
			String concreteExceptionCode) {
		return new MaintainServiceException(concreteExceptionCode, null,
				null, null);
	}

	public static MaintainServiceException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new MaintainServiceException(concreteExceptionCode, null,
				cause, null);
	}

	public static MaintainServiceException newInstanceMsg(String msg) {
		return new MaintainServiceException(null, msg, null, null);
	}

	public static MaintainServiceException newInstanceMsg(String msg,
			Throwable cause) {
		return new MaintainServiceException(null, msg, cause, null);
	}

	public static MaintainServiceException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new MaintainServiceException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
