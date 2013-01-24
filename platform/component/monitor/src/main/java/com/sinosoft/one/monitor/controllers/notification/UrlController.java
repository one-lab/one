package com.sinosoft.one.monitor.controllers.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.model.App;
import com.sinosoft.one.monitor.model.Method;
import com.sinosoft.one.monitor.model.Response;
import com.sinosoft.one.monitor.model.Url;
import com.sinosoft.one.monitor.service.AppService;
import com.sinosoft.one.monitor.service.MethodService;
import com.sinosoft.one.monitor.service.ResponseService;
import com.sinosoft.one.monitor.service.UrlService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

@Path("urlConfigure")
public class UrlController {
	@Autowired
	private UrlService urlService;
	@Autowired
	private MethodService methodService;
	@Autowired
	ResponseService responseService;
	@Autowired
	AppService appService;
	
	@Get("url")
	@Post("url")
	public String getAllUrl(@Param("appName") String appName) {
		App app=appService.getAppByName(appName);
		List<Url> list=urlService.getAllUrl(app.getId());
		String responseMessage=JSON.toJSONString(list);
		return "@"+responseMessage;
	}
	
	@Get("list")
	public String getUrlList(@Param("appId")String appId,Invocation inv){
		List<Url> list=urlService.getAllUrl(appId);
		List<Method> listMethod =methodService.getAllMethod(appId);
		List<Response> listRes=responseService.findAllUrls(appId);
		List<App> listApp=appService.getAllApp();
		App app=appService.getAppById(appId);
		inv.addModel("response", listRes);
		inv.addModel("url", list);
		inv.addModel("method", listMethod);
		inv.addModel("app", listApp);
		inv.addModel("appOne", app);
		return "urllist";
	}
	
	@Get("listAll")
	public String getUrls(Invocation inv){
		List<Url> list=urlService.getAllUrl();
		List<Method> listMethod =methodService.getAllMethod();
		List<Response> listRes=responseService.findAllUrls();
		List<App> listApp=appService.getAllApp();
		inv.addModel("response", listRes);
		inv.addModel("url", list);
		inv.addModel("method", listMethod);
		inv.addModel("app", listApp);
		return "urllist";
	}
	@Post("delete/{id}")
	public Reply deleteUrl(@Param("id") String id){
		urlService.delete(id);
		return Replys.simple().success("success");
	}
	
	@Post("edit")
	public Reply getUrlById(@Param("id")String id){
		return Replys.with(urlService.getUrlById(id)).as(Json.class);
	}
	@Post("save")
	public String saveUrl(Url url){
		url.setStatus("1");
		urlService.saveUrl(url);
		return "r:/notification/urlConfigure/list?appName="+url.getAppId();
	}
}
