package com.sinosoft.one.monitor.os.linux.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.OsStati;
import com.sinosoft.one.monitor.os.linux.repository.OsStatiRepository;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;

/**
 * 内存部分数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
@Component
public class OsStatiService {
	
	@Autowired
	private OsStatiRepository osStatiRepository;
	
	/**
	 *  创建当前一小时的统计数据 不断更新 (CPU、物理内存、交换内存、磁盘、响应时间)
	 * @param ram
	 */
	public OsStati  creatStatiOneHour(String osInfoId ,String type,Date hourPoint,String maxValue ,String minValue,String averageValue){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE);
		OsStati osStati=osStatiRepository.getStatiThisTime(osInfoId, type, simpleDateFormat.format( hourPoint), OsUtil.ORCL_DATEFORMATE);
		if(osStati==null)
			osStati=new OsStati();
		osStati.setOsid(osInfoId);
		osStati.setRecordTime(hourPoint);
		osStati.setType(type);
		osStati.setMaxValue(maxValue);
		osStati.setMinValue(minValue);
		osStati.setAverageValue(averageValue);
		return osStatiRepository.save(osStati);
	}
	
	
	/**
	 * 保存基本信息统计结果集合
	 * @param osStatis
	 */
	public void saveStatiOneHourList(List<OsStati> osStatis){
		osStatiRepository.save(osStatis);
	}
	
	/**
	 * 查询统计表一个时间点的某种记录
	 * @param osid
	 * @param timepoint时间点
	 * @return
	 */
	public OsStati findStatiByTimePoint(String osid,String type,Date timepoint){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE);
		return osStatiRepository.getStatiThisTime(osid,type, simpleDateFormat.format(timepoint),  OsUtil.ORCL_DATEFORMATE);
	}
	
 
	/**
	 * 查询统计表一个时间段的统计结果记录
	 * @param osid
	 * @param timepoint时间点
	 * @return
	 */
	public List<OsStati> findStatiByTimeSpan(String osid,String type,Date begin ,Date end ,int timespan){
		int timeSize=0;
		if(timespan>1){
			timeSize=24;
		}else{
			timeSize=1;
		}
		long aveTime =(end.getTime()-begin.getTime())/Long.parseLong(timeSize*60*60*1000+"")+1;//平均时间段
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_YEAR_MON_DAY);
		List<OsStati> osStatis=new ArrayList<OsStati>();
		for (int i = 0; i <aveTime; i++) {
			String max=osStatiRepository.findStatiMaxByTimeSpan(osid, type, simpleDateFormat.format(begin), OsUtil.DATEFORMATE_YEAR_MON_DAY);
			String min=osStatiRepository.findStatiMinByTimeSpan(osid, type, simpleDateFormat.format(begin), OsUtil.DATEFORMATE_YEAR_MON_DAY);
			String ave=osStatiRepository.findStatiAveByTimeSpan(osid, type, simpleDateFormat.format(begin), OsUtil.DATEFORMATE_YEAR_MON_DAY);
			OsStati osStati=new OsStati();
			if(max==null)
				max="-1.0";
			if(min==null)
				min="-1.0";
			if(ave==null)
				ave="-1.0";
			osStati.setMaxValue(BigDecimal.valueOf(Double.valueOf(max)).divide(BigDecimal.valueOf(1),2,BigDecimal.ROUND_HALF_UP).toString());
			osStati.setMinValue(BigDecimal.valueOf(Double.valueOf(min)).divide(BigDecimal.valueOf(1),2,BigDecimal.ROUND_HALF_UP).toString());
			osStati.setAverageValue(BigDecimal.valueOf(Double.valueOf(ave)).divide(BigDecimal.valueOf(1),2,BigDecimal.ROUND_HALF_UP).toString());
			osStati.setRecordTime(begin);
			begin=new Date(begin.getTime()+timeSize*60*60*1000);
			osStatis.add(osStati);
		}
		
		return osStatis;
	}
}
