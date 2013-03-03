package com.sinosoft.one.monitor.alarm.domain;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
