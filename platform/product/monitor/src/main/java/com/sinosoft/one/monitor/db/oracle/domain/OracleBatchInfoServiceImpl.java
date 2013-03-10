package com.sinosoft.one.monitor.db.oracle.domain;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.db.oracle.model.*;
import com.sinosoft.one.monitor.db.oracle.repository.AvaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.AvaStaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.InfoRepository;
import com.sinosoft.one.monitor.db.oracle.repository.LasteventRepository;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * User: Chunliang.Han
 * Date: 13-3-2
 * Time: 下午8:17
 */
@Component
public class OracleBatchInfoServiceImpl implements OracleBatchInfoService {
    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private AvaStaRepository avaStaRepository;
    @Autowired
    private AvaRepository avaRepository;
    @Autowired
    private LasteventRepository lasteventRepository;
    @Autowired
    private AlarmRepository alarmRepository;

    /**
     * 最近24小时可用性统计
     * 最近30天可用性统计（目前尚未实现）
     *
     * @param staTimeEnum
     * @return
     */
    @Override
    public List<OracleAvaInfoModel> avaInfoList(StaTimeEnum staTimeEnum) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "sysTime"));
        List<Info> infoList = (List<Info>) infoRepository.findAll(sort);
        List<OracleAvaInfoModel> oracleAvaInfoModelList = new ArrayList<OracleAvaInfoModel>();
        Date now = new Date();
        Date timeStart =  StaTimeEnum.getTime(staTimeEnum,now);
        double total = 0;
        double during =  (now.getTime()-timeStart.getTime())/100;
        for (Info info : infoList) {
            OracleAvaInfoModel oracleAvaInfoModel = new OracleAvaInfoModel();
            AvaSta avaSta = avaStaRepository.findAvaSta(info.getId());
            oracleAvaInfoModel.setMonitorID(info.getId());
            oracleAvaInfoModel.setMonitorName(info.getName());
            double avaRate = avaSta.getNormalRuntime() / ((avaSta.getNormalRuntime() + avaSta.getTotalPoweroffTime())/1.0);
            oracleAvaInfoModel.setAvaRate(avaRate + "");
            if(staTimeEnum==StaTimeEnum.LAST_24HOUR){
                Sort sort1 = new Sort(new Sort.Order(Sort.Direction.ASC, "recordTime"));
                List<Ava> avaList0 = (List<Ava>) avaRepository.findAll(sort1);
                List<Ava> avaList = caculate(avaList0);
                List<String[]> parts = new ArrayList<String[]>();
                for (int i = 0; i < avaList.size() - 1; i++) {
                    Ava start = avaList.get(i);
                    Ava end = avaList.get(i + 1);
                    long startTime = timeStart.getTime();
                    if(startTime-start.getRecordTime().getTime()>0){
                        continue;
                    }
                    String[] part = new String[3];
                    long len = start.getRecordTime().getTime()-startTime-start.getInterval()*60000;
                    if(i==0&&len>1000){
                        part[0] = startTime+"";
                        part[1] = "2";
                        part[2] = ((start.getRecordTime().getTime()-startTime)/during)+"";
                        parts.add(part);
                        total += start.getRecordTime().getTime()-startTime;
                        continue;
                    }
                    String[] part1 = new String[3];
                    part1[0] = start.getRecordTime().getTime()+"";
                    part1[1] = start.getState();
                    part1[2] = ((end.getRecordTime().getTime()-start.getRecordTime().getTime())/during)+"";
                    total += end.getRecordTime().getTime()-start.getRecordTime().getTime();
                    parts.add(part1);
                }
                Ava ava = avaList.get(avaList.size()-1);
                String[] part = new String[3];
                part[0] = ava.getRecordTime().getTime()+"";
                part[1] = ava.getState();
                long lastTime = ava.getRecordTime().getTime()+ava.getInterval()*60000;
                if(now.getTime()<=lastTime+1000){
                    part[2] = ((now.getTime()-ava.getRecordTime().getTime())/during)+"";
                    parts.add(part) ;
                }else {
                    part[2] = ava.getInterval()*60000/during+"";
                    parts.add(part);
                    String[] part1 = new String[3];
                    part1[0] = lastTime+"";
                    part1[1] = "2";
                    part1[2] = (now.getTime()-lastTime )/during +"";
                    parts.add(part1) ;
                }
                total = total+ now.getTime()-ava.getRecordTime().getTime();
                oracleAvaInfoModel.setGraphInfo(parts);
                oracleAvaInfoModelList.add(oracleAvaInfoModel);
            }
        }
        double rate = total/during;
        System.out.print(rate);
        return oracleAvaInfoModelList;
    }
    private List<Ava> caculate(List<Ava> avaList){
        List<Ava> avas = new ArrayList<Ava>();
        for(int i=0;i<avaList.size()-1;i++){
            int j=i;
            int flag = 0;
            while(j+1<avaList.size()&&avaList.get(j).getState().equals(avaList.get(j+1).getState())){
                long interval = avaList.get(j).getInterval()*60000;
                long recordTime = avaList.get(j).getRecordTime().getTime();
                long nextTime =  avaList.get(j+1).getRecordTime().getTime();
                j++;
                if(nextTime-recordTime>interval+1000){
                    flag = 1;
                    j--;
                    break;
                }
            }
            if(flag == 0){
                Ava ava = new Ava();
                ava.setState(avaList.get(i).getState());
                ava.setRecordTime(avaList.get(i).getRecordTime());
                avas.add(ava);
            } else {
                Ava ava = new Ava();
                ava.setState(avaList.get(i).getState());
                ava.setRecordTime(avaList.get(i).getRecordTime());
                avas.add(ava);
                Ava ava1 = new Ava();
                ava1.setState("2");
                ava1.setRecordTime(new Date(avaList.get(j).getRecordTime().getTime()+avaList.get(j).getInterval()*60000));
                avas.add(ava1);
            }
            i = j;
        }
        return avas;
    }
    @Override
    public List<OracleHealthInfoModel> healthInfoList(StaTimeEnum staTimeEnum) {

        List<OracleHealthInfoModel> oracleHealthInfoModelList = new ArrayList<OracleHealthInfoModel>();
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "sysTime"));
        List<Info> infoList = (List<Info>) infoRepository.findAll(sort);
        Date endTime = new Date();
        Date startTime = StaTimeEnum.getTime(staTimeEnum, endTime);
        for (Info info : infoList) {
            String monitorId = info.getId();
            List<Alarm> alarmList = alarmRepository.findAlarmByMonitorId(monitorId, startTime, endTime);
            OracleHealthInfoModel oracleHealthInfoModel = new OracleHealthInfoModel();
            oracleHealthInfoModel.setMonitorID(monitorId);
            oracleHealthInfoModel.setMonitorName(info.getName());
            List<String[]> alarms = getHealthyState(alarmList, staTimeEnum, startTime, endTime);
            oracleHealthInfoModel.setGraphInfo(alarms);
            oracleHealthInfoModelList.add(oracleHealthInfoModel);
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

    private void pullDateMapListBycalendar(List<Long[]> dateMapList, Date startTime,
                                           Date currTime, Calendar calendar, int timeGranularity) {
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

    @Override
    public List<OracleStaBaseInfoModel> listStaBaseInfo() {
        List<OracleStaBaseInfoModel> oracleStaBaseInfoModelList = new ArrayList<OracleStaBaseInfoModel>();
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "sysTime"));
        List<Info> infoList = (List<Info>) infoRepository.findAll(sort);
        for (Info info : infoList) {
            OracleStaBaseInfoModel oracleStaBaseInfoModel = new OracleStaBaseInfoModel();
            oracleStaBaseInfoModel.setMonitorID(info.getId());
            oracleStaBaseInfoModel.setMonitorName(info.getName());
            //查询数据库得到当前是否可连接
            String state = avaRepository.findState();
            oracleStaBaseInfoModel.setUsability(state);
            //获取5分钟前到现在报警信息
            Date endTime = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            calendar.add(Calendar.MINUTE, (int) -info.getPullInterval());
            Date startTime = calendar.getTime();
            //根据报警信息接确定当前是否可用
            String[] healthyPint = new String[2];
            String healthyFlag = "1";
            StringBuilder msg = new StringBuilder();
            //"1"代表可用，"0"代表不可用
            if("0".equals(state)){
                healthyPint[0] = "3";
                healthyPint[1] = msg.append(info.getName()).append("为停止").toString();
            } else {
                List<Alarm> alarmList = alarmRepository.findAlarmByMonitorId(info.getId(), startTime, endTime);
                for (Alarm alarm : alarmList) {
                    if (alarm.getSeverity() != null) {
                        msg.append(alarm.getMessage()).append("\n");
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
                healthyPint[1] = msg.toString();
            }
            //插入可用性
            oracleStaBaseInfoModel.setHealthy(healthyPint);
            oracleStaBaseInfoModelList.add(oracleStaBaseInfoModel);
        }
        return oracleStaBaseInfoModelList;
    }

    @Override
    public List<StaGraphModel> listMonitorEventSta() {
        List<StaGraphModel> totalStaGraphModelList = new ArrayList<StaGraphModel>();
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "sysTime"));
        List<Info> infoList = (List<Info>) infoRepository.findAll(sort);
        Date end = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -3);
        Date start = calendar.getTime();
        for (Info info : infoList) {
            StaGraphModel staGraphModel = new StaGraphModel();
            String monitorId = info.getId();
            staGraphModel.setId(monitorId);
            staGraphModel.setName(info.getName());
            List<Lastevent> lasteventList = lasteventRepository.findLastEventList(monitorId, start, end);
            staGraphModel.setLasteventList(lasteventList);
            totalStaGraphModelList.add(staGraphModel);
        }
        return totalStaGraphModelList;
    }
}
