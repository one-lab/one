package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;

import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * service-Maintain模块异常
 * 
 * @author zhujinwei
 * 
 */
public class MaintainServiceException extends BusinessException {
	private static final String subUserExceptionCode = "010001";

	private MaintainServiceException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
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
			Throwable cause, ExceptionGrade grade) {
		return new MaintainServiceException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
