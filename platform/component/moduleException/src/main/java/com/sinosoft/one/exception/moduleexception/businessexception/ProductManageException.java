package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * ProductManage模块异常
 * 
 * @author zhujinwei
 * 
 */
public class ProductManageException extends BusinessException {
	private static final String subuserexceptionCode = "010010";

	private ProductManageException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
	}

	public static ProductManageException newInstanceCode(
			String concreteExceptionCode) {
		return new ProductManageException(concreteExceptionCode,
				null, null, null);
	}

	public static ProductManageException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new ProductManageException(concreteExceptionCode,
				null, cause, null);
	}

	public static ProductManageException newInstanceMsg(String msg) {
		return new ProductManageException(null, msg, null, null);
	}

	public static ProductManageException newInstanceMsg(String msg,
			Throwable cause) {
		return new ProductManageException(null, msg, cause, null);
	}

	public static ProductManageException newInstanceMsg(String msg,
			Throwable cause, ExceptionLevel level) {
		return new ProductManageException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}