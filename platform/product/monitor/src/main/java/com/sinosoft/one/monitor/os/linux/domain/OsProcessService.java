package com.sinosoft.one.monitor.os.linux.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;
import com.sinosoft.one.monitor.os.linux.model.OsStati;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;

@Component
public class OsProcessService {
	@Autowired
	private OsCpuService osCpuService;
	@Autowired
	private OsDiskService osDiskService;
	@Autowired
	private OsRamService osRamService;
	@Autowired
	private OsRespondTimeService osRespondTimeService;
	@Autowired
	private OsAvailableServcie OsAvailableServcie;
	@Autowired
	private OsDataMathService osDataMathService;
	@Autowired
	private OsAvailableServcie osAvailableServcie;
	@Autowired
	private OsStatiService osStatiService;
	/**
	 * 保存采样信息  //并更新统计记录
	 * @param cpuInfo 采集的CPU信息字符串
	 * @param ramInfo 采集的内存信息字符串
	 * @param diskInfo 采集的磁盘信息字符串
	 * @param respondTime 采集的响应信息字符串
	 * @param sampleTime 采集时间
	 */
	public void saveSampleData(String osInfoId,String cpuInfo,String ramInfo,String diskInfo,String respondTime ,Date sampleTime){
		osCpuService.saveCpu(osInfoId,cpuInfo ,sampleTime);//保存CPU采样
		osDiskService.saveDisk(osInfoId,diskInfo, sampleTime);//保存磁盘采样
		osRamService.saveRam(osInfoId,ramInfo , sampleTime);//保存内存采样
		osRespondTimeService.saveRespondTime(osInfoId,respondTime , sampleTime);//保存响应时间采样
		//更新统计记录
		List<OsStati> OsStatis=osDataMathService.statiOneHourRam(osInfoId, sampleTime);//更新内存统计
		OsStati cpuOsStati=osDataMathService.statiOneHourCpu(osInfoId, sampleTime);//更新CPU统计
		OsStati diskOsStati=osDataMathService.statiOneHourDisk(osInfoId, sampleTime);//更行磁盘统计
		OsStati respondOsStati=osDataMathService.statiOneHourRespond(osInfoId, sampleTime);//更行响应时间统计
		OsStatis.add(cpuOsStati);
		OsStatis.add(diskOsStati);
		OsStatis.add(respondOsStati);
		osStatiService.saveStatiOneHourList(OsStatis);
		//删除前一小时的记录
		//获取最大记录
	}
	
	/**
	 * 轮询任务 保存可用性采样 //并更新统计记录
	 * @param osId
	 * @param time
	 * @param Status
	 */
	public void savaAvailableSampleData(String osInfoId,Date sampleTime,int interCycleTime ,String Status){
		//保存本次采样
		osAvailableServcie.saveAvailableTemp(osInfoId, sampleTime, Status);
		//统计采样结果 今天
		Calendar c  = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, sampleTime.getDate());
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		//取当天的前24小时整时点
		Date todayzeroTime= c.getTime();
		osAvailableServcie.deleteAvailable(osInfoId, todayzeroTime);//删除今天的统计表记录
		osDataMathService.statiAvailable(osInfoId, sampleTime, todayzeroTime, interCycleTime, todayzeroTime);//保存新统计记录
		//删除24小时之外的数据
		Calendar c2  = Calendar.getInstance();
		c2.set(Calendar.DAY_OF_MONTH, sampleTime.getDate());
		c2.set(Calendar.HOUR_OF_DAY,-24);
		Date deleteTime= c2.getTime();
		osAvailableServcie.deleteTempByLessThanTime(osInfoId, deleteTime);
//		if(osAvailabletemp.getSampleDate().getDate()<sampleTime.getDate()){
//			//统计昨天的数据
//			//获得昨天的整点
//			c.set(Calendar.DAY_OF_MONTH, sampleTime.getDate()-1);
//			Date yestodayzeroTime= c.getTime();
//			//删除昨天天在统计表的数据
//			osAvailableServcie.deleteAvailable(osInfoId, yestodayzeroTime);
//			//新增昨天到统计表里的数据
//			osDataMathService.statiAvailable(osInfoId, todayzeroTime, yestodayzeroTime, interCycleTime, yestodayzeroTime);
//			osAvailableServcie.deleteTempByLessThanTime(osInfoId, sampleTime);
//		}
		
		
	}
	
	/**
	 * 获取最后一次轮询点时间
	 * @param osInfoId
	 * @return
	 */
	public String getLastSampleTime(String osInfoId ,Date currentTime){
		//获取最后一次可用性记录
		OsAvailabletemp osAvailabletemp=OsAvailableServcie.getLastAvailable(osInfoId, currentTime);
		return osAvailabletemp.getSampleDate().toGMTString();
	}
	
	

	/**
	 *  可用性的 定点任务调用方法
	 *  每天保存上一天（上24/昨天）可用性采样数据到 可用性统计 表
	 *  每天删除统计表中上一天可（上48/前天）用性采样数据
	 *  时间段 00:00:00--(删除)--00:00:00--(保存)---00:00:00(当前点)
	 * @param osInfoId
	 * @param currentTime
	 */
	public  void saveStatiEveryDayAvailableStati(String osInfoId ,Date currentTime,int interCycleTime){
		//当前天数
		Calendar c  = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,  currentTime.getDate());
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		//取当天的前24小时整时点
		Date d1 = c.getTime();
		c.add(Calendar.HOUR_OF_DAY, -24);
		//取当天的前48小时整时点
		Date d2 = c.getTime();
		//统计并保存 //保存为时间为昨天的日期
		osDataMathService.statiAvailable(osInfoId, d1, d2, interCycleTime, d2);
		//删除前天
		OsAvailableServcie.deleteLTFHourAvailale(osInfoId, currentTime);
	}
	
//	public static void main(String[] args) {
//		Date date= new Date();
//		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(OsUtil.DATEFORMATE_DAY);
//		Calendar c  = Calendar.getInstance();
//		c.set(Calendar.DAY_OF_MONTH, new Integer(simpleDateFormat1.format(date)));
//		c.set(Calendar.HOUR_OF_DAY,0);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		//取当天的前24小时整时点
//		Date todayzeroTime= c.getTime();
//		System.out.println(todayzeroTime);
//		
//		c.set(Calendar.DAY_OF_MONTH, new Integer(simpleDateFormat1.format(date))-1);
//		Date todayzeroTime1= c.getTime();
//		System.out.println(todayzeroTime1);
//		if(todayzeroTime.get>todayzeroTime1){
//			
//		}
//}
	
	
}
