package com.sinosoft.one.monitor.log;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
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
	 * @throws Throwable  com.sinosig.servicebus.transpolicy.webservice.TransPolicyService
	 */
    @Around("execution(* com.sinosig.servicebus.*.*service..*.*(..))")
//  @Around("execution(* com.sinosoft.one.demo..*.*(..))")
    public Object logAgroundClassAndInterface(ProceedingJoinPoint pjp)
			throws Throwable {
    	logger.debug("LogTraceAspect");
    	TraceModel traceModel = TraceUtils.getTraceModel();
		if(traceModel == null || traceModel.getUrlId() == null) {
			return pjp.proceed();
		}
		String traceId = traceModel.getUrlTraceLog().getId();
		Class<?> sourceClass = pjp.getSignature().getDeclaringType();
		Class<?> targetClass = pjp.getTarget() == null ? sourceClass : pjp.getTarget().getClass();

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
		try {
			begin = System.currentTimeMillis();
			result = pjp.proceed();
			end = System.currentTimeMillis();
			time = end - begin;
			return result;
		} finally {
			// @Interfacetrace检查
			if(!AopUtils.isCglibProxyClass(targetClass)) {
				String urlId = traceModel.getUrlId();
				Set<LogMethod> logMethods = logConfigs.getLogMethods(urlId);
				if(logMethods != null && logMethods.size() > 0) {
					for(LogMethod logMethod : logMethods) {
						if(logMethod.getClassName().equals(sourceClass.getName()) && logMethod.getMethodName().equals(specificMethod.getName())) {
							MethodTraceLog methodTraceLog = new MethodTraceLog();

							methodTraceLog.setUrlTraceLogId(traceId);
							methodTraceLog.setMethodId(logMethod.getId());
							methodTraceLog.setBeginTime(new Timestamp(begin));
							methodTraceLog.setEndTime(new Timestamp(end));
							methodTraceLog.setConsumeTime(time);
							methodTraceLog.setMethodName(specificMethod.getName());
							methodTraceLog.setClassName(sourceClass.getName());
							methodTraceLog.setInParam(JSON.toJSONString(pjp.getArgs()));
							methodTraceLog.setOutParam(JSON.toJSONString(result));
							methodTraceLog.setRecordTime(new Date());

							logger.debug(MethodTraceLog.FORMAT_STRING, methodTraceLog.toObjectArray());

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
		if(m != null && pjp.getThis()!=null&&Proxy.isProxyClass(pjp.getThis().getClass())) {
			m = pjp.getTarget().getClass().getMethod(m.getName(), m.getParameterTypes());
		}
		return m;
	}
}
