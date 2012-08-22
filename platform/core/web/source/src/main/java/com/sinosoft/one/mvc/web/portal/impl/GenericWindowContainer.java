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

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.one.mvc.MvcConstants;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.portal.Window;
import com.sinosoft.one.mvc.web.portal.WindowCallback;
import com.sinosoft.one.mvc.web.portal.WindowContainer;
import com.sinosoft.one.mvc.web.portal.WindowListener;
import com.sinosoft.one.mvc.web.portal.WindowListeners;
import com.sinosoft.one.mvc.web.portal.WindowRender;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Portal 框架的核心类。
 * 
 *
 * 
 */
public abstract class GenericWindowContainer implements WindowRender, WindowContainer,
        WindowListener {

    private static final Log logger = LogFactory.getLog(GenericWindowContainer.class);

    protected static final NestedWindowRender singletonRender = new NestedWindowRender();

    protected NestedWindowRender render = singletonRender;

    protected ExecutorService executorService;

    protected WindowListeners windowListeners;

    protected Invocation invocation;

    protected List<Window> windows = new LinkedList<Window>();

    protected long timeout;

    public GenericWindowContainer(Invocation inv, ExecutorService executorService,
            WindowListener portalListener) {
        this.invocation = inv;
        this.executorService = executorService;
        addListener(portalListener);
    }

    public void setTimeout(long timeoutInMills) {
        this.timeout = timeoutInMills;
    }

    public long getTimeout() {
        return timeout;
    }

    
    public Invocation getInvocation() {
        return invocation;
    }

    /**
     * 为一致概念，这里麻烦一点，请您调用: {@link #getInvocation()#addModel(String, Object)}
     * 来完成 现在是2010-08-04，正常情况下2010国庆后将去掉此代码
     */
    @Deprecated
    
    public void addModel(String name, Object value) {
        getInvocation().addModel(name, value);
    }

    
    public HttpServletRequest getRequest() {
        return invocation.getRequest();
    }

    
    public HttpServletResponse getResponse() {
        return invocation.getResponse();
    }

    
    public void addListener(WindowListener l) {
        if (l == null) {
            return;
        } else {
            synchronized (this) {
                if (windowListeners == null) {
                    windowListeners = new WindowListeners();
                }
                windowListeners.addListener(l);
            }
        }
    }

    
    public Window addWindow(String name, String windowPath) {
        return this.addWindow(name, windowPath, (WindowCallback) null);
    }

    
    public Window addWindow(String name, String windowPath, final Map<String, Object> attributes) {
        WindowCallback callback = null;
        if (attributes != null && attributes.size() > 0) {
            callback = new WindowCallback() {

                
                public void beforeSubmit(Window window) {
                    synchronized (attributes) {
                        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                            window.set(entry.getKey(), entry.getValue());
                        }
                    }
                }
            };
        }
        return this.addWindow(name, windowPath, callback);
    }

    
    public Window addWindow(String name, String windowPath, WindowCallback callback) {
        // 创建 窗口对象
        WindowImpl window = new WindowImpl(this, name, windowPath);

        WindowRequest request = new WindowRequest(window, getRequest());
        WindowResponse response = new WindowResponse(window);

        request.setAttribute("$$one-mvc-portal.window.name", name);
        request.setAttribute("$$one-mvc-portal.window.path", windowPath);

        // PortalWaitInterceptor#waitForWindows
        // MvcFilter#supportsMvcpipe
        request.removeAttribute(MvcConstants.PIPE_WINDOW_IN);

        // 定义窗口任务
        WindowTask task = new WindowTask(window, request, response);

        // 注册到相关变量中
        Window windowInView = new WindowForView(window);
        synchronized (windows) {
            this.windows.add(windowInView);
        }
        // for render
        this.invocation.addModel(name, windowInView);

        if (callback != null) {
            callback.beforeSubmit(window);
        }

        // 事件侦听回调
        onWindowAdded(window);

        // 提交到执行服务中执行
        WindowFuture<?> future = submitWindow(this.executorService, task);
        window.setFuture(future);

        // 返回窗口对象
        return window;
    }

    
    public List<Window> getWindows() {
        return windows;
    }

    
    public WindowRender getWindowRender() {
        return render.getInnerRender();
    }

    
    public void setWindowRender(WindowRender render) {
        if (render == null) {
            this.render = singletonRender;
        } else {
            if (this.render == singletonRender) {
                this.render = new NestedWindowRender(render);
            } else {
                this.render.setInnerRender(render);
            }
        }
    }

    @SuppressWarnings( { "unchecked" })
    protected WindowFuture<?> submitWindow(ExecutorService executor, WindowTask task) {
        Future<?> future = executor.submit(task);
        return new WindowFuture(future, task.getWindow());
    }

    
    public void render(Writer out, Window window) throws IOException {
        render.render(out, window);
    }

    //-------------实现toString()---------------F

    
    public String toString() {
        return "aggregate ['" + invocation.getRequestPath().getUri() + "']";
    }

    //------------ 以下代码是PortalListener和Invocation的实现代码 --------------------------------

    
    public void onWindowAdded(Window window) {
        if (windowListeners != null) {
            try {
                windowListeners.onWindowAdded(window);
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }

    
    public void onWindowStarted(Window window) {
        if (windowListeners != null) {
            try {
                windowListeners.onWindowStarted(window);
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }

    
    public void onWindowCanceled(Window window) {
        if (windowListeners != null) {
            try {
                windowListeners.onWindowCanceled(window);
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }

    
    public void onWindowDone(Window window) {
        if (windowListeners != null) {
            try {
                windowListeners.onWindowDone(window);
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }

    
    public void onWindowError(Window window) {
        if (windowListeners != null) {
            try {
                windowListeners.onWindowError(window);
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }

    
    public void onWindowTimeout(Window window) {
        if (windowListeners != null) {
            try {
                windowListeners.onWindowTimeout(window);
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }

}
