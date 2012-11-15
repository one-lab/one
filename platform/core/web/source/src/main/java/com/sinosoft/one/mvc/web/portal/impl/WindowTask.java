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

import java.util.concurrent.ExecutorService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import com.sinosoft.one.mvc.MvcConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * {@link WindowTask} 把一个窗口任务进行封装，使可以提交到 {@link ExecutorService} 执行。
 * 
 *
 * 
 */
final class WindowTask implements Runnable {


    private static final Log logger = LogFactory.getLog(WindowTask.class);

    private final WindowImpl window;

    private final WindowRequest request;

    private final WindowResponse response;

    public WindowTask(WindowImpl window, WindowRequest request, WindowResponse response) {
        if (window == null) {
            throw new NullPointerException("window");
        }
        this.window = window;
        this.request = request;
        this.response = response;
    }

    public WindowImpl getWindow() {
        return window;
    }

    public void run() {
        try {
            // started
            window.getContainer().onWindowStarted(window);

            // doRequest
            String windowPath = window.getPath();
            if (windowPath.length() == 0 || windowPath.charAt(0) != '/') {
                String requestUri = request.getRequestURI();
                if (!requestUri.endsWith("/")) {
                    requestUri = requestUri + "/";
                }
                windowPath = requestUri + windowPath;
            }


         //   request.setAttribute("$$one-mvc-portal.window", window);
            request.setAttribute("$$one-mvc-portal.window."+window.getName(), window);

//            String list = (String)request.getAttribute("$$one-mvc-portal.window.names");
//            if(list==null){
//                list = window.getName();
//            }
//            else{
//                list = list+","+window.getName();
//            }
//            request.setAttribute("$$one-mvc-portal.window.names",list);

            if (this.response.isCommitted()) {
                if (logger.isDebugEnabled()) {
                    logger.debug("onWindowTimeout: response has committed. [" + window.getName()
                            + "]@" + window.getContainer());
                }
                window.getContainer().onWindowTimeout(window);
                return;
            }

            final RequestDispatcher rd = request.getRequestDispatcher(windowPath);
            request.setAttribute(MvcConstants.WINDOW_REQUEST_URI, request.getContextPath() + windowPath);
            rd.forward(request, this.response);

            // done!
            window.getContainer().onWindowDone(window);
        } catch (Throwable e) {
            logger.error("", e);
            window.setThrowable(e);
            window.getContainer().onWindowError(window);
        } finally {
            // remove request from ThreadLocal in PortalRequest 
            // 销毁在PortalRequest的ThreadLocal成员变量中保存的与 当前线程相关的request对象，以防内存泄漏。
            final HttpServletRequest wrapper = window.getContainer().getRequest();
            final PortalRequest portalRequest = PortalRequest.unwrapPortalRequest(wrapper);
            portalRequest.setRequest(null);

        }
    }

    @Override
    public String toString() {
        return "window [name=" + window.getName() + ", path=" + window.getPath() + "]";
    }

}
