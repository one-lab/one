package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;

/**
 * common-bizConfig模块异常
 * 
 * @author zhujinwei
 * 
 */
public class BizConfigCommonException extends BusinessException {
	private static final String subuserexceptionCode = "010011";

	private BizConfigCommonException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static BizConfigCommonException newInstanceCode(
			String concreteExceptionCode) {
		return new BizConfigCommonException(concreteExceptionCode, null, null,
				null);
	}

	public static BizConfigCommonException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new BizConfigCommonException(concreteExceptionCode, null, cause,
				null);
	}

	public static BizConfigCommonException newInstanceMsg(String msg) {
		return new BizConfigCommonException(null, msg, null, null);
	}

	public static BizConfigCommonException newInstanceMsg(String msg,
			Throwable cause) {
		return new BizConfigCommonException(null, msg, cause, null);
	}

	public static BizConfigCommonException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new BizConfigCommonException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}