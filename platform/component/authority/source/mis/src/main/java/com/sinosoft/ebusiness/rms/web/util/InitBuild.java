package com.sinosoft.ebusiness.rms.web.util;

import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitBuild  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//启动服务器自动加载 
	public void init() throws ServletException {
		try {
			URL url =this.getClass().getClassLoader().getResource("/config/authority.xml");
			System.out.println(url.getFile()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			// 调用方法，读入xml文件，转化为hashmap 放入context
			this.getServletContext().setAttribute("authorityMap",InitXmlAuthorInfo.getAuthorityMap(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

