package com.sinosoft.one.mvc.web.portal.taglibs;


import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.InvocationUtils;
import com.sinosoft.one.mvc.web.portal.PortalUtils;
import com.sinosoft.one.mvc.web.portal.Window;
import com.sinosoft.one.mvc.web.portal.impl.PipeImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Intro:
 * User: Kylin
 * Date: 12-11-9
 * Time: 上午11:36
 * To change this template use File | Settings | File Templates.
 */
public class PipeWritesTag extends TagSupport {

    private static Log logger = LogFactory.getLog(PipeWriteTag.class);

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        Map<String, Map<String, String>> pipeWriters = (Map<String, Map<String, String>>)pageContext.getAttribute("pipeWrites");

        Invocation inv = InvocationUtils.getCurrentThreadInvocation();
        if (inv == null) {
            if (logger.isWarnEnabled()) {
                logger.warn("it is not in a mvc request: '"
                        + ((HttpServletRequest) pageContext.getRequest()).getRequestURI() + "'");
            }

            return super.doEndTag();
        }

        PipeImpl pipe = (PipeImpl) PortalUtils.getPipe(inv);


        if (pipe == null) {
            if (logger.isWarnEnabled()) {
                logger.warn("there is not pipe for this jsp: '"
                        + ((HttpServletRequest) pageContext.getRequest()).getRequestURI() + "'");
            }
            return super.doEndTag();
        }
        try {
            if (logger.isDebugEnabled()) {
                logger.debug("writing " + pipe + "...");
            }

            List<Window> windowList = pipe.getWindows();
            for(Window window : windowList) {
                String name = window.getName();
                if(pipeWriters.containsKey(name)) {
                    Map<String, String> lazyProperty = pipeWriters.get(name);
                    window.setLazyLoad(Boolean.valueOf(lazyProperty.get("lazyLoad")));
                    window.setLazyAreaId(lazyProperty.get("lazyAreaId"));
                }
            }

            pipe.write(pageContext.getOut());

            if (logger.isDebugEnabled()) {
                logger.debug("writing " + pipe + "... done");
            }
        } catch (IOException e) {
            throw new JspException(e);
        }

        return super.doEndTag();
    }
}
