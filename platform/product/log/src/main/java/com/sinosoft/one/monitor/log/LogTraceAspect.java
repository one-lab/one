package com.sinosoft.one.monitor.log;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ClassUtils;

/**
 * 控制InterfaceTrace的InterfaceTraceAspect.
 *
 * @author qc
 */
@Aspect
public class LogTraceAspect {

    private static Logger logger = LoggerFactory.getLogger(LogTraceAspect.class);

    private static  LogConfigs logConfigs;

    public static void setLogConfigs(LogConfigs logConfigs) {
	    LogTraceAspect.logConfigs = logConfigs;
    }

    /**
	 * 根据@InterfaceTraced标记来记录日志
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
    @Around("execution(* com.sinosoft.one.mvc.test..*(..))")
	public Object logAgroundClassAndInterface(ProceedingJoinPoint pjp)
			throws Throwable {
	    TraceModel traceModel = TraceUtils.getTraceModel();
	    if(traceModel == null) {
		    return pjp.proceed();
	    }
	    String traceId = traceModel.getTraceId();
		Class<?> sourceClass = pjp.getSignature().getDeclaringType();
		Class<?> targetClass = pjp.getTarget().getClass();
        if(logger.isDebugEnabled()){
            logger.debug("target class is:",targetClass);
        }
		Method method = getMethod(pjp);

		// 获取cglib代理对象
		Class<?> userClass = ClassUtils.getUserClass(targetClass);
		Method specificMethod = ClassUtils.getMostSpecificMethod(method,
				userClass);
		specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);

		Object result = null;
		long begin = 0;
		long end = 0;
		long time = 0;
	    String exceptionStackTrace = "";
		try {
			begin = System.currentTimeMillis();
			result = pjp.proceed();
			end = System.currentTimeMillis();
			time = end - begin;
			return result;
		} finally {
			// @Interfacetrace检查
			if(!ClassUtils.isCglibProxyClass(targetClass)) {
				String urlId = traceModel.getUrlId();
				Set<LogMethod> logMethods = logConfigs.getLogMethods(urlId);
                if(logMethods != null && logMethods.size() > 0) {
                    for(LogMethod logMethod : logMethods) {
                        if(logMethod.getClassName().equals(sourceClass.getName()) && logMethod.getMethodName().equals(specificMethod.getName())) {
	                        MethodTraceLog methodTraceLog = new MethodTraceLog();

	                        methodTraceLog.setUrlTraceId(traceId);
	                        methodTraceLog.setBeginTime(new Timestamp(begin));
	                        methodTraceLog.setEndTime(new Timestamp(end));
	                        methodTraceLog.setConsumeTime(time);
	                        methodTraceLog.setMethodName(method.getName());
	                        methodTraceLog.setClassName(sourceClass.getName());
	                        methodTraceLog.setInParam(JSON.toJSONString(pjp.getArgs()));
	                        methodTraceLog.setOutParam(JSON.toJSONString(result));
	                        methodTraceLog.setRecordTime(new Date());

	                        UrlTraceLog urlTraceLog = traceModel.getUrlTraceLog();
	                        urlTraceLog.addMethodTraceLog(methodTraceLog);
                        }
                    }
                }
            }
		}
	}

	/**
	 * 获得执行方法.
	 * @param pjp
	 *            ProceedingJoinPoint
	 * @return 执行方法
	 */
	private Method getMethod(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method m = signature.getMethod();
        if( Proxy.isProxyClass(pjp.getThis().getClass())) {
            m = pjp.getTarget().getClass().getMethod(m.getName(), m.getParameterTypes());
        }
        return m;
	}
}
