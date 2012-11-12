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
 * Date: 12-11-9
 * Time: 上午11:16
 */
public class UnCryptoCommonTag extends TagSupport {
	private static Log logger = LogFactory.getLog(UnCryptoCommonTag.class);
	private String eType;
	private String eIds;

	public String geteType() {
		return eType;
	}

	public void seteType(String eType) {
		this.eType = eType;
	}

	public String geteIds() {
		return eIds;
	}

	public void seteIds(String eIds) {
		this.eIds = eIds;
	}

	@Override
	public int doStartTag() throws JspException {

		String key = (String) ((HttpServletRequest)pageContext.getRequest()).getSession()
				.getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
		try {
			JspWriter out = pageContext.getOut();
			out.append("<script type=\"text/javascript\">( function(){");
			String[] ids = eIds.split(",");
			for( int l=ids.length,i=0;i<l;i++ ){
				out.append("$$crypdata=$(\"#").append(ids[i])
						.append("\").text();$(\"#").append(ids[i])
						.append("\").text(decode('"+key+"',$$crypdata));");
			}
			out.append("} )();</script>");
			out.flush();
		} catch (IOException e) {
			logger.error(e);
		}
		return super.doStartTag();
	}
}
