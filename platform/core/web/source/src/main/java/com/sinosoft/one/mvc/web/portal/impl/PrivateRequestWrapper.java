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
package com.sinosoft.one.mvc.web.portal.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * 私有请求包装器，但不继承于 {@link HttpServletRequestWrapper}
 * 
 *
 * 
 */
public class PrivateRequestWrapper implements HttpServletRequest {

    private HttpServletRequest request;

    private Object mutex;

    public PrivateRequestWrapper(HttpServletRequest request) {
        this.request = request;
        this.mutex = request;
    }

    protected HttpServletRequest getRequest() {
        return request;
    }

    
    public RequestDispatcher getRequestDispatcher(String path) {
        return getRequest().getRequestDispatcher(path);
    }

    
    public Object getAttribute(String name) {
        return getRequest().getAttribute(name);
    }

    
    @SuppressWarnings("unchecked")
    public Enumeration getAttributeNames() {
        synchronized (mutex) {
            return getRequest().getAttributeNames();
        }
    }

    
    public void removeAttribute(String name) {
        synchronized (mutex) {
            getRequest().removeAttribute(name);
        }
    }

    
    public void setAttribute(String name, Object value) {
        synchronized (mutex) {
            getRequest().setAttribute(name, value);
        }
    }

    
    public String getContextPath() {
        return getRequest().getContextPath();
    }

    
    public String getQueryString() {
        return getRequest().getQueryString();
    }

    
    public String getRequestURI() {
        return getRequest().getRequestURI();
    }

    
    public String getServletPath() {
        return getRequest().getServletPath();
    }

    
    public StringBuffer getRequestURL() {
        return getRequest().getRequestURL();
    }

    
    public String getAuthType() {
        return getRequest().getAuthType();
    }

    
    public Cookie[] getCookies() {
        synchronized (mutex) {
            return getRequest().getCookies();
        }
    }

    
    public long getDateHeader(String name) {
        synchronized (mutex) {
            return getRequest().getDateHeader(name);
        }
    }

    
    public String getHeader(String name) {
        synchronized (mutex) {
            return getRequest().getHeader(name);
        }
    }

    
    @SuppressWarnings("unchecked")
    public Enumeration getHeaders(String name) {
        synchronized (mutex) {
            return getRequest().getHeaders(name);
        }
    }

    
    @SuppressWarnings("unchecked")
    public Enumeration getHeaderNames() {
        synchronized (mutex) {
            return getRequest().getHeaderNames();
        }
    }

    
    public int getIntHeader(String name) {
        synchronized (mutex) {
            return getRequest().getIntHeader(name);
        }
    }

    
    public String getMethod() {
        return getRequest().getMethod();
    }

    
    public String getPathInfo() {
        return getRequest().getPathInfo();
    }

    
    public String getPathTranslated() {
        return getRequest().getPathTranslated();
    }

    
    public String getRemoteUser() {
        return getRequest().getRemoteUser();
    }

    
    public boolean isUserInRole(String role) {
        return getRequest().isUserInRole(role);
    }

    
    public java.security.Principal getUserPrincipal() {
        return getRequest().getUserPrincipal();
    }

    
    public String getRequestedSessionId() {
        return getRequest().getRequestedSessionId();
    }

    
    public HttpSession getSession(boolean create) {
        return getRequest().getSession(create);
    }

    
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    
    public boolean isRequestedSessionIdValid() {
        return getRequest().isRequestedSessionIdValid();
    }

    
    public boolean isRequestedSessionIdFromCookie() {
        return getRequest().isRequestedSessionIdFromCookie();
    }

    
    public boolean isRequestedSessionIdFromURL() {
        return getRequest().isRequestedSessionIdFromURL();
    }

    @SuppressWarnings("deprecation")
    
    public boolean isRequestedSessionIdFromUrl() {
        return getRequest().isRequestedSessionIdFromUrl();
    }

    
    public String getCharacterEncoding() {
        return getRequest().getCharacterEncoding();
    }

    
    public void setCharacterEncoding(String enc) throws java.io.UnsupportedEncodingException {
        synchronized (mutex) {
            getRequest().setCharacterEncoding(enc);
        }
    }

    
    public int getContentLength() {
        return getRequest().getContentLength();
    }

    
    public String getContentType() {
        return getRequest().getContentType();
    }

    
    public ServletInputStream getInputStream() throws IOException {
        synchronized (mutex) {
            return getRequest().getInputStream();
        }
    }

    
    public String getParameter(String name) {
        synchronized (mutex) {
            return getRequest().getParameter(name);
        }
    }

    
    @SuppressWarnings("unchecked")
    public synchronized Map getParameterMap() {
        // 如果没有同步，tomcat下可能出现java.lang.IllegalStateException: No modifications are allowed to a locked ParameterMap
        return getRequest().getParameterMap();
    }

    
    @SuppressWarnings("unchecked")
    public Enumeration getParameterNames() {
        return getRequest().getParameterNames();
    }

    
    public String[] getParameterValues(String name) {
        return getRequest().getParameterValues(name);
    }

    
    public String getProtocol() {
        return getRequest().getProtocol();
    }

    
    public String getScheme() {
        return getRequest().getScheme();
    }

    
    public String getServerName() {
        return getRequest().getServerName();
    }

    
    public int getServerPort() {
        return getRequest().getServerPort();
    }

    
    public BufferedReader getReader() throws IOException {
        synchronized (mutex) {
            return getRequest().getReader();
        }
    }

    
    public String getRemoteAddr() {
        return getRequest().getRemoteAddr();
    }

    
    public String getRemoteHost() {
        return getRequest().getRemoteHost();
    }

    
    public Locale getLocale() {
        return getRequest().getLocale();
    }

    
    @SuppressWarnings("unchecked")
    public Enumeration getLocales() {
        return getRequest().getLocales();
    }

    
    public boolean isSecure() {
        return getRequest().isSecure();
    }

    @SuppressWarnings("deprecation")
    
    public String getRealPath(String path) {
        return getRequest().getRealPath(path);
    }

    
    public int getRemotePort() {
        return getRequest().getRemotePort();
    }

    
    public String getLocalName() {
        return getRequest().getLocalName();
    }

    
    public String getLocalAddr() {
        return getRequest().getLocalAddr();
    }

    
    public int getLocalPort() {
        return getRequest().getLocalPort();
    }

}
