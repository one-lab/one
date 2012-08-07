package com.sinosoft.one.rms.client.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginFilter extends AuthenticatingFilter {

	public static final String DEFAULT_ERROR_KEY_ATTRIBUTE_NAME = "登陆失败";
	
	private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);
	public static final String DEFAULT_USERNAME_PARAM = "userCode";
	public static final String DEFAULT_PASSWORD_PARAM = "passWord";
	public static final String DEFAULT_COMCODE_PARAM = "comCode";

	private String failureKeyAttribute = DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;
	private String userCodeParam = DEFAULT_USERNAME_PARAM;
	private String passWordParam = DEFAULT_PASSWORD_PARAM;
	private String comCodeParam = DEFAULT_COMCODE_PARAM;

	public LoginFilter() {
		 setLoginUrl(DEFAULT_LOGIN_URL);//父类定义的默认登陆链接'loging.jsp'
	}
	
	public void setLoginUrl(String loginUrl) {
		String previous = getLoginUrl();
		if (previous != null) {
			this.appliedPaths.remove(previous);
		}
		super.setLoginUrl(loginUrl);
		this.appliedPaths.put(getLoginUrl(), null);
	}

	
	//必须重写的方法
	public AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) throws Exception {
		String userCode = getUserCode(request);
		System.out.println(userCode);
		String passWord = getPassWord(request);
		System.out.println(passWord);
		String comCode = getComCode(request);
		return new LoginToken(userCode, passWord, comCode);//返回自定义的TOKEN实例
	}

	//必须重写的方法 对所拦截链接的处理
	public boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {//是否登录的连接
			if (isLoginSubmission(request, response)) {//是否登陆请求处理
				return executeLogin(request, response);//拦截的是登陆链接则返回executeLogin
			} else {
				return true;
			}
		} else {
			saveRequestAndRedirectToLogin(request, response);
			return false;
		}
	}
	
	public boolean isLoginSubmission(ServletRequest request,
			ServletResponse response) {
		return (request instanceof HttpServletRequest)&& WebUtils.toHttp(request).getMethod().equalsIgnoreCase(POST_METHOD);
	}
	
	//登陆失败的处理
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		setFailureAttribute(request, e);
		// login failed, let request continue back to the login page:
		return true;
	}
	
	 protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
	        String className = ae.getClass().getName();
	        request.setAttribute(getFailureKeyAttribute(), className);
	}

	//登陆成功的处理
	public boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		issueSuccessRedirect(request, response);
		// we handled the success redirect directly, prevent the chain from
		// continuing:
		return true;
	}
	
	public String getUserCode(ServletRequest request) {
		return WebUtils.getCleanParam(request, getUserCodeParam());
	}

	public String getPassWord(ServletRequest request) {
		return WebUtils.getCleanParam(request, getPassWordParam());
	}

	public String getComCode(ServletRequest request) {
		return WebUtils.getCleanParam(request, getComCodeParam());
	}

	public String getUserCodeParam() {
		return userCodeParam;
	}

	public void setUserCodeParam(String userCodeParam) {
		this.userCodeParam = userCodeParam;
	}

	public String getPassWordParam() {
		return passWordParam;
	}

	public void setPassWordParam(String passWordParam) {
		this.passWordParam = passWordParam;
	}

	public String getComCodeParam() {
		return comCodeParam;
	}

	public void setComCodeParam(String comCodeParam) {
		this.comCodeParam = comCodeParam;
	}

	public String getFailureKeyAttribute() {
		return failureKeyAttribute;
	}

	public void setFailureKeyAttribute(String failureKeyAttribute) {
		this.failureKeyAttribute = failureKeyAttribute;
	}
	
}
