package com.sinosoft.one.monitor.os.linux.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsCpu;
import com.sinosoft.one.monitor.os.linux.model.OsRam;
import com.sinosoft.one.monitor.os.linux.model.viewmodel.OsGridModel;
import com.sinosoft.one.monitor.os.linux.util.OsTransUtil;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;

@Component
public class OsRamViewHandle {

	@Autowired
	private OsRamService osRamService;
	
	@Autowired
	private OsService osService;
	
	/**
	 * 构建物理内存的图形MAP
	 * @param Oss
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 */
	public Map<String,List<Map<String, Object>>> creatRamLineData(List<Os>Oss,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date beforOneHourTime= c.getTime();
		long aveTime =(currentTime.getTime()-beforOneHourTime.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		Map<String,List<Map<String, Object>>> osCpuUiliZation =new HashMap<String,List<Map<String, Object>>>();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date havePoint=beforOneHourTime; //有值的点
		Date date=new Date();
		for (Os os : Oss) {
			List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
			Map<String, Object> m=new HashMap<String, Object>();
			OsRam osRam= osRamService.findNealyRam(os.getOsInfoId(), havePoint ,interCycle);
			if (osRam!=null) {
				m.put("y",Double.valueOf(osRam.getMemUtiliZation()));
			}else {
				m.put("y",-1);
			}
			m.put("x", simpleDateFormat.format(havePoint));
			maps.add(m);//第一次取之前5分钟内最大的值
			List<OsRam> osRams=osRamService.getRamByDate(os.getOsInfoId(), havePoint, currentTime);
			for (int i = 0; i < osRams.size(); i++) {
				if(osRams.get(i).getSampleDate().getTime()-havePoint.getTime()>5*60*1000){
					int ptime=(int) ((osRams.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
					for (int j = 0; j < ptime; j++) {//计算与上次中间相差了几个是加段 添加几个空点
						Map<String, Object> map=new HashMap<String, Object>();
						Date nullpoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
						map.put("y",-1.0);
						map.put("x", simpleDateFormat.format(nullpoint));
						maps.add(map);
						havePoint=nullpoint;
					}
					Map<String, Object> map=new HashMap<String, Object>();
					havePoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
					map.put("x", simpleDateFormat.format(havePoint));
					map.put("y", Double.valueOf(osRams.get(i).getMemUtiliZation()));
					maps.add(map);//本次的点
					}else{
						if(osRams.get(i).getSampleDate().getTime()<havePoint.getTime()&&maps.size()>1 ){//如果小于上次时间
							Map<String, Object> map=new HashMap<String, Object>();
							map.put("y", Double.valueOf(osRams.get(i).getMemUtiliZation()));
							map.put("x", simpleDateFormat.format(havePoint));
							maps.set(maps.size()-1, map);//覆盖上次的点
							continue;
						} 
						Map<String, Object> map=new HashMap<String, Object>();
						havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
						map.put("y", Double.valueOf(osRams.get(i).getMemUtiliZation()));
						map.put("x", simpleDateFormat.format(havePoint));
						maps.add(map);
					}
					date=osRams.get(i).getSampleDate();
					
				}
				int mapsSize=maps.size();
				if(maps.size()<aveTime){//如果总的点小于平均时间段 补上空点
					for (int i = 0; i < aveTime-mapsSize+1; i++) {
						Map<String, Object> map=new HashMap<String, Object>();
						havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
						map.put("y",-1);
						map.put("x", simpleDateFormat.format(havePoint));
						maps.add(map);//本次的点
					}
				}
				osCpuUiliZation.put(os.getName(), maps);
			}
		return osCpuUiliZation;
	}
	
	
	
	/**
	 * 构建多个操作系统物理内存的图形MAP
	 * @param Oss
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 */
	public Map<String,List<Map<String, Object>>> creatSwapLineData(List<Os>Oss,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date beforOneHourTime= c.getTime();
		long aveTime =(currentTime.getTime()-beforOneHourTime.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		Map<String,List<Map<String, Object>>> osCpuUiliZation =new HashMap<String,List<Map<String, Object>>>();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date havePoint=beforOneHourTime; //有值的点
		Date date=new Date();
		for (Os os : Oss) {
			List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
			Map<String, Object> m=new HashMap<String, Object>();
			OsRam osRam= osRamService.findNealyRam(os.getOsInfoId(), havePoint ,interCycle);
			if (osRam!=null) {
				m.put("y",Double.valueOf(osRam.getMemUtiliZation()));
			}else { 
				m.put("y",-1);
			}
			m.put("x", simpleDateFormat.format(havePoint));
			maps.add(m);//第一次取之前5分钟内最大的值
			List<OsRam> osRams=osRamService.getRamByDate(os.getOsInfoId(), havePoint, currentTime);
			for (int i = 0; i < osRams.size(); i++) {
				if(osRams.get(i).getSampleDate().getTime()-havePoint.getTime()>5*60*1000){
					int ptime=(int) ((osRams.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
					for (int j = 0; j < ptime; j++) {//计算与上次中间相差了几个是加段 添加几个空点
						Map<String, Object> map=new HashMap<String, Object>();
						Date nullpoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
						map.put("y",-1.0);
						map.put("x", simpleDateFormat.format(nullpoint));
						maps.add(map);
						havePoint=nullpoint;
					}
					Map<String, Object> map=new HashMap<String, Object>();
					havePoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
					map.put("x", simpleDateFormat.format(havePoint));
					map.put("y",Double.valueOf(osRams.get(i).getSwapUtiliZation()));
					maps.add(map);//当前这个点的值
					}else{
						if(osRams.get(i).getSampleDate().getTime()<havePoint.getTime()&&maps.size()>1){//如果小于上次时间
							Map<String, Object> map=new HashMap<String, Object>();
							map.put("y",Double.valueOf(osRams.get(i).getSwapUtiliZation()));
							map.put("x", simpleDateFormat.format(havePoint));
							maps.set(maps.size()-1, map);//覆盖上次的点
							continue;
						} 
						Map<String, Object> map=new HashMap<String, Object>();
						havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
						map.put("y",Double.valueOf(osRams.get(i).getSwapUtiliZation()));
						map.put("x", simpleDateFormat.format(havePoint));
						maps.add(map);//本次的点
					}
					date=osRams.get(i).getSampleDate();
					
				}
				int mapsSize=maps.size();
				if(maps.size()<aveTime){//如果总的点小于平均时间段 补上空点
					for (int i = 0; i < aveTime-mapsSize+1; i++) {
						Map<String, Object> map=new HashMap<String, Object>();
						havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
						map.put("y",-1.0);
						map.put("x", simpleDateFormat.format(havePoint));
						maps.add(map);
					}
				}
				osCpuUiliZation.put(os.getName(), maps);
			}
		return osCpuUiliZation;
	}
	
	/**
	 * 构建一个操作系统物理内存曲线图形
	 * @param Oss
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 * @return
	 */
	public List<Map<String, Object>> creatOneRamLineData(Os os,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date havePoint= c.getTime();//有值的点
		long aveTime =(currentTime.getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date date=new Date();
		List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
		Map<String, Object> m=new HashMap<String, Object>();
		OsRam osRam=osRamService.findNealyRam(os.getOsInfoId(), havePoint ,interCycle);
		if (osRam!=null) {
			m.put("y",Double.valueOf(osRam.getMemUtiliZation()));
		}else {
			m.put("y",-1.0);
		}
		m.put("x", simpleDateFormat.format(havePoint));
		maps.add(m);//第一次取之前5分钟内最大的值
		List<OsRam> osRams=osRamService.getRamByDate(os.getOsInfoId(), havePoint, currentTime);
		for (int i = 0; i < osRams.size(); i++) {
			if(osRams.get(i).getSampleDate().getTime()-havePoint.getTime()>5*60*1000){
				int ptime=(int) ((osRams.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
				for (int j = 0; j < ptime; j++) {
					Map<String, Object> map=new HashMap<String, Object>();
					Date nullpoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
					map.put("y",-1.0);
					map.put("x", simpleDateFormat.format(nullpoint));
					maps.add(map);
					havePoint=nullpoint;
				}
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
				map.put("x", simpleDateFormat.format(havePoint));
				map.put("y",Double.valueOf(osRams.get(i).getMemUtiliZation()));
				maps.add(map);
			}else{
				if(osRams.get(i).getSampleDate().getTime()<date.getTime()&&maps.size()>1){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("y",Double.valueOf(osRams.get(i).getMemUtiliZation()));
					map.put("x", simpleDateFormat.format(havePoint));
					maps.set(maps.size()-1, map);//覆盖上次的点
					continue;
				} 
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",Double.valueOf(osRams.get(i).getMemUtiliZation()));
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);
			}
			date=osRams.get(i).getSampleDate();
			
		}
		int mapsSize=maps.size();
		if(maps.size()<aveTime){//如果总的点小于平均时间段 补上空点
			for (int i = 0; i < aveTime-mapsSize+1; i++) {
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",-1.0);
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);
			}
		}
		return maps;
	}
	
	/**
	 * 构建一个操作系统交换内存的曲线
	 * @param os
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 * @return
	 */
	public List<Map<String, Object>> creatOneSwapLineData(Os os,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date havePoint= c.getTime();//有值的点
		long aveTime =(currentTime.getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date date=new Date();
		List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
		Map<String, Object> m=new HashMap<String, Object>();
		OsRam osRam=osRamService.findNealyRam(os.getOsInfoId(), havePoint ,interCycle);
		if (osRam!=null) {
			m.put("y",Double.valueOf(osRam.getMemUtiliZation()));
		}else {
			m.put("y",-1);
		}
		m.put("x", simpleDateFormat.format(havePoint));
		maps.add(m);//第一次取之前5分钟内最大的值
		List<OsRam> osRams=osRamService.getRamByDate(os.getOsInfoId(), havePoint, currentTime);
		for (int i = 0; i < osRams.size(); i++) {
			if(osRams.get(i).getSampleDate().getTime()-havePoint.getTime()>5*60*1000){
				int ptime=(int) ((osRams.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
				for (int j = 0; j < ptime; j++) {
					Map<String, Object> map=new HashMap<String, Object>();
					Date nullpoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
					map.put("y",-1);
					map.put("x", simpleDateFormat.format(nullpoint));
					maps.add(map);
					havePoint=nullpoint;
				}
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
				map.put("x", simpleDateFormat.format(havePoint));
				map.put("y",Double.valueOf(osRams.get(i).getMemUtiliZation()));
				maps.add(map);
			}else{
				if(osRams.get(i).getSampleDate().getTime()<date.getTime()&&maps.size()>1){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("y",Double.valueOf(osRams.get(i).getMemUtiliZation()));
					map.put("x", simpleDateFormat.format(havePoint));
					maps.set(maps.size()-1, map);//覆盖上次的点
					continue;
				} 
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",Double.valueOf(osRams.get(i).getMemUtiliZation()));
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);
			}
			date=osRams.get(i).getSampleDate();
			
		}
		int mapsSize=maps.size();
		if(maps.size()<aveTime){//如果总的点小于平均时间段 补上空点
			for (int i = 0; i < aveTime-mapsSize+1; i++) {
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",-1);
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);
			}
		}
		return maps;
	}
	
	/**
	 * 构建当前内存的grid
	 * @param osId
	 * @param currentTime
	 * @return
	 */
	public List<OsGridModel> creatCurrentMemView(String osId,Date currentTime){
		Os os=osService.getOsBasicById(osId);
		OsRam osRam=osRamService.findNealyRam(os.getOsInfoId(), currentTime, os.getIntercycleTime());
		List<OsGridModel>osSwapViewModels=new ArrayList<OsGridModel>();
		if(osRam==null){
			OsGridModel osRamViewModel=new OsGridModel();
			osRamViewModel.setName("物理内存利用率");
			osRamViewModel.setUtilzation("未知");
			osRamViewModel.setLink("<a href='#' onclick='viewWindow(this,\"historyMem/7\")' class='img-7'></a>");
			osRamViewModel.setUsed("未知");
			osSwapViewModels.add(osRamViewModel);
			OsGridModel osSwapViewModel=new OsGridModel();
			osSwapViewModel.setName("交换内存利用率");
			osRamViewModel.setUtilzation("未知");
			osSwapViewModel.setLink("<a href='#' onclick='viewWindow(this,\"historyMem/7\")' class='img-7'></a>");
			osSwapViewModel.setUsed("未知");
			osSwapViewModels.add(osSwapViewModel);
		}else{
			OsGridModel osRamViewModel=new OsGridModel();
			osRamViewModel.setName("物理内存利用率");
			osRamViewModel.setUtilzation(osRam.getMemUtiliZation()); 
			osRamViewModel.setLink("<a href='#' onclick='viewWindow(this,\"historyMem/7\")' class='img-7'></a>");
			osRamViewModel.setUsed(OsTransUtil.countUtilZation("1024", osRam.getMemUsed()));
			osSwapViewModels.add(osRamViewModel);
			OsGridModel osSwapViewModel=new OsGridModel();
			osSwapViewModel.setName("交换内存利用率");
			osSwapViewModel.setUtilzation(osRam.getSwapUtiliZation());
			osSwapViewModel.setLink("<a href='#' onclick='viewWindow(this,\"historyMem/7\")' class='img-7'></a>");
			osSwapViewModel.setUsed(OsTransUtil.countUtilZation("1024", osRam.getSwapUsed()));
			osSwapViewModels.add(osSwapViewModel);
		}
		return osSwapViewModels;
	}
}
