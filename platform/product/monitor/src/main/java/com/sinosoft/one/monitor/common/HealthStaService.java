package com.sinosoft.one.monitor.common;

import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康状况服务类
 * User: carvin
 * Date: 13-3-8
 * Time: 上午11:42
 */
@Service
public class HealthStaService {
	@Autowired
	private AlarmRepository alarmRepository;

	/**
	 * 根据天数得到健康度Map
	 * @param monitorId 监视器ID
	 * @param days 天
	 * @return 健康度Map
	 */
	public Map<Integer, SeverityLevel> healthStaForDays(String monitorId, int days) {
		Date startDate = null;
		Date endDate = null;
		if(days == 1) {
			startDate = LocalDate.now().toDate();
			endDate = LocalDateTime.now().toDate();
		} else {
			startDate = LocalDate.now().minusDays(days).toDate();
			endDate = LocalDateTime.now().toDate();
		}
		List<HealthStaForTime> healthStaForTimeList = alarmRepository.selectHealthStaForDay(monitorId, startDate, endDate);
		return generateHealthStaMap(healthStaForTimeList);
	}

	/**
	 * 根据小时数得到健康度Map
	 * @param monitorId 监控器ID
	 * @param hours 小时数
	 * @return 健康度Map
	 */
	public Map<Integer, SeverityLevel> healthStaForHours(String monitorId, int hours) {
		LocalDateTime localDateTime = LocalDateTime.now();
		Date startDate =  localDateTime.minusHours(hours).toDate();
		Date endDate = localDateTime.toDate();
		List<HealthStaForTime> healthStaForTimeList = alarmRepository.selectHealthStaForHour(monitorId, startDate, endDate);
		return generateHealthStaMap(healthStaForTimeList);
	}

	private Map<Integer, SeverityLevel> generateHealthStaMap(List<HealthStaForTime> healthStaForTimes) {
		Map<Integer, HealthStaForTime> healthStaForTimeMap = new HashMap<Integer, HealthStaForTime>();

		for(HealthStaForTime healthStaForTime : healthStaForTimes) {
			int timeIndex = healthStaForTime.getTimeIndex();
			if(healthStaForTimeMap.containsKey(timeIndex)) {
				HealthStaForTime targetHealthStaForTime = healthStaForTimeMap.get(timeIndex);
				if(healthStaForTime.getSeverity() == SeverityLevel.CRITICAL) {
					targetHealthStaForTime.setCriticalCount(healthStaForTime.getCount());
				} else if(healthStaForTime.getSeverity() == SeverityLevel.WARNING) {
					targetHealthStaForTime.setWarningCount(healthStaForTime.getCount());
				} else if(healthStaForTime.getSeverity() == SeverityLevel.INFO) {
					targetHealthStaForTime.setNormalCount(healthStaForTime.getCount());
				}
			} else {
				healthStaForTimeMap.put(timeIndex, healthStaForTime);
			}
		}

		Map<Integer, SeverityLevel> result = new HashMap<Integer, SeverityLevel>();
		for(Integer key : healthStaForTimeMap.keySet()) {
			result.put(key, healthStaForTimeMap.get(key).getSeverityLevel());
		}
		return result;
	}
}
