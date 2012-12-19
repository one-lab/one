package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * common-publishInfo模块异常
 * 
 * @author zhujinwei
 * 
 */
public class PublishInfoCommonException extends BusinessException {
	private static final String subUserExceptionCode = "010012";

	private PublishInfoCommonException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static PublishInfoCommonException newInstanceCode(
			String concreteExceptionCode) {
		return new PublishInfoCommonException(concreteExceptionCode,
				null, null, null);
	}

	public static PublishInfoCommonException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new PublishInfoCommonException(concreteExceptionCode,
				null, cause, null);
	}

	public static PublishInfoCommonException newInstanceMsg(String msg) {
		return new PublishInfoCommonException(null, msg, null, null);
	}

	public static PublishInfoCommonException newInstanceMsg(String msg,
			Throwable cause) {
		return new PublishInfoCommonException(null, msg, cause, null);
	}

	public static PublishInfoCommonException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new PublishInfoCommonException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}