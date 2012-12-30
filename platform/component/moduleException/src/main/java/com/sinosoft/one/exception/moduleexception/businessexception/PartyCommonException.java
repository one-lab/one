package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * common-party模块异常
 * 
 * @author zhujinwei
 * 
 */
public class PartyCommonException extends BusinessException {
	private static final String subuserexceptionCode = "010014";

	private PartyCommonException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
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
			Throwable cause, ExceptionLevel level) {
		return new PartyCommonException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}