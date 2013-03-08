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
		Calendar c  = Calendar.getInstance();
		////获取当前时间的小时数 取整时点
		c.setTime(sampleTime);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date hourPoint=c.getTime();
		osCpuService.saveCpu(osInfoId,cpuInfo ,sampleTime);//保存CPU采样
		osDiskService.saveDisk(osInfoId,diskInfo, sampleTime);//保存磁盘采样
		osRamService.saveRam(osInfoId,ramInfo , sampleTime);//保存内存采样
		osRespondTimeService.saveRespondTime(osInfoId,respondTime , sampleTime);//保存响应时间采样
		//更新统计记录
		osDataMathService.statiOneHourRam(osInfoId, sampleTime,hourPoint);//更新内存统计
		osDataMathService.statiOneHourCpu(osInfoId, sampleTime,hourPoint);//更新CPU统计
		osDataMathService.statiOneHourDisk(osInfoId, sampleTime,hourPoint);//更行磁盘统计
		osDataMathService.statiOneHourRespond(osInfoId, sampleTime,hourPoint);//更行响应时间统计
		//删除24小时前的记录
		Calendar c2  = Calendar.getInstance();
		c2.set(Calendar.DATE, sampleTime.getDate());
		c2.add(Calendar.HOUR_OF_DAY,-24);
		Date deleteTime= c2.getTime();
		//删除24小时前的临时数据
		osCpuService.deleteCpuByLessThanTime(osInfoId, deleteTime);
		osDiskService.deleteDiskByLessThanTime(osInfoId, deleteTime);
		osRamService.deleteRamByLessThanTime(osInfoId, deleteTime);
		osRespondTimeService.deleteResponTimekByLessThanTime(osInfoId, deleteTime);
	}
	
	/**
	 * 轮询任务 保存可用性采样 //并更新统计记录
	 * @param osId
	 * @param time
	 * @param Status
	 */
	public void savaAvailableSampleData(String osInfoId,Date sampleTime,int interCycleTime ,String Status){
		//保存本次采样
		osAvailableServcie.saveAvailableTemp(osInfoId, sampleTime, Status,interCycleTime);
		//统计采样结果 今天
		Calendar c  = Calendar.getInstance();
		c.setTime( sampleTime);
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		//取当天的前24小时整时点
		Date todayzeroTime= c.getTime();
		//修改今天的统计表记录
		osDataMathService.statiAvailable(osInfoId, sampleTime, todayzeroTime, interCycleTime, todayzeroTime);//保存新统计记录
		//删除24小时前的数据
		Calendar c2  = Calendar.getInstance();
		c2.setTime( sampleTime);
		c2.add(Calendar.HOUR_OF_DAY,-24);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		Date deleteTime= c2.getTime();
		osAvailableServcie.deleteTempByLessThanTime(osInfoId, deleteTime);
	}
	
	/**
	 * 获取最后一次轮询时间
	 * @param osInfoId
	 * @return
	 */
	public Date getLastSampleTime(String osInfoId ,Date currentTime){
		//获取最后一次可用性记录
 		OsAvailabletemp osAvailabletemp=OsAvailableServcie.getLastAvailable(osInfoId, currentTime);
		return osAvailabletemp.getSampleDate();
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
		c.setTime(currentTime);
//		c.set(Calendar.DAY_OF_MONTH,  currentTime.getDay());
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
