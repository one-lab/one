package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * ommon-credit模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CreditConfigCommonException extends BusinessException {
	private static final String subuserexceptionCode = "010015";

	private CreditConfigCommonException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
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
			Throwable cause, ExceptionLevel level) {
		return new CreditConfigCommonException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}