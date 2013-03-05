package com.sinosoft.one.monitor.exception;


import org.apache.log4j.MDC;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


/**
 * 异常拦截,写数据库和发通知
 *
 * @author zhujinwei
 *
 */
@Aspect
public class ExceptionAspect {
    /**
     * 异常拦截,拦截后抛出
     *
     * @param throwable
     */
    @AfterThrowing(pointcut = "execution(* com.sinosoft.one.mvc.test..*(..))", throwing="throwable")
    public void exceptionCatch(Throwable throwable) {
	    String hasException = (String)MDC.get("hasException");
	    if(hasException == null) {
		    MDC.put("hasException", "true");
		    Exceptions.handleThrowable(throwable);
	    }
    }
}
