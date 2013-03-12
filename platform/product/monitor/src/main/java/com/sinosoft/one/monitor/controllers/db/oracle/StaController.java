package com.sinosoft.one.monitor.controllers.db.oracle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.db.oracle.domain.OracleStaService;
import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.domain.TimeGranularityEnum;
import com.sinosoft.one.monitor.db.oracle.model.EventSta;
import com.sinosoft.one.monitor.db.oracle.model.OracleStaInfoDetailModel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;

/**
 * 
 * @ClassName: StaController
 * @author yangzongbin
 * @date 2013-3-6 下午09:51:52
 * @description 这个类用来展示7天连接数报表
 */

@Path("sta")
public class StaController {

	@Autowired
	private OracleStaService oracleStaService;

	/*
	 * 监视器名称 oracle 属性 连接时间 ms 从 2013-2-26 上午11:00 到 2013-3-1 下午6:22
	 */
	// 连接时间和阈值以及监视器名称 oracle
	// 属性 连接时间 ms
	// 从 2013-2-26 上午11:00
	// 到 2013-3-1 下午6:22

	// public void viewBaseInfo(@Param("monitorId")String monitorId, Invocation
	// inv) {
	//
	// //System.out.println(monitorId);
	//
	// }
	@Get("view/{monitorId}/{eventType}/{eventName}/{st}")
	public String viewPage(@Param("monitorId") String monitorId,@Param("eventType")int eventType,@Param("eventName")int eventName,@Param("st")int st, Invocation inv)
			throws Exception {
		String en = "";
		StaTimeEnum sta = StaTimeEnum.LAST_1YEAR;
		switch (st) {
		case 1:
				sta = StaTimeEnum.LAST_7DAY;
			break;
		case 2:
				sta = StaTimeEnum.LAST_30DAY;
			break;
		}
		switch (eventName) {
		case 1:
				en = "连接时间 ms";
			break;
		case 2:
				en = "用户数";
			break;
		case 3:
			en = "缓冲区命中率";
		break;
		}
		// System.out.println("+++++++++++++++++++++++++++++++++++++++");
		// System.out.println("+++++++++++++++++++++++++++++++++++++++");
		// System.out.println(monitorId);
		OracleStaInfoDetailModel oracleStaInfoDetailModel = oracleStaService
		.getBaseInfo(monitorId, eventType, en, new Date(),
				sta, TimeGranularityEnum.DAY);
		inv.addModel("osdm", oracleStaInfoDetailModel);
        inv.addModel("monitorId", monitorId);
		// viewTable(monitorId,inv);
		// System.out.println("+++++++++++++++++++++++++++");
		if(eventType == 1 && st == 1 ){
			return "sevenDayConnect";
		}else if(eventType == 1 && st == 2){
			return "thirtyDayConnect";
		}else if(eventType == 2 && st == 1){
			return "sevenDayUser";
		}else if(eventType == 2 && st == 2){
			return "thirtyDayUser";
		}else if(eventType == 3 && st == 1){
			return "sevenDayHitRate";
		}else if(eventType == 3 && st == 2){
			return "thirtyDayHitRate";
		}else{
			return "@error";
		}
	}

	// 最下面table所用数据
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Get("viewTable/{monitorId}/{eventType}/{eventName}/{st}")
	public void viewTable(@Param("monitorId") String monitorId,@Param("eventType")int eventType,@Param("eventName")int eventName,@Param("st")int st, Invocation inv)
			throws Exception {
		
		String en = "";
		StaTimeEnum sta = StaTimeEnum.LAST_1YEAR;
		switch (st) {
		case 1:
				sta = StaTimeEnum.LAST_7DAY;
			break;
		case 2:
				sta = StaTimeEnum.LAST_30DAY;
			break;
		}
		switch (eventName) {
		case 1:
				en = "连接时间 ms";
			break;
		case 2:
				en = "用户数";
			break;
		case 3:
			en = "缓冲区命中率";
		break;
		}
		
		OracleStaInfoDetailModel oracleStaInfoDetailModel = oracleStaService
		.getBaseInfo(monitorId, eventType, en, new Date(),
				sta, TimeGranularityEnum.DAY);
		List<EventSta> eventStas = oracleStaInfoDetailModel.getRecordItems();

		Page page = new PageImpl(eventStas);
		Gridable<EventSta> gridable = new Gridable<EventSta>(page);
		String cellString = new String("date,time,min,max,avg");
		gridable.setIdField("id");
		gridable.setCellStringField(cellString);
		try {
			UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
		} catch (Exception e) {
			throw new Exception("json数据转换出错!", e);
		}

	}

	// 报表展示所需数据
	/*
	 * xAxis: { categories: ['26-二月,12:00', '27-二月,00:00', '27-二月,12:00',
	 * '28-二月,00:00', '28-二月,12:00', '1-三月,00:00', '1-三月,12:00'] }
	 */
	/*
	 * series: [{ { name: '平均值(每小时)', data: [57, 85, 19, 42, 57, 85, 19] }, ]
	 */
	@Get("viewGrid/{monitorId}/{eventType}/{eventName}/{st}")
	public String viewGrid(@Param("monitorId") String monitorId,@Param("eventType")int eventType,@Param("eventName")int eventName,@Param("st")int st) {
		String en = "";
		StaTimeEnum sta = StaTimeEnum.LAST_1YEAR;
		switch (st) {
		case 1:
				sta = StaTimeEnum.LAST_7DAY;
			break;
		case 2:
				sta = StaTimeEnum.LAST_30DAY;
			break;
		}
		switch (eventName) {
		case 1:
				en = "连接时间 ms";
			break;
		case 2:
				en = "用户数";
			break;
		case 3:
			en = "缓冲区命中率";
		break;
		}
		
		OracleStaInfoDetailModel oracleStaInfoDetailModel = oracleStaService
				.getBaseInfo(monitorId, eventType, en, new Date(),
						sta, TimeGranularityEnum.DAY);
		List<EventSta> eventStas = oracleStaInfoDetailModel.getRecordItems();
		// xAxis
		JSONObject xAxis = new JSONObject();
		JSONArray categories = new JSONArray();
		// series
		JSONArray series = new JSONArray();
		JSONObject name = new JSONObject();
		name.put("name", "平均值(每小时)");
		JSONArray data = new JSONArray();
		for (int i = 0; i < eventStas.size(); i++) {
			Date date = eventStas.get(i).getEventRecordTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			String str = sdf.format(date);
			categories.add(str);
			data.add(eventStas.get(i).getAvg());
		}
		xAxis.put("categories", categories);
		name.put("data", data);
		series.add(name);
		JSONObject surr = new JSONObject();
		surr.put("xAxis", xAxis);
		surr.put("series", series);
		System.out.println(surr.toJSONString());
		return "@" + surr.toJSONString();
	}

}
