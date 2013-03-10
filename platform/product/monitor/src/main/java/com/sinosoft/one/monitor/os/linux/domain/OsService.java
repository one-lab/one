package com.sinosoft.one.monitor.os.linux.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.domain.TimeGranularityEnum;
import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.model.OracleHealthInfoModel;
import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsShell;
import com.sinosoft.one.monitor.os.linux.model.viewmodel.OsHealthModel;
import com.sinosoft.one.monitor.os.linux.repository.OsRepository;
import com.sinosoft.one.monitor.os.linux.repository.OsShellRepository;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
/**
 * 数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
@Component
public class OsService {
	@Autowired
	private OsRepository osRepository;
	@Autowired
	private OsShellRepository osShellRepository;
	
	@Autowired
	private AlarmRepository alarmRepository;
	/**
	 * 读取操作系统基本信息
	 * @return
	 */
	public Os getOsBasicByIp(String ip){
		return  osRepository.findOsbyIp(ip);
	}

	/**
	 * 判断IP是否已有
	 * @param ip
	 * @return
	 */
	public boolean checkOsByIp(String ip){
		int ipcount=osRepository.checkOsByIp(ip);
		if(ipcount>0){
			return false;
		}
		return true;
	}
	/**
	 * 读取操作系统基本信息
	 * @return
	 */
	public Os getOsBasicById(String id){
		Os os=osRepository.findOne(id);
		return  os;
	}
	/**
	 * 保存操作系统基本信息
	 * @return
	 * @throws Exception 
	 */
	public void saveOsBasic(String name,String type,String ipAddr,String subnetMask,int interCycle) throws Exception{
		Os os=osRepository.findOsbyIp(ipAddr);
		if(os!=null){
			 throw new Exception();
		}
		Os newos =new Os();
		newos.setName(name);
		newos.setType(type);
		newos.setIpAddr(ipAddr);
		newos.setSubnetMask(subnetMask);
		newos.setIntercycleTime(interCycle);
		osRepository.save(newos);
	}
	
	/**
	 * 删除操作系统基本信息
	 * @return
	 */
	public void deleteOsBasic(String osId){
		try {
			osRepository.delete(osId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	/**
	 * 读取操作系统基本脚本
	 * @return
	 */
	public List<OsShell> getOsShell(){
		return osShellRepository.findShell();
	}
	
	/**
	 * 保存操作系统基本脚本
	 */
	public void saveShell(String type,String template){
		OsShell osShell=new OsShell();
		osShell.setType(type);
		osShell.setTemplate(template);
		osShellRepository.save(osShell);
	}
	
	/**
	 * 获取所有OS监控器信息
	 * @return
	 */
	public List<Os> getAllOs(){
		return (List<Os>) osRepository.findAll();
	}
	
	 public List<OsHealthModel> healthInfoList(List<Os> oss,Date beingTime,Date endTime ,StaTimeEnum staTimeEnum) {
		List<OsHealthModel> oracleHealthInfoModelList = new ArrayList<OsHealthModel>();
		for (Os os : oss) {
			List<Alarm> alarmList = alarmRepository.findAlarmByMonitorId(
					os.getOsInfoId(), beingTime, endTime);
			OsHealthModel osHealthModel = new OsHealthModel();
			osHealthModel.setMonitorID(os.getOsInfoId());
			osHealthModel.setMonitorName(os.getName());
			List<String[]> alarms = getHealthyState(alarmList, staTimeEnum,
					beingTime, endTime);
			osHealthModel.setGraphInfo(alarms);
			oracleHealthInfoModelList.add(osHealthModel);
		}
		
		return oracleHealthInfoModelList;
	 }
	 
	  /**
	     * 获取时间段内各个点的健康状况
	     *
	     * @param alarmList
	     * @param staTimeEnum
	     * @param startTime
	     * @param currTime
	     * @return
	     */
	    private List<String[]> getHealthyState(List<Alarm> alarmList, StaTimeEnum staTimeEnum, Date startTime, Date currTime) {
	        List<String[]> healthy = new ArrayList<String[]>();
	        List<Long[]> dateMapList = new ArrayList<Long[]>();
	        //如果统计24小时的健康状况
	        if (staTimeEnum.equals(StaTimeEnum.LAST_24HOUR)) {
	            pullDateMapList(dateMapList, startTime, currTime, TimeGranularityEnum.HOUR);
	            for (Long[] dateMap : dateMapList) {
	                String[] healthyPint = new String[2];
	                String healthyFlag = "1";
	                StringBuilder info = new StringBuilder();
	                long start = dateMap[0];
	                long end = dateMap[1];
	                for (Alarm alarm : alarmList) {
	                    Date recordTime = alarm.getCreateTime();
	                    long recordTimeNumber = recordTime.getTime();
	                    if (recordTimeNumber < start) {
	                        continue;
	                    } else if (recordTimeNumber >= end) {
	                        break;
	                    } else if (alarm.getSeverity() != null) {

	                        info.append(alarm.getMessage()).append("\n");
	                        if (alarm.getSeverity().equals(SeverityLevel.INFO)) {
	                            healthyFlag = "1";
	                        } else if (alarm.getSeverity().equals(SeverityLevel.WARNING)) {
	                            healthyFlag = "2";
	                        } else if (alarm.getSeverity().equals(SeverityLevel.CRITICAL)) {
	                            healthyFlag = "3";
	                        } else if (alarm.getSeverity().equals(SeverityLevel.UNKNOW)) {
	                            healthyFlag = "4";
	                        }
	                    }
	                }
	                healthyPint[0] = healthyFlag;
	                healthyPint[1] = info.toString();
	                healthy.add(healthyPint);
	            }
	        }
	        //如果统计30天的健康状况
	        else if (staTimeEnum.equals(StaTimeEnum.LAST_30DAY)) {
	            pullDateMapList(dateMapList, startTime, currTime, TimeGranularityEnum.DAY);
	            for (Long[] dateMap : dateMapList) {
	                String[] healthyPint = new String[2];
	                String healthyFlag = "1";
	                StringBuilder info = new StringBuilder();
	                long start = dateMap[0];
	                long end = dateMap[1];
	                for (Alarm alarm : alarmList) {
	                    Date recordTime = alarm.getCreateTime();
	                    long recordTimeNumber = recordTime.getTime();
	                    if (recordTimeNumber < start) {
	                        continue;
	                    } else if (recordTimeNumber >= end) {
	                        break;
	                    } else if (alarm.getSeverity() != null) {

	                        info.append(alarm.getMessage()).append("\n");
	                        if (alarm.getSeverity().equals(SeverityLevel.INFO)) {
	                            healthyFlag = "1";
	                        } else if (alarm.getSeverity().equals(SeverityLevel.WARNING)) {
	                            healthyFlag = "2";
	                        } else if (alarm.getSeverity().equals(SeverityLevel.CRITICAL)) {
	                            healthyFlag = "3";
	                        } else if (alarm.getSeverity().equals(SeverityLevel.UNKNOW)) {
	                            healthyFlag = "4";
	                        }
	                    }
	                }
	                healthyPint[0] = healthyFlag;
	                healthyPint[1] = info.toString();
	                healthy.add(healthyPint);
	            }
	        }
	        return healthy;
	    }
	    /**
	     * @param dateMapList 要装的时间段集合
	     * @param startTime   开始时间
	     * @param currTime    结束时间
	     * @param currTime    timeGranularityEnum 时间粒度
	     */
	    private void pullDateMapList(List<Long[]> dateMapList, Date startTime,
	                                 Date currTime, TimeGranularityEnum timeGranularityEnum) {
	        Calendar calendar = Calendar.getInstance();
	        switch (timeGranularityEnum) {
	            case HOUR: {
	                pullDateMapListBycalendar(dateMapList, startTime, currTime, calendar, Calendar.HOUR_OF_DAY);
	                break;
	            }
	            case DAY: {
	                pullDateMapListBycalendar(dateMapList, startTime, currTime, calendar, Calendar.DATE);
	                break;
	            }
	        }
	    }
	    
	private void pullDateMapListBycalendar(List<Long[]> dateMapList,
			Date startTime, Date currTime, Calendar calendar,
			int timeGranularity) {
		long start = startTime.getTime();
		long end = currTime.getTime();
		while (start < end) {
			calendar.setTimeInMillis(start);
			calendar.add(timeGranularity, 1);
			Long[] dateMap = new Long[2];
			dateMap[0] = start;
			start = calendar.getTime().getTime();
			dateMap[1] = start;
			dateMapList.add(dateMap);
		}
}
}
