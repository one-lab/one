package com.sinosoft.one.exception.moduleexception.dataverify;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.DataVerifyException;
/**
 * Online模块异常
 * 
 * @author zhujinwei
 * 
 */
public class OnlineException extends DataVerifyException {
	private static final String subuserexceptionCode = "010100";

	private OnlineException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static OnlineException newInstanceCode(String concreteExceptionCode) {
		return new OnlineException(concreteExceptionCode, null, null, null);
	}

	public static OnlineException newInstanceCode(String concreteExceptionCode,
			Throwable cause) {
		return new OnlineException(concreteExceptionCode, null, cause, null);
	}

	public static OnlineException newInstanceMsg(String msg) {
		return new OnlineException(null, msg, null, null);
	}

	public static OnlineException newInstanceMsg(String msg, Throwable cause) {
		return new OnlineException(null, msg, cause, null);
	}

	public static OnlineException newInstanceMsg(String msg, Throwable cause,
			ExceptionLevel level) {
		return new OnlineException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}