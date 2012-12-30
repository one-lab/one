package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * Common Payment模块异常
 * 
 * @author zhujinwei
 * 
 */
public class PaymentCommonException extends BusinessException {
	private static final String subuserexceptionCode = "010016";

	private PaymentCommonException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static PaymentCommonException newInstanceCode(
			String concreteExceptionCode) {
		return new PaymentCommonException(concreteExceptionCode,
				null, null, null);
	}

	public static PaymentCommonException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new PaymentCommonException(concreteExceptionCode,
				null, cause, null);
	}

	public static PaymentCommonException newInstanceMsg(String msg) {
		return new PaymentCommonException(null, msg, null, null);
	}

	public static PaymentCommonException newInstanceMsg(String msg,
			Throwable cause) {
		return new PaymentCommonException(null, msg, cause, null);
	}

	public static PaymentCommonException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new PaymentCommonException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}