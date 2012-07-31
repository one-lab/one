package com.sinosoft.platform.platformDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Intercepted;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.annotation.rest.Put;
import com.sinosoft.one.mvc.web.paramresolver.ResolverFactoryImpl.MultipartFileResolver;

import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sinosoft.platform.platformDemo.model.account.User;
import com.sinosoft.platform.platformDemo.service.account.AccountManager;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)
 * 
 * @author kylin
 */
@Path("")
public class UploadController {

	@Autowired
	private AccountManager accountManager;
	/**
	 * 待完善：
	 * @param files
	 * @param fileResolver
	 * @param inv
	 * @return
	 */
	@Post("/upload")
	public String login(@Param("files") MultipartFile[] files, @Param("file1")MultipartFileResolver fileResolver,   Invocation inv) {
//		for (MultipartFileResolver multipartFile : files) {
//			//multipartFileResolver.
//		}
		//inv.getRequest().getSession().setAttribute("loginUserName", null);
		return "@success";
	}
	
	
}
