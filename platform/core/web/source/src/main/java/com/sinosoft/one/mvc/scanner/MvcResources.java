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
package com.sinosoft.one.mvc.scanner;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.sinosoft.one.mvc.scanning.LoadScope;
import com.sinosoft.one.mvc.scanning.ResourceRef;
import com.sinosoft.one.mvc.scanning.MvcScanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 *
 * 
 */
public class MvcResources {

    protected static Log logger = LogFactory.getLog(MvcResources.class);

    public static List<Resource> findContextResources(LoadScope load) throws IOException {
        if (logger.isInfoEnabled()) {
            logger.info("[applicationContext] start to found applicationContext files ...");
        }
        String[] scope = load.getScope("applicationContext");
        if (logger.isDebugEnabled()) {
            if (scope == null) {
                logger.debug("[applicationContext] use default scope"
                        + " [all class folders and mvcd jar files]");
            } else {
                logger.debug("[applicationContext] use scope: " + Arrays.toString(scope));
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("[applicationContext] call 'findFiles'");
        }
        List<ResourceRef> resources = MvcScanner.getInstance().getJarOrClassesFolderResources(
                scope);
        if (logger.isDebugEnabled()) {
            logger.debug("[applicationContext] exits from 'findFiles'");
            logger.debug("[applicationContext] it has " + resources.size()
                    + " classes folders or jar files " + "in the applicationContext scope: "
                    + resources);

            logger.debug("[applicationContext] iterates the 'findFiles'"
                    + " classes folders or jar files; size=" + resources.size());
        }

        List<Resource> ctxResources = new LinkedList<Resource>();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        int index = 0;
        for (ResourceRef ref : resources) {
            index++;
            if (ref.hasModifier("applicationContext")) {
                Resource[] founds = ref.getInnerResources(resourcePatternResolver,
                        "applicationContext*.xml");
                List<Resource> asList = Arrays.asList(founds);
                ctxResources.addAll(asList);
                if (logger.isDebugEnabled()) {
                    logger.debug("[applicationContext] found applicationContext resources ("
                            + index + "/" + resources.size() + ": " + asList);
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger
                            .debug("[applicationContext] ignored bacause not marked as 'mvc:applicationContext' or 'mvc:*'  ("
                                    + index + "/" + resources.size() + ": " + ref);
                }
            }
        }
        if (logger.isInfoEnabled()) {
            logger.info("[applicationContext] FOUND " + ctxResources.size()
                    + " applcationContext files: " + ctxResources);
        }
        return ctxResources;
    }

    public static String[] findMessageBasenames(LoadScope load) throws IOException {
        if (logger.isInfoEnabled()) {
            logger.info("[messages] start to found mvc.root 'messages' files ...");
        }
        String[] scope = load.getScope("messages");

        if (logger.isDebugEnabled()) {
            logger.debug("[messages] call 'scoped'");
        }
        List<ResourceRef> resources = MvcScanner.getInstance().getJarOrClassesFolderResources(
                scope);

        if (logger.isDebugEnabled()) {
            logger.debug("[messages] exits from 'scoped'");
            logger.debug("[messages] it has " + resources.size() + " classes folders or jar files "
                    + "in the messages scope: " + resources);

            logger.debug("[messages] iterates the 'scoped'"
                    + " classes folders or jar files; size=" + resources.size());
        }

        List<String> messagesResources = new LinkedList<String>();
        int index = 0;
        for (ResourceRef ref : resources) {
            index++;
            if (ref.hasModifier("messages")) {
                messagesResources.add(ref.getInnerResourcePattern("messages"));
                if (logger.isDebugEnabled()) {
                    logger.debug("[messages] add messages base name (" + index + "/"
                            + resources.size() + ": " + ref);
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger
                            .debug("[messages] ignored bacause not marked as 'mvc:messages' or 'mvc:*'  ("
                                    + index + "/" + resources.size() + ": " + ref);
                }
            }
        }
        if (logger.isInfoEnabled()) {
            logger.info("[messages] found " + messagesResources.size() + " messages base names: "
                    + messagesResources);
        }

        return messagesResources.toArray(new String[0]);
    }
}
