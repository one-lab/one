package com.sinosoft.one.mvc.mock.controllers.intercetorsAnnotatedBySuper;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class TailPostInterceptor extends ControllerInterceptorAdapter {

	public static final String RETURN = "TailPostInterceptor.after";

	public TailPostInterceptor() {
		setPriority(-10);
	}

	@Override
	public Object after(Invocation inv, Object instruction) throws Exception {
		return RETURN;
	}
}
