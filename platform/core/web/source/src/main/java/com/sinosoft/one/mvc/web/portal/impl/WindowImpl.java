/*
 * Copyright 2007-2012 the original author or authors.
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

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Charsets;
import com.sinosoft.one.mvc.web.portal.Portal;
import com.sinosoft.one.mvc.web.portal.Window;
import org.apache.commons.lang.StringUtils;

/**
 * 
 *
 * 
 */
class WindowImpl implements Window {

    private static boolean defaultMayInterruptIfRunning = false;
    static {
        String pv;
        try {
            pv = System.getProperty("mvc.portal.may_interrupt_if_running");
            if (pv == null) {
                pv = (String) System.getenv("mvc.portal.may_interrupt_if_running");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pv = "false";
        }
        if (pv == null) {
            pv = "false";
        }
        defaultMayInterruptIfRunning = Boolean.valueOf(pv);
    }

    //--------------------

    private String name;

    private String path;

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    private String charset;

    private Throwable throwable;

    private int statusCode = 200;

    private String statusMessage = "";

    private GenericWindowContainer container;

    private WindowFuture<?> future;

    private boolean mayInterruptIfRunning = defaultMayInterruptIfRunning;

    private boolean interrupted = false;

    private boolean lazyLoad;

    private String lazyAreaId;

    /**
     * 窗口请求对象私有的、有别于其他窗口的属性
     */
    private Map<String, Object> privateAttributes;

    public WindowImpl(GenericWindowContainer container, String name, String windowPath) {
        this.container = container;
        this.name = name;
        this.path = windowPath;
    }

    /**
     * 请使用 {@link #getContainer()}代替
     */
    
    @Deprecated
    public Portal getPortal() {
        return (Portal) container;
    }

    
    public GenericWindowContainer getContainer() {
        return container;
    }

    
    public Future<?> getFuture() {
        return future;
    }

    public void setFuture(WindowFuture<?> future) {
        this.future = future;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }

    
    public boolean isCancelled() {
        return interrupted || future.isCancelRequested() || future.isCancelled();
    }

    
    public void set(String key, Object value) {
        if (FUTURE_CANCEL_ENABLE_ATTR.equals(key)) {
            if (value == null || Boolean.FALSE.equals(value) || "false".equals(value)) {
                setMayInterruptIfRunning(false);
            } else {
                setMayInterruptIfRunning(true);
            }
        } else {
            if (privateAttributes == null) {
                privateAttributes = new HashMap<String, Object>();
            }
            privateAttributes.put(key, value);
        }
    }

    
    public Object get(String key) {
        if (FUTURE_CANCEL_ENABLE_ATTR.equals(key)) {
            return mayInterruptIfRunning();
        }
        return privateAttributes == null ? null : privateAttributes.get(key);
    }

    
    public void remove(String key) {
        if (FUTURE_CANCEL_ENABLE_ATTR.equals(key)) {
            setMayInterruptIfRunning(defaultMayInterruptIfRunning);
            return;
        }
        if (privateAttributes != null) {
            privateAttributes.remove(key);
        }
    }

    
    public Map<String, Object> getAttributes() {
        if (privateAttributes == null) {
            return Collections.emptyMap();
        } else {
            return Collections.unmodifiableMap(privateAttributes);
        }
    }

    
    public void setTitle(Object title) {
        set(TITLE_ATTR, title);
    }

    
    public Object getTitle() {
        Object value = get(TITLE_ATTR);
        if (value == null) {
            value = name;
        }
        return value;
    }

    
    public int getContentLength() {
        return byteArrayOutputStream.size() == 0 ? -1 : byteArrayOutputStream.size();
    }

    
    public String getContent() {
        try {
            String content = new String(byteArrayOutputStream.toByteArray(), getCharacterEncoding());
            return content;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void appendContent(int b) {
        byteArrayOutputStream.write(b);
    }

    public void appendContent(byte[] b) throws IOException {
        byteArrayOutputStream.write(b);
    }

    
    public void clearContent() {
        byteArrayOutputStream.reset();
    }

    public boolean isDone() {
        return future.isDone();
    }

    
    public boolean isSuccess() {
        return !isCancelled() && isDone() && getStatusCode() == HttpServletResponse.SC_OK
                && throwable == null;
    }

    
    public String getName() {
        return name;
    }

    
    public String getPath() {
        return path;
    }

    
    public Throwable getThrowable() {
        return throwable;
    }

    
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
        this.statusMessage = throwable.getMessage();
        if (statusCode < 500 || statusCode >= 600) {
            statusCode = 500;
        }
    }

    public void setStatus(int sc) {
        this.statusCode = sc;
        this.statusMessage = "";
    }

    public void setStatus(int sc, String msg) {
        this.statusCode = sc;
        this.statusMessage = msg;
    }

    
    public int getStatusCode() {
        return statusCode;
    }

    
    public String getStatusMessage() {
        return statusMessage;
    }

    
    public String toString() {
        return "window[" + path + "]";
    }

    
    public void render(Writer out) throws IOException {
        getContainer().render(out, this);
    }

    
    public boolean equals(Object obj) {
        if (!(obj instanceof Window)) {
            return false;
        }
        return this.name.equals(((Window) obj).getName());
    }

    
    public int hashCode() {
        return this.name.hashCode();
    }

    
    public void setMayInterruptIfRunning(boolean mayInterruptIfRunning) {
        this.mayInterruptIfRunning = mayInterruptIfRunning;
    }

    public void setLazyLoad(boolean lazyLoad) {
        this.lazyLoad = lazyLoad;
    }

    public void setLazyAreaId(String lazyAreaId) {
        this.lazyAreaId = lazyAreaId;
    }

    public boolean isLazyLoad() {
        return lazyLoad;
    }

    public String getLazyAreaId() {
        return lazyAreaId;
    }

    public boolean mayInterruptIfRunning() {
        return mayInterruptIfRunning;
    }

    public String getCharacterEncoding() {
        return charset != null ? charset : Charsets.UTF_8.displayName();
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
