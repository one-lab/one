package com.sinosoft.one.monitor.exception;


import com.sinosoft.one.monitor.log.TraceModel;
import com.sinosoft.one.monitor.log.TraceUtils;
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
    @AfterThrowing(pointcut = "execution(* com.sinosoft.one.demo.service..*(..))", throwing="throwable")
    public void exceptionCatch(Throwable throwable) {
	    TraceModel traceModel = TraceUtils.getTraceModel();
		if(!traceModel.hasException()) {
			traceModel.setException(true);
			Exceptions.handleThrowable(throwable);
		}
    }
}
