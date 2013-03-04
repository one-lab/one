package com.sinosoft.one.monitor.os.linux.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.OsAvailable;
import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;
import com.sinosoft.one.monitor.os.linux.model.OsCpu;
import com.sinosoft.one.monitor.os.linux.model.OsDisk;
import com.sinosoft.one.monitor.os.linux.model.OsRam;
import com.sinosoft.one.monitor.os.linux.model.OsRespondtime;
import com.sinosoft.one.monitor.os.linux.model.OsStati;
import com.sinosoft.one.monitor.os.linux.util.OsTransUtil;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;

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
	 */												//当前时间		//目标时间		
	public void statiAvailable(String osInfoId,Date currentTime,Date targetTime,int interCycleTime ,Date timeSpan ){
//		SimpleDateFormat Format=new SimpleDateFormat(OsUtil.DATEFORMATE); 
		List<OsAvailabletemp> osAvailabletemps=osAvailableServcie.getAvailableTemps(osInfoId, targetTime, currentTime);
		long nomorRun=0;//可用时间记录
		long crashtime=0;//不可用时间记录
		long repairTime=0;//总回复时间
		long stopSpacCount=0;//总故障间隔
		String aveRepair;//平均回复时间
		String aveFault;//平均故障间隔
		List<Map<Integer,OsAvailabletemp>>stopSpacs=new ArrayList<Map<Integer,OsAvailabletemp>>();//故障间隔集合
		Map<Integer,OsAvailabletemp>stopSpacMap=new HashMap<Integer, OsAvailabletemp>();//故障间隔记录
		int listSize=osAvailabletemps.size();//记录长度
		int stopCount=0;//停机次数
		int stopSapcFlag=1;//故障标记 1 ：第一次故障| 2：第二次故障
		String lastStatus=osAvailabletemps.get(0).getStatus();//上一次状态 先记录第一次
		Date lastDate=osAvailabletemps.get(0).getSampleDate(); //上一次的时间 先记录第一次
		String thisStatus;//本次状态
		for (int i = 0;  i <= listSize-1; i++) {
			OsAvailabletemp osAvtemp=osAvailabletemps.get(i);
			thisStatus=osAvtemp.getStatus();
			if(i==0){//如果是第一次
//				 //第一次时间减0点
//				if(thisStatus.toString().equals("0")){//第一次为0 计入不可用时间
//					stopCount=stopCount+1;//记录停机数
//					canNoUseCount=osAvtemp.getSampleDate().getTime()-targetTime.getTime();
//					stopSpacMap.put(1, osAvtemp);
//				}else{
//					//计入可用时间 
//					canUseCount=osAvtemp.getSampleDate().getTime()-targetTime.getTime();
//				}
			}else{
				//不等于上次状态
				if(!thisStatus.toString().equals(lastStatus)){
					if(thisStatus.toString().equals("0")){//本次是0 上次是1  记为可用
						stopCount=stopCount+1;//本次为停机记录停机数
						nomorRun +=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
						if(stopSapcFlag==1){//如果为1是 两次故障间隔的 起点
							stopSpacMap.put(1, osAvtemp);
							stopSapcFlag=2;
						}else{//如果为1是 两次故障间隔的 终点
							stopSpacMap.put(2, osAvtemp);
							stopSapcFlag=1;
							stopSpacs.add(stopSpacMap);
						}
					}
					if(thisStatus.toString().equals("1")){//本次是1 上次是0 记为不可用
						crashtime+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
						repairTime+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();//回复时间
					}
				}else{
				//等于上次状态
					if(thisStatus.toString().equals("0")){//本次是0 上次是0  记为不可用
						crashtime+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
						stopCount=stopCount+1;
					}
					if(thisStatus.toString().equals("1")){//本次是1 上次是1  
						if(osAvtemp.getSampleDate().getTime()-osAvailabletemps.get(i-1).getSampleDate().getTime()>interCycleTime*60*1000){
							//如果相隔时间大于轮询时间则为不可用
							crashtime+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
							repairTime+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
							stopCount=stopCount+1;
						}else{
							nomorRun+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
						}
					}
				}
				lastDate=osAvtemp.getSampleDate();//记录上次时间
				lastStatus=thisStatus;//循环中上一次的状态记录
			}
		}
		long countTime=osAvailabletemps.get(listSize-1).getSampleDate().getTime()-targetTime.getTime();//总时间
		for (Map<Integer,OsAvailabletemp>  map : stopSpacs) {
			stopSpacCount+=map.get(2).getSampleDate().getTime()-map.get(1).getSampleDate().getTime();
		}
		if(stopCount!=0){
			 aveRepair=OsTransUtil.LongToHMS(repairTime/stopCount);//平均回复时间
			 aveFault=OsTransUtil.LongToHMS(repairTime/stopCount);//平均故障间隔
		}else{
			aveRepair=0+"";
			aveFault=0+"";
		}
		//正常运行时间计算
		System.out.println("总故障间隔"+stopSpacCount);
		System.out.println("故障次数"+stopCount);
		System.out.println("最后一个点时间"+osAvailabletemps.get(listSize-1).getSampleDate());
		System.out.println("最后一个点时间"+osAvailabletemps.get(listSize-1).getSampleDate().getTime());
		System.out.println("当前时间"+currentTime);
		System.out.println("当前时间"+currentTime.getTime());
		System.out.println("目标时间"+targetTime.getTime());
		System.out.println("目标时间"+targetTime);
		System.out.println(nomorRun);
		System.out.println(crashtime);
		System.out.println(countTime);
		System.out.println(repairTime);
		OsAvailable osAvailable=osAvailableServcie.getAvailable(osInfoId, timeSpan);
		if(osAvailable!=null){//判断是否修改
			osAvailableServcie.updateAvailable(osAvailable, normalRun(interCycleTime, countTime, nomorRun), OsTransUtil.LongToHMS(crashtime), aveRepair,  aveFault);
		}else{
			osAvailableServcie.saveAvailable(osInfoId, normalRun(interCycleTime, countTime, nomorRun), OsTransUtil.LongToHMS(crashtime), aveRepair,  aveFault, timeSpan);
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
		c.set(Calendar.DATE, currentTime.getDate());
		c.set(Calendar.HOUR_OF_DAY, currentTime.getHours());
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
		c.set(Calendar.DATE, currentTime.getDate());
		c.set(Calendar.HOUR_OF_DAY, currentTime.getHours());
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
		c.set(Calendar.DATE, currentTime.getDate());
		c.set(Calendar.HOUR_OF_DAY, currentTime.getHours());
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
		String diskUitliZatiionMax=osCpuService.getMaxCpuUtilZation(osInfoId, hourPoint, currentTime);
		String diskUitliZatiionMin=osCpuService.getMinCpuUtilZation(osInfoId, hourPoint, currentTime);
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
		c.set(Calendar.DATE, currentTime.getDate());
		c.set(Calendar.HOUR_OF_DAY, currentTime.getHours());
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
	public String  normalRun(int interCycleTime ,long countTime,long normrolRunTime){
		long interCycle =interCycleTime*60*1000+1;
		BigDecimal  normalRun;
		if(normrolRunTime+interCycle<=countTime){
			normalRun=BigDecimal.valueOf(normrolRunTime).divide(BigDecimal.valueOf(countTime),4,BigDecimal.ROUND_HALF_DOWN);
		}else{
			normalRun=BigDecimal.valueOf(normrolRunTime+interCycle).divide(BigDecimal.valueOf(countTime),4, BigDecimal.ROUND_HALF_DOWN);
		}
		return normalRun.multiply(BigDecimal.valueOf(100)).setScale(2).toString();
	}
}