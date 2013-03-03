package com.sinosoft.one.monitor.db.oracle.domain;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.db.oracle.model.*;
import com.sinosoft.one.monitor.db.oracle.repository.AvaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.AvaStaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.InfoRepository;
import com.sinosoft.one.monitor.db.oracle.repository.LasteventRepository;
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

    @Override
    public List<OracleAvaInfoModel> avaInfoList(String totalTime) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "sysTime"));
        List<Info> infoList = (List<Info>) infoRepository.findAll(sort);
        List<OracleAvaInfoModel> oracleAvaInfoModelList = new ArrayList<OracleAvaInfoModel>();

        for (Info info : infoList) {
            OracleAvaInfoModel oracleAvaInfoModel = new OracleAvaInfoModel();
            AvaSta avaSta = avaStaRepository.findAvaSta(info.getId());
            oracleAvaInfoModel.setMonitorID(info.getId());
            oracleAvaInfoModel.setMonitorName(info.getName());
            double avaRate = avaSta.getNormalRuntime() / (avaSta.getNormalRuntime() + avaSta.getTotalPoweroffTime());
            oracleAvaInfoModel.setAvaRate(avaRate + "");
            Sort sort1 = new Sort(new Sort.Order(Sort.Direction.ASC, "recordTime"));
            List<Ava> avaList = (List<Ava>) avaRepository.findAll(sort1);
            List<String[]> parts = new ArrayList<String[]>();
            for (int i = 0; i < avaList.size() - 1; i++) {
                Ava start = avaList.get(i);
                Ava end = avaList.get(i + 1);
                String[] part = new String[2];
                part[0] = (end.getRecordTime().getTime() - start.getRecordTime().getTime()) + "";
                part[1] = start.getState();
                parts.add(part);
            }
            oracleAvaInfoModel.setGraphInfo(parts);
            oracleAvaInfoModelList.add(oracleAvaInfoModel);
        }
        return oracleAvaInfoModelList;
    }

    @Override
    public List<OracleHealthInfoModel> healthInfoList(StaTimeEnum staTimeEnum) {

        List<OracleHealthInfoModel> oracleHealthInfoModelList = new ArrayList<OracleHealthInfoModel>();
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "sysTime"));
        List<Info> infoList = (List<Info>) infoRepository.findAll(sort);
        Date endTime = new Date();
        Date startTime  = StaTimeEnum.getTime(staTimeEnum,endTime);
        for(Info info:infoList){
            String monitorId = info.getId();
            List<Alarm> alarmList = alarmRepository.findAlarmByMonitorId(monitorId,startTime,endTime);
            OracleHealthInfoModel oracleHealthInfoModel = new OracleHealthInfoModel();
            oracleHealthInfoModel.setMonitorID(monitorId);
            oracleHealthInfoModel.setMonitorName(info.getName());
            //oracleHealthInfoModel.setGraphInfo();
            oracleHealthInfoModelList.add(oracleHealthInfoModel);
        }
        return oracleHealthInfoModelList;
    }
    private List<String[]> getHealthyState(List<Alarm> alarmList){

         for(Alarm alarm:alarmList){

         }
        return null;
    }
    @Override
    public List<OracleStaBaseInfoModel> listStaBaseInfo(String monitorType) {
        List<OracleStaBaseInfoModel> oracleStaBaseInfoModelList = new ArrayList<OracleStaBaseInfoModel>();
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "sysTime"));
        List<Info> infoList = (List<Info>) infoRepository.findAll(sort);
        for(Info info:infoList){
            OracleStaBaseInfoModel oracleStaBaseInfoModel = new OracleStaBaseInfoModel();
            oracleStaBaseInfoModel.setMonitorID(info.getId());
            oracleStaBaseInfoModel.setMonitorName(info.getName());
            String state = avaRepository.findState();
            oracleStaBaseInfoModel.setUsability(state);
            //oracleStaBaseInfoModel.setHealthy();
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
        calendar.add(Calendar.HOUR_OF_DAY,-3);
        Date start = calendar.getTime();
        for(Info info:infoList){
            StaGraphModel staGraphModel = new StaGraphModel();
            String monitorId = info.getId();
            staGraphModel.setId(monitorId);
            staGraphModel.setName(info.getName());
            List<Lastevent> lasteventList = lasteventRepository.findLastEventList(monitorId,start,end);
            staGraphModel.setLasteventList(lasteventList);
            totalStaGraphModelList.add(staGraphModel);
        }
        return totalStaGraphModelList;
    }
}
