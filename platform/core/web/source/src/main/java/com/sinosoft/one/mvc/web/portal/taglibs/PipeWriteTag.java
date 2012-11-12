/*
 * Copyright 2007-2010 the original author or authors.
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
package com.sinosoft.one.mvc.web.portal.taglibs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 *
 * 
 */

public class PipeWriteTag extends TagSupport {

    private static final long serialVersionUID = -6302408795675569266L;

    private boolean lazyLoad = true;

    private String id;

    private String targetId;

    private static Log logger = LogFactory.getLog(PipeWriteTag.class);
    @Override
    public int doStartTag() throws JspException {

        Map<String, Map<String, String>> pipeWriters = (Map<String, Map<String, String>>)pageContext.getAttribute("pipeWrites");

        if(pipeWriters == null) {
            pipeWriters = new HashMap<String, Map<String, String>>();
        }

        final Map<String, String> pipeWriter = new HashMap<String, String>();
        pipeWriter.put("lazyLoad", String.valueOf(lazyLoad));
        pipeWriter.put("lazyAreaId", id);
        pipeWriter.put("targetId", targetId);

        pipeWriters.put(targetId, pipeWriter);
        pageContext.setAttribute("pipeWrites", pipeWriters);

        return SKIP_BODY;
    }

    public boolean isLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(boolean lazyLoad) {
        this.lazyLoad = lazyLoad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
