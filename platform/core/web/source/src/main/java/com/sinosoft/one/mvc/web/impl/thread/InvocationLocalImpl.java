/*
 * Copyright 2007-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sinosoft.one.mvc.web.impl.thread;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.InvocationLocal;
import com.sinosoft.one.mvc.web.InvocationUtils;
import com.sinosoft.one.mvc.web.RequestPath;
import com.sinosoft.one.mvc.web.paramresolver.ParamMetaData;
import com.sinosoft.one.mvc.web.var.Flash;
import com.sinosoft.one.mvc.web.var.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 *
 * 
 */
public class InvocationLocalImpl implements InvocationLocal {

    
    public Invocation getCurrent(boolean required) {
        Invocation inv = InvocationUtils.getInvocation(InvocationUtils.getCurrentThreadRequest());
        if (inv == null && required) {
            throw new IllegalStateException("invocation");
        }
        return inv;
    }

    private Invocation required() {
        return getCurrent(true);
    }

    
    public void addModel(Object value) {
        required().addModel(value);
    }

    
    public void addModel(String name, Object value) {
        required().addModel(name, value);
    }

    
    public void changeMethodParameter(int index, Object newValue) {
        required().changeMethodParameter(index, newValue);

    }

    
    public void changeMethodParameter(String name, Object newValue) {
        required().changeMethodParameter(name, newValue);

    }
    
    
    public void changeMethodParameter(ParamMetaData paramMeta, Object newValue) {
        required().changeMethodParameter(paramMeta, newValue);
    }

    
    public WebApplicationContext getApplicationContext() {
        return required().getApplicationContext();
    }

    
    public Object getAttribute(String name) {
        return required().getAttribute(name);
    }

    
    public Set<String> getAttributeNames() {
        return required().getAttributeNames();
    }

    
    public BindingResult getBindingResult(String bean) {
        return required().getBindingResult(bean);
    }

    
    public List<String> getBindingResultNames() {
        return required().getBindingResultNames();
    }

    
    public List<BindingResult> getBindingResults() {
        return required().getBindingResults();
    }

    
    public Object getController() {
        return required().getController();
    }

    
    public Class<?> getControllerClass() {
        return required().getControllerClass();
    }

    
    public void addFlash(String name, String msg) {
        required().addFlash(name, msg);
    }

    
    public Flash getFlash() {
        return required().getFlash();
    }

    
    public Method getMethod() {
        return required().getMethod();
    }

    
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return required().isAnnotationPresent(annotationClass);
    }

    
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return required().getAnnotation(annotationClass);
    }

    
    public Object getMethodParameter(String name) {
        return required().getMethodParameter(name);
    }

    
    public String[] getMethodParameterNames() {
        return required().getMethodParameterNames();
    }

    
    public Object[] getMethodParameters() {
        return required().getMethodParameters();
    }

    
    public Model getModel() {
        return required().getModel();
    }

    
    public Object getModel(String name) {
        return required().getModel(name);
    }

    
    public String getParameter(String name) {
        return required().getParameter(name);
    }

    
    public BindingResult getParameterBindingResult() {
        return required().getParameterBindingResult();
    }

    
    public HttpServletRequest getRequest() {
        return required().getRequest();
    }

    
    public RequestPath getRequestPath() {
        return required().getRequestPath();
    }

    
    public HttpServletResponse getResponse() {
        return required().getResponse();
    }

    
    public ServletContext getServletContext() {
        return required().getServletContext();
    }

    
    public void removeAttribute(String name) {
        required().removeAttribute(name);

    }

    
    public Invocation setAttribute(String name, Object value) {
        return required().setAttribute(name, value);
    }

    
    public void setRequest(HttpServletRequest request) {
        required().setRequest(request);
    }

    
    public Flash getFlash(boolean create) {
        return required().getFlash(create);
    }

    
    public Invocation getPreInvocation() {
        return required().getPreInvocation();
    }

    
    public Invocation getHeadInvocation() {
        return required().getHeadInvocation();
    }

    
    public String getResourceId() {
        return required().getResourceId();
    }

    
    public void addAfterCompletion(AfterCompletion afterComletion) {
        required().addAfterCompletion(afterComletion);
    }
}
