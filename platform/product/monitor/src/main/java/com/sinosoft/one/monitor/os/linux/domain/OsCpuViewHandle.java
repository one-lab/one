package com.sinosoft.one.monitor.os.linux.domain;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.data.jade.parsers.sqljep.function.ToNumber;
import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsCpu;
import com.sinosoft.one.monitor.os.linux.model.OsRam;
import com.sinosoft.one.monitor.os.linux.model.viewmodel.OsGridModel;
import com.sinosoft.one.monitor.os.linux.util.OsTransUtil;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;
@Component
public class OsCpuViewHandle {
	@Autowired
	private OsCpuService osCpuService;
	
	@Autowired
	private OsService osService;
	
	private static Map<String,String> map=new HashMap<String, String>();
	static{
		
		 map.put("runQueue", "运行队列");
		 map.put("Link", "<a href='javascript:void(0)' onclick='viewWindow(this)' class='img-7'></a>");
		 map.put("blockProcess", "阻塞进程");
		 map.put("blockProcessLink", "<a href='javascript:void(0)' onclick='viewWindow(this)' class='img-7'></a>");
		 map.put("userTime", "用户时间(%)");
		 map.put("userTimeLink", "<a href='javascript:void(0)' onclick='viewWindow(this)' class='img-7'></a>");
		 map.put("sysTime", "系统时间(%)");
		 map.put("sysTimeLink", "<a href='javascript:void(0)' onclick='viewWindow(this)' class='img-7'></a>");
		 map.put("ioWait", "I/O等待(%)");
		 map.put("ioWaitLink", "<a href='javascript:void(0)' onclick='viewWindow(this)' class='img-7'></a>");
		 map.put("cpuIdle", "空闲时间(%) ");
		 map.put("cpuIdleLink", "<a href='javascript:void(0)' onclick='viewWindow(this)' class='img-7'></a>");
		 map.put("interRupt", "中断/秒");
		 map.put("interRuptLink", "<a href='javascript:void(0)' onclick='viewWindow(this)' class='img-7'></a>");
	}
	
