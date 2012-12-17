package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.ebusiness.sys.exception.ExceptionGrade;
import com.sinosoft.one.ebusiness.sys.exception.userException.BusinessException;
/**
 * WorkFlow模块异常
 * 
 * @author zhujinwei
 * 
 */
public class WorkFlowException extends BusinessException {
	private static final String subUserExceptionCode = "010019";

	private WorkFlowException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionGrade grade) {
		super(subUserExceptionCode, concreteExceptionCode, msg, cause, grade);
	}

	public static WorkFlowException newInstanceCode(
			String concreteExceptionCode) {
		return new WorkFlowException(concreteExceptionCode,
				null, null, null);
	}

	public static WorkFlowException newInstanceCode(
			String concreteExceptionCode, Throwable cause) {
		return new WorkFlowException(concreteExceptionCode,
				null, cause, null);
	}

	public static WorkFlowException newInstanceMsg(String msg) {
		return new WorkFlowException(null, msg, null, null);
	}

	public static WorkFlowException newInstanceMsg(String msg,
			Throwable cause) {
		return new WorkFlowException(null, msg, cause, null);
	}

	public static WorkFlowException newInstanceMsg(String msg,
			Throwable cause, ExceptionGrade grade) {
		return new WorkFlowException(null, msg, cause, grade);
	}

	public String getSubUserExceptionCode() {
		return subUserExceptionCode;
	}

	private static final long serialVersionUID = 1L;
}