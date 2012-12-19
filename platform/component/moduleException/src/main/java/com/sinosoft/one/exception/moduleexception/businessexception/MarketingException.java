package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * Marketing模块异常
 * 
 * @author zhujinwei
 * 
 */
public class MarketingException extends BusinessException {
	private static final String subUserExceptionCode = "010017";

	private MarketingException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
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
			Throwable cause, ExceptionGrade grade) {
		return new MarketingException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}