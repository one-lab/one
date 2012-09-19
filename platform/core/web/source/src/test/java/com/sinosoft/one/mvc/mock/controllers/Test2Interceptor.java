package com.sinosoft.one.mvc.mock.controllers;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class Test2Interceptor extends ControllerInterceptorAdapter {
	
	public Test2Interceptor() {
		setPriority(100);
	}

	@Override
	protected Object before(Invocation inv) throws Exception {
		System.out.println("----------------invoke testInterceptor2 before method");
		return super.before(inv);
	}

	@Override
	protected Object after(Invocation inv, Object instruction) throws Exception {
		System.out.println("----------------invoke testInterceptor2 after method");
		return super.after(inv, instruction);
	}

}
