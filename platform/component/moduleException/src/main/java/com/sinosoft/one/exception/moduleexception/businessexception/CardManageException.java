package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;

/**
 * manage-card模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CardManageException extends BusinessException {
	private static final String subuserexceptionCode = "010009";

	private CardManageException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static CardManageException newInstanceCode(
			String concreteExceptionCode) {
		return new CardManageException(concreteExceptionCode, null, null, null);
	}

	public static CardManageException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new CardManageException(concreteExceptionCode, null, cause, null);
	}

	public static CardManageException newInstanceMsg(String msg) {
		return new CardManageException(null, msg, null, null);
	}

	public static CardManageException newInstanceMsg(String msg, Throwable cause) {
		return new CardManageException(null, msg, cause, null);
	}

	public static CardManageException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new CardManageException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}