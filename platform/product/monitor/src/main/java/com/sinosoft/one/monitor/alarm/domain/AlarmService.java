package com.sinosoft.one.monitor.alarm.domain;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void saveAlarm(Alarm alarm) {
		alarmRepository.save(alarm);
	}

	/**
	 * 根据监视器ID，查询当前天的监视器ID
	 * @param monitorId 监视器ID
	 * @return 所有告警信息
	 */
	public List<Alarm> queryCurrentDayAlarms(String monitorId) {
		return alarmRepository.findAlarmByMonitorId(monitorId, DateUtil.getCurrentBeginDate(), DateUtil.getCurrentEndDate());
	}
}
