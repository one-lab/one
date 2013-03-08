package com.sinosoft.one.monitor.log;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.MDC;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统运行时打印方便调试与追踪信息的工具类.
 * 
 * 使用MDC存储traceID, 一次trace中所有日志都自动带有该ID,
 * 可以方便的用grep命令在日志文件中提取该trace的所有日志.
 * 
 * 需要在log4j.properties中将ConversionPattern添加%X{traceId},如:
 * log4j.appender.stdout.layout.ConversionPattern=%d [%c] %X{traceId}-%m%n
 * 
 * @author qc
 */
public final class TraceUtils {
	private TraceUtils() {}

	private static final String TRACE_MODEL = "traceModel";

	public static final int TRACE_ID_LENGTH = 32;


	/**
	 * 结束一次Trace.
	 * 清除traceId.
	 */
	public static void endTrace() {
		MDC.remove(TRACE_MODEL);
	}

	public static void beginTrace(TraceModel traceModel) {
		traceModel.setTraceId(RandomStringUtils.randomAlphanumeric(TRACE_ID_LENGTH));
		MDC.put(TRACE_MODEL, traceModel);
	}

	public static TraceModel getTraceModel() {
		return (TraceModel)MDC.get(TRACE_MODEL);
	}

	public static String getIPAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		String[] ips = ip.split(",");
		return ips[0];
	}
}

