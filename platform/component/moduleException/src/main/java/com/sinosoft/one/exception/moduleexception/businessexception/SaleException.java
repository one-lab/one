package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * Sale模块异常
 * 
 * @author zhujinwei
 * 
 */
public class SaleException extends BusinessException {
	private static final String subuserexceptionCode = "010018";

	private SaleException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static SaleException newInstanceCode(
			String concreteExceptionCode) {
		return new SaleException(concreteExceptionCode,
				null, null, null);
	}

	public static SaleException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new SaleException(concreteExceptionCode,
				null, cause, null);
	}

	public static SaleException newInstanceMsg(String msg) {
		return new SaleException(null, msg, null, null);
	}

	public static SaleException newInstanceMsg(String msg,
			Throwable cause) {
		return new SaleException(null, msg, cause, null);
	}

	public static SaleException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new SaleException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}