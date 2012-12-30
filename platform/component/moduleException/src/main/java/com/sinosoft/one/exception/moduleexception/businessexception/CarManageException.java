package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * manage-car模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CarManageException extends BusinessException {
	private static final String subuserexceptionCode = "010008";

	private CarManageException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
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
			Throwable cause, ExceptionLevel level) {
		return new CarManageException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}