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
	private ServletContext servletContext;
	private CryptoConfig cryptoConfig = new CryptoConfig();

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

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String requestUrl = ((HttpServletRequest) request).getRequestURI();

//		System.out.println(request.getParameterMap());

		CryptoMatchResult matchResult = cryptoConfig.quickMatch(requestUrl);
		if( matchResult != null ) {
			String key = (String) ((HttpServletRequest) request).getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
			if( CryptoMatchResult.UNCRYPTO_MATCH_RESULT.equals( matchResult ) ) {
				String uncryptos = request.getParameter(CryptoConfig.CRUPTO_ATTR_NAMES);
				//解密用的requestwapper
				request = new CryptoRequestWapper((HttpServletRequest)request,
						new HashMap<String,String[]>(request.getParameterMap()), key,uncryptos);

			}else if( CryptoMatchResult.CRYPTO_MATCH_RESULT.equals( matchResult )) {
				try {
					cryptoRequest(request, response, requestUrl);
				} catch (Exception e) {
					logger.error("crypto the data has exception!!",e);
				}
			}
			logger.info("requestURI:" + requestUrl);
		}

		//@todo 判断是否ajax 需要替换response 这种方式不太好 建议提供API的方式。但是API的不灵活不能适应已开发好的系统。 新系统建议使用Api的方式。  CryptoCoded.encode(request,"",user);

		chain.doFilter(request,response);
	}

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
}
