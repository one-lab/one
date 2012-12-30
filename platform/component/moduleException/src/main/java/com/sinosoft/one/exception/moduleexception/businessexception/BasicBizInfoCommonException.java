package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;

/**
 * common-basicBizInfo模块异常
 * 
 * @author zhujinwei
 * 
 */
public class BasicBizInfoCommonException extends BusinessException {
	private static final String subuserexceptionCode = "010013";

	protected BasicBizInfoCommonException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static BasicBizInfoCommonException newInstanceCode(
			String concreteExceptionCode) {
		return new BasicBizInfoCommonException(concreteExceptionCode, null,
				null, null);
	}



	public static BasicBizInfoCommonException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new BasicBizInfoCommonException(concreteExceptionCode, null,
				cause, null);
	}

	public static BasicBizInfoCommonException newInstanceMsg(String msg) {
		return new BasicBizInfoCommonException(null, msg, null, null);
	}

	public static BasicBizInfoCommonException newInstanceMsg(String msg,
			Throwable cause) {
		return new BasicBizInfoCommonException(null, msg, cause, null);
	}

	public static BasicBizInfoCommonException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new BasicBizInfoCommonException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}