package com.sinosoft.one.monitor.controllers.db.oracle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.db.oracle.domain.OracleAvaService;
import com.sinosoft.one.monitor.db.oracle.domain.OracleInfoService;
import com.sinosoft.one.monitor.db.oracle.domain.OraclePreviewService;
import com.sinosoft.one.monitor.db.oracle.domain.OracleSGAService;
import com.sinosoft.one.monitor.db.oracle.domain.OracleTableSpaceService;
import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.model.AvaSta;
import com.sinosoft.one.monitor.db.oracle.model.EventInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.GridModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleDetailModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleSGAHitRateModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleSGAModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleTableSpaceModel;
import com.sinosoft.one.monitor.db.oracle.model.Point;
import com.sinosoft.one.monitor.db.oracle.model.SGAStateModel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;

/**
 * oracle前端页面展示,包括:数据库基本信息，可用性，连接时间图，用户活动性，表空间，数据库明细, sga图,sga状态
 * sga明细
 * 
 * @author Administrator
 * 
 */
public class OracleController {

	@Autowired
	private OracleInfoService oracleInfoServiceImpl;
	@Autowired
	private OracleAvaService oracleAvaServiceImpl;
	@Autowired
	private OraclePreviewService oraclePreviewServiceImpl;
	@Autowired
	private OracleSGAService oracleSGAServiceImpl;
	@Autowired
	private OracleTableSpaceService oracleTableSpaceServiceImpl;
	
	// 展现oracle基本信息
	public String viewInfo(String monitorId, Invocation inv) {

		OracleInfoModel oracleInfoModel = oracleInfoServiceImpl
				.getMonitorInfo(monitorId);
		inv.addModel("oracleInfoModel", oracleInfoModel);
		return "oracle";
	}

	// 可用性饼状图所用数据
	public String viewAva(String monitorId) {
		AvaSta avaSta = oracleAvaServiceImpl.findAvaSta(monitorId,
				StaTimeEnum.TODAY);
		long normalRuntime = avaSta.getNormalRuntime();
		long powerOffTime = avaSta.getTotalPoweroffTime();
		// 如何保留两位小数
		Double usePercent = normalRuntime
				/ (normalRuntime + powerOffTime / 1.0) * 100;
		int usePercents = usePercent.intValue();
		String json = "";
		JSONArray data = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("name", "不可用");
		jo.put("y", 100 - usePercents);
		jo.put("sliced", false);
		jo.put("select", false);
		JSONArray state = new JSONArray();
		state.add("可用");
		state.add(usePercents);
		data.add(jo);
		data.add(state);
		return "@" + json;
	}

	// 用户连接数和连接时间所用数据
	public String viewConnectAndActive(String monitorId) {
		EventInfoModel[] eventInfoModel = oraclePreviewServiceImpl
				.viewConnectInfo(monitorId);
		EventInfoModel connectEvent = eventInfoModel[0];
		EventInfoModel activeCount = eventInfoModel[1];

		String json = "";
		// x轴代表时间点
		JSONObject xAxis = new JSONObject();
		JSONArray categories = new JSONArray();
		// 连接时间y轴
		JSONArray connectSeries = new JSONArray();
		JSONObject surr = new JSONObject();
		surr.put("name", connectEvent.getEventName());
		JSONArray connectData = new JSONArray();
		// 用户活动数y轴
		JSONArray activeSeries = new JSONArray();
		JSONObject surr2 = new JSONObject();
		surr.put("name", activeCount.getEventName());
		JSONArray activeData = new JSONArray();
		// x轴和连接时间y轴添加值
		List<Point> connectPoints = connectEvent.getPoints();
		for (int i = 0; i < connectPoints.size(); i++) {
			categories.add(connectPoints.get(i).getxAxis());
			connectData.add(connectPoints.get(i).getyAxis());
		}

		xAxis.put("categories", categories);
		surr.put("data", connectData);
		connectSeries.add(surr);
		// 用户活动数y轴添加值
		List<Point> activePoints = connectEvent.getPoints();
		for (int i = 0; i < activePoints.size(); i++) {
			activeData.add(activePoints.get(i).getyAxis());
		}
		surr2.put("data", activeData);
		activeSeries.add(surr2);

		// 组装两个json
		JSONObject result = new JSONObject();
		result.put("x轴", xAxis);
		result.put("connectSeries", connectSeries);
		result.put("activeSeries", activeSeries);
		json = result.toJSONString();
		return "@" + json;
	}

