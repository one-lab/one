package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;

/**
 * manage-card模块异常
 * 
 * @author zhujinwei
 * 
 */
public class CardManageException extends BusinessException {
	private static final String subUserExceptionCode = "010009";

	private CardManageException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
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
			Throwable cause, ExceptionGrade grade) {
		return new CardManageException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}