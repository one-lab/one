package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * ommon-credit模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CreditConfigCommonException extends BusinessException {
	private static final String subUserExceptionCode = "010015";

	private CreditConfigCommonException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static CreditConfigCommonException newInstanceCode(
			String concreteExceptionCode) {
		return new CreditConfigCommonException(concreteExceptionCode,
				null, null, null);
	}

	public static CreditConfigCommonException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new CreditConfigCommonException(concreteExceptionCode,
				null, cause, null);
	}

	public static CreditConfigCommonException newInstanceMsg(String msg) {
		return new CreditConfigCommonException(null, msg, null, null);
	}

	public static CreditConfigCommonException newInstanceMsg(String msg,
			Throwable cause) {
		return new CreditConfigCommonException(null, msg, cause, null);
	}

	public static CreditConfigCommonException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new CreditConfigCommonException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}