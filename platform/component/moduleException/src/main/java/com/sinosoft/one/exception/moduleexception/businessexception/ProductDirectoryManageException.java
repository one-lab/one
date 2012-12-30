package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * manage-productDirectory模块异常
 * 
 * @author zhujinwei
 * 
 */
public class ProductDirectoryManageException extends BusinessException {
	private static final String subuserexceptionCode = "010007";

	private ProductDirectoryManageException(String concreteExceptionCode, String msg,
			Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static ProductDirectoryManageException newInstanceCode(
			String concreteExceptionCode) {
		return new ProductDirectoryManageException(concreteExceptionCode, null, null,
				null);
	}

	public static ProductDirectoryManageException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new ProductDirectoryManageException(concreteExceptionCode, null, cause,
				null);
	}

	public static ProductDirectoryManageException newInstanceMsg(String msg) {
		return new ProductDirectoryManageException(null, msg, null, null);
	}

	public static ProductDirectoryManageException newInstanceMsg(String msg,
			Throwable cause) {
		return new ProductDirectoryManageException(null, msg, cause, null);
	}

	public static ProductDirectoryManageException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new ProductDirectoryManageException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}
