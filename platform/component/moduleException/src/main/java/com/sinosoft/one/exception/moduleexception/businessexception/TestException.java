package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-26
 * Time: 下午12:49
 * To change this template use File | Settings | File Templates.
 */
public class TestException extends BasicBizInfoCommonException {
    private TestException(String concreteExceptionCode, String msg, Throwable cause, ExceptionLevel level) {
        super(concreteExceptionCode, msg, cause, level);
    }
    public static void testException() {
        newInstanceCode("");
    }
}
