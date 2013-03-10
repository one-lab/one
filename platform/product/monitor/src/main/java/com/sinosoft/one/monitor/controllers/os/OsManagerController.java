package com.sinosoft.one.monitor.controllers.os;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.os.linux.domain.OsAvailableViewHandle;
import com.sinosoft.one.monitor.os.linux.domain.OsProcessService;
import com.sinosoft.one.monitor.os.linux.domain.OsService;
import com.sinosoft.one.monitor.os.linux.domain.OsViewHandle;
import com.sinosoft.one.monitor.os.linux.model.Os;
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
public class OsManagerController {
	@Autowired
	private OsService osService;

	@Autowired
	private OsAvailableViewHandle osViewDataHandleService;
	
	@Autowired
	private OsProcessService osProcessService;
	
	@Autowired
	private OsViewHandle osLineViewHandle; 
	
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 可用性页面
	 * @param inv
	 * @return
	 */
	@Get("toSystemMonitor")
	public String toSystemMonitor(Invocation inv) {
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
		
		return "systemMonitor";
	}
	
	/**
	 * 可用性条块
	 * @param timespan
	 * @return
	 */
	@Get("healthList/{timespan}")
	public Reply healthList(@Param("timespan") String timespan) {
		if (timespan.equals("24hours")) {
			
		// 1 zhengc 2jingg 3yanz 4weiz
		Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
		Map<String, Object> rowsMap = new HashMap<String, Object>();
		rowsMap.put("id", "1");
		List<String> list = new ArrayList<String>();
		String[] strs = new String[24];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = "1";
			if (i == 4) {
				strs[i] = "1";
			}
			if (i == 10) {
				strs[i] = "2";
			}
			if (i == 15) {
				strs[i] = "3";
			}
			if (i == 20) {
				strs[i] = "4";
			}
			
		}
		list.add("<a href='Linuxcentos.html'>Linux2</a>");
		for (String str : strs) {
			if (str.equals("1")) {
				list.add("<span class='normal'></span>");
			}
			if (str.equals("2")) {
				list.add("<span class='warn'></span>");
			}
			if (str.equals("3")) {
				list.add("<span class='critical'></span>");
			}
			if (str.equals("4")) {
				list.add("<span class='normal'></span>");
			}
		}
		rowsMap.put("cell", list);
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		maps.add(rowsMap);
		map.put("rows", maps);
		return Replys.with(map).as(Json.class);
	}
		return null;
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
	
//	@Post("performanceList")
//	public Reply performanceList() {
		
//		return Replys.with(viewMap).as(Json.class);
//	}
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
