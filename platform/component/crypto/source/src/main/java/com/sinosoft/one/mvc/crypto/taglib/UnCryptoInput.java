package com.sinosoft.one.mvc.crypto.taglib;

import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
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

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		String names = (String) pageContext.getRequest().getAttribute(CryptoConfig.UNCRYPTO_ATTR_NAMES);
		String key = (String) ((HttpServletRequest)pageContext.getRequest()).getSession()
				.getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
		try {
			out.append("<script type=\"text/javascript\">( function(){");
			String[] ids = names.split(",");
			for( int l=ids.length,i=0;i<l;i++ ){
				out.append("$$crypdata=$(\"input[name='").append(ids[i])
						.append("']\").val();$(\"input[name='").append(ids[i])
						.append("']\").val(decode('"+key+"',$$crypdata));");
			}
			out.append("} )();</script>");
			out.flush();
		} catch (IOException e) {
			logger.error(e);
		}
		return super.doStartTag();
	}
}
