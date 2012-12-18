package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;

/**
 * common-bizConfig模块异常
 * 
 * @author zhujinwei
 * 
 */
public class BizConfigCommonException extends BusinessException {
	private static final String subUserExceptionCode = "010011";

	private BizConfigCommonException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static BizConfigCommonException newInstanceCode(
			String concreteExceptionCode) {
		return new BizConfigCommonException(concreteExceptionCode, null, null,
				null);
	}

	public static BizConfigCommonException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new BizConfigCommonException(concreteExceptionCode, null, cause,
				null);
	}

	public static BizConfigCommonException newInstanceMsg(String msg) {
		return new BizConfigCommonException(null, msg, null, null);
	}

	public static BizConfigCommonException newInstanceMsg(String msg,
			Throwable cause) {
		return new BizConfigCommonException(null, msg, cause, null);
	}

	public static BizConfigCommonException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new BizConfigCommonException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}