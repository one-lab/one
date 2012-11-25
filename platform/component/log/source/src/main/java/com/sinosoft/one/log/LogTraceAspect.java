package com.sinosoft.one.log;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Timestamp;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
@Aspect
public class LogTraceAspect {
    
    static final String SEPARATOR = " _$$_ ";

    static final String MESSAGE_TEMPLATE = "[@MethodTrace][@traceId={}]在"+SEPARATOR+" {} "+SEPARATOR+
            " 调用 "+SEPARATOR+" {} "+SEPARATOR+" 传入参数 "+SEPARATOR+" {} "+SEPARATOR+" 返回 "+SEPARATOR+
            " {} "+SEPARATOR+" ,在 "+SEPARATOR+" {} "+SEPARATOR+" 结束,经历时常为 "+SEPARATOR+
            " {} "+SEPARATOR+" 内容 "+SEPARATOR+" {} "+SEPARATOR+" 操作人 "+SEPARATOR+" {} "+SEPARATOR+
            " 机构 "+SEPARATOR+" {} "+SEPARATOR;

	// db记录日志
	Logger dbLogger = LoggerFactory.getLogger("DBLog");


    private static Logger logger = LoggerFactory.getLogger(LogTraceAspect.class);

	private static JsonBinder binder = JsonBinder.buildNonDefaultBinder();


    private User user;

    public void setUser(User user){
       this.user = user;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    Environment getEnvironment(){
        return this.environment;
    }

    private Environment environment;

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
            LogTraced interfaceTraced = getCurrentMethodInterfaceTraced(specificMethod);
            if(interfaceTraced==null)
                interfaceTraced = checkInfTrace(method, userClass);
            if(interfaceTraced != null) {
                String description = formatDescription(interfaceTraced.description(),pjp.getArgs());
                //检查当前环境与防止因为代理反复切入的问题
                if(checkEnvironment(interfaceTraced.env())&&!ClassUtils.isCglibProxyClass(targetClass)) {
                    //获取追踪ID
                    String traceId = TraceUtils.getTraceId();
                    if (traceId == null || "".equals(traceId))
                        traceId = "noId";
                    dbLogger.info(MESSAGE_TEMPLATE,
                            new Object[]{
                                    traceId,
                                    new Timestamp(begin),
                                    pjp.getSignature().toShortString(),
                                    binder.toJson(pjp.getArgs()),
                                    binder.toJson(result), new Timestamp(end),
                                    new Long(time), description, this.user == null ? StringUtils.EMPTY : this.user.getUserCode(),
                                    this.user == null ? StringUtils.EMPTY : this.user.getCompanyCode()});
                }
            }
		}
	}

    String formatDescription(String description,Object[] arguments) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String[] formatStr = StringUtils.substringsBetween(description,"${","}");
        if(formatStr!=null){
            Object[] na = new Object[formatStr.length];
            for(int i=0;i<formatStr.length;i++){
                int paramIndex = Integer.parseInt(StringUtils.substringBetween(formatStr[i],"[","]"));
                String proPath = StringUtils.substringAfter(formatStr[i],":");
                if(StringUtils.isBlank(proPath))
                    na[i]=arguments[i];
                else
                    na[i]= BeanUtils.getProperty(arguments[paramIndex],proPath);

                //remove description ${}中内容
                description = StringUtils.remove(description,formatStr[i]);
            }
            description = StringUtils.replace(description,"${","{");
            return MessageFormatter.arrayFormat(description,na).getMessage();
        }
        else{
            return description;
        }

    }

    boolean checkEnvironment(Environment methodEnv){
        if(this.environment.equals(methodEnv))
            return true;
        if(this.environment.equals(Environment.DEVLEOP))
            return true;
        if(this.environment.equals(Environment.TEST)&&methodEnv.equals(Environment.DEVLEOP)){
            return true;
        }
        return false;

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

}
