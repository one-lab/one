package com.sinosoft.one.exception.moduleexception.dataverify;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.DataVerifyException;
/**
 * Mis模块异常
 * 
 * @author zhujinwei
 * 
 */
public class MisException extends DataVerifyException {
	private static final String subuserexceptionCode = "010101";

	private MisException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static MisException newInstanceCode(String concreteExceptionCode) {
		return new MisException(concreteExceptionCode, null, null, null);
	}

	public static MisException newInstanceCode(String concreteExceptionCode,
			Throwable cause) {
		return new MisException(concreteExceptionCode, null, cause, null);
	}

	public static MisException newInstanceMsg(String msg) {
		return new MisException(null, msg, null, null);
	}

	public static MisException newInstanceMsg(String msg, Throwable cause) {
		return new MisException(null, msg, cause, null);
	}

	public static MisException newInstanceMsg(String msg, Throwable cause,
			ExceptionLevel level) {
		return new MisException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}