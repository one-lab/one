package com.sinosoft.one.mvc.mock.controllers;

import java.lang.reflect.Method;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Interceptor;

@Interceptor(oncePerRequest = true)
public class OncePerRequestInterceptor extends ControllerInterceptorAdapter {

    int count;

    @Override
    protected boolean isForAction(Method actionMethod, Class<?> controllerClazz) {
        return OncePerRequestController.class == controllerClazz;
    }

    @Override
    public Object before(Invocation inv) throws Exception {
        if (count > 0) {
            throw new IllegalArgumentException("onceperrequest");
        }
        count++;
        return super.before(inv);
    }
}
