package com.sinosoft.one.monitor.controllers;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.InvocationChain;

import java.lang.annotation.Annotation;

public class SecondMonitorInterceptor extends ControllerInterceptorAdapter {

    public SecondMonitorInterceptor() {
        setPriority(170);
    }

    @Override
    protected Class<? extends Annotation> getRequiredAnnotationClass() {
        return null;
    }

    @Override
    protected Object before(Invocation inv) throws Exception {
        return super.before(inv);
    }

    @Override
    protected Object round(Invocation inv, InvocationChain chain)
            throws Exception {
        return super.round(inv, chain);
    }

    @Override
    protected Object after(Invocation inv, Object instruction) throws Exception {
        return super.after(inv, instruction);
    }

    @Override
    public void afterCompletion(Invocation inv, Throwable ex) throws Exception {
        super.afterCompletion(inv, ex);
    }
}