	/**
	 * 构建多个操作系统CPU的图形MAP
	 * @param Oss
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 */
	public Map<String,List<Map<String, Object>>> creatCpuLineData(List<Os>Oss,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date havePoint= c.getTime();//有值的点
		long aveTime =(currentTime.getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		Map<String,List<Map<String, Object>>> osCpuUiliZation =new HashMap<String,List<Map<String, Object>>>();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date date=new Date();
		for (Os os : Oss) {
			List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
			Map<String, Object> m=new HashMap<String, Object>();
			OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), havePoint ,interCycle);
			if (osCpu!=null) {
				m.put("y",Double.valueOf(osCpu.getUtiliZation()));
			}else {
				m.put("y",-1);
			}
			m.put("x", simpleDateFormat.format(havePoint));
			maps.add(m);//第一次取之前5分钟内最大的值
			List<OsCpu> osCpus=osCpuService.getCpuByDate(os.getOsInfoId(), havePoint, currentTime);
			for (int i = 0; i < osCpus.size(); i++) {
				if(osCpus.get(i).getSampleDate().getTime()-havePoint.getTime()>interCycle*60*1000){
					int ptime=(int) ((osCpus.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
					for (int j = 0; j < ptime; j++) {
						Map<String, Object> map=new HashMap<String, Object>();
						Date nullpoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
						map.put("y",-1);
						map.put("x", simpleDateFormat.format(nullpoint));
						maps.add(map);//当前这个点的值
						havePoint=nullpoint;
					}
					Map<String, Object> map=new HashMap<String, Object>();
					havePoint=new Date (havePoint.getTime()+(Long.parseLong(interCycle*60*1000+"")));
					map.put("x", simpleDateFormat.format(havePoint));
					map.put("y",Double.valueOf(osCpus.get(i).getUtiliZation()));
					maps.add(map);
				}else{
					if(osCpus.get(i).getSampleDate().getTime()<date.getTime()&&maps.size()>1){
						Map<String, Object> map=new HashMap<String, Object>();
						map.put("y",Double.valueOf(osCpus.get(i).getUtiliZation()));
						map.put("x", simpleDateFormat.format(havePoint));
						maps.set(maps.size()-1, map);//覆盖上次的点
						continue;
					} 
					Map<String, Object> map=new HashMap<String, Object>();
					havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
					map.put("y",Double.valueOf(osCpus.get(i).getUtiliZation()));
					map.put("x", simpleDateFormat.format(havePoint));
					maps.add(map);//本次的点
				}
				date=osCpus.get(i).getSampleDate();
				
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
			osCpuUiliZation.put(os.getName(), maps);
		}
		return osCpuUiliZation;
	}
	
	/**
	 * 构建1个操作系统CPU利用率的曲线图形
	 * @param os
	 * @param currentTime
	 * @param interCycle
	 * @param timespan 小时数 
	 * @return
	 */
	public List<Map<String, Object>> creatOneCpuUsedLineData(Os os,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date havePoint= c.getTime();//有值的点
		long aveTime =(currentTime.getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date date=new Date();
		List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
		Map<String, Object> m=new HashMap<String, Object>();
		OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), havePoint ,interCycle);
		if (osCpu!=null) {
			m.put("y",Double.valueOf(osCpu.getUtiliZation()));
		}else {
			m.put("y",-1);
		}
		m.put("x", simpleDateFormat.format(havePoint));
		maps.add(m);//第一次取之前5分钟内最大的值
		List<OsCpu> osCpus=osCpuService.getCpuByDate(os.getOsInfoId(), havePoint, currentTime);
		for (int i = 0; i < osCpus.size(); i++) {
			if(osCpus.get(i).getSampleDate().getTime()-havePoint.getTime()>interCycle*60*1000){
				int ptime=(int) ((osCpus.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
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
				map.put("y",Double.valueOf(osCpus.get(i).getUtiliZation()));
				maps.add(map);
			}else{
				if(osCpus.get(i).getSampleDate().getTime()<date.getTime()&&maps.size()>1){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("y",Double.valueOf(osCpus.get(i).getUtiliZation()));
					map.put("x", simpleDateFormat.format(havePoint));
					maps.set(maps.size()-1, map);//覆盖上次的点
					continue;
				} 
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",Double.valueOf(osCpus.get(i).getUtiliZation()));
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);
			}
			date=osCpus.get(i).getSampleDate();
			
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
	 * 一个操作系统分解CPU的userTime
	 * @param os
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 * @return
	 */
	public List<Map<String, Object>> creatOneCpuUserTimeLine(Os os,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date havePoint= c.getTime();//有值的点
		long aveTime =(currentTime.getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date date=new Date();
		List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
		Map<String, Object> m=new HashMap<String, Object>();
		OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), havePoint ,interCycle);
		if (osCpu!=null) {
			m.put("y",Double.valueOf(osCpu.getUserTime()));
		}else {
			m.put("y",-1);
		}
		m.put("x", simpleDateFormat.format(havePoint));
		maps.add(m);//第一次取之前5分钟内最大的值
		List<OsCpu> osCpus=osCpuService.getCpuByDate(os.getOsInfoId(), havePoint, currentTime);
		for (int i = 0; i < osCpus.size(); i++) {
			if(osCpus.get(i).getSampleDate().getTime()-havePoint.getTime()>interCycle*60*1000){
				int ptime=(int) ((osCpus.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
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
				map.put("y",Double.valueOf(osCpus.get(i).getUserTime()));
				maps.add(map);//本次点
			}else{
				if(osCpus.get(i).getSampleDate().getTime()<date.getTime()&&maps.size()>1){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("y",Double.valueOf(osCpus.get(i).getUserTime()));
					map.put("x", simpleDateFormat.format(havePoint));
					maps.set(maps.size()-1, map);//覆盖上次的点
					continue;
				} 
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",Double.valueOf(osCpus.get(i).getUserTime()));
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);//本次点
			}
			date=osCpus.get(i).getSampleDate();
			
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
	 * 一个操作系统分解CPU的systime 曲线
	 * @param os
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 * @return
	 */
	public List<Map<String, Object>> creatOneCpuSysTimeLine(Os os,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date havePoint= c.getTime();//有值的点
		long aveTime =(currentTime.getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date date=new Date();
		List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
		Map<String, Object> m=new HashMap<String, Object>();
		OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), havePoint ,interCycle);
		if (osCpu!=null) {
			m.put("y",Double.valueOf(osCpu.getSysTime()));
		}else {
			m.put("y",-1);
		}
		m.put("x", simpleDateFormat.format(havePoint));
		maps.add(m);//第一次取之前5分钟内最大的值
		List<OsCpu> osCpus=osCpuService.getCpuByDate(os.getOsInfoId(), havePoint, currentTime);
		for (int i = 0; i < osCpus.size(); i++) {
			if(osCpus.get(i).getSampleDate().getTime()-havePoint.getTime()>interCycle*60*1000){
				int ptime=(int) ((osCpus.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
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
				map.put("y",Double.valueOf(osCpus.get(i).getSysTime()));
				maps.add(map);//本次点
			}else{
				if(osCpus.get(i).getSampleDate().getTime()<date.getTime()&&maps.size()>1){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("y",Double.valueOf(osCpus.get(i).getSysTime()));
					map.put("x", simpleDateFormat.format(havePoint));
					maps.set(maps.size()-1, map);//覆盖上次的点
					continue;
				} 
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",Double.valueOf(osCpus.get(i).getSysTime()));
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);//本次点
			}
			date=osCpus.get(i).getSampleDate();
			
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
	 * 一个操作系统分解CPU的IO曲线
	 * @param os
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 * @return
	 */
	public List<Map<String, Object>> creatOneCpuIOLine(Os os,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date havePoint= c.getTime();//有值的点
		long aveTime =(currentTime.getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date date=new Date();
		List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
		Map<String, Object> m=new HashMap<String, Object>();
		OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), havePoint ,interCycle);
		if (osCpu!=null) {
			m.put("y",Double.valueOf(osCpu.getIoWait()));
		}else {
			m.put("y",-1);
		}
		m.put("x", simpleDateFormat.format(havePoint));
		maps.add(m);//第一次取之前5分钟内最大的值
		List<OsCpu> osCpus=osCpuService.getCpuByDate(os.getOsInfoId(), havePoint, currentTime);
		for (int i = 0; i < osCpus.size(); i++) {
			if(osCpus.get(i).getSampleDate().getTime()-havePoint.getTime()>interCycle*60*1000){
				int ptime=(int) ((osCpus.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
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
				map.put("y",Double.valueOf(osCpus.get(i).getIoWait()));
				maps.add(map);//本次点
			}else{
				if(osCpus.get(i).getSampleDate().getTime()<date.getTime()&&maps.size()>1){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("y",Double.valueOf(osCpus.get(i).getIoWait()));
					map.put("x", simpleDateFormat.format(havePoint));
					maps.set(maps.size()-1, map);//覆盖上次的点
					continue;
				} 
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",Double.valueOf(osCpus.get(i).getIoWait()));
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);//本次点
			}
			date=osCpus.get(i).getSampleDate();
			
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
	 * 一个操作系统分解CPU的IDLE曲线
	 * @param os
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 * @return
	 */
	public List<Map<String, Object>> creatOneCpuIDLELine(Os os,Date currentTime,int interCycle,int timespan){
		Calendar c  = Calendar.getInstance();
		c.setTime(currentTime);
		c.set(Calendar.HOUR_OF_DAY,currentTime.getHours()-timespan);
		Date havePoint= c.getTime();//有值的点
		long aveTime =(currentTime.getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+"");//平均时间段
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS_MINE);
		Date date=new Date();
		List<Map<String, Object>>maps=new ArrayList<Map<String,Object>>();
		Map<String, Object> m=new HashMap<String, Object>();
		OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), havePoint ,interCycle);
		if (osCpu!=null) {
			m.put("y",Double.valueOf(osCpu.getCpuIdle()));
		}else {
			m.put("y",-1);
		}
		m.put("x", simpleDateFormat.format(havePoint));
		maps.add(m);//第一次取之前5分钟内最大的值
		List<OsCpu> osCpus=osCpuService.getCpuByDate(os.getOsInfoId(), havePoint, currentTime);
		for (int i = 0; i < osCpus.size(); i++) {
			if(osCpus.get(i).getSampleDate().getTime()-havePoint.getTime()>interCycle*60*1000){
				int ptime=(int) ((osCpus.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
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
				map.put("y",Double.valueOf(osCpus.get(i).getCpuIdle()));
				maps.add(map);//本次点
			}else{
				if(osCpus.get(i).getSampleDate().getTime()<date.getTime()&&maps.size()>1){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("y",Double.valueOf(osCpus.get(i).getCpuIdle()));
					map.put("x", simpleDateFormat.format(havePoint));
					maps.set(maps.size()-1, map);//覆盖上次的点
					continue;
				} 
				Map<String, Object> map=new HashMap<String, Object>();
				havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
				map.put("y",Double.valueOf(osCpus.get(i).getIoWait()));
				map.put("x", simpleDateFormat.format(havePoint));
				maps.add(map);//本次点
			}
			date=osCpus.get(i).getSampleDate();
			
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
	 * 构建当前Cpu的grid
	 * @param osId
	 * @param currentTime
	 * @return
	 */
	public List<OsGridModel> creatCurrentCpuView(String osId,Date currentTime){
		Os os=osService.getOsBasicById(osId);
		OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), currentTime, os.getIntercycleTime());
		List<OsGridModel>osSwapViewModels=new ArrayList<OsGridModel>();
		if(osCpu==null){
			OsGridModel osRamViewModel=new OsGridModel();
			osRamViewModel.setName("CPU使用率");
			osRamViewModel.setUtilzation("未知");
			osRamViewModel.setLink("<a href='#' class='img-7'></a>");
			osRamViewModel.setUsed("0");
			osRamViewModel.setThreshold("0");
			osSwapViewModels.add(osRamViewModel);
		}else{
			OsGridModel osRamViewModel=new OsGridModel();
			osRamViewModel.setName("CPU使用率");
			osRamViewModel.setUtilzation(osCpu.getUtiliZation());
			osRamViewModel.setLink("<a href='#' class='img-7'></a>");
			osRamViewModel.setThreshold("0");
			osSwapViewModels.add(osRamViewModel);
			
		}
		return osSwapViewModels;
	}
	
	/**
	 * 构建当前Cpu分解的grid
	 * @param osId
	 * @param currentTime
	 * @return
	 */ 
	public List<OsGridModel> creatCpuResolveView(String osId,Date currentTime){
		List<OsGridModel>osSwapViewModels=new ArrayList<OsGridModel>();
		Os os=osService.getOsBasicById(osId);
		OsCpu osCpu=osCpuService.findNealyCpu(os.getOsInfoId(), currentTime, os.getIntercycleTime());
		try {
			if(osCpu==null){
				osCpu= new OsCpu();
			}
				for (Field field : osCpu.getClass().getDeclaredFields()) {
					if(!map.keySet().contains(field.getName())){
						continue;
					}
					field.setAccessible(true);
					OsGridModel osGridModel = new OsGridModel();
					osGridModel.setName(map.get(field.getName()));
					if(field.get(osCpu)==null){
						osGridModel.setValue("未知");
						osGridModel.setStuts("<a  class='img-unknow'></a>");
					}else{
						osGridModel.setStuts("<a  class='img-unknow'></a>");
						osGridModel.setValue(field.get(osCpu).toString());
					}
					osGridModel.setLink(map.get("Link"));
					
					osSwapViewModels.add(osGridModel);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return osSwapViewModels;
	}
	
	
}
	
	
