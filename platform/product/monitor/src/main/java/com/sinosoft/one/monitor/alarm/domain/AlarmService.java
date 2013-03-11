package com.sinosoft.one.monitor.alarm.domain;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.resources.domain.ResourcesService;
import com.sinosoft.one.monitor.resources.model.Resource;
import com.sinosoft.one.monitor.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 处理告警信息业务逻辑类
 * User: carvin
 * Date: 13-3-1
 * Time: 上午10:33
 */
@Service
public class AlarmService {
	@Autowired
	private AlarmRepository alarmRepository;

    @Autowired
    private ResourcesService resourcesService;


	public void saveAlarm(Alarm alarm) {
		alarmRepository.save(alarm);
	}

	/**
	 * 根据监视器ID，查询当前天的alarm
	 * @param monitorId 监视器ID
	 * @return 所有告警信息
	 */
	public List<Alarm> queryCurrentDayAlarmsByResourceId(String monitorId) {
        List<Alarm>  alarms = alarmRepository.findAlarmByMonitorId(monitorId,
                DateUtil.getTodayBeginDate(), DateUtil.getTodayEndDate());
        return fillAlarm(alarms);
	}

    /**
     *
      * @return
     */
    public List<Alarm> queryCurrentDayAlarms( String givenTime, String givenType){
        Assert.hasText(givenTime);
        Assert.hasText(givenType);
        List<Alarm>  alarms = alarmRepository.findAlarmsWithGivenTimeAndType(givenTime,givenType);
        return fillAlarm(alarms);
    }

    private List<Alarm> fillAlarm(List<Alarm>  alarms){
        for(Alarm alarm:alarms){
            Resource resource =  resourcesService.getResource(alarm.getMonitorId());
            if(resource == null)
                throw new RuntimeException("资源Id："+alarm.getMonitorId()+"获取不到相关resource，请检查");
            alarm.setAppName(resource.getResourceName());
        }
        return alarms;
    }


    /**
     * 获取最近的50条记录，按记录时间排序
     * @return
     */
    public List<Alarm> queryLatestAlarmsRowsFifty(){
        Sort desc = new Sort(Sort.Direction.DESC,"createTime");
        PageRequest pageRequest = new PageRequest(0,50,desc);
        List<Alarm>  alarms =   alarmRepository.findAll(pageRequest).getContent();
        return  fillAlarm(alarms);
    }
}
