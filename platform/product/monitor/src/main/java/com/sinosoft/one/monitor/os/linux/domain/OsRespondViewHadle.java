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
import com.sinosoft.one.monitor.os.linux.model.OsRam;
import com.sinosoft.one.monitor.os.linux.model.OsRespondtime;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;

@Component
public class OsRespondViewHadle {
	@Autowired
	private OsRespondTimeService osRespondTimeService;
	
	/**
	 * 响应时间的图形MAP
	 * @param Oss
	 * @param currentTime
	 * @param interCycle
	 * @param timespan
	 */
	public Map<String,List<Map<String, Object>>> creatRespondLineData(List<Os>Oss,Date currentTime,int interCycle,int timespan){
		//获取当前时间的1小时
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
			OsRespondtime osRespondtime= osRespondTimeService.findNealyResponTime(os.getOsInfoId(), havePoint ,interCycle);
			if (osRespondtime!=null) {
				m.put("y",Integer.valueOf(osRespondtime.getRespondTime()));
			}else {
				m.put("y",-1);
			}
			m.put("x",simpleDateFormat.format(havePoint));
			maps.add(m);
			List<OsRespondtime> OsRespondtime=osRespondTimeService.getRespondTimeByTime(os.getOsInfoId(), havePoint, currentTime);
			for (int i = 0; i < OsRespondtime.size(); i++) {
				if(OsRespondtime.get(i).getSampleDate().getTime()-havePoint.getTime()>5*60*1000){
					int ptime=(int) ((OsRespondtime.get(i).getSampleDate().getTime()-havePoint.getTime())/Long.parseLong(interCycle*60*1000+""));//空了几次
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
					map.put("y",Integer.valueOf(OsRespondtime.get(i).getRespondTime()));
					maps.add(map);
					}else{
						if(OsRespondtime.get(i).getSampleDate().getTime()<havePoint.getTime()&&maps.size()>1){
							Map<String, Object> map=new HashMap<String, Object>();
							map.put("y",Integer.valueOf(OsRespondtime.get(i).getRespondTime()));
							map.put("x", simpleDateFormat.format(havePoint));
							maps.set(maps.size()-1, map);
							continue;
						} 
						Map<String, Object> map=new HashMap<String, Object>();
						havePoint=new Date(havePoint.getTime()+Long.parseLong(interCycle*60*1000+""));
						map.put("y",Integer.valueOf(OsRespondtime.get(i).getRespondTime()));
						map.put("x", simpleDateFormat.format(havePoint));
						maps.add(map);
					}
					date=OsRespondtime.get(i).getSampleDate();
					
				}
				int mapsSize=maps.size();
				if(maps.size()<aveTime){
//					if(mapsSize==0){
//						mapsSize=mapsSize+1;
//					}
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
}
