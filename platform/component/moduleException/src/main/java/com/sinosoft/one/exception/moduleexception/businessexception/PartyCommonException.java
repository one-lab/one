package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * common-party模块异常
 * 
 * @author zhujinwei
 * 
 */
public class PartyCommonException extends BusinessException {
	private static final String subUserExceptionCode = "010014";

	private PartyCommonException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static PartyCommonException newInstanceCode(
			String concreteExceptionCode) {
		return new PartyCommonException(concreteExceptionCode,
				null, null, null);
	}

	public static PartyCommonException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new PartyCommonException(concreteExceptionCode,
				null, cause, null);
	}

	public static PartyCommonException newInstanceMsg(String msg) {
		return new PartyCommonException(null, msg, null, null);
	}

	public static PartyCommonException newInstanceMsg(String msg,
			Throwable cause) {
		return new PartyCommonException(null, msg, cause, null);
	}

	public static PartyCommonException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new PartyCommonException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}