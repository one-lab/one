package com.sinosoft.one.monitor.controllers.db.oracle;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.db.oracle.domain.OracleBatchInfoService;
import com.sinosoft.one.monitor.db.oracle.domain.OracleInfoService;
import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.model.Highchart;
import com.sinosoft.one.monitor.db.oracle.model.HighchartSerie;
import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.model.Lastevent;
import com.sinosoft.one.monitor.db.oracle.model.OracleAvaInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleHealthInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleStaBaseInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.StaGraphModel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

/**
 * oracle - 批量配置视图Controller
 * @author bao
 *
 */
@Path
public class OracleMonitorController {
	@Autowired
	private OracleBatchInfoService oracleBatchInfoService;
	@Autowired
	private OracleInfoService oracleInfoService;
	
	/* 返回前台ajax请求数据信息*/
	private Map<String, Object> message = new HashMap<String, Object>();
	
	@Get("oracleMonitor")
	public String oracleMonitor() {
		return "oracleMonitor";
	}
	
	/**
	 * oracle - 批量配置视图
	 * 包含：可用性、性能、列表视图
	 * @param inv
	 * @return
	 */
	@Get("avaInfoList/{avaInfoStyle}")
    public String avaInfoList(@Param("avaInfoStyle")int avaInfoStyle, Invocation inv){
		StaTimeEnum avaStyle = null;
		switch (avaInfoStyle) {
		case 1: //24小时内
			avaStyle = StaTimeEnum.LAST_24HOUR;
			break;
		case 30: //30天统计信息
			avaStyle = StaTimeEnum.LAST_30DAY;
			break;
		default: //默认返回24小时
			avaStyle = StaTimeEnum.LAST_24HOUR;
			break;
		}
		/* 查询可用性历史纪录信息*/
        List<OracleAvaInfoModel> oracleAvaInfoList = oracleBatchInfoService.avaInfoList(avaStyle);
        inv.addModel("oracleAvaInfoList",oracleAvaInfoList);
        inv.addModel("avaInfoStyle", avaInfoStyle);
        return "oracleAvaInfo";
    }
	
	/**
	 * 性能信息
	 * @return
	 */
	public Reply performance(){
		List<StaGraphModel> staGraphs = oracleBatchInfoService.listMonitorEventSta();
		/* 缓存库命中率*/
		Highchart memory_utilization = new Highchart("memory_utilization");
		/* 活动的远程连接数*/
		//Highchart CPU_utilization = new Highchart("CPU_utilization");
		/* 连接时间*/
		Highchart exchange_utilization = new Highchart("exchange_utilization");
		/* 活动连接数*/
		Highchart reply_utilization = new Highchart("reply_utilization");
		for(StaGraphModel staGraph : staGraphs) {
			HighchartSerie memorySerie = new HighchartSerie(staGraph.getName());
			HighchartSerie exchangeSerie = new HighchartSerie(staGraph.getName());
			HighchartSerie replySerie = new HighchartSerie(staGraph.getName());
			/* 判断x轴信息是否为空，如果为空填充x轴信息*/
			boolean xflag = exchange_utilization.getCategories().isEmpty();
			for(Lastevent lastevent : staGraph.getLasteventList()) {
				memorySerie.addData(lastevent.getBufferHitRate());
				exchangeSerie.addData(Double.valueOf(lastevent.getConnectTime()));
				replySerie.addData(Double.valueOf(lastevent.getActiveCount()));
				
				/* 格式化X轴显示时间格式*/
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				String category = sdf.format(lastevent.getRecordTime());
				if(xflag) { //若果外层为第一次循环，构建X轴信息
					exchange_utilization.addCategory(category);
					reply_utilization.addCategory(category);
					memory_utilization.addCategory(category);
				}
			}
			memory_utilization.addSerie(memorySerie);
			exchange_utilization.addSerie(exchangeSerie);
			reply_utilization.addSerie(replySerie);
		}
		return Replys.with(Arrays.asList(memory_utilization, exchange_utilization, reply_utilization)).as(Json.class);
	}
	
	/**
	 * 健康状态列表
	 * @return
	 */
	@Get("healthList/{healthType}")
	public Reply healthList(@Param("healthType")int healthType, Invocation inv) {
		String contextPath = inv.getServletContext().getContextPath();
		StaTimeEnum healthStyle = null;
		switch (healthType) {
		case 1: //24小时内
			healthStyle = StaTimeEnum.LAST_24HOUR;
			break;
		case 30: //30天统计信息
			healthStyle = StaTimeEnum.LAST_30DAY;
			break;
		default: //默认返回24小时
			healthStyle = StaTimeEnum.LAST_24HOUR;
			break;
		}
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		List<OracleHealthInfoModel> oracleHealthInfos = oracleBatchInfoService.healthInfoList(healthStyle);
		/* 设置名称信息格式化*/
		String messageFormat0 = "<a href={0}>{1}</a>";
		/* 设置状态信息格式*/
		String messageFormat1 = "<span class={0}>{1}</span>";
		for(OracleHealthInfoModel oracleHealthInfo : oracleHealthInfos) {
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("id", oracleHealthInfo.getMonitorID());
			List<String> cell = new ArrayList<String>();
			/* 构建数据库监控详细信息地址*/
			String url = contextPath + "/db/oracle/home/viewInfo/"+ oracleHealthInfo.getMonitorID();
			cell.add(MessageFormat.format(messageFormat0, url,oracleHealthInfo.getMonitorName()));
			for(int i=0; i<oracleHealthInfo.getGraphInfo().size(); i++) {
				String[] values = oracleHealthInfo.getGraphInfo().get(i);
				String cssClass = "";
				if("1".equals(values[0])) { //正常
					cssClass = "normal";
				} else if("2".equals(values[0])) { //警告
					cssClass = "warn";
				} else if("3".equals(values[0])) { //严重
					cssClass = "critical";
				}  else { //未知
					cssClass = "";
				}
				String value = MessageFormat.format(messageFormat1, cssClass, values[1]);
				cell.add(value);
			}
			row.put("cell", cell);
			rows.add(row);
		}
		Map<String, Object> grid = new HashMap<String, Object>();
		grid.put("rows", rows);
		return Replys.with(grid).as(Json.class);
	}
	
