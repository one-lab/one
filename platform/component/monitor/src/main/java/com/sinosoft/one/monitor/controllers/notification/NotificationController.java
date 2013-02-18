package com.sinosoft.one.monitor.controllers.notification;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.model.App;
import com.sinosoft.one.monitor.model.Warn;
import com.sinosoft.one.monitor.service.AppService;
import com.sinosoft.one.monitor.service.MailService;
import com.sinosoft.one.monitor.service.WarnService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

@Path("notification")
public class NotificationController {
	@Autowired
	private WarnService warnService;
	@Autowired
	private MailService mailService;
	@Autowired
	private AppService appService;
	@Get("note")
	@Post("note")
	public String notification(Warn warn){
		warn.setSendemail("0");
		warn.setSendsms("0");
		warn.setOccurdate(new Date());
		warnService.save(warn);
		mailService.sendMimeMail(warn);
		return "@success";
	}
	@Get("list")
	public String getAllNotificationByAppId(@Param("appId")String appId,Invocation inv){
		List<Warn> warnList=warnService.getAllByAppId(appId);
		List<App> listApp=appService.getAllApp();
		inv.addModel("app", listApp);
		inv.addModel("warn", warnList);
		return "warnlist";
	}
	@Get("listAll")
	public String getAllNotification(Invocation inv){
		List<Warn> warnList=warnService.getAllWarns();
		List<App> listApp=appService.getAllApp();
		inv.addModel("app", listApp);
		inv.addModel("warn", warnList);
		return "warnlist";
	}
}
