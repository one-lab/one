package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * common-publishInfo模块异常
 * 
 * @author zhujinwei
 * 
 */
public class PublishInfoCommonException extends BusinessException {
	private static final String subuserexceptionCode = "010012";

	private PublishInfoCommonException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
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
			Throwable cause, ExceptionLevel level) {
		return new PublishInfoCommonException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}