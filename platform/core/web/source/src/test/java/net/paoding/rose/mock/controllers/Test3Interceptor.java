package net.paoding.rose.mock.controllers;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

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