	/**
	 * 数据库列表视图
	 * @return
	 */
	public Reply thresholdList(Invocation inv) {
		return Replys.with(buildThresholdGrid(inv)).as(Json.class);
	}
	
	/**
	 * 添加页面
	 * @return
	 */
	@Get("add")
	public String addUI() {
		return "oracleSave";
	}
	
	/**
	 * 添加操作
	 * @param oracleInfo
	 * @param inv
	 * @return
	 */
	@Post("add")
	public Reply add(Info oracleInfo,Invocation inv) {
		oracleInfo.setSysTime(new Date());
		//oracleInfoService.saveMonitor(oracleInfo);
		return Replys.with(message).as(Json.class);
	}
	
	/**
	 * 编辑页面
	 * @param monitorId
	 * @param inv
	 * @return
	 */
	@Get("editUI/{monitorId}")
	public String editUI(@Param("monitorId")String monitorId,Invocation inv) {
		Info oracleInfo = oracleInfoService.getInfo(monitorId);
		inv.addModel("oracleInfo", oracleInfo);
		return "oracleSave";
	}
	
	/**
	 * 编辑操作
	 * @param oracleInfo
	 * @param inv
	 * @return
	 */
	@Post("edit")
	public Reply edit(Info oracleInfo,Invocation inv) {
		Info info = oracleInfoService.getInfo(oracleInfo.getId());
		info.setName(oracleInfo.getName());
		info.setIpAddress(oracleInfo.getIpAddress());
		info.setSubnetMask(oracleInfo.getSubnetMask());
		info.setPort(oracleInfo.getPort());
		info.setPullInterval(oracleInfo.getPullInterval());
		info.setUsername(oracleInfo.getUsername());
		info.setPassword(oracleInfo.getPassword());
		info.setInstanceName(oracleInfo.getInstanceName());
		oracleInfoService.editMonitor(info);
		message.put("result", true);
		return Replys.with(message).as(Json.class);
	}
	
	/**
	 * 删除操作(包含删除一个和批量删除操作)
	 * @param monitorId
	 * @param inv
	 * @return
	 */
	@Get("remove")
	public Reply remove(@Param("monitorIds")List<String> monitorIds, Invocation inv) {
		//oracleInfoService.deleteMonitor(monitorId);
		message.put("result", true);
		return Replys.with(message).as(Json.class);
	}
	
	/**
	 * 构建数据库列表视图数据
	 * @param inv
	 * @return
	 */
	private Map<String, Object> buildThresholdGrid(Invocation inv) {
		/* 获取项目根路径*/
		String contextPath = inv.getServletContext().getContextPath();
		/* 封装表格行数据信息List->rows*/
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		/* 初始化每列数据格式*/
		String messageFormat0 = "<a href={0}>{1}</a>"; //数据库名
		String messageFormat1 = "<div class={0}></div>"; //可用性-usability
		String messageFormat2 = "<div class={0}></div>"; //健康状况-healthy
		String messageFormat3 = "<a href={0} class='eid'>编辑</a> <a href='javascript:void(0)' class='del' onclick='delRow(this)'>删除</a>";
		/* 查询数据库健康列表数据*/
		List<OracleStaBaseInfoModel> oracleStaBaseInfos = oracleBatchInfoService.listStaBaseInfo();
		/* 循环构建表格行数据*/
		for(OracleStaBaseInfoModel oracleStaBaseInfo : oracleStaBaseInfos) {
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("id", oracleStaBaseInfo.getMonitorID());
			List<String> cell = new ArrayList<String>();
			/* 可用性 1-可用sys_up ；0-不可用 sys_down*/
			String usabilityClass = "1".equals(oracleStaBaseInfo.getUsability()) ? "sys_up" : "sys_down";
			/* 健康状况 1-健康(绿色=fine) ；其它状态均不健康(红色=poor)*/
			String[] healthy = oracleStaBaseInfo.getHealthy();
			String healthyClass = "1".equals(healthy[0]) ? "fine" : "poor";
			/* 构建修改连接+对应数据库MonitorID*/
			String editUrl = contextPath + "/db/oracle/editUI/" + oracleStaBaseInfo.getMonitorID();
			/* 格式化表格数据信息*/
			cell.add(MessageFormat.format(messageFormat0, "", oracleStaBaseInfo.getMonitorName()));
			cell.add(MessageFormat.format(messageFormat1, usabilityClass));
			cell.add(MessageFormat.format(messageFormat2, healthyClass));
			cell.add(MessageFormat.format(messageFormat3, editUrl));
			row.put("cell", cell);
			rows.add(row);
		}
		Map<String, Object> grid = new HashMap<String, Object>();
		grid.put("rows", rows);
		return grid;
	}
}
