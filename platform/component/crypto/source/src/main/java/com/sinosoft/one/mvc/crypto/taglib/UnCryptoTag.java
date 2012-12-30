package com.sinosoft.one.mvc.crypto.taglib;

import com.sinosoft.one.mvc.crypto.CryptoCodec;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.common.core.OutSupport;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

import javax.servlet.jsp.JspException;

/**
 * UnCrypto标签
 * User: carvin
 * Date: 12-12-27
 * Time: 下午3:02
 * To change this template use File | Settings | File Templates.
 */
public class UnCryptoTag extends OutSupport {
    //*********************************************************************
    // 'Private' state (implementation details)

    private String value_;			// stores EL-based property

    private String id_;

    //*********************************************************************
    // Constructor

    public UnCryptoTag() {
        super();
        init();
    }


    //*********************************************************************
    // Tag logic

    // evaluates expression and chains to parent
    public int doStartTag() throws JspException {

        // evaluate any expressions we were passed, once per invocation
        evaluateExpressions();

        // chain to the parent implementation
        return super.doStartTag();
    }


    // Releases any resources we may have (or inherit)
    public void release() {
        super.release();
        init();
    }


    //*********************************************************************
    // Accessor methods

    public void setValue(String value_) {
        this.value_ = value_;
    }

    public void setId(String id_) {
        this.id_ = id_;
    }
    //*********************************************************************
    // Private (utility) methods

    // (re)initializes state (during release() or construction)
    private void init() {
        // null implies "no expression"
        value_ = null;
        id_ = null;
    }

    /* Evaluates expressions as necessary */
    private void evaluateExpressions() throws JspException {
        try {
            value = ExpressionUtil.evalNotNull(
                    "out", "value", value_, Object.class, this, pageContext);

            String key = (String) (pageContext.getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME));
            value = CryptoCodec.encode(key, String.valueOf(value));
            if(id_ != null && !id_.trim().equals("")) {
                value = doUnCryptoJsWithId(key,value.toString());
            } else {
                value = doUnCryptoJs(key,value.toString());
            }
            escapeXml =false;
        } catch (NullAttributeException ex) {
            // explicitly allow 'null' for value
            value = null;
        }
    }

    private String doUnCryptoJsWithId(String key, String value) {
        StringBuilder out = new StringBuilder(100);
        out.append("<script type='text/javascript'>( function(){");
        out.append("document.getElementById('" + id_ + "').value =decode('") .append(key).append("','").append(value).append("');");
        out.append("})();</script>");
        return out.toString();
    }
    private String doUnCryptoJs(String key, String value) {
        StringBuilder out = new StringBuilder(100);
        out.append("<script type='text/javascript'>( function(){");
            out.append("document.write(decode('") .append(key).append("','").append(value).append("'));");
        out.append("})();</script>");
        return out.toString();
    }
}
