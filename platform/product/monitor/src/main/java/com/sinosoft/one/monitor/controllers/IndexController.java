package com.sinosoft.one.monitor.controllers;


import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

/**
 * 首页
 * @author bao
 *
 */
@Path
public class IndexController {
	
	@Get("index")
	public String index() {
		return "index";
	}
}
