package com.sinosoft.platform.platformDemo.controllers;

import java.lang.annotation.Annotation;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.InvocationChain;

public class FristDemoInterceptor extends ControllerInterceptorAdapter {

	public FristDemoInterceptor() {
		setPriority(190);
	}
	
    // 覆盖这个方法返回一个注解类，使得只有注解了该annotation的方法才会被起作用(注解在控制器类或方法上均有效)    
	// 还有一个相反功能的方法：getDenyAnnotationClass，表示注解了某个annotatioin后，拦截器不要拦截他    
	@Override 
	protected Class<? extends Annotation> getRequiredAnnotationClass() {        
		return null;    
	}
	@Override
	protected Object before(Invocation inv) throws Exception {
		Date date = new Date();
		String dateStr = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		inv.addModel("date", dateStr);
		return super.before(inv);
	}

	@Override
	protected Object round(Invocation inv, InvocationChain chain)
			throws Exception {
//		String ctrl = inv.getModel("ctrl").toString()+"invoking FristDemoInterceptor.roundMethod:</br>";
//		inv.addModel("ctrl", ctrl);
		return super.round(inv, chain);
	}
	
	@Override
	protected Object after(Invocation inv, Object instruction) throws Exception {
		String loginUserName = (String)inv.getRequest().getSession().getAttribute("loginUserName");
		if(loginUserName != null){
			inv.addModel("welInfo", "您好，"+loginUserName+"先生，今天天气不错！");
		}
		return super.after(inv, instruction);
	}

	@Override
	public void afterCompletion(Invocation inv, Throwable ex) throws Exception {
//		String ctrl = inv.getModel("ctrl").toString()+":invoking FristDemoInterceptor.afterCompletion Method</br>";
//		inv.addModel("ctrl", ctrl);
		super.afterCompletion(inv, ex);
	}
	
}
