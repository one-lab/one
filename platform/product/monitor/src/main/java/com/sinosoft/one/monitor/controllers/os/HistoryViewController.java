package com.sinosoft.one.monitor.controllers.os;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

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

@Path
public class HistoryViewController {
	
	@Autowired
	private OsService osService;
	
	@Autowired
	private OsViewHandle osViewHandle;
	
//	@Get("historyCPUSevenDay/{osId}")
//	public String historyCPUSevenDay(@Param("osId") String osId,Invocation inv){
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_YEAR_MON_DAY);
//		Os os=osService.getOsBasicById(osId);
//		Date currentDate=new Date();
//		Date beginDate=new Date(currentDate.getTime()-7*24*60*60*1000);
//		inv.addModel("os", os);
//		inv.addModel("beginDate", simpleDateFormat.format(beginDate));
//		inv.addModel("currentDate", simpleDateFormat.format(currentDate));
//		return "historyCPUSevenDay";
//	}
	//CPU天数报表的统计
	@Get("historyCPU/{timespan}/{osId}")
	public String historyCPUSevenDay(@Param("osId") String osId,@Param("timespan") String timespan,Invocation inv){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_YEAR_MON_DAY);
		Os os=osService.getOsBasicById(osId);
		Date currentDate=new Date();
		Date beginDate=new Date(currentDate.getTime()-6*24*60*60*1000);
		inv.addModel("os", os);
		inv.addModel("beginDate", simpleDateFormat.format(beginDate));
		inv.addModel("currentDate", simpleDateFormat.format(currentDate));
		if (timespan.toString().equals("7")) {
			return "historyCPUSevenDay";
		}
		return "historyCPUThirtyDay";
	}
	//DISK天数报表的统计
	@Get("historyDISK/{timespan}/{osId}")
	public String historyDiskSevenDay(@Param("osId") String osId,@Param("timespan") String timespan,Invocation inv){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_YEAR_MON_DAY);
		Os os=osService.getOsBasicById(osId);
		Date currentDate=new Date();
		Date beginDate=new Date(currentDate.getTime()-6*24*60*60*1000);
		inv.addModel("os", os);
		inv.addModel("beginDate", simpleDateFormat.format(beginDate));
		inv.addModel("currentDate", simpleDateFormat.format(currentDate));
		if (timespan.toString().equals("7")) {
			return "historyDiskSevenDay";
		}
		return "historyDiskThirtyDay";
	}
	
	//MEM天数报表的统计
	@Get("historyMem/{timespan}/{osId}")
	public String historyRamSevenDay(@Param("osId") String osId,@Param("timespan") String timespan,Invocation inv){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_YEAR_MON_DAY);
		Os os=osService.getOsBasicById(osId);
		Date currentDate=new Date();
		Date beginDate=new Date(currentDate.getTime()-6*24*60*60*1000);
		inv.addModel("os", os);
		inv.addModel("beginDate", simpleDateFormat.format(beginDate));
		inv.addModel("currentDate", simpleDateFormat.format(currentDate));
		if (timespan.toString().equals("7")) {
			return "historyMemorySevenDay";
		}
		return "historyMemoryThirtyDay";
	}
	
	
	@Post("historyCPUStatiLine/{timespan}/{osId}")
	public Reply historyCPUSevenDayLine(@Param("osId") String osId,@Param("timespan") String timespan){
		Date currentDate=new Date();
		Map<String,List<Map<String, Object>>> map=osViewHandle.creatStatiLine(osId, OsUtil.CPU_STATIF_FLAG_D, currentDate, Integer.valueOf(timespan));
		Map<String,List<Map<String, Object>>> viewMap=new  HashMap<String,List<Map<String, Object>>>();
		viewMap.put("CPU利用率最大值%", map.get("max"));
		viewMap.put("CPU利用率最小值%", map.get("min"));
		viewMap.put("CPU利用率最平均值%", map.get("ave"));
		return Replys.with(viewMap).as(Json.class);
	}
	
	
	@Post("historyDiskStatiLine/{timespan}/{osId}")
	public Reply historyDiksSevenDayLine(@Param("osId") String osId,@Param("timespan") String timespan){
		Date currentDate=new Date();
		Map<String,List<Map<String, Object>>> map=osViewHandle.creatStatiLine(osId, OsUtil.DISK_STATIF_FLAG, currentDate, Integer.valueOf(timespan));
		Map<String,List<Map<String, Object>>> viewMap=new  HashMap<String,List<Map<String, Object>>>();
		viewMap.put("磁盘利用率最大值%", map.get("max"));
		viewMap.put("磁盘利用率最小值%", map.get("min"));
		viewMap.put("磁盘利用率最平均值%", map.get("ave"));
		return Replys.with(viewMap).as(Json.class);
	}
	
	@Post("historyMemStatiLine/{timespan}/{osId}")
	public Reply historyMemSevenDayLine(@Param("osId") String osId,@Param("timespan") String timespan){
		Date currentDate=new Date();
		Map<String,List<Map<String, Object>>> map=osViewHandle.creatStatiLine(osId, OsUtil.RAM_STATIF_FLAG, currentDate, Integer.valueOf(timespan));
		Map<String,List<Map<String, Object>>> viewMap=new  HashMap<String,List<Map<String, Object>>>();
		viewMap.put("内存利用率最大值%", map.get("max"));
		viewMap.put("内存利用率最小值%", map.get("min"));
		viewMap.put("内存利用率最平均值%", map.get("ave"));
		return Replys.with(viewMap).as(Json.class);
	}
}
