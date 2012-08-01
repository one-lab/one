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

import java.util.concurrent.ExecutorService;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.portal.Portal;
import com.sinosoft.one.mvc.web.portal.WindowListener;

/**
 * {@link Portal} 的实现类，Portal 框架的核心类。
 * 
 *
 * 
 */
public class PortalImpl extends GenericWindowContainer implements Portal, WindowListener {

    public PortalImpl(Invocation inv, ExecutorService executorService, WindowListener portalListener) {
        super(inv, executorService, portalListener);
    }

    //-------------实现toString()---------------

    @Override
    public String toString() {
        return "portal ['" + getInvocation().getRequestPath().getUri() + "']";
    }

}
