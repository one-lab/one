package com.sinosoft.one.monitor.controllers.notification;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.controllers.LoginRequired;
import com.sinosoft.one.monitor.model.App;
import com.sinosoft.one.monitor.model.Method;
import com.sinosoft.one.monitor.service.AppService;
import com.sinosoft.one.monitor.service.MethodService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

@LoginRequired
@Path("methodConfigure")
public class MethodController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MethodService methodService;
	@Autowired
	private AppService appService;

	@Post("method")
	public String getAllMethod(@Param("appName") String appName) {
		List<Method> list = null;
		App app = appService.getAppByName(appName);
		if (null != app){
			list = methodService.getAllMethod(app.getId());
		}
		if (null == list || 0 == list.size()) {
			return "@[]";
		}
		String jsonString = JSON.toJSONString(list);
		logger.debug("-----" + jsonString + "-----");
		return "@" + jsonString;
	}

	@Get("list")
	public String getMethodList(String appName, Invocation inv) {
		List<Method> methods = methodService.getAllMethod(appName);
		inv.addModel("methods", methods);
		return "url/urllist";
	}

	@Get("delete/{id}")
	public String deleteMethod(@Param("id") String id) {
		methodService.deleteMethod(id);
		return "r:/notification/urlConfigure/list";
	}

	@Post("save")
	public String save(Method method) {
		method.setStatus("1");
		methodService.save(method);
		return "r:/notification/urlConfigure/list";
	}

}