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
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;

/**
 * 
 * @ClassName: SevenDayConnController
 * @author yangzongbin
 * @date 2013-3-6 下午09:51:52
 * @description 这个类用来展示7天连接数报表
 */

@Path("oneDayConn")
public class OneDayConnController {

	@Autowired
	private OracleStaService oracleStaService;

	/*
	 * 监视器名称 oracle 属性 连接时间 ms 从 2013-2-26 上午11:00 到 2013-3-1 下午6:22
	 */
	// 连接时间和阈值以及监视器名称 oracle
	// 属性 连接时间 ms
	// 从 2013-2-26 上午11:00
	// 到 2013-3-1 下午6:22
	
	public void viewBaseInfo(@Param("monitorId")String monitorId, Invocation inv) {
	
		//System.out.println(monitorId);
		OracleStaInfoDetailModel oracleStaInfoDetailModel = oracleStaService
				.getBaseInfo(monitorId, 1, "连接时间 ms", new Date(),
						StaTimeEnum.LAST_24HOUR, TimeGranularityEnum.DAY);
		inv.addModel("oracleStaInfoDetailModel", oracleStaInfoDetailModel);
	}
	@Get("view/{monitorId}")
	public String viewPage(@Param("monitorId")String monitorId,Invocation inv) throws Exception{
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println(monitorId);
		viewTable(monitorId,inv);
		//System.out.println("+++++++++++++++++++++++++++");
		return "oneDayConnect";
	}

	// 最下面table所用数据
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Post("viewConnectTable/{monitorId}")
	public void viewTable(@Param("monitorId")String monitorId, Invocation inv)
			throws Exception {
		OracleStaInfoDetailModel oracleStaInfoDetailModel = oracleStaService
				.getBaseInfo(monitorId, 1, "连接时间 ms", new Date(),
						StaTimeEnum.LAST_24HOUR, TimeGranularityEnum.DAY);
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

	//报表展示所需数据
	/*xAxis: {
    categories: ['26-二月,12:00', '27-二月,00:00', '27-二月,12:00', '28-二月,00:00', '28-二月,12:00', '1-三月,00:00', '1-三月,12:00']
                 }*/
	/*series: [{
				{
        name: '平均值(每小时)',
        data: [57, 85, 19, 42, 57, 85, 19]
    },
			]*/
	public String viewGrid(String monitorId,Date now){
		OracleStaInfoDetailModel oracleStaInfoDetailModel = oracleStaService
		.getBaseInfo(monitorId, 1, "连接时间 ms", now,
				StaTimeEnum.LAST_24HOUR, TimeGranularityEnum.DAY);
		List<EventSta> eventStas = oracleStaInfoDetailModel.getRecordItems();
		//xAxis
		JSONObject xAxis = new JSONObject();
		JSONArray categories = new JSONArray();
		//series
		JSONArray series = new JSONArray();
		JSONObject name = new JSONObject();
		name.put("name","平均值(每小时)");
		JSONArray data = new JSONArray();
		for(int i = 0;i<eventStas.size();i++){
			Date date = eventStas.get(i).getEventRecordTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
			String str = sdf.format(date);
			categories.add(str);
			data.add(eventStas.get(i).getAvg());
		}
		xAxis.put("categories", categories);
		name.put("data", data);
		JSONObject surr = new JSONObject();
		surr.put("xAxis", xAxis);
		surr.put("series", series);
		return "@"+ surr.toJSONString();
	}
	
}
