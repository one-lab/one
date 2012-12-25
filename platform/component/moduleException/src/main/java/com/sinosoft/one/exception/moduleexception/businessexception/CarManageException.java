package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * manage-car模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CarManageException extends BusinessException {
	private static final String subUserExceptionCode = "010008";

	private CarManageException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static CarManageException newInstanceCode(
			String concreteExceptionCode) {
		return new CarManageException(concreteExceptionCode,
				null, null, null);
	}

	public static CarManageException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new CarManageException(concreteExceptionCode,
				null, cause, null);
	}

	public static CarManageException newInstanceMsg(String msg) {
		return new CarManageException(null, msg, null, null);
	}

	public static CarManageException newInstanceMsg(String msg,
			Throwable cause) {
		return new CarManageException(null, msg, cause, null);
	}

	public static CarManageException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new CarManageException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}