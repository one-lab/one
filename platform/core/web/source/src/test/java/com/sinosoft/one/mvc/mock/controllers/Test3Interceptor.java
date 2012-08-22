package com.sinosoft.one.mvc.mock.controllers;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class Test3Interceptor extends ControllerInterceptorAdapter {
	
	public Test3Interceptor() {
		setPriority(20);
	}

	@Override
	protected Object before(Invocation inv) throws Exception {
		System.out.println("----------------invoke testInterceptor3 before method");
		return super.before(inv);
	}

	@Override
	protected Object after(Invocation inv, Object instruction) throws Exception {
		System.out.println("----------------invoke testInterceptor3 after method");
		return super.after(inv, instruction);
	}

}
