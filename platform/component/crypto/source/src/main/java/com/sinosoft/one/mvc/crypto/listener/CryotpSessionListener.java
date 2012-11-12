package com.sinosoft.one.mvc.crypto.listener;

import com.sinosoft.one.mvc.crypto.CryptoCodec;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * User: Morgan
 * Date: 12-11-8
 * Time: 上午9:56
 */
public class CryotpSessionListener implements HttpSessionListener {
	private static Log logger = LogFactory.getLog(CryotpSessionListener.class);
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME,
				CryptoCodec.getCryptoKey(se.getSession().getId()));
		if(logger.isDebugEnabled()) {
			logger.debug("CryotpSessionListener session created");
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {

	}
}
