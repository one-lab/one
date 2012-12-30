package com.sinosoft.one.mvc.crypto.listener;

import com.sinosoft.one.mvc.crypto.CryptoCodec;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * User: Morgan
 * Date: 12-11-8
 * Time: 上午9:56
 */
public class CryptoSessionListener implements HttpSessionListener {
	private static Logger logger = LoggerFactory.getLogger(CryptoSessionListener.class);
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME,
				CryptoCodec.getCryptoKey(se.getSession().getId()));

		logger.info("CryotpSessionListener session created");
	}

	public void sessionDestroyed(HttpSessionEvent se) {

	}
}
