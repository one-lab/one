package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * Marketing模块异常
 * 
 * @author zhujinwei
 * 
 */
public class MarketingException extends BusinessException {
	private static final String subuserexceptionCode = "010017";

	private MarketingException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static MarketingException newInstanceCode(
			String concreteExceptionCode) {
		return new MarketingException(concreteExceptionCode,
				null, null, null);
	}

	public static MarketingException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new MarketingException(concreteExceptionCode,
				null, cause, null);
	}

	public static MarketingException newInstanceMsg(String msg) {
		return new MarketingException(null, msg, null, null);
	}

	public static MarketingException newInstanceMsg(String msg,
			Throwable cause) {
		return new MarketingException(null, msg, cause, null);
	}

	public static MarketingException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new MarketingException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}