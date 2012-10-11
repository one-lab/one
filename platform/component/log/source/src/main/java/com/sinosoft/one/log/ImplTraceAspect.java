package com.sinosoft.one.log;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sinosoft.one.util.encode.JsonBinder;

/**
 * 控制ImplTrace的ImplTraceAspect.
 * @change 不再区分接口与实现类的日志注解，统一使用LogTraceAspect
 * @see LogTraceAspect
 * @author qc
 */
@Aspect
@Deprecated
public class ImplTraceAspect {

	// db记录日志
	private static Logger dbLogger = LoggerFactory.getLogger("DBLog");

	private static JsonBinder binder = JsonBinder.buildNonDefaultBinder();

	// 环境
	private String environment;

	/**
	 * 对有@ImplTraced(configEnv=Environment.TEST)标记的方法,
	 * 记录其执行参数及返回结果. 只支持具体class
	 */
	@Around("execution(@com.sinosoft.one.log.ImplTraced(configEnv=Environment.TEST) * com.sinosoft.ebusiness..*.*(..))")
	public Object traceTest(ProceedingJoinPoint pjp) throws Throwable {
		// TEST环境与开发环境都应该记录日志
		if (Environment.TEST.toString().equals(environment)||Environment.DEVLEOP.toString().equals(environment))
			return logAgroundClass(pjp, true);
		else
			return logAgroundClass(pjp, false);
	}

	/**
	 * 对有@ImplTraced(enableId=true,configEnv=Environment.DEVLEOP)标记的方法,
	 * 记录其执行参数及返回结果. 只支持具体class
	 */
	@Around("execution(@com.sinosoft.one.log.ImplTraced(configEnv=Environment.DEVLEOP) * com.sinosoft.ebusiness..*.*(..))")
	public Object traceDevelop(ProceedingJoinPoint pjp) throws Throwable {
		// 只有开发环境才记录日志
		if (Environment.DEVLEOP.toString().equals(environment))
			return logAgroundClass(pjp, true);
		else
			return logAgroundClass(pjp, false);
	}

	/**
	 * 对有@ImplTraced(enableId=true,configEnv=Environment.PRODUCT)标记的方法,
	 * 记录其执行参数及返回结果. 只支持具体class
	 */
	@Around("execution(@com.sinosoft.one.log.ImplTraced(configEnv=Environment.PRODUCT) * com.sinosoft.ebusiness..*.*(..))")
	public Object traceProduct(ProceedingJoinPoint pjp) throws Throwable {
		//System.out.println("---------traceProduct-----aspect");
		// 判断当前的环境 是否是test 和development 、PRODUCT
		return logAgroundClass(pjp, true);
	}

	/**
	 * 拦截后处理方法
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	// @Around("@annotation(cn.com.chinalife.ebusiness.log.ImplTraced)")
	public Object logAgroundClass(ProceedingJoinPoint pjp, boolean isTrace)
			throws Throwable {
		if (isTrace == false)
			return pjp.proceed();
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
			String traceId = TraceUtils.getTraceId();
			if (traceId == null || "".equals(traceId))
				traceId = "noId";
			dbLogger.info(
					"[@MethodTrace][@traceId="
							+ traceId
							+ "]在 -- {} -- 调用 -- {} -- 传入参数 -- {} -- 返回 -- {} -- ,在 -- {} -- 结束,经历时常为 -- {} -- ",
					new Object[] { new Timestamp(begin),
							pjp.getSignature().toShortString(),
							"入参暂时不填",//binder.toJson(pjp.getArgs())
							binder.toJson(result), new Timestamp(end),
							new Long(time) });
		}
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
