package com.sinosoft.one.mvc.crypto.filter;

import com.sinosoft.one.mvc.crypto.CryptoCodec;
import com.sinosoft.one.mvc.crypto.config.Crypto;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.crypto.config.CryptoMatchResult;
import com.sinosoft.one.mvc.crypto.config.UnCrypto;
import com.sinosoft.one.mvc.crypto.wapper.CryptoRequestWapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * User: Morgan
 * Date: 12-11-5
 * Time: 下午6:04
 */
public class CryptoFilter implements Filter {

	private Log logger = LogFactory.getLog(CryptoFilter.class);
	private static String configLocation;
	private FilterConfig filterConfig;
	private static ServletContext servletContext;
	private static CryptoConfig cryptoConfig = CryptoConfig.getInstance();

	public static InputStream getConfigFileAsStream() {
		return servletContext.getResourceAsStream(configLocation);
	}

	public static ServletContext getServletCotext() {
		return servletContext;
	}

	public static String getConfigFileRealPath() {
		return servletContext.getRealPath(configLocation);
	}


	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		configLocation = filterConfig.getInitParameter("cryptoConfigLocation");

		servletContext = filterConfig.getServletContext();
		initCryptoConfig(servletContext);
	}

	private void initCryptoConfig(ServletContext servletContext ) {
//		String xmlDir = servletContext.getRealPath("\\");
		InputStream is = servletContext.getResourceAsStream(configLocation);

		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(is);
			Element root = document.getRootElement();
			for(Iterator<Element> it = root.elementIterator();it.hasNext();){
				Element el = it.next();
				String url = el.attributeValue(new QName("url"));
				//todo url mast not be null!!!
				if(el.getName().equalsIgnoreCase("crpyto")) {

					Crypto crypto = null;
					List<Crypto> list = new ArrayList<Crypto>();
					for(Iterator<Element> propertys = el.elementIterator();propertys.hasNext(); ) {
						Element prop = propertys.next();
						crypto = new Crypto(url,prop.attributeValue(new QName("includes")),
								el.attributeValue(new QName("excludes")),
								prop.attributeValue(new QName("name")));
						list.add(crypto);
					}
					cryptoConfig.addCrypto(url,list);
				} else if(el.getName().equalsIgnoreCase("uncrypto")) {
					UnCrypto unCrypto = new UnCrypto(url);
					cryptoConfig.addUnCrypto(url,unCrypto);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

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

		HttpServletResponse httpResponse = (HttpServletResponse) response;
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

			} else if( CryptoMatchResult.CRYPTO_MATCH_RESULT.equals( matchResult )) {
				//匹配结果为后台配置文件的加密url
				try {
					//@todo 判断是否ajax 需要替换response 这种方式不太好 建议提供API的方式。
					// 但是API的不灵活不能适应已开发好的系统。 新系统建议使用Api的方式。  CryptoCoded.encode(request,"",user);
//					if( isAjaxRequest( httpRequest ) ) {
//						//@todo ajax的后台加密
//						cryptoResponst(request, response);
//					} else {
//						//非ajax的后台加密
//
//					}
					cryptoRequest(request, response, requestUrl);

				} catch (Exception e) {
					logger.error("crypto the data has exception!!",e);
				}
			}
			logger.info("requestURI:" + requestUrl);
		}



		chain.doFilter(request,response);
	}

	/**
	 * 加密response
	 * @param request
	 * @param response
	 */
	private void cryptoResponst(ServletRequest request, ServletResponse response) {
//		String key = (String) ((HttpServletRequest) request).getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
		logger.info("is ajax response!!!");
	}

	/**
	 * 加密request中的attribute
	 * @param request
	 * @param response
	 * @param url
	 * @throws Exception
	 */
	private void cryptoRequest(ServletRequest request, ServletResponse response,String url) throws Exception{
		String key = (String) ((HttpServletRequest) request).getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
		List<Crypto> cryptoList = cryptoConfig.getCryptoMap().get(url);
		if(cryptoList.size()>0) {
			StringBuffer unCryptoNames = new StringBuffer();
			for( Crypto crypto : cryptoList ){
				Object attr = request.getAttribute(crypto.getName());
				if(attr != null) {
					String includes = crypto.getIncludes();
					String excludes = crypto.getExcludes();
					if( includes != null ) {
						String props[] = includes.split(",");
						for(String propName : props) {
							if(propName.contains(".")){
								logger.error("crypto-plugin V1.x just support bean's simple string attribute");
								return;
							}
							unCryptoNames.append(propName).append(",");
							String p = BeanUtils.getProperty(attr, propName);
							BeanUtils.setProperty(attr,propName,CryptoCodec.encode(key,p));
						}
					} else if( excludes != null ) {
						PropertyDescriptor[] properties = org.springframework.beans.BeanUtils.getPropertyDescriptors(attr.getClass());
						Map<String,String> popMap = new HashMap<String, String>();
						for( PropertyDescriptor property : properties ) {
							String pName = property.getName();
							if(property.getPropertyType().getName().contains("String") &&
									!excludes.contains(pName)) {
								unCryptoNames.append(pName).append(",");
								popMap.put(pName, CryptoCodec.encode(key,BeanUtils.getProperty(attr, pName)));
							}
						}
						BeanUtils.populate(attr,popMap);
					} else {
						if(attr instanceof String){
							unCryptoNames.append(crypto.getName()).append(",");
							request.setAttribute(crypto.getName(),CryptoCodec.encode(key, (String) attr));
						}
					}
				}
			}
			request.setAttribute(CryptoConfig.UNCRYPTO_ATTR_NAMES,unCryptoNames.toString());
		}
	}

	public void destroy() {

		this.filterConfig = null;
		this.cryptoConfig = null;
		this.servletContext = null;

	}

	/**
	 * isAjaxRequest:判断请求是否为Ajax请求. <br/>
	 */
	private boolean isAjaxRequest(HttpServletRequest req){
		String header = req.getHeader("X-Requested-With");
		boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
		return isAjax;
	}
}