	// sga饼状图所用数据
	public String viewSGA(String monitorId) {

		OracleSGAModel oracleSGAModel = oracleSGAServiceImpl
				.viewSGAInfo(monitorId);
		String bufferCacheSize = oracleSGAModel.getBufferCacheSize();
		String sharePoolSize = oracleSGAModel.getSharePoolSize();
		String redoLogCacheSize = oracleSGAModel.getRedoLogCacheSize();
		String libCacheSize = oracleSGAModel.getLibCacheSize();
		String dictSize = oracleSGAModel.getDictSize();
		String sqlAreaSize = oracleSGAModel.getSqlAreaSize();
		String fixedSGASize = oracleSGAModel.getFixedSGASize();
		String json = "";
		// 拼接data的json对象
		JSONObject data = new JSONObject();
		JSONArray surround = new JSONArray();
		JSONObject bufferCache = new JSONObject();
		bufferCache.put("name", "缓存存储器大小");
		bufferCache.put("y", bufferCacheSize);
		bufferCache.put("sliced", false);
		bufferCache.put("selected", false);
		JSONArray sharePool = new JSONArray();
		sharePool.add("共享池大小");
		sharePool.add(sharePoolSize);
		JSONArray redoLogCache = new JSONArray();
		redoLogCache.add("重做日志缓冲器大小");
		redoLogCache.add(redoLogCacheSize);
		JSONArray libCache = new JSONArray();
		libCache.add("库存存储器大小");
		libCache.add(libCacheSize);
		JSONArray dict = new JSONArray();
		dict.add("数据字典存储器大小");
		dict.add(dictSize);
		JSONArray sqlArea = new JSONArray();
		sqlArea.add("sql区域大小");
		sqlArea.add(sqlAreaSize);
		JSONArray fixedSGA = new JSONArray();
		fixedSGA.add("固定区域大小");
		fixedSGA.add(fixedSGASize);
		data.put("surround", surround);
		data.put("bufferCache", bufferCache);
		data.put("sharePool", sharePool);
		data.put("libCache", libCache);
		data.put("dict", dict);
		data.put("sqlArea", sqlArea);
		data.put("fixedSGASize", fixedSGASize);
		json = data.toJSONString();
		return "@" + json;

	}

	// 表空间所用数据
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void viewTableSpace(String monitorId,Invocation inv) throws Exception {

		List<OracleTableSpaceModel> oracleTableSpaceModelList = oracleTableSpaceServiceImpl.listTableSpaceInfo(monitorId);
		for(int i=0;i<oracleTableSpaceModelList.size();i++){
			oracleTableSpaceModelList.get(i).setId(i+"");
			String str = "<div class='bg_bar'><div class='red_bar' style='width:10%'></div></div>";
			String [] strs= str.split("10%");
			//System.out.println(strs[0]);
			//System.out.println(strs[1]);
			StringBuilder sb = new StringBuilder();
			sb.append(strs[0]).append(oracleTableSpaceModelList.get(i).getUsedRate()).append(strs[1]);
			oracleTableSpaceModelList.get(i).setStatusBar(sb.toString());
			//System.out.println(sb);
		}
		Page page = new PageImpl(oracleTableSpaceModelList);
		Gridable<OracleTableSpaceModel> gridable = new Gridable<OracleTableSpaceModel>(page);
		String cellString = new String(
		"tableSpaceName,statusBar,totalSize,totalBlock,used,usedRate,unused,unusedRate");
		gridable.setIdField("id");
		gridable.setCellStringField(cellString);
		try {
			UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
		} catch (Exception e) {
			throw new Exception("json数据转换出错!", e);
		}
	}

