package com.sinosoft.one.monitor.controllers.os;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.model.OracleHealthInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.OracleStaBaseInfoModel;
import com.sinosoft.one.monitor.os.linux.domain.OsAvailableViewHandle;
import com.sinosoft.one.monitor.os.linux.domain.OsService;
import com.sinosoft.one.monitor.os.linux.domain.OsViewHandle;
import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.viewmodel.OsHealthModel;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

@Path
@SuppressWarnings({"deprecation", "unchecked"})
public class OsManagerController {
	@Autowired
	private OsService osService;

	@Autowired
	private OsAvailableViewHandle osViewDataHandleService;
	
	/*@Autowired
	private OsProcessService osProcessService;*/
	
	@Autowired
	private OsViewHandle osLineViewHandle; 
	
	/* 返回前台ajax请求数据信息*/
	private Map<String, Object> message = new HashMap<String, Object>();
	
	
	/**
	 * 新增一个操作系统监控器.
	 */
	@Post("isIpExists")
	public Reply isIpExists(Invocation inv) {
		String ip = inv.getParameter("ipAddr");
		System.out.println(osService.checkOsByIp(ip));
		if (osService.checkOsByIp(ip)) {
			return Replys.with(true).as(Json.class);
		} else
			return Replys.with(false).as(Json.class);
	}

