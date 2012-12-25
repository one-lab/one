package com.sinosoft.one.exception.userexception;

import com.sinosoft.one.exception.ExceptionGrade;
import com.sinosoft.one.exception.UserException;

/**
 * 业务异常
 *
 * @author zhujinwei
 *
 */
public abstract class BusinessException extends UserException {
    private final static String userExceptionCode = "0100";

    public BusinessException(String subUserExceptionCode,
                             String concreteExceptionCode, String msg, Throwable cause,
                             ExceptionGrade grade) {
        super(userExceptionCode, subUserExceptionCode, concreteExceptionCode,
                msg, cause, grade);
    }

    public String getUserExceptionCode() {
        return userExceptionCode;
    }

    private static final long serialVersionUID = 1L;
}
