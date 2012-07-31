package com.sinosoft.one.mvc.mock.controllers.intercetorsAnnotatedBySuper;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class TailInterceptor extends ControllerInterceptorAdapter {

	public static final String RETURN = "TailInterceptor.after";

	public TailInterceptor() {
		setPriority(-1);
	}

	@Override
	public Object after(Invocation inv, Object instruction) throws Exception {
		return RETURN;
	}
}
