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
	 * 开始Trace, 将traceId放入MDC.
	 */
	public static void beginTrace(String traceId) {
		MDC.put(TRACE_ID_KEY, traceId);
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

	/**
	 * 模仿throwable的printStackTrace
	 *
	 * @return
	 */
	public static String getExceptionStackTrace(Throwable throwable) {
		StringBuffer sb = new StringBuffer();
		if (throwable != null) {
			try {
				sb.append(throwable.toString() + "\n");
				StackTraceElement causedTrace[] = throwable
						.getStackTrace();
				for (StackTraceElement trace : throwable.getStackTrace()) {
					sb.append("\tat " + trace.toString() + "\n");
				}
				Throwable ourCause = throwable.getCause();
				while (ourCause != null) {
					StackTraceElement[] trace = ourCause.getStackTrace();
					int m = trace.length - 1, n = causedTrace.length - 1;
					while (m >= 0 && n >= 0 && trace[m].equals(causedTrace[n])) {
						m--;
						n--;
					}
					int framesInCommon = trace.length - 1 - m;

					sb.append("Caused by: " + ourCause);
					for (int i = 0; i <= m; i++)
						sb.append("\tat " + trace[i]);
					if (framesInCommon != 0)
						sb.append("\t... " + framesInCommon + " more");
					causedTrace = ourCause.getStackTrace();
					ourCause = ourCause.getCause();
				}
				sb.toString();
			} catch (Exception e) {
				sb = new StringBuffer();
				sb.append("分析异常时,产生异常: " + e.getMessage());
			}
		} else
			sb.append("no exception reason");
		return sb.toString();
	}
	
}

