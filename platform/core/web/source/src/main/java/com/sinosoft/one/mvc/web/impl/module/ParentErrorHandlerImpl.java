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
package com.sinosoft.one.mvc.web.impl.module;

import com.sinosoft.one.mvc.web.ControllerErrorHandler;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.ParentErrorHandler;
import com.sinosoft.one.mvc.web.impl.thread.InvocationBean;

/**
 * 
 *
 * 
 */
public class ParentErrorHandlerImpl implements ParentErrorHandler {

    public Object onError(Invocation inv, Throwable ex) throws Throwable {
        InvocationBean invb = (InvocationBean) inv;
        Module module = invb.getModule();
        while ((module = module.getParent()) != null) {
            ControllerErrorHandler handler;
            if ((handler = module.getErrorHandler()) != null) {
                return handler.onError(invb, ex);
            }
        }
        throw ex;
    }

}
