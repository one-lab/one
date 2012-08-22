package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class BlockInterceptor extends ControllerInterceptorAdapter {

	public static final String RETURN = "returned-by-BlockInterceptor.before";
	public static final String AFTER_COMPLETION = "BlockInterceptor.afterCompletion";

	public BlockInterceptor() {
		setPriority(10);
	}

	@Override
	public Object before(Invocation inv) throws Exception {
		return RETURN;
	}

	@Override
	public void afterCompletion(Invocation inv, Throwable ex)
			throws Exception {
		inv.getRequest().setAttribute(AFTER_COMPLETION, true);
	}

}