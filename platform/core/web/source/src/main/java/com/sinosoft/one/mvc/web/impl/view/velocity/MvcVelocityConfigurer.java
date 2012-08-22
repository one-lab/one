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
package com.sinosoft.one.mvc.web.impl.view.velocity;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

/**
 * 
 *
 * 
 */
public class MvcVelocityConfigurer extends VelocityConfigurer {

    /** the name of the resource loader for Mvc's bind macros */
    private static final String ROSE_MACRO_RESOURCE_LOADER_NAME = "mvcMacro";

    /** the key for the class of Mvc's bind macro resource loader */
    private static final String ROSE_MACRO_RESOURCE_LOADER_CLASS = "mvcMacro.resource.loader.class";

    /** the name of Mvc's default bind macro library */
    private static final String ROSE_MACRO_LIBRARY = "com/sinosoft/one/mvc/web/impl/view/velocity/mvc.vm";

    @Override
    protected void postProcessVelocityEngine(VelocityEngine velocityEngine) {
        super.postProcessVelocityEngine(velocityEngine);
        velocityEngine.setProperty(ROSE_MACRO_RESOURCE_LOADER_CLASS, ClasspathResourceLoader.class
                .getName());
        velocityEngine.addProperty(VelocityEngine.RESOURCE_LOADER, ROSE_MACRO_RESOURCE_LOADER_NAME);
        velocityEngine.addProperty(VelocityEngine.VM_LIBRARY, ROSE_MACRO_LIBRARY);
        if (logger.isInfoEnabled()) {
            logger.info("ClasspathResourceLoader with name '" + ROSE_MACRO_RESOURCE_LOADER_NAME
                    + "' added to configured VelocityEngine");
        }
    }
}
