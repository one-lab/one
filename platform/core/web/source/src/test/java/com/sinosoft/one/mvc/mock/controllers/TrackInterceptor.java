package com.sinosoft.one.mvc.mock.controllers;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class TrackInterceptor extends ControllerInterceptorAdapter {

	@Override
	public Object before(Invocation inv) throws Exception {
		return super.before(inv);
	}

	@Override
	public Object after(Invocation inv, Object instruction)
			throws Exception {
		return super.after(inv, instruction);
	}

	@Override
	public void afterCompletion(Invocation inv, Throwable ex)
			throws Exception {
		super.afterCompletion(inv, ex);
	}
}
