package com.sinosoft.one.monitor.controllers.db.oracle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.common.AttributeName;
import com.sinosoft.one.monitor.db.oracle.domain.OracleAvaService;
import com.sinosoft.one.monitor.db.oracle.domain.OracleInfoService;
import com.sinosoft.one.monitor.db.oracle.domain.OraclePreviewService;
import com.sinosoft.one.monitor.db.oracle.domain.OracleSGAService;
import com.sinosoft.one.monitor.db.oracle.domain.OracleTableSpaceService;
import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.model.AvaSta;
import com.sinosoft.one.monitor.db.oracle.model.EventInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.GridModel;
import com.sinosoft.one.monitor.db.oracle.model.Highchart;
import com.sinosoft.one.monitor.db.oracle.model.HighchartSerie;
import com.sinosoft.one.monitor.db.oracle.model.OracleDetailModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleSGAHitRateModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleSGAModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleTableSpaceModel;
import com.sinosoft.one.monitor.db.oracle.model.Point;
import com.sinosoft.one.monitor.db.oracle.model.SGAStateModel;
import com.sinosoft.one.monitor.db.oracle.utils.DBUtil4Monitor;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
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
@Path("home")
public class OracleController {

	@Autowired
	private OracleInfoService oracleInfoService;
	@Autowired
	private OracleAvaService oracleAvaService;
	@Autowired
	private OraclePreviewService oraclePreviewService;
	@Autowired
	private OracleSGAService oracleSGAService;
	@Autowired
	private OracleTableSpaceService oracleTableSpaceService;
	
	// 展现oracle基本信息
	@Get("viewInfo/{monitorId}")
	public String viewInfo(@Param("monitorId")String monitorId, Invocation inv) {

		OracleInfoModel oracleInfoModel = oracleInfoService
				.getMonitorInfo(monitorId);
        SGAStateModel sgaStateModel =  oracleSGAService.viewSGAStateInfo(monitorId);

        OracleDetailModel oracleDetailModel = oraclePreviewService.viewDbDetail(monitorId);
        
        inv.addModel("oracleDetailModel", oracleDetailModel);
		inv.addModel("oracleInfoModel", oracleInfoModel);
        inv.addModel("sgaStateModel", sgaStateModel);
        inv.addModel("monitorId", monitorId);
		return "oracle";
	}

	// 可用性饼状图所用数据
	@Get("viewAva/{monitorId}")
	public String viewAva(@Param("monitorId")String monitorId) {
		AvaSta avaSta = oracleAvaService.findAvaSta(monitorId,
				StaTimeEnum.TODAY);
		long normalRuntime = avaSta.getNormalRuntime();
		long powerOffTime = avaSta.getTotalPoweroffTime();
		// 如何保留两位小数
		Double usePercent = normalRuntime
				/ (normalRuntime + powerOffTime / 1.0) * 100;
		int usePercents = usePercent.intValue();
		int unUsedPercents = 100 - usePercents;
		JSONArray  y = new JSONArray();
		y.add(unUsedPercents);
		//System.out.println(y.toJSONString());
		return "@"+y.toJSONString();
	}
	
    @Get("viewConnect/{monitorId}")
	// 用户连接数和连接时间所用数据
	public String viewConnectAndActive(@Param("monitorId")String monitorId) {
		EventInfoModel[] eventInfoModel = oraclePreviewService
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
		surr2.put("name", activeCount.getEventName());
		JSONArray activeData = new JSONArray();
		// x轴和连接时间y轴添加值
		List<Point> connectPoints = connectEvent.getPoints();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		for (int i = 0; i < connectPoints.size(); i++) {
			categories.add(sdf.format(connectPoints.get(i).getxAxis()));
			connectData.add(connectPoints.get(i).getyAxis());
		}
		/*
		 * labels: { 
									  	:3
										} 
		 */
		JSONObject jos = new JSONObject();
		jos.put("step", 4);
		xAxis.put("labels", jos);
		xAxis.put("categories", categories);
		surr.put("data", connectData);
		connectSeries.add(surr);
		// 用户活动数y轴添加值
		List<Point> activePoints = activeCount.getPoints();
		for (int i = 0; i < activePoints.size(); i++) {
			activeData.add(activePoints.get(i).getyAxis());
		}
		surr2.put("data", activeData);
		activeSeries.add(surr2);

		// 组装两个json
		JSONObject result = new JSONObject();
		result.put("xaxis", xAxis);
		result.put("connectSeries", connectSeries);
		result.put("activeSeries", activeSeries);
		json = result.toJSONString();
        return "@" + json;
	}
    
	// sga饼状图所用数据
    @Get("viewSGA/{monitorId}")
	public String viewSGA(@Param("monitorId")String monitorId) {
    	
		OracleSGAModel oracleSGAModel = oracleSGAService.viewSGAInfo(monitorId);
		BigDecimal bufferCacheSize = new BigDecimal(oracleSGAModel.getBufferCacheSize());;
		BigDecimal sharePoolSize =  new BigDecimal(oracleSGAModel.getSharePoolSize());
		BigDecimal redoLogCacheSize =  new BigDecimal(oracleSGAModel.getRedoLogCacheSize());
		BigDecimal libCacheSize =  new BigDecimal(oracleSGAModel.getLibCacheSize());
		BigDecimal dictSize =  new BigDecimal(oracleSGAModel.getDictSize());
		BigDecimal sqlAreaSize =  new BigDecimal(oracleSGAModel.getSqlAreaSize());
		BigDecimal fixedSGASize = new BigDecimal( oracleSGAModel.getFixedSGASize());
		JSONArray data = new JSONArray();
		data.add(bufferCacheSize);
		data.add(sharePoolSize);
		data.add(redoLogCacheSize);
		data.add(libCacheSize);
		data.add(dictSize);
		data.add(sqlAreaSize);
		data.add(fixedSGASize);
		return "@" +data.toJSONString();
	}