	// 数据库详细所用数据
	public void viewOracleDetail(String monitorId,Invocation inv) {
		OracleDetailModel oracleDetailModel = oraclePreviewServiceImpl.viewDbDetail(monitorId);
		inv.addModel("oracleDetailModel", oracleDetailModel);
	}
	
	//SGA曲线图所用数据（缓冲区命中率，库命中率，数据字典命中率）
	public String viewSGAGraph(String monitorId){
		EventInfoModel eventInfoModel = oracleSGAServiceImpl.viewHitRateStaInfo(monitorId);
		List<OracleSGAHitRateModel> sgaHitRateModels = eventInfoModel.getSgaHitRateModels();
		//x轴代表时间点
		JSONObject xAxis = new JSONObject();
		JSONArray categories = new JSONArray();
		//y轴
		JSONArray series = new JSONArray();
		JSONObject bufferHitRate = new JSONObject();
		bufferHitRate.put("name", "缓冲区击中率");
		JSONArray bufferHitRateDate  = new JSONArray();
		JSONObject dictHitRate = new JSONObject();
		dictHitRate.put("name","数据字典击中率" );
		JSONArray dictHitRateDate  = new JSONArray();
		JSONObject libHitRate = new JSONObject();
		libHitRate.put("name", "缓存击中率");
		JSONArray libHitRateDate  = new JSONArray();
		for(int i=0;i<sgaHitRateModels.size();i++){
			categories.add(sgaHitRateModels.get(i).getRecordTime());
			bufferHitRateDate.add(sgaHitRateModels.get(i).getBufferHitRate());
			dictHitRateDate.add(sgaHitRateModels.get(i).getDictHitRate());
			libHitRateDate.add(sgaHitRateModels.get(i).getLibHitRate());
		}
		bufferHitRate.put("data",bufferHitRateDate );
		dictHitRate.put("data", dictHitRateDate);
		libHitRate.put("data",libHitRateDate );
		series.add(bufferHitRate);
		series.add(dictHitRate);
		series.add(libHitRate);
		xAxis.put("categories", categories);
		JSONObject result = new JSONObject();
		result.put("x轴", xAxis);
		result.put("y轴", series);
		String json = "";
		json = result.toJSONString();
		return "@"+json;
	}
	//sga详细信息数据
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void viewSGADetail(String monitorId,Invocation inv) throws Exception{
		OracleSGAModel oracleSGAModel = oracleSGAServiceImpl.viewSGAInfo(monitorId);
		String threshold = "<a onclick='viewRelevanceSGADetail(this)'><div class='threshold_icon'></div></a>";
		GridModel bufferCacheSize = new GridModel();
		bufferCacheSize.setId("1");
		bufferCacheSize.setAttribute("缓冲区大小");
		bufferCacheSize.setValue(oracleSGAModel.getBufferCacheSize());
		bufferCacheSize.setThreshold(threshold);
		GridModel sharePoolSize = new GridModel();
		sharePoolSize.setId("2");
		sharePoolSize.setAttribute("共享池大小");
		sharePoolSize.setValue(oracleSGAModel.getSharePoolSize());
		sharePoolSize.setThreshold(threshold);
		GridModel  redoLogCacheSize = new GridModel();
		redoLogCacheSize.setId("3");
		redoLogCacheSize.setValue("RedoLog缓冲区");
		redoLogCacheSize.setThreshold(threshold);
		GridModel libCacheSize = new GridModel();
		libCacheSize.setId("4");
		libCacheSize.setAttribute("库缓存的大小");
		libCacheSize.setValue(oracleSGAModel.getLibCacheSize());
		libCacheSize.setThreshold(threshold);
		GridModel dictSize = new GridModel();
		dictSize.setId("5");
		dictSize.setAttribute("数据字典缓存大小");
		dictSize.setValue(oracleSGAModel.getDictSize());
		dictSize.setThreshold(threshold);
		GridModel sqlAreaSize = new GridModel();
		sqlAreaSize.setId("6");
		sqlAreaSize.setAttribute("SQL区大小");
		sqlAreaSize.setValue(oracleSGAModel.getSqlAreaSize());
		sqlAreaSize.setThreshold(threshold);
		GridModel fixedSGASize = new GridModel();
		fixedSGASize.setId("7");
		fixedSGASize.setAttribute("固有区大小");
		fixedSGASize.setAttribute(oracleSGAModel.getFixedSGASize());
		GridModel javaPoolSize = new GridModel();
		javaPoolSize.setId("8");
		javaPoolSize.setAttribute("Java池大小");
		javaPoolSize.setValue(oracleSGAModel.getJavaPoolSize());
		javaPoolSize.setThreshold(threshold);
		GridModel largePoolSize= new GridModel();
		largePoolSize.setId("9");
		largePoolSize.setAttribute("Large池大小");
		largePoolSize.setValue(oracleSGAModel.getLargePoolSize());
		largePoolSize.setThreshold(threshold);
		
		List<GridModel> gridModels = new ArrayList<GridModel>();
		gridModels.add(largePoolSize);
		gridModels.add(javaPoolSize);
		gridModels.add(fixedSGASize);
		gridModels.add(sqlAreaSize);
		gridModels.add(dictSize);
		gridModels.add(libCacheSize);
		gridModels.add(redoLogCacheSize);
		gridModels.add(sharePoolSize);
		gridModels.add(bufferCacheSize);
		Page page = new PageImpl(gridModels);
		Gridable<GridModel> gridable = new Gridable<GridModel>(page);
		String cellString = new String(
		"attribute,value,threshold");
		gridable.setIdField("id");
		gridable.setCellStringField(cellString);
		try {
			UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
		} catch (Exception e) {
			throw new Exception("json数据转换出错!", e);
		}
		
	}
	
