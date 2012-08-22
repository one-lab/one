package com.sinosoft.one.mvc.mock.controllers.intercetorsAnnotatedBySuper;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class HeadInterceptor extends ControllerInterceptorAdapter {

	public static final String RETURN = "HeadInterceptor.after";
	
	@Override
	public Object after(Invocation inv, Object instruction) throws Exception {
		return instruction + "." + RETURN;
	}
}
