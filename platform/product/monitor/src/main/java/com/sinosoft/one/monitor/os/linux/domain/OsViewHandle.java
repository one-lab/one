package com.sinosoft.one.monitor.os.linux.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsCpu;
import com.sinosoft.one.monitor.os.linux.model.OsDisk;
import com.sinosoft.one.monitor.os.linux.model.OsRam;
import com.sinosoft.one.monitor.os.linux.util.OsTransUtil;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;

@Component
public class OsViewHandle {
	@Autowired
	private OsCpuViewHandle osCpuViewDataHandle;
	@Autowired
	private OsRamViewHandle osRamViewHandle;
	@Autowired
	private OsRespondViewHadle osRespondViewHadle;
	@Autowired
	private OsRamService osRamService;
	@Autowired
	private OsCpuService osCpuService;
	@Autowired
	private OsDiskService osDiskService;
	@Autowired
	private OsService osService;
	
	/**
	 * 构建多个操作系统的线
	 *  @param currentTime页面当前时间
	 * @param interCycle 页面轮询时间
	 * @param timespan 需要的时间段 如 1为1小时内
	 * @return
	 */
	public Map<String, Map<String,List<Map<String, Object>>>>  createlineView(Date currentTime ,int interCycle ,int timespan){
		List<Os>oss=osService.getAllOs();
		Map<String, Map<String,List<Map<String, Object>>>> viewMap=new HashMap<String, Map<String,List<Map<String, Object>>>>();
		Map<String,List<Map<String, Object>>> cpuLineViewMaps=osCpuViewDataHandle.creatCpuLineData(oss, currentTime, interCycle, timespan);
		Map<String,List<Map<String, Object>>> ramLineViewMaps=osRamViewHandle.creatRamLineData(oss, currentTime, interCycle, timespan);
		Map<String,List<Map<String, Object>>> swapLineViewMaps=osRamViewHandle.creatSwapLineData(oss, currentTime, interCycle, timespan);
		Map<String,List<Map<String, Object>>> respondLineViewMaps=osRespondViewHadle.creatRespondLineData(oss, currentTime, interCycle, timespan);
		viewMap.put("chartMem", ramLineViewMaps);
		viewMap.put("chartCpu", cpuLineViewMaps);
		viewMap.put("chartSwap", swapLineViewMaps);
		viewMap.put("chartReply", respondLineViewMaps);
		return viewMap;
	}
	
	/**
	 * 构建1个操作系统的线
	 * @param os
	 * @param currentTime页面当前时间
	 * @param interCycle 页面轮询时间
	 * @param timespan 需要的时间段 如 1为1小时内
	 * @return
	 */
	public Map<String,List<Map<String, Object>>>  createOneOsCpuAndMemline(String osid,Date currentTime ,int interCycle ,int timespan){
		Os os =osService.getOsBasicById(osid);
		Map<String,List<Map<String, Object>>> viewMap=new  HashMap<String,List<Map<String, Object>>>();
		List<Map<String, Object>> oneCpuLineViewMaps=osCpuViewDataHandle.creatOneCpuUsedLineData(os, currentTime, interCycle, timespan);
		List<Map<String, Object>> oneRamLineViewMaps=osRamViewHandle.creatOneRamLineData(os, currentTime, interCycle, timespan);
		List<Map<String, Object>> oneSwapLineViewMaps=osRamViewHandle.creatOneSwapLineData(os, currentTime, interCycle, timespan);
		viewMap.put("CPU", oneCpuLineViewMaps);
		viewMap.put("MEM", oneRamLineViewMaps);
		viewMap.put("SWAP", oneSwapLineViewMaps);
		return viewMap;
	}
	
	/**
	 * 构建1个操作系统Cpu分解的线
	 * @param os
	 * @param currentTime页面当前时间
	 * @param interCycle 页面轮询时间
	 * @param timespan 需要的时间段 如 1为1小时内
	 * @return
	 */
	public Map<String,List<Map<String, Object>>>  createOneCpuResolveView(String osid,Date currentTime ,int interCycle ,int timespan){
		Os os =osService.getOsBasicById(osid);
		Map<String,List<Map<String, Object>>> viewMap=new  HashMap<String,List<Map<String, Object>>>();
		List<Map<String, Object>> oneCpuUserTimeLineViewMaps=osCpuViewDataHandle.creatOneCpuUserTimeLine(os, currentTime, interCycle, timespan);
		List<Map<String, Object>> oneCpuSysTimeLineViewMaps=osCpuViewDataHandle.creatOneCpuSysTimeLine(os, currentTime, interCycle, timespan);
		List<Map<String, Object>> oneCpuIOLineViewMaps=osCpuViewDataHandle.creatOneCpuIOLine(os, currentTime, interCycle, timespan);
		List<Map<String, Object>> OneCpuIDLELineViewMaps=osCpuViewDataHandle.creatOneCpuIDLELine(os, currentTime, interCycle, timespan);
		viewMap.put("userTime", oneCpuUserTimeLineViewMaps);
		viewMap.put("sysTime", oneCpuSysTimeLineViewMaps);
		viewMap.put("io", oneCpuIOLineViewMaps);
		viewMap.put("idle", OneCpuIDLELineViewMaps);
		return viewMap;
	}
	
	/**
	 * 获取最新的cpu、内存 、磁盘利用率
	 * @param osid
	 * @param currentTime
	 * @return
	 */
	public Map<String, Double> creatUtilZationView(String osid, Date currentTime){
		Map<String, Double> map=new HashMap<String, Double>();
		Os os =osService.getOsBasicById(osid);
		OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), currentTime, os.getIntercycleTime());
		List<OsDisk> osDisks=osDiskService.findNealyDisk(os.getOsInfoId(), currentTime, os.getIntercycleTime());
		OsRam osRam=osRamService.findNealyRam(os.getOsInfoId(), currentTime, os.getIntercycleTime());
		if(osCpu==null){
			map.put("cpuUtilzation", 0.00);
		}else{
			map.put("cpuUtilzation", Double.valueOf(osCpu.getUtiliZation()));
		}
		if(osDisks.size()<0){
			map.put("diskUtilzation", 0.00);
		}else{
			long diskTotal=0;
			long diskUsed=0;
			for (OsDisk osDisk : osDisks) {
				diskTotal+=Long.parseLong(osDisk.getTotal());
				diskUsed+=Long.parseLong(osDisk.getUsed());
			}
			String result= OsTransUtil.countUtilZation(diskTotal+"", diskUsed+"");
			map.put("diskUtilzation", Double.parseDouble(result));
		}
		if(osRam==null){
			map.put("ramUtilzation", 0.00);
		}else{
			long memTotal=Long.parseLong(osRam.getMemTotal())+Long.parseLong(osRam.getSwapTotal());
			long memUsed=Long.parseLong(osRam.getMemUsed())+Long.parseLong(osRam.getSwapUsed());
			String result= OsTransUtil.countUtilZation(memTotal+"", memUsed+"");
			map.put("ramUtilzation", Double.parseDouble(result));
		}
		return map;
	}
}