	//sga状态数据
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void viewSGSStatus(String monitorId,Invocation inv) throws Exception{
		SGAStateModel sgaStateModel = oracleSGAServiceImpl.viewSGAStateInfo(monitorId);
		String threshold = "<a onclick='viewRelevanceSGAStatus(this)'><div class='threshold_icon'></div></a>";
		GridModel bufferHitRate = new GridModel();
		bufferHitRate.setId("1");
		bufferHitRate.setAttribute("缓冲区命中率");
		bufferHitRate.setValue(sgaStateModel.getBufferHitRate());
		bufferHitRate.setThreshold(threshold);
		GridModel dictHitRate = new GridModel();
		dictHitRate.setId("2");
		dictHitRate.setAttribute("数据字典命中率");
		dictHitRate.setValue(sgaStateModel.getDictHitRate());
		dictHitRate.setThreshold(threshold);
		GridModel libHitRate = new GridModel();
		libHitRate.setId("3");
		libHitRate.setAttribute("缓存库命中率");
		libHitRate.setValue(sgaStateModel.getLibHitRate());
		libHitRate.setThreshold(threshold);
		GridModel unusedCache = new GridModel();
		unusedCache.setThreshold(threshold);
		unusedCache.setId("4");
		unusedCache.setAttribute("可用内存");
		unusedCache.setValue(sgaStateModel.getUnusedCache());
		
		List<GridModel> gridModels = new ArrayList<GridModel>();
		gridModels.add(bufferHitRate);
		gridModels.add(dictHitRate);
		gridModels.add(libHitRate);
		gridModels.add(unusedCache);
		Page page = new PageImpl(gridModels);
		Gridable<GridModel> gridable = new Gridable<GridModel>(page);
		String cellString = new String(
		"attribute,value,threshold");
		gridable.setIdField("id");
		gridable.setCellStringField(cellString);
		try {
			UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
		} catch (Exception e) {
			throw new Exception("json数据转换出错!", e);
		}
	}
	
}
