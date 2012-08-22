package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2;

import java.lang.annotation.Annotation;

import com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2.annotation.DenyAnnotation;
import com.sinosoft.one.mvc.mock.controllers.for_interceptors_test2.annotation.RequiredAnnotation;
import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class SimpleInterceptor extends ControllerInterceptorAdapter {

    public static final String RETURN = "returned-by-SimpleInterceptor.after";
    public static final String AFTER_COMPLETION = "SimpleInterceptor.afterCompletion";

    public SimpleInterceptor() {
        setPriority(20);
    }

    @Override
    protected Class<? extends Annotation> getRequiredAnnotationClass() {
        return RequiredAnnotation.class;
    }

    @Override
    protected Class<? extends Annotation> getDenyAnnotationClass() {
        return DenyAnnotation.class;
    }

    @Override
    public Object after(Invocation inv, Object instruction) throws Exception {
        return RETURN;
    }

    @Override
    public void afterCompletion(Invocation inv, Throwable ex) throws Exception {
        inv.getRequest().setAttribute(AFTER_COMPLETION, true);
    }
}
