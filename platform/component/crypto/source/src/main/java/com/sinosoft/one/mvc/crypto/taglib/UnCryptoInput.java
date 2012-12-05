package com.sinosoft.one.mvc.crypto.taglib;

import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * User: Morgan
 * Date: 12-11-8
 * Time: 下午7:41
 */
public class UnCryptoInput extends TagSupport {
    private static Log logger = LogFactory.getLog(UnCryptoInput.class);
    private String formIds;

    public String getFormIds() {
        return formIds;
    }

    public void setFormIds(String formIds) {
        this.formIds = formIds;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        String key = (String) ((HttpServletRequest) pageContext.getRequest()).getSession()
                .getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
        if (!StringUtils.isBlank(formIds)) {
            try {
                out.append("<script type=\"text/javascript\">( function(){");
                String[] eFormIds = formIds.split(",");
                for (String eFormId : eFormIds) {
                    out.append("var i=0;var j=$(\"#").append(eFormId).append("\").find(\"input\").length;for(i=0;i<j;i++){")
                            .append("$$crypdata=$(\"#").append(eFormId).append("\").find(\"input\").eq(i).val();")
                            .append("$(\"#").append(eFormId).append("\").find(\"input\").eq(i).val(decode('")
                            .append(key).append("',$$crypdata));}");
                }
                out.append("})();</script>");
                out.flush();
            } catch (IOException e) {
                logger.error(e);
            }
        }
        return super.doStartTag();
    }
}