	/**
	 * 增加页面
	 * @param os
	 * @return
	 */
	@Post("addApp")
	public String saveOs(@Validation(errorPath = "saveOs") @Param("os") Os os) {
		try {
			osService.saveOsBasic(os.getName(), os.getType(), os.getIpAddr(),
					os.getSubnetMask(), 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@Post("systemMonitorTable/{timespan}")
	public String systemMonitorTable(@Param("timespan") String timespan,
			Invocation inv) {
		if ("24".equals(timespan)) {

			// 0 hong 1 zheng 2wushuju
			Date date=new Date();
			Map<String, Object> Modelmap =  osViewDataHandleService.getAvailableViewData(date);
			List<String> timeList= new ArrayList<String>();
			Date time=(Date) Modelmap.get("beginTime");
			System.out.println(time);
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
			Calendar c  = Calendar.getInstance();
			for (int i = 0; i < 12; i++) {
				if(i==0){
					c.set(Calendar.HOUR_OF_DAY,time.getHours());
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
					timeList.add(simpleDateFormat.format(c.getTime()));
				}else{
					c.set(Calendar.HOUR_OF_DAY,time.getHours()+2);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
					 
					System.out.println(simpleDateFormat.format(c.getTime()));
					timeList.add(simpleDateFormat.format(c.getTime()));
					time=c.getTime();
				}
			}
			System.out.println(Modelmap.get("beginTime"));
			List<Map<String, Object>> maplist= (List<Map<String, Object>>) Modelmap.get("mapList");
			inv.addModel("maplist",maplist);
			inv.addModel("timeList",timeList);
			
			return "systemMonitorTable";
			//30天的逻辑
		}else if("30".equals(timespan)){
			return "systemMonitorTable";
		}
		return null;
		
		
	}
	/**
	 * 可用性页面
	 * @param inv
	 * @return
	 */
	@Get("toSystemMonitor")
	public String toSystemMonitor(Invocation inv) {
		return "systemMonitor";
	}
	
	/**
	 * 可用性条块
	 * @param timespan
	 * @return
	 */
	@Get("healthList/{timespan}")
	public Reply healthList(@Param("timespan") int timespan, Invocation inv) {
		List<Os> oss=osService.getAllOs();
		String contextPath = inv.getServletContext().getContextPath();
		StaTimeEnum healthStyle = null;
		switch (timespan) {
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
		Date date=new Date();
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		List<OsHealthModel> osHealthModels = osService.healthInfoList(oss, healthStyle.getTime(healthStyle, date), date, healthStyle);
		/* 设置名称信息格式化*/
		String messageFormat0 = "<a href={0}>{1}</a>";
		/* 设置状态信息格式*/
		String messageFormat1 = "<span class={0}>{1}</span>";
		for(OsHealthModel osHealthModel : osHealthModels) {
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("id", osHealthModel.getMonitorID());
			List<String> cell = new ArrayList<String>();
			/* 构建数据库监控详细信息地址*/
			String url = contextPath + "/db/oracle/home/viewInfo/"+ osHealthModel.getMonitorID();
			cell.add(MessageFormat.format(messageFormat0, url,osHealthModel.getMonitorName()));
			for(int i=0; i<osHealthModel.getGraphInfo().size(); i++) {
				String[] values = osHealthModel.getGraphInfo().get(i);
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
	 * 单个操作系统主页面
	 * @param osId
	 * @param inv
	 * @return
	 */
	@Get("linuxcentos/{osId}")
	public String linuxcentos(@Param("osId") String osId ,Invocation inv){
		inv.addModel("id", osId);
		return "linuxcentos";
	}
	
	/**
	 * 性能页面
	 */
	@Post("performanceList")
	public Reply performanceList() {
		Map<String, Map<String,List<Map<String, Object>>>> viewMap=osLineViewHandle.createlineView(new Date(), 5, 1);
		System.out.println(Replys.with(viewMap).as(Json.class).toString());
		return Replys.with(viewMap).as(Json.class);
	}
	
	/**
	 * 数据库列表视图
	 * @return
	 */
	public Reply systemList(Invocation inv) {
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
		
		List<OracleStaBaseInfoModel> oracleStaBaseInfos = new ArrayList<OracleStaBaseInfoModel>();
		/**
		 * 测试用的假数据，service写好后修改上面返回list集合即可
		 */
		OracleStaBaseInfoModel staBaseInfo = new OracleStaBaseInfoModel();
		staBaseInfo.setMonitorID("test_linux");
		staBaseInfo.setMonitorName("test_linux");
		staBaseInfo.setUsability("1");
		staBaseInfo.setHealthy(new String[]{"1", ""});
		oracleStaBaseInfos.add(staBaseInfo);
		
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
			String editUrl = contextPath + "/os/editUI/" + oracleStaBaseInfo.getMonitorID();
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
		return Replys.with(grid).as(Json.class);
	}
	
	/**
	 * 编辑页面
	 * @param monitorId
	 * @param inv
	 * @return
	 */
	@Get("editUI/{monitorId}")
	public String editUI(@Param("monitorId")String monitorId,Invocation inv) {
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
	 * 健康状态列表
	 * @return
	 */
//	public Reply healthList(Invocation inv) {
//		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
//		List<OracleHealthInfoModel> oracleHealthInfoModels = OracleBatchInfoService.healthInfoList(StaTimeEnum.LAST_24HOUR);
//		String messageFormat0 = "<a href='{0}'>{1}</a>";
//		String messageFormat1 = "<span class={0}>{1}</span>";
//		for(OracleHealthInfoModel oracleHealthInfoModel : oracleHealthInfoModels) {
//			Map<String, Object> row = new HashMap<String, Object>();
//			row.put("id", oracleHealthInfoModel.getMonitorID());
//			List<String> cell = new ArrayList<String>();
//			cell.add(MessageFormat.format(messageFormat0, "",oracleHealthInfoModel.getMonitorName()));
//			for(int i=0; i<oracleHealthInfoModel.getGraphInfo().size(); i++) {
//				String[] values = oracleHealthInfoModel.getGraphInfo().get(i);
//				String cssClass = "";
//				if("1".equals(values[0])) {
//					cssClass = "normal";
//				} else if("2".equals(values[0])) {
//					cssClass = "warn";
//				} else {
//					cssClass = "";
//				}
//				String value = MessageFormat.format(messageFormat1, cssClass, values[1]);
//				cell.add(value);
//			}
//			row.put("cell", cell);
//			rows.add(row);
//		}
//		Map<String, Object> grid = new HashMap<String, Object>();
//		grid.put("rows", rows);
//		return Replys.with(grid).as(Json.class);
//	}
}
