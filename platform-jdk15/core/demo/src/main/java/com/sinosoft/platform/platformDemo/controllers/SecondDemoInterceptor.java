package com.sinosoft.platform.platformDemo.controllers;

import java.lang.annotation.Annotation;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.InvocationChain;

public class SecondDemoInterceptor extends ControllerInterceptorAdapter {

	public SecondDemoInterceptor() {
		setPriority(170);
	}
	
	@Override    
	protected Class<? extends Annotation> getRequiredAnnotationClass() {        
		return null;    
	}
	
	@Override
	protected Object before(Invocation inv) throws Exception {
//		String ctrl = "-------invoking SecondDemoInterceptor.bforeMethod</br>";
//		inv.addModel("ctrl",ctrl);
		return super.before(inv);
	}

	@Override
	protected Object round(Invocation inv, InvocationChain chain)
			throws Exception {
//		String ctrl = inv.getModel("ctrl").toString()+"-------invoking SecondDemoInterceptor.roundMethod</br>";
//		inv.addModel("ctrl",ctrl);
		return super.round(inv, chain);
	}

	@Override
	protected Object after(Invocation inv, Object instruction) throws Exception {
//		String ctrl = inv.getModel("ctrl").toString()+"----invoking SecondDemoInterceptor.afterMethod</br>";
//		inv.addModel("ctrl",ctrl);
		return super.after(inv, instruction);
	}

	@Override
	public void afterCompletion(Invocation inv, Throwable ex) throws Exception {
//		String ctrl = inv.getModel("ctrl").toString()+"----invoking SecondDemoInterceptor.afterCompletion Method</br>";
//		inv.addModel("ctrl",ctrl);
		super.afterCompletion(inv, ex);
	}
	
}
