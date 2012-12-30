package com.sinosoft.one.mvc.crypto.filter;

import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.crypto.config.CryptoMatchResult;
import com.sinosoft.one.mvc.crypto.config.UnCrypto;
import com.sinosoft.one.mvc.crypto.parser.CryptoConfigurationParser;
import com.sinosoft.one.mvc.crypto.wapper.CryptoRequestWapper;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * User: Morgan
 * Date: 12-11-5
 * Time: 下午6:04
 */
public class CryptoFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(CryptoFilter.class);
	private String configLocation;
	private CryptoConfig cryptoConfig = CryptoConfig.getInstance();

	public void init(FilterConfig filterConfig) throws ServletException {
        configLocation = filterConfig.getInitParameter("cryptoConfigLocation");
        if(StringUtils.isBlank(configLocation)) {
            throw new IllegalStateException("The CryptoFilter 's cryptoConfigLocation param is not blank.");
        }
        ServletContext servletContext = filterConfig.getServletContext();
		initCryptoConfig(servletContext);
	}

	private void initCryptoConfig(ServletContext servletContext ) {
        new CryptoConfigurationParser().parserCryptoConfiguration(configLocation);
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestUrl = httpRequest.getRequestURI();
		logger.info("in do Filter requestURI:" + requestUrl);

		//匹配加解密配置文件的url
		CryptoMatchResult matchResult = cryptoConfig.quickMatch(requestUrl);
		if( matchResult != null ) {
			String key = (String) httpRequest.getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
			//匹配结果为后台配置文件的解密url
			if( CryptoMatchResult.UNCRYPTO_MATCH_RESULT.equals( matchResult ) ) {
				String uncryptos = request.getParameter(CryptoConfig.CRUPTO_ATTR_NAMES);
				//解密用的requestwapper
				request = new CryptoRequestWapper(httpRequest,
						new HashMap<String,String[]>(request.getParameterMap()), key,uncryptos);

			}

			logger.info("requestURI:" + requestUrl);
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		this.cryptoConfig = null;
	}
}
