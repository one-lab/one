package com.sinosoft.one.monitor.exception;


import com.sinosoft.one.monitor.log.LogTraceAspect;
import com.sinosoft.one.monitor.log.TraceModel;
import com.sinosoft.one.monitor.log.TraceUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 寮傚父鎷︽埅,鍐欐暟鎹簱鍜屽彂閫氱煡
 *
 * @author zhujinwei
 *
 */
@Aspect
public class ExceptionAspect {
	 private static Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    /**
     * 寮傚父鎷︽埅,鎷︽埅鍚庢姏鍑�
     *
     * @param throwable
     */
//    @AfterThrowing(pointcut = "execution(* com.sinosig.servicebus..*service.*.*Service*.*(..))", throwing="throwable")
	@AfterThrowing(pointcut ="execution(* com.sinosig.servicebus.*.*service..*.*(..))", throwing="throwable")
	public void exceptionCatch(Throwable throwable) {
		logger.info("ExceptionAspectStart");
	    TraceModel traceModel = TraceUtils.getTraceModel();
		if(traceModel!=null&&!traceModel.hasException()) {
			traceModel.setException(true);
			Exceptions.handleThrowable(throwable);
		}
    }
}
