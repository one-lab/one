package com.sinosoft.one.monitor.os.linux.domain;

import java.text.SimpleDateFormat;
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
	public OsStati  creatStatiOneHour(String osInfoId ,String type,Date recordTime,String maxValue ,String minValue,String averageValue){
//		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS);
		Calendar c  = Calendar.getInstance();
		////获取当前时间的小时数 取整时点
		c.set(Calendar.DATE, recordTime.getDate());
		c.set(Calendar.HOUR_OF_DAY, recordTime.getHours());
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date hourPoint=c.getTime();
//		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat(OsUtil.DATEFORMATE);
		osStatiRepository.deleteStatiRmThisHour(osInfoId, type, hourPoint);
		OsStati osStati=new OsStati();
		osStati.setOsid(osInfoId);
		osStati.setRecordTime(hourPoint);
		osStati.setType(type);
		osStati.setMaxValue(maxValue);
		osStati.setMinValue(minValue);
		osStati.setAverageValue(averageValue);
		return osStati;
	}
	
	/**
	 * 保存基本信息统计结果集合
	 * @param osStatis
	 */
	public void saveStatiOneHourList(List<OsStati> osStatis){
		osStatiRepository.save(osStatis);
	}
	
}
