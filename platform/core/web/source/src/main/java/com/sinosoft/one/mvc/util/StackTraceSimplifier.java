package com.sinosoft.one.mvc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 对栈进行简化的工具，去掉递归调用时循环出现的那部分栈。
 * 
 * @author Li Weibo[weibo.leo@gmail.com]
 */
public class StackTraceSimplifier {

	protected static Log logger = LogFactory.getLog(StackTraceSimplifier.class);

	private static final Pattern EXCLUDED_STACK_TRACE = Pattern
			.compile("^com\\.sinosoft\\.one\\.mvc\\.web\\.(((ControllerInterceptorAdapter" +
					"|InterceptorDelegate|OncePerRequestInterceptorDelegate).*)"
					+ "|(impl\\.thread\\.ActionEngine\\$InvocationChainImpl.*))");

	/**
	 * 对指定异常的栈进行简化
	 * @param e
	 */
	public static void simplify(Throwable e) {
		if (!isSimplifyStackTrace()) {
			return;
		}

		if (e.getCause() != null) {
			simplify(e.getCause());
		}

		StackTraceElement[] trace = e.getStackTrace();
		
		if (trace == null || trace.length == 0) {
			return;
		}

		List<StackTraceElement> simpleTrace = new ArrayList<StackTraceElement>(
				trace.length);
		simpleTrace.add(trace[0]);

		// Remove unnecessary stack trace elements.
		for (int i = 1; i < trace.length; i++) {
			if (EXCLUDED_STACK_TRACE.matcher(trace[i].getClassName()).matches()) {
				continue;
			}
			simpleTrace.add(trace[i]);
		}
		
		e.setStackTrace(simpleTrace.toArray(new StackTraceElement[simpleTrace
				.size()]));
	}

	private static boolean isSimplifyStackTrace() {
		return !logger.isDebugEnabled();
	}
}
