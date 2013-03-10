package com.sinosoft.one.monitor.controllers;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.alarm.domain.AlarmService;
import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.application.domain.ApplicationEnhance;
import com.sinosoft.one.monitor.application.domain.ApplicationEnhanceFactory;
import com.sinosoft.one.monitor.application.domain.ApplicationService;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.utils.MessageUtils;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.util.date.DateUtils;
import com.sinosoft.one.util.date.DateUtils.Formatter;

/**
 * 首页
 * @author bao
 *
 */
@Path
public class IndexController {
	
	@Autowired
	private AlarmService alarmService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private ApplicationEnhanceFactory applicationEnhanceFactory;
	
	@Get("index")
	public String index() {
		return "index";
	}
	
	public Reply alarmList(Invocation inv) {
		/* 获取项目根路径*/
		String contextPath = inv.getServletContext().getContextPath();
		/* 封装表格行数据信息List->rows*/
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		/* 初始化每列数据格式*/
		String messageFormat0 = "<div class={0}></div>"; //数据库名
		String messageFormat1 = "<a href={0} title={1}>{2}</a>"; //可用性-usability
		/* 查询数据库健康列表数据*/
		List<Alarm> alarmList = alarmService.queryLatestAlarmsRowsFifty();
		/* 循环构建表格行数据*/
		for(Alarm alarm : alarmList) {
			Map<String, Object> row = new HashMap<String, Object>();
			List<String> cell = new ArrayList<String>();
			
			/* 健康状况 1-健康(绿色=fine) ；其它状态均不健康(红色=poor)*/
			String healthyClass = MessageUtils.SeverityLevel2CssClass(alarm.getSeverity());
			/* 构建预警详细信息地址*/
			String url = contextPath + "/alarm/manager/alarmmanager/detail/"+alarm.getId();
			/* 格式化表格数据信息*/
			/* 可用性 1-可用sys_up ；0-不可用 sys_down*/
			cell.add(MessageFormat.format(messageFormat0, healthyClass));
			String message = alarm.getMessage();
			String subMessage = message.length()>10 ? message.substring(0, 9)+"...." : message;
			cell.add(MessageFormat.format(messageFormat1, url, message, subMessage));
			cell.add(alarm.getAppName());
			cell.add(alarm.getMonitorType());
			cell.add(DateUtils.toFormatString(alarm.getCreateTime(), Formatter.YEAR_TO_MINUTE));
			row.put("cell", cell);
			rows.add(row);
		}
		Map<String, Object> grid = new HashMap<String, Object>();
		grid.put("rows", rows);
		return Replys.with(grid).as(Json.class);
	}
	
	public Reply applicationList(Invocation inv) {
		
		/* 获取项目根路径*/
		String contextPath = inv.getServletContext().getContextPath();
		/* 封装表格行数据信息List->rows*/
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		/* 初始化每列数据格式*/
		String messageFormat0 = "<a href={0}>{1}</a>"; //应用名
		String messageFormat1 = "<div class={0}></div>"; //健康状况-healthy
		String messageFormat2 = "<div class={0}></div>"; //可用性-usability
		/* 查询数据库健康列表数据*/
		List<Application> applications = applicationService.findValidateApplication();
		/* 循环构建表格行数据*/
		for(Application application : applications) {
			ApplicationEnhance applicationEnhance = null;
			applicationEnhance = applicationEnhanceFactory.enhanceApplication(application);
			Map<String, Object> row = new HashMap<String, Object>();
			List<String> cell = new ArrayList<String>();
			/* 健康状况 1-健康(绿色=fine) ；其它状态均不健康(红色=poor)*/
			String healthyClass = MessageUtils.SeverityLevel2CssClass(applicationEnhance.getHealth());
			
			/* 可用性 1-可用sys_up ；0-不可用 sys_down*/
			String usabilityClass = MessageUtils.trend2CssClass(applicationEnhance.getTrend());
			/* 构建数据库监控详细信息地址*/
			String url = contextPath + "/application/manager/detail/main/"+application.getId();
			/* 格式化表格数据信息*/
			cell.add(MessageFormat.format(messageFormat0, url, application.getApplicationName()));
			cell.add(MessageFormat.format(messageFormat1, usabilityClass));
			cell.add(MessageFormat.format(messageFormat2, healthyClass));
			row.put("cell", cell);
			rows.add(row);
		}
		Map<String, Object> grid = new HashMap<String, Object>();
		grid.put("rows", rows);
		return Replys.with(grid).as(Json.class);
	}
}
