package com.sinosoft.one.monitor.controllers.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.model.App;
import com.sinosoft.one.monitor.service.AppService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

/**
 * 应用服务控制器
 * @author gwt
 */
@Path("appConfigure")
public class AppController {
	@Autowired
	private AppService appService;
	/**
	 * 获取app列表
	 */
	@Get("list")
	public String getAllApp(Invocation inv){
		List<App> appList=appService.getAllApp();
		inv.addModel("app", appList);
		return "appList";
	}
	
	@Post("app")
	public Reply getAppById(@Param("id") String id,Invocation inv){
		App app=appService.getAppById(id);
		return Replys.with(app).as(Json.class);
	}
	
	@Post("appList")
	public Reply getAppList(Invocation inv){
		List<App> appList=appService.getAllApp();
		return Replys.with(appList).as(Json.class);
	}
}
