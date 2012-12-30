package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.BusinessException;
/**
 * WorkFlow模块异常
 * 
 * @author zhujinwei
 * 
 */
public class WorkFlowException extends BusinessException {
	private static final String subuserexceptionCode = "010019";

	private WorkFlowException(String concreteExceptionCode,
			String msg, Throwable cause, ExceptionLevel level) {
		super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
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
			Throwable cause, ExceptionLevel level) {
		return new WorkFlowException(null, msg, cause, level);
	}

	public String getSubuserexceptionCode() {
		return subuserexceptionCode;
	}

	private static final long serialVersionUID = 1L;
}