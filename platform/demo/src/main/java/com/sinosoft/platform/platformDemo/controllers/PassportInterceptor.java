package com.sinosoft.platform.platformDemo.controllers;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Interceptor;

import org.apache.commons.lang.StringUtils;
//设置oncePerRequest为true，表示如果当前的请求如果是被forward、include转来的，并且之前已经执行了该拦截器，
//则当前不再过该拦截器，在大部分情况下可以这样理解“一个请求只执行一次”
@Interceptor
public class PassportInterceptor extends ControllerInterceptorAdapter {

	public PassportInterceptor() {
		// 设置优先级，优先级越高的拦截器，before方法越先执行        
		// PassportInterceptor要比很多拦截器都要先执行，其中包括LoginRequredInterceptor         
		setPriority(1000);
	}
	

	// before方法在调用控制器方法前执行，相反的after则是控制器执行后才执行
	@Override
	protected Object before(Invocation inv) throws Exception {
		String loginName = (String) inv.getRequest().getSession().getAttribute("loginUserName");
		if(StringUtils.isBlank(loginName))
			return "r:/platformDemo/login";
		else
			return true;
	}
	
}
