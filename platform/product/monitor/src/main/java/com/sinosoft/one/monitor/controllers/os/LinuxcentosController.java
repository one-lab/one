package com.sinosoft.one.monitor.controllers.os;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.sinosoft.one.monitor.os.linux.domain.OsAvailableServcie;
import com.sinosoft.one.monitor.os.linux.domain.OsAvailableViewHandle;
import com.sinosoft.one.monitor.os.linux.domain.OsCpuViewHandle;
import com.sinosoft.one.monitor.os.linux.domain.OsDiskViewHandle;
import com.sinosoft.one.monitor.os.linux.domain.OsProcessService;
import com.sinosoft.one.monitor.os.linux.domain.OsRamViewHandle;
import com.sinosoft.one.monitor.os.linux.domain.OsRespondTimeService;
import com.sinosoft.one.monitor.os.linux.domain.OsService;
import com.sinosoft.one.monitor.os.linux.domain.OsViewHandle;
import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsDisk;
import com.sinosoft.one.monitor.os.linux.model.viewmodel.OsGridModel;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;

@Path
public class LinuxcentosController {
	@Autowired
	private OsService osService;
	
	@Autowired
	private OsProcessService osProcessService;
	
	@Autowired
	private OsRespondTimeService osRespondTimeService;
	
	@Autowired
	private OsAvailableServcie osAvailableServcie;
	
	@Autowired
	private OsViewHandle osViewHandle;
	
	@Autowired
	private OsRamViewHandle osRamViewHandle;
	
	@Autowired
	private OsAvailableViewHandle osAvailableViewHandle;
	
	@Autowired
	private OsCpuViewHandle osCpuViewHandle;
	
	@Autowired
	private OsDiskViewHandle osDiskViewHandle;
	@Post("osInfo/{osId}")
	public Reply osInfo(@Param("osId") String osId ) {
		System.out.println(osId);
		Map<String, String> map = new HashMap<String, String>();
		Date currentTime=new Date();
		//获取操作系统基本信息】【
		Os os=osService.getOsBasicById(osId);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE);
		map.put("monitorName", os.getName());
		map.put("health", "1");
		map.put("type", os.getType());
		map.put("osName", os.getIpAddr());
		map.put("os", os.getType());
		//获取最后一次 响应时间
		String responTime= osRespondTimeService.findLastResponTime(osId, currentTime);
		//获取最后一次轮询时间
		Date lastSampleTime=osProcessService.getLastSampleTime(osId, currentTime);
		Calendar c  = Calendar.getInstance();
		c.setTime(lastSampleTime);
		c.set(Calendar.MINUTE, lastSampleTime.getMinutes()+os.getIntercycleTime());
		Date nextSampleTime=c.getTime();
		System.out.println(osId);
		map.put("lastTime", simpleDateFormat.format(lastSampleTime));
		map.put("nextTime", simpleDateFormat.format(nextSampleTime)); 
		map.put("respondTime",responTime+"毫秒");
		return Replys.with(map).as(Json.class);
	}

	/**
	 * 今天的可用性图饼
	 * @param osId
	 * @return
	 */
	@Post("getUsability/{osId}")
	public Reply getUsability(@Param("osId") String osId ) {
		Map<String, Double> map = new HashMap<String, Double>();
		Date currentTime=new Date();
		map = osAvailableViewHandle.creatAvailablePie(osId, currentTime, 1);
		return Replys.with(map).as(Json.class);
	}

	/**
	 * 今天的利用率 罗盘
	 * @param osId
	 * @return
	 */
	@Post("getUtilzation/{osId}")
	public Reply getUtilzation(@Param("osId") String osId ) {
		Date currentTime=new Date();
		Map<String, Double> map = new HashMap<String, Double>();
		map=osViewHandle.creatUtilZationView(osId, currentTime);
		return Replys.with(map).as(Json.class);
	}

	/**
	 * 概览页面CPU 与内存曲线
	 * @param osId
	 * @return
	 */ 
	@Post("getCpuAndRam/{osId}")
	public Reply getCpuAndRam(@Param("osId") String osId ) {
		Date currentTime=new Date();
		Map<String,List<List<?>>> oneOsCpuAndMem= osViewHandle.createOneOsCpuAndMemline(osId, currentTime, 5, 2);
		return Replys.with(oneOsCpuAndMem).as(Json.class);
	}
	/**
	 * 概览页面CPU分解信息曲线  cpu利用率曲线（内存CPU表格下面的曲线）
	 * @param osId
	 * @return
	 */
	@Post("getCpuInfo/{osId}")
	public Reply getCpuInfo(@Param("osId") String osId ) {
		Date currentTime=new Date();
		Map<String,List<List<?>>> lineMap =osViewHandle.createOneCpuResolveView(osId, currentTime, 5, 2);
		return Replys.with(lineMap).as(Json.class);
	}


	/**
	 *  CPU与内存利用率曲线下面的表格
	 * 概览页面内存利用率表格
	 * @param osId
	 * @param inv
	 */
	@Post("gridMemory/{osId}")
	public void gridMemory(@Param("osId") String osId ,Invocation inv) {
		Date currentTime=new Date();
		List<OsGridModel> osRamViewModels=osRamViewHandle.creatCurrentMemView(osId, currentTime);
		Page page = new PageImpl(osRamViewModels);
		Gridable<OsGridModel> gridable = new Gridable<OsGridModel>(page);
		gridable.setIdField("id");
		gridable.setCellStringField("name,utilzation,used,link");
		try {
			UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 概览页面CPU利用率  CPU与内存利用率曲线下面（ 内存表格左边）的表格
	 * @param osId
	 * @param inv
	 */
	@Post("gridCpu/{osId}")
	public void gridCpu(@Param("osId") String osId ,Invocation inv){
		Date currentTime=new Date();
		List<OsGridModel> osGridModels=osCpuViewHandle.creatCurrentCpuView(osId, currentTime);
		Page page = new PageImpl(osGridModels);
		Gridable<OsGridModel> gridable = new Gridable<OsGridModel>(page);
		gridable.setIdField("id");
		gridable.setCellStringField("name,utilzation,link");
		try {
			UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 概览页面CPU分解grid 当前时间 io 中断等grid 最下面的分解CPU信息表格
	 * @param osId
	 * @return
	 */
	@Post("gridCpuResolve/{osId}")
	public void gridCpuResolve(@Param("osId") String osId ,Invocation inv ){
		Date currentTime=new Date();
		List<OsGridModel> osGridModels=osCpuViewHandle.creatCpuResolveView(osId, currentTime);
		Page page = new PageImpl(osGridModels);
		Gridable<OsGridModel> gridable = new Gridable<OsGridModel>(page);
		gridable.setIdField("id");
		gridable.setCellStringField("name,value");
		try {
			UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 概览页面磁盘
	 * @param osId
	 * @param inv
	 */
	@Post("gridDiskGrid/{osId}")
	public void gridDisk(@Param("osId") String osId ,Invocation inv ){
		Date currentTime=new Date();
		List<OsDisk> osGridModels=osDiskViewHandle.creatCpuResolveView(osId, currentTime);
		Page page = new PageImpl(osGridModels);
		Gridable<OsDisk> gridable = new Gridable<OsDisk>(page);
		gridable.setIdField("id");
		gridable.setCellStringField("diskPath,total,usedUtiliZation,used,freeUtiliZation,free");
		try {
			UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
