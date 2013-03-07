package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.application.model.UrlResponseTime;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationDetailAlarmViewModel;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationDetailPieViewModel;
import com.sinosoft.one.monitor.application.repository.UrlResponseTimeRepository;
import com.sinosoft.one.monitor.common.HealthSta;
import com.sinosoft.one.monitor.common.HealthStaCache;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import com.sinosoft.one.monitor.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 应用明细服务类.
 * User: carvin
 * Date: 13-3-6
 * Time: 下午8:18
 */
@Service
public class ApplicationDetailService {
	@Autowired
	private AlarmRepository alarmRepository;
	@Autowired
	private UrlResponseTimeRepository urlResponseTimeRepository;
	@Autowired
	private HealthStaCache healthStaCache;


	/**
	 * 生成应用明细告警展示信息
	 * @param applicationId 所属应用ID
	 * @return 告警展示信息
	 */
	public ApplicationDetailAlarmViewModel generateAlarmViewModel(String applicationId) {
		Date startDate = DateUtil.getTodayBeginDate();
		Date endDate = new Date();

		ApplicationDetailAlarmViewModel applicationDetailAlarmViewModel = new ApplicationDetailAlarmViewModel();
		// 获得可用性

		// 获得健康度
		Pageable pageable = new PageRequest(0, 1, Sort.Direction.DESC, "create_time");
		Page<Alarm> alarmPage = alarmRepository.selectAlarmsByMonitorId(pageable, applicationId, startDate, endDate);
		Iterator<Alarm> alarmIterator = alarmPage.iterator();
		Alarm alarm = null;
		if(alarmIterator.hasNext()) {
			alarm = alarmPage.iterator().next();
		}
		applicationDetailAlarmViewModel.setSeverityLevel(alarm == null ? SeverityLevel.INFO : alarm.getSeverity());

		pageable = new PageRequest(0, 10, Sort.Direction.DESC, "create_time");
		alarmPage = alarmRepository.selectCriticalAlarmsByMonitorId(pageable, applicationId, startDate, endDate);
		alarmIterator = alarmPage.iterator();
		while (alarmIterator.hasNext()) {
			applicationDetailAlarmViewModel.addAlarmInfo(alarmIterator.next().getMessage());
		}
		int criticalCount = alarmRepository.countCriticalByMonitorId(applicationId, startDate, endDate);
		applicationDetailAlarmViewModel.setCriticalCount(criticalCount);
		return applicationDetailAlarmViewModel;
	}

	/**
	 * 生成应用饼图展示信息
	 * @param applicationId 所属应用ID
	 * @return 饼图展示信息
	 */
	public ApplicationDetailPieViewModel generatePieViewModel(String applicationId) {
		ApplicationDetailPieViewModel applicationDetailPieViewModel = new ApplicationDetailPieViewModel();
		Date startDate = DateUtil.getTodayBeginDate();
		Date endDate = new Date();
		List<HealthSta> healthStas = alarmRepository.selectHealthStaForMonitor(applicationId, startDate, endDate);
		for(HealthSta healthSta : healthStas) {
			if(healthSta.getSeverity() == SeverityLevel.CRITICAL) {
				applicationDetailPieViewModel.setCriticalCount(healthSta.getCount());
			} else if(healthSta.getSeverity() == SeverityLevel.WARNING) {
				applicationDetailPieViewModel.setWarningCount(healthSta.getCount());
			} else if(healthSta.getSeverity() == SeverityLevel.INFO) {
				applicationDetailPieViewModel.setNormalCount(healthSta.getCount());
			}
		}

		return applicationDetailPieViewModel;
	}

	public List<UrlResponseTime> queryUrlResponseTimes(String applicationId) {
		Date startDate = DateUtil.getTodayBeginDate();
		Date endDate = new Date();
		List<UrlResponseTime> urlResponseTimes = urlResponseTimeRepository.selectUrlResponseTimesForMonitorUrl(applicationId, startDate, endDate);
		for(UrlResponseTime urlResponseTime : urlResponseTimes) {
			urlResponseTime.setHealthBar(healthStaCache.getHealthBar(applicationId, urlResponseTime.getUrlId()));
		}
		return urlResponseTimes;
	}

}