	// 表空间所用数据
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Get("viewTableSpace/{monitorId}")
	public void viewTableSpace(@Param("monitorId")String monitorId,Invocation inv) throws Exception {

		List<OracleTableSpaceModel> oracleTableSpaceModelList = oracleTableSpaceService.listTableSpaceInfo(monitorId);
		for(int i=0;i<oracleTableSpaceModelList.size();i++){
			oracleTableSpaceModelList.get(i).setId(i+"");
			String str = "<div class='bg_bar'><div class='red_bar' style='width:10%'></div></div>";
			String [] strs= str.split("10%");
			StringBuilder sb = new StringBuilder();
			sb.append(strs[0]).append(oracleTableSpaceModelList.get(i).getUsedRate()).append("%").append(strs[1]);
			oracleTableSpaceModelList.get(i).setStatusBar(sb.toString());
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
    // 表空间所用数据
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Get("viewTableSpaceOverPreview/{monitorId}")
    public void viewTableSpaceOverPreview(@Param("monitorId")String monitorId,Invocation inv) throws Exception {

        List<OracleTableSpaceModel> oracleTableSpaceModelList = oracleTableSpaceService.listTableSpaceInfo(monitorId);
        for(int i=0;i<oracleTableSpaceModelList.size();i++){
            oracleTableSpaceModelList.get(i).setId(i+"");
            String str = "<div class='bg_bar'><div class='red_bar' style='width:10%'></div></div>";
            String [] strs= str.split("10%");
            StringBuilder sb = new StringBuilder();
            sb.append(strs[0]).append(oracleTableSpaceModelList.get(i).getUsedRate()).append("%").append(strs[1]);
            oracleTableSpaceModelList.get(i).setStatusBar(sb.toString());
        }
        Page page = new PageImpl(oracleTableSpaceModelList);
        Gridable<OracleTableSpaceModel> gridable = new Gridable<OracleTableSpaceModel>(page);
        String cellString = new String(
                "tableSpaceName,unused,unusedRate");
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
		OracleDetailModel oracleDetailModel = oraclePreviewService.viewDbDetail(monitorId);
		inv.addModel("oracleDetailModel", oracleDetailModel);
	}
	
	//sga详细信息数据
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Get("viewSGADetail/{monitorId}")
	public void viewSGADetail(@Param("monitorId")String monitorId,Invocation inv) throws Exception{
		OracleSGAModel oracleSGAModel = oracleSGAService.viewSGAInfo(monitorId);
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
		redoLogCacheSize.setValue(oracleSGAModel.getRedoLogCacheSize());
		redoLogCacheSize.setAttribute("RedoLog缓冲区");
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
		fixedSGASize.setValue(oracleSGAModel.getFixedSGASize());
		fixedSGASize.setThreshold(threshold);
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
	@Get("viewSGAStatus/{monitorId}")
	public void viewSGAStatus(@Param("monitorId")String monitorId,Invocation inv) throws Exception{
		
		SGAStateModel sgaStateModel = oracleSGAService.viewSGAStateInfo(monitorId);
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
	//SGA曲线图所用数据（缓冲区命中率，库命中率，数据字典命中率）
	@Get("viewSGAGraph/{monitorId}")
	public Reply viewSGAGraph(@Param("monitorId")String monitorId) {
		Highchart highchart = new Highchart("sga_target");
		EventInfoModel eventInfoModel = oracleSGAService.viewHitRateStaInfo(monitorId);
		List<OracleSGAHitRateModel> sgaHitRateModels = eventInfoModel.getSgaHitRateModels();
		HighchartSerie highchartSerie1 = new HighchartSerie("缓冲区命中率");
		HighchartSerie highchartSerie2 = new HighchartSerie("数据字典命中率");
		HighchartSerie highchartSerie3 = new HighchartSerie("缓存库命中率");
		for(OracleSGAHitRateModel oracleSGAHitRate : sgaHitRateModels) {
			highchartSerie1.addData(Double.valueOf(oracleSGAHitRate.getBufferHitRate()));
			highchartSerie2.addData(Double.valueOf(oracleSGAHitRate.getDictHitRate()));
			highchartSerie3.addData(Double.valueOf(oracleSGAHitRate.getLibHitRate()));
			highchart.addCategory(oracleSGAHitRate.getRecordTime());
		}
		highchart.addSerie(highchartSerie1);
		highchart.addSerie(highchartSerie2);
		highchart.addSerie(highchartSerie3);
		return Replys.with(highchart).as(Json.class);
	}
	
	private BigDecimal bigdecimalUtils(String target,int length,RoundingMode rm){
		BigDecimal bd = new BigDecimal(target);
		bd.setScale(length, rm.CEILING);
		return bd;
	}
	
}
