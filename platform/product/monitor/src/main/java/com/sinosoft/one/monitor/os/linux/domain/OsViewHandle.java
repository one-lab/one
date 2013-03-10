package com.sinosoft.one.monitor.os.linux.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.sinosoft.one.monitor.os.linux.model.viewmodel.OsGridModel;
import com.sinosoft.one.monitor.os.linux.model.viewmodel.StatiDataModel;
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
	private OsStatiViewHandle osStatiViewHandle;
	@Autowired
	private OsRamService osRamService;
	@Autowired
	private OsCpuService osCpuService;
	@Autowired
	private OsDiskService osDiskService;
	@Autowired
	private OsService osService;
	@Autowired
	private OsStatiService osStatiService;
	@Autowired
	private OsAvailableServcie osAvailableServcie;
	
	
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
	
	/**
	 * 统计报表曲线
	 * @param osid
	 * @param currentTime
	 * @param timespan 时间段 1 7 30
	 * @return
	 */
	public Map<String,List<Map<String, Object>>> creatStatiLine(String osid,String statitype, Date currentTime,int timespan ){
		long span;
		if(timespan>1){
			span=(timespan-1)*24;
		}else{
			span=(timespan*24);
		}
		Map<String,List<Map<String, Object>>> viewMap=new  HashMap<String,List<Map<String, Object>>>();
		Date dayPoint= new Date(currentTime.getTime()-Long.valueOf(span*60*60*1000));
		dayPoint=OsTransUtil.getDayPointByDate(dayPoint);//天整点
		List<StatiDataModel> osStatis=osStatiService.findStatiByTimeSpan(osid, statitype, dayPoint, currentTime);
		currentTime=OsTransUtil.getDayPointByDate(currentTime);//获取当天整点
		List<Map<String, Object>> cpuMaxmaps=osStatiViewHandle.creatCpuMaxStatiLine( osStatis, currentTime, dayPoint, timespan);
		List<Map<String, Object>> cpuMinmaps=osStatiViewHandle.creatCpuMinStatiLine( osStatis, currentTime, dayPoint, timespan);
		List<Map<String, Object>> cpuAvemaps=osStatiViewHandle.creatCpuAvaStatiLine( osStatis, currentTime, dayPoint, timespan);
		viewMap.put("max", cpuMaxmaps);
		viewMap.put("min", cpuMinmaps);
		viewMap.put("ave", cpuAvemaps);
		return viewMap;
		
	}
	
	
	/**
	 * 统计报表表格
	 * @param osid
	 * @param currentTime
	 * @param timespan 时间段 1 7 30
	 * @return
	 */
	public List<OsGridModel> creatStatiGrid(String osid,String statitype, Date currentTime,int timespan ){
		long span=0;
		SimpleDateFormat simpleDateFormat;
		if(timespan>1){
			span=24;	
			simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_YEAR_MON_DAY);
		}else{
			
			simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS);
		}
		List<OsGridModel>osGridModels= new ArrayList<OsGridModel>();
		Date dayPoint=OsTransUtil.getBeforeDate(currentTime, timespan+"");
		List<StatiDataModel> osStatis=osStatiService.findStatiByTimeSpan(osid, statitype, dayPoint, currentTime);
		for (int i = 0; i < osStatis.size(); i++) {
			if(osStatis.get(i).getDate().getTime()-dayPoint.getTime()>=(span*60*60*1000)){
				Integer ptime=(Integer) BigDecimal.valueOf(osStatis.get(i).getDate().getTime()-dayPoint.getTime()).divide(BigDecimal.valueOf(Long.parseLong(span*60*60*1000+"")),0,BigDecimal.ROUND_UP).intValue();//空了几次
				for (int j = 0; j < ptime; j++) {
					OsGridModel osGridModel=new OsGridModel();
					osGridModel.setMaxValue("未知");
					osGridModel.setMinValue("未知");
					osGridModel.setAverageValue("未知");
					osGridModel.setTime(simpleDateFormat.format(dayPoint));
					osGridModels.add(osGridModel);
					dayPoint=new Date (dayPoint.getTime()+(Long.parseLong(span*60*60*1000+"")));
				}
				OsGridModel osGridModel=new OsGridModel();
				osGridModel.setMaxValue(osStatis.get(i).getMaxValue());
				osGridModel.setMinValue(osStatis.get(i).getMinValue());
				osGridModel.setAverageValue(osStatis.get(i).getAvgValue());
				osGridModel.setTime(simpleDateFormat.format(dayPoint));
				osGridModels.add(osGridModel);
				dayPoint=new Date (dayPoint.getTime()+(Long.parseLong(span*60*60*1000+"")));
			}
			else{
				OsGridModel osGridModel=new OsGridModel();
				osGridModel.setMaxValue(osStatis.get(i).getMaxValue());
				osGridModel.setMinValue(osStatis.get(i).getMinValue());
				osGridModel.setAverageValue(osStatis.get(i).getAvgValue());
				osGridModel.setTime(simpleDateFormat.format(dayPoint));
				osGridModels.add(osGridModel);//本次点
				dayPoint=new Date(dayPoint.getTime()+Long.parseLong(span*60*60*1000+""));
			}
		}
		int mapsSize=osGridModels.size();
		if(osGridModels.size()<timespan){//如果总的点小于平均时间段 补上空点
			for (int i = 0; i < timespan-mapsSize; i++) {
				OsGridModel osGridModel=new OsGridModel();
				osGridModel.setMaxValue("未知");
				osGridModel.setMinValue("未知");
				osGridModel.setAverageValue("未知");
				osGridModel.setTime(simpleDateFormat.format(dayPoint));
				osGridModels.add(osGridModel);//本次点
				dayPoint=new Date(dayPoint.getTime()+Long.parseLong(span*60*60*1000+""));
			}
		}
		return osGridModels;
		
	}
	/**
	 * 可用性统计报表表格
	 * @param osid
	 * @param currentTime
	 * @param timespan 时间段 1 7 30
	 * @return
	 */
	public List<OsGridModel> creatAvailableHistoryGrid(String osid,String statitype, Date currentTime,int timespan ){
		long span=0;
		SimpleDateFormat simpleDateFormat;
		if(timespan>1){
			span=24;	
			simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_YEAR_MON_DAY);
		}else{
			
			simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS);
		}
		List<OsGridModel>osGridModels= new ArrayList<OsGridModel>();
		Date dayPoint=OsTransUtil.getBeforeDate(currentTime, timespan+"");
		List<StatiDataModel> osStatis=osAvailableServcie.getOsAvailablesHistoryByDate(osid, currentTime, timespan);
		for (int i = 0; i < osStatis.size(); i++) {
			if(osStatis.get(i).getDate().getTime()-dayPoint.getTime()>(span*60*60*1000)){
				Integer ptime=(Integer) BigDecimal.valueOf(osStatis.get(i).getDate().getTime()-dayPoint.getTime()).divide(BigDecimal.valueOf(Long.parseLong(span*60*60*1000+"")),0,BigDecimal.ROUND_UP).intValue();//空了几次
				for (int j = 0; j < ptime; j++) {
					OsGridModel osGridModel=new OsGridModel();
					osGridModel.setNormalRun("未知");
					osGridModel.setCrashTime("未知");
					osGridModel.setAveRepairTime("未知");
					osGridModel.setAveFaultTime("未知");
					osGridModel.setTime(simpleDateFormat.format(dayPoint));
					osGridModels.add(osGridModel);
					dayPoint=new Date (dayPoint.getTime()+(Long.parseLong(span*60*60*1000+"")));
				}
				OsGridModel osGridModel=new OsGridModel();
				osGridModel.setNormalRun(osStatis.get(i).getNormalRun());
				osGridModel.setCrashTime(osStatis.get(i).getCrashTime());
				osGridModel.setAveRepairTime(osStatis.get(i).getAveRepairTime());
				osGridModel.setAveFaultTime(osStatis.get(i).getAveFaultTime());
				osGridModel.setTime(simpleDateFormat.format(dayPoint));
				osGridModels.add(osGridModel);
				dayPoint=new Date (dayPoint.getTime()+(Long.parseLong(span*60*60*1000+"")));
			}
			else{
				OsGridModel osGridModel=new OsGridModel();
				osGridModel.setNormalRun(osStatis.get(i).getNormalRun());
				osGridModel.setCrashTime(osStatis.get(i).getCrashTime());
				osGridModel.setAveRepairTime(osStatis.get(i).getAveRepairTime());
				osGridModel.setAveFaultTime(osStatis.get(i).getAveFaultTime());
				osGridModel.setTime(simpleDateFormat.format(dayPoint));
				osGridModels.add(osGridModel);//本次点
				dayPoint=new Date(dayPoint.getTime()+Long.parseLong(span*60*60*1000+""));
			}
		}
		int mapsSize=osGridModels.size();
		if(osGridModels.size()<timespan){//如果总的点小于平均时间段 补上空点
			for (int i = 0; i < timespan-mapsSize; i++) {
				OsGridModel osGridModel=new OsGridModel();
				osGridModel.setNormalRun("未知");
				osGridModel.setCrashTime("未知");
				osGridModel.setAveRepairTime("未知");
				osGridModel.setAveFaultTime("未知");
				osGridModel.setTime(simpleDateFormat.format(dayPoint));
				osGridModels.add(osGridModel);//本次点
				dayPoint=new Date(dayPoint.getTime()+Long.parseLong(span*60*60*1000+""));
			}
		}
		return osGridModels;
		
	}
}
