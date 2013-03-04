package com.sinosoft.one.monitor.log;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.MDC;

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
public class TraceUtils {

	public static final String TRACE_ID_KEY = "traceId";

	public static final String URL_TRACE_LOG_KEY = "urlTraceLog";

	public static final String URL_ID_KEY = "urlId";

	public static final String URL = "url";

	public static final String REQUEST_PARAMS = "requestParams";


	public static final int TRACE_ID_LENGTH = 32;
	
	/**
	 * 开始Trace, 默认生成本次Trace的ID(8字符长)并放入MDC.
	 */
	public static void beginTrace(UrlTraceLog urlTraceLog, String urlId) {
		String traceId = RandomStringUtils.randomAlphanumeric(TRACE_ID_LENGTH);
		MDC.put(TRACE_ID_KEY, traceId);
		MDC.put(URL_ID_KEY, urlId);
		MDC.put(URL_TRACE_LOG_KEY, urlTraceLog);
	}

	/**
	 * 开始Trace, 将url放入MDC.
	 */
	public static void beginTraceForNoMonitorURL(String url, String requestParams) {
		MDC.put(URL, url);
		MDC.put(REQUEST_PARAMS, requestParams);
	}

	/**
	 * 开始Trace, 将traceId放入MDC.
	 */
	public static void beginTrace(String traceId) {
		MDC.put(TRACE_ID_KEY, traceId);
	}

	/**
	 * 结束一次Trace.
	 * 清除traceId.
	 */
	public static void endTraceForNoMonitorURL() {
		MDC.remove(URL);
		MDC.remove(REQUEST_PARAMS);
	}

	/**
	 * 结束一次Trace.
	 * 清除traceId.
	 */
	public static void endTrace() {
		MDC.remove(TRACE_ID_KEY);
		MDC.remove(URL_ID_KEY);
		MDC.remove(URL_TRACE_LOG_KEY);
	}
	/**
	 * 获取TraceId
	 * @return
	 */
	public static String  getTraceId(){
		return (String) MDC.get(TRACE_ID_KEY);
	}

	/**
	 * 获取UrlTraceLog
	 * @return
	 */
	public static UrlTraceLog  getUrlTraceLog(){
		return (UrlTraceLog) MDC.get(URL_TRACE_LOG_KEY);
	}

	/**
	 * 获取UrlId
	 * @return
	 */
	public static String  getUrlId(){
		return (String) MDC.get(URL_ID_KEY);
	}
}

