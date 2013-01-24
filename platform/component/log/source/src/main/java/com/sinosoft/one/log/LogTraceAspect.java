package com.sinosoft.one.log;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Timestamp;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.log.config.LogConfigs;
import com.sinosoft.one.log.config.LogMethod;
import com.sinosoft.one.log.methodtrace.MethodTraceLog;
import com.sinosoft.one.log.methodtrace.MethodTraceLogInspectMode;
import com.sinosoft.one.monitoragent.notification.NotificationEvent;
import com.sinosoft.one.monitoragent.notification.NotificationModule;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ClassUtils;

import com.sinosoft.one.util.encode.JsonBinder;

/**
 * 控制InterfaceTrace的InterfaceTraceAspect.
 *
 * @author qc
 */
public class LogTraceAspect {
	// db记录日志
	Logger dbLogger = LoggerFactory.getLogger("DBLog");

    private MethodTraceLogInspectMode inspectMode = MethodTraceLogInspectMode.NATIVE;

    private static Logger logger = LoggerFactory.getLogger(LogTraceAspect.class);

    private LogConfigs logConfigs;

    public void setLogConfigs(LogConfigs logConfigs) {
        this.logConfigs = logConfigs;
    }

    /**
	 * 根据@InterfaceTraced标记来记录日志
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object logAgroundClassAndInterface(ProceedingJoinPoint pjp)
			throws Throwable {
		Class<?> sourceClass = pjp.getSignature().getDeclaringType();
		Class<?> targetClass = pjp.getTarget().getClass();
        if(logger.isDebugEnabled()){
            logger.debug("target class is:",targetClass);
        }
		Method method = getMethod(pjp, sourceClass);

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
            String description = "";
            Environment environment = Environment.DEVELOP;
            boolean isDeal = false;
            if(inspectMode == MethodTraceLogInspectMode.ALL || inspectMode == MethodTraceLogInspectMode.NATIVE) {
                LogTraced interfaceTraced = getLogTracedAnnotation(userClass, method, specificMethod);
                if(interfaceTraced != null) {
                    description =  Loggables.formatDescription(interfaceTraced.description(),pjp.getArgs());
                    environment = interfaceTraced.env();
                    isDeal = true;
                }
            }
            if(!isDeal && (inspectMode ==  MethodTraceLogInspectMode.ALL || inspectMode == MethodTraceLogInspectMode.REMOTE)) {
                LogMethod logMethod = logConfigs.getLogMethod(sourceClass.getName(), specificMethod.getName());
                if(logMethod != null) {
                    description =  Loggables.formatDescription(logMethod.getDescription(),pjp.getArgs());
                    environment = Environment.valueOf(logMethod.getEnvironment());
                    isDeal = true;

                    if (time > logMethod.getMaxExecuteTime()) {
                        String methodName =  logMethod.getClassName() + "." + logMethod.getMethodName();
                        String title = "方法 [" + methodName + "] 追踪日志预警";
                        String content = "方法 [" + methodName + "] 响应超时，最大响应时间为["
                                + logMethod.getMaxExecuteTime() + "]ms，实际响应时间为[" + time + "]ms.";
                        NotificationEvent notificationEvent = new NotificationEvent(title, content, "",
                                NotificationModule.RESPONSE, "");
                        Loggables.notification(notificationEvent);
                    }
                }
            }

           if(isDeal) {
                //检查当前环境与防止因为代理反复切入的问题
                if(logConfigs.checkEnvironment(environment) && !ClassUtils.isCglibProxyClass(targetClass)) {
                    //获取追踪ID
                    String traceId = TraceUtils.getTraceId();
                    if (traceId == null || "".equals(traceId)) {
                        traceId = "noId";
                    }

                    MethodTraceLog methodTraceLog = new MethodTraceLog();
                    methodTraceLog.setId(RandomStringUtils.randomAlphabetic(32));
                    methodTraceLog.setUrlTraceId(traceId);
                    methodTraceLog.setBeginTime(new Timestamp(begin));
                    methodTraceLog.setEndTime(new Timestamp(end));
                    methodTraceLog.setConsumeTime(time);
                    methodTraceLog.setMethodName(method.getName());
                    methodTraceLog.setClassName(sourceClass.getName());
                    methodTraceLog.setInParam(JSON.toJSONString(pjp.getArgs()));
                    methodTraceLog.setOutParam(JSON.toJSONString(result));
                    methodTraceLog.setLogDescription(description);
                    methodTraceLog.setEnvironment(environment);

                    dbLogger.info(MethodTraceLog.FORMAT_STRING, methodTraceLog.toObjectArray());
                    Loggables.doLogStatistics(methodTraceLog.getFullMethodName(), methodTraceLog.getConsumeTime());
                }
            }
		}
	}

    /**
     * 获取接口中存在的注解
     * @param method
     * @param userClass
     * @return
     */
	private LogTraced checkInfTrace(Method method, Class<?> userClass) {
		Class<?>[] inf = ClassUtils.getAllInterfacesForClass(userClass);
		for (Class<?> c : inf) {
			Method m = AopUtils.getMostSpecificMethod(method, c);
			return getCurrentMethodInterfaceTraced(m);
		}
		return null;
	}

	/**
	 * 解析当前方法上的@InterfaceTrace声明
	 * @param ae
	 * @return
	 */
	private LogTraced getCurrentMethodInterfaceTraced(AnnotatedElement ae) {
		LogTraced t = ae.getAnnotation(LogTraced.class);
		if (t == null) {
			for (Annotation metaAnn : ae.getAnnotations()) {
				return  metaAnn.annotationType().getAnnotation(LogTraced.class);
			}
		}
        return t;
	}

	/**
	 * 获得执行方法.
	 * @param pjp
	 *            ProceedingJoinPoint
	 * @return 执行方法
	 */
	private Method getMethod(ProceedingJoinPoint pjp, Class<?> targetClass) throws NoSuchMethodException {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method m = signature.getMethod();
        if( Proxy.isProxyClass(pjp.getThis().getClass())) {
            m = pjp.getTarget().getClass().getMethod(m.getName(), m.getParameterTypes());
        }
        return m;
	}

    private LogTraced  getLogTracedAnnotation(Class userClass, Method targetMethod, Method specificMethod) {
        LogTraced interfaceTraced = getCurrentMethodInterfaceTraced(specificMethod);
        if(interfaceTraced == null) {
            interfaceTraced = checkInfTrace(targetMethod, userClass);
        }
        return interfaceTraced;
    }

    public MethodTraceLogInspectMode getInspectMode() {
        return inspectMode;
    }

    public void setInspectMode(MethodTraceLogInspectMode inspectMode) {
        this.inspectMode = inspectMode;
    }
}
