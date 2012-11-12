/*
 * Copyright 2007-2011 the original author or authors.
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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.Future;

import com.sinosoft.one.mvc.web.portal.Portal;
import com.sinosoft.one.mvc.web.portal.Window;

/**
 * 
 * @author qieqie.wang@gmail.com
 * 
 */
public class WindowForView implements Window {

    private WindowImpl inner;

    public WindowForView(WindowImpl window) {
        this.inner = window;
    }

    
    public String toString() {
        StringWriter sw = new StringWriter(getContentLength() >= 0 ? getContentLength() : 16);
        PrintWriter out = new PrintWriter(sw);
        try {
            render(out);
        } catch (IOException e) {
            e.printStackTrace(out);
        }
        out.flush();
        return sw.getBuffer().toString();
    }

    
    public void render(Writer out) throws IOException {
        this.inner.render(out);
    }

    
    public void clearContent() {
        inner.clearContent();
    }

    
    public Object get(String key) {
        return inner.get(key);
    }

    
    public Map<String, Object> getAttributes() {
        return inner.getAttributes();
    }

    
    public GenericWindowContainer getContainer() {
        return inner.getContainer();
    }

    
    public String getContent() {
        return inner.getContent();
    }

    
    public int getContentLength() {
        return inner.getContentLength();
    }

    
    public Future<?> getFuture() {
        return inner.getFuture();
    }

    
    public String getName() {
        return inner.getName();
    }

    
    public String getPath() {
        return inner.getPath();
    }

    
    public Portal getPortal() {
        return inner.getPortal();
    }

    
    public int getStatusCode() {
        return inner.getStatusCode();
    }

    
    public String getStatusMessage() {
        return inner.getStatusMessage();
    }

    
    public Throwable getThrowable() {
        return inner.getThrowable();
    }

    
    public Object getTitle() {
        return inner.getTitle();
    }

    
    public boolean isCancelled() {
        return inner.isCancelled();
    }

    
    public boolean isDone() {
        return inner.isDone();
    }

    
    public boolean isSuccess() {
        return inner.isSuccess();
    }

    
    public boolean mayInterruptIfRunning() {
        return inner.mayInterruptIfRunning();
    }

    
    public void remove(String key) {
        inner.remove(key);
    }

    
    public void set(String key, Object value) {
        inner.set(key, value);
    }

    
    public void setMayInterruptIfRunning(boolean mayInterruptIfRunning) {
        inner.setMayInterruptIfRunning(mayInterruptIfRunning);
    }

    public void setLazyLoad(boolean lazyLoad) {
        inner.setLazyLoad(lazyLoad);
    }

    public void setLazyAreaId(String lazyAreaId) {
        inner.setLazyAreaId(lazyAreaId);
    }

    public boolean isLazyLoad() {
        return inner.isLazyLoad();
    }

    public String getLazyAreaId() {
        return inner.getLazyAreaId();
    }

    public void setThrowable(Throwable throwable) {
        inner.setThrowable(throwable);
    }

    
    public void setTitle(Object title) {
        inner.setTitle(title);
    }

    public WindowImpl getInner() {
        return this.inner;
    }

}
