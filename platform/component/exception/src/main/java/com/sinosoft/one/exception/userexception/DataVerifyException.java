package com.sinosoft.one.exception.userexception;

import com.sinosoft.one.exception.ExceptionGrade;
import com.sinosoft.one.exception.UserException;

/**
 * 数据校验异常
 *
 * @author zhujinwei
 *
 */
public abstract class DataVerifyException extends UserException {
    private static final String userExceptionCode = "0101";

    public DataVerifyException(String subUserExceptionCode,
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
