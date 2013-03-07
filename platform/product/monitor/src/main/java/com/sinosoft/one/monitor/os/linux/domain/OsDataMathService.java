package com.sinosoft.one.monitor.os.linux.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsAvailable;
import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;
import com.sinosoft.one.monitor.os.linux.model.OsCpu;
import com.sinosoft.one.monitor.os.linux.model.OsDisk;
import com.sinosoft.one.monitor.os.linux.model.OsRam;
import com.sinosoft.one.monitor.os.linux.model.OsRespondtime;
import com.sinosoft.one.monitor.os.linux.model.OsStati;
import com.sinosoft.one.monitor.os.linux.util.OsTransUtil;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;
import com.sinosoft.one.monitor.utils.AvailableCalculate;
import com.sinosoft.one.monitor.utils.BussinessUtil;
import com.sinosoft.one.monitor.utils.AvailableCalculate.AvailableDetail;

/**
 * 信息处理类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
@Component
public class OsDataMathService {

	@Autowired
	private OsAvailableServcie osAvailableServcie;
	
	@Autowired
	private OsStatiService osStatiService;

	@Autowired
	private OsRamService osRamService;
	
	@Autowired
	private OsCpuService osCpuService;

	@Autowired
	private OsDiskService osDiskService;
	
	@Autowired
	private OsRespondTimeService osRespondTimeService;
	/**
	 * 可用性统计算法 进行可用性数据统计计算
	 * @param osInfoId OSID
	 * @param currentTime当前时间
	 * @param targetTime目标时间
	 * @param interCycleTime轮询时间
	 * @param timeSpan 时间段类型标记
	 */											//当前时间           //查询时间段的目标时间	 //轮询时间 分钟
	public void statiAvailable(String osInfoId,Date currentTime,Date targetTime,int interCycleTime ,Date timeSpan ){
		int stopCount=0;//停机次数
		OsAvailable osAvailable=osAvailableServcie.getAvailable(osInfoId, timeSpan);
		List<OsAvailabletemp> osAvailabletemps=osAvailableServcie.getAvailableTemps(osInfoId, targetTime, currentTime);
		List<AvailableDetail> availableDetails=osAvailableServcie.findGroupByInterCycleTime(osInfoId, targetTime);
		long lastRecordTime = 0;//上次时间变量
		for (int i = 0; i < osAvailabletemps.size(); i++) {
			if(i==0){//判断第一次与查询时间起始时间targetTime 是否大于轮询时间
				if(osAvailabletemps.get(i).getSampleDate().getTime()-targetTime.getTime()>osAvailabletemps.get(i).getIntercycleTime()*60*1000){
					stopCount=stopCount+1;
				}
			}else{
				if(osAvailabletemps.get(i).getSampleDate().getTime()-lastRecordTime>osAvailabletemps.get(i).getIntercycleTime()*60*1000){
					stopCount=stopCount+1;
				}
			}
			lastRecordTime=osAvailabletemps.get(i).getSampleDate().getTime();
		}
		if(osAvailable==null){
			AvailableCalculate availableCalculate=AvailableCalculate.simpleCalculate(osAvailabletemps.get(0).getSampleDate(),Long.valueOf(interCycleTime*1000), Long.valueOf(0), availableDetails, Integer.valueOf(0), interCycleTime);
			//初始一条统计的运行时间=轮询时间
			osAvailableServcie.saveAvailable(osInfoId, 1,0, 0, 1, timeSpan);
		}else{
			AvailableCalculate availableCalculate=AvailableCalculate.simpleCalculate(osAvailabletemps.get(0).getSampleDate(), osAvailable.getNormalRun(), osAvailable.getCrashTime(), availableDetails,osAvailable.getStopCount(), 1);
//			osAvailableServcie.saveAvailable(osInfoId,availableCalculate.getAliveTime().longValue() , availableCalculate.getStopTime().longValue(),availableCalculate.getTimeToRepair().longValue(),  availableCalculate.getTimeBetweenFailures().longValue(), timeSpan);
			osAvailableServcie.updateAvailable(osAvailable, availableCalculate.getAliveTime().longValue() , availableCalculate.getStopTime().longValue(), availableCalculate.getTimeToRepair().longValue(),  availableCalculate.getTimeBetweenFailures().longValue(),osAvailable.getStopCount());
		}
	}
	
	
	
	
	
	
	
	/**
	 * 统计内存，当前时间到当前小时整点
	 * @param osInfoId
	 */
	public List<OsStati> statiOneHourRam(String osInfoId,Date currentTime){
//		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS);
		Calendar c  = Calendar.getInstance();
		////获取当前时间的小时数 取整时点
		c.setTime(currentTime);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date hourPoint=c.getTime();
		List<OsRam> osRams = osRamService.getRamByDate(osInfoId, hourPoint, currentTime);
		double memUtilZationCount=0;//物理内存利用率总数
		double swapUtilZationCount = 0;//交换内存利用率总数
		for (OsRam osRam : osRams) {
			memUtilZationCount += Double.parseDouble( osRam.getMemUtiliZation() );//物理内存利用率总数
			swapUtilZationCount += Double.parseDouble(osRam.getSwapUtiliZation());//交换内存利用率总数
		}
		String remUitliZatiionAverage = OsTransUtil.countAve(memUtilZationCount, osRams.size());//物理内存利用率平均值
		String swapUitliZatiionAverage = OsTransUtil.countAve(swapUtilZationCount, osRams.size());//交换内存利用率平均值
		String ramUitliZatiionMax=osRamService.getMaxMemUtilZation(osInfoId, hourPoint, currentTime);
		String ramUitliZatiionMin=osRamService.getMinMemUtilZation(osInfoId, hourPoint, currentTime);
		String swapUitliZatiionMax=osRamService.getMaxSwapUtilZation(osInfoId, hourPoint, currentTime);
		String swapUitliZatiionMin=osRamService.getMinSwapUtilZation(osInfoId, hourPoint, currentTime);
		OsStati ramOsStati=osStatiService.creatStatiOneHour(osInfoId, OsUtil.RAM_STATIF_FLAG, hourPoint, ramUitliZatiionMax, ramUitliZatiionMin, remUitliZatiionAverage);
		OsStati swapOsStati=osStatiService.creatStatiOneHour(osInfoId, OsUtil.SWAP_STATIF_FLAG, hourPoint, swapUitliZatiionMax, swapUitliZatiionMin, swapUitliZatiionAverage);
		List<OsStati>osStatis=new ArrayList<OsStati>();
		osStatis.add(ramOsStati);
		osStatis.add(swapOsStati);
		return osStatis;
	}
	
	/**
	 * 统计CPU，当前时间到当前小时整点
	 * @param osInfoId
	 */
	public OsStati statiOneHourCpu(String osInfoId,Date currentTime){
//		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS);
		Calendar c  = Calendar.getInstance();
		////获取当前时间的小时数 取整时点
		c.setTime(currentTime);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date hourPoint=c.getTime();
		List<OsCpu>osCpus=osCpuService.getCpuByDate(osInfoId, hourPoint, currentTime);
		double cpuUtilZationCount=0;//cpu利用率总数
		for (OsCpu osCpu : osCpus) {
			cpuUtilZationCount+= Double.parseDouble( osCpu.getUtiliZation());
		}
		String cpuUitliZatiionAverage=OsTransUtil.countAve(cpuUtilZationCount, osCpus.size());
		String cpuUitliZatiionMax=osCpuService.getMaxCpuUtilZation(osInfoId, hourPoint, currentTime);
		String cpuUitliZatiionMin=osCpuService.getMinCpuUtilZation(osInfoId, hourPoint, currentTime);
		OsStati cpuOsStati=osStatiService.creatStatiOneHour(osInfoId, OsUtil.CPU_STATIF_FLAG, hourPoint, cpuUitliZatiionMax, cpuUitliZatiionMin, cpuUitliZatiionAverage);
		return cpuOsStati;
	}
	
	/**
	 * 统计磁盘，当前时间到当前小时整点
	 * @param osInfoId
	 */
	public OsStati statiOneHourDisk(String osInfoId,Date currentTime){
//		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS);
		Calendar c  = Calendar.getInstance();
		////获取当前时间的小时数 取整时点
		c.setTime(currentTime);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date hourPoint=c.getTime();
		List<OsDisk>osDisks=osDiskService.getDiskByDate(osInfoId, hourPoint, currentTime);
		double diskUtilZationCount=0;//磁盘利用率总数
		for (OsDisk osDisk : osDisks) {
			diskUtilZationCount+=Double.parseDouble(osDisk.getTotalUtiliZation());
		}
		String diskUitliZatiionAverage=OsTransUtil.countAve(diskUtilZationCount, osDisks.size());
		System.out.println(diskUitliZatiionAverage);
		String diskUitliZatiionMax=osDiskService.getMaxDiskUtilZation(osInfoId, hourPoint, currentTime);
		String diskUitliZatiionMin=osDiskService.getMinDiskUtilZation(osInfoId, hourPoint, currentTime);
		OsStati osStati= osStatiService.creatStatiOneHour(osInfoId, OsUtil.DISK_STATIF_FLAG, hourPoint, diskUitliZatiionMax, diskUitliZatiionMin, diskUitliZatiionAverage);
		return osStati;
	}
	
	/**
	 * 统计磁盘，当前时间到当前小时整点
	 * @param osInfoId
	 */
	public OsStati statiOneHourRespond(String osInfoId,Date currentTime){
//		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(OsUtil.DATEFORMATE_HOURS);
		Calendar c  = Calendar.getInstance();
		////获取当前时间的小时数 取整时点
		c.setTime(currentTime);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date hourPoint=c.getTime();
		List<OsRespondtime>osRespondtimes=osRespondTimeService.getRespondTimeByTime(osInfoId, hourPoint, currentTime);
		long respondTime=0;//磁盘利用率总数
		for (OsRespondtime osRespondtime : osRespondtimes) {
			respondTime+=Long.parseLong(osRespondtime.getRespondTime());
		}
		String respondTimeAverage=OsTransUtil.countAve(respondTime, osRespondtimes.size());
		System.out.println(respondTimeAverage);
		String respondTimeMax=osRespondTimeService.getMaxRespondTime(osInfoId, hourPoint, currentTime);
		String respondTimeMin=osRespondTimeService.getMinRespondTime(osInfoId, hourPoint, currentTime);
		OsStati osStati= osStatiService.creatStatiOneHour(osInfoId, OsUtil.RSPOND_STATIF_FLAG, hourPoint, respondTimeMax, respondTimeMin, respondTimeAverage);
		return osStati;
	}
	/**
	 * 计算Long的百分比 为2位小数
	 * @param interCycleTime
	 * @param countTime
	 * @param normrolRunTime
	 * @return
	 */
	public long  normalRun(int interCycleTime ,long countTime,long normrolRunTime){
		long interCycle =interCycleTime*60*1000+1;
		BigDecimal  normalRun;
		if(normrolRunTime+interCycle<=countTime){
			normalRun=BigDecimal.valueOf(normrolRunTime).divide(BigDecimal.valueOf(countTime),4,BigDecimal.ROUND_HALF_DOWN);
		}else{
			normalRun=BigDecimal.valueOf(normrolRunTime+interCycle).divide(BigDecimal.valueOf(countTime),4, BigDecimal.ROUND_HALF_DOWN);
		}
		return normalRun.multiply(BigDecimal.valueOf(100)).setScale(2).longValue();
	}
}