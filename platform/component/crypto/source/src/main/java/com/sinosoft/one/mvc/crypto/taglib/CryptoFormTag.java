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
 * Date: 12-11-7
 * Time: 上午11:57
 */
public class CryptoFormTag extends TagSupport {
	private static Log logger = LogFactory.getLog(CryptoFormTag.class);
	private String includes;
	private String excludes;
	private String formId;

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getIncludes() {
		return includes;
	}

	public void setIncludes(String includes) {
		this.includes = includes;
	}

	public String getExcludes() {
		return excludes;
	}

	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}

	@Override
	public int doStartTag() throws JspException {
		String key = (String) ((HttpServletRequest)pageContext.getRequest()).getSession()
				.getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
		JspWriter out = pageContext.getOut();
		try {
			out.append(" return crypto_form('")
					.append(key).append("','");
			if( includes != null )
				out.append("includes::").append(includes);
			else if( excludes != null )
				out.append("excludes::").append(excludes);
			out.append("','").append(formId).append("');");
			out.flush();
		} catch (IOException e) {
			logger.error("CryptoFormTag doStartTag has exception",e);
		}

		return super.doStartTag();
	}
}
