package com.sinosoft.one.exception.moduleexception.dataverify;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.DataVerifyException;
/**
 * Online模块异常
 * 
 * @author zhujinwei
 * 
 */
public class OnlineException extends DataVerifyException {
	private static final String subUserExceptionCode = "010100";

	private OnlineException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
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
			ExceptionGrade grade) {
		return new OnlineException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}