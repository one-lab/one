package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * ProductManage模块异常
 * 
 * @author zhujinwei
 * 
 */
public class ProductManageException extends BusinessException {
	private static final String subUserExceptionCode = "010010";

	private ProductManageException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
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
			Throwable cause, ExceptionGrade grade) {
		return new ProductManageException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}