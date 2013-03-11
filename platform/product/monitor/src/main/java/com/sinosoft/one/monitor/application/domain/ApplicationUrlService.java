package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.application.model.*;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationUrlCountViewModel;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationUrlHealthAvaViewModel;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationUrlInfoViewModel;
import com.sinosoft.one.monitor.application.model.viewmodel.UrlTraceLogViewModel;
import com.sinosoft.one.monitor.application.repository.*;
import com.sinosoft.one.monitor.common.HealthStaService;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.common.Trend;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 应用URL服务类
 * User: carvin
 * Date: 13-3-9
 * Time: 下午12:51
 *
 */
@Service
public class ApplicationUrlService {
	@Autowired
	private HealthStaService healthStaService;
	@Autowired
	private ApplicationEmuService applicationEmuService;
	@Autowired
	private UrlResponseTimeRepository urlResponseTimeRepository;
	@Autowired
	private UrlVisitsStaRepository urlVisitsStaRepository;
	@Autowired
	private UrlTraceLogRepository urlTraceLogRepository;
	@Autowired
	private MethodResponseTimeRepository methodResponseTimeRepository;
	@Autowired
	private AlarmRepository alarmRepository;
	@Autowired
	private MethodRepository methodRepository;

	public ApplicationUrlInfoViewModel generateUrlInfoViewModel(String applicationId, String urlId) {
		// 获得健康度
		SeverityLevel severityLevel  = SeverityLevel.UNKNOW;
		Date startDate = LocalDate.now().toDate();
		Date endDate = LocalDateTime.now().toDate();
		int criticalCount = alarmRepository.countCriticalBySubReousrce(applicationId, ResourceType.APPLICATION_SCENARIO_URL.name(),
				urlId, startDate, endDate);
		if(criticalCount > 0) {
			severityLevel = SeverityLevel.CRITICAL;
		} else {
			int warningCount = alarmRepository.countWarningBySubReousrce(applicationId,  ResourceType.APPLICATION_SCENARIO_URL.name(),
					urlId, startDate, endDate);
			if(warningCount > 0) {
				severityLevel = SeverityLevel.WARNING;
			} else {
				severityLevel = SeverityLevel.INFO;
			}
		}

		// 获得可用性信息
		UrlAvailableInf urlAvailableInf = applicationEmuService.getUrlAvailableToday(urlId);

		ApplicationUrlInfoViewModel applicationUrlInfoViewModel = new ApplicationUrlInfoViewModel();
		applicationUrlInfoViewModel.setHealth(severityLevel == SeverityLevel.INFO ? "cando" : "cannot");
		applicationUrlInfoViewModel.setAvailability(urlAvailableInf.getTrend() != Trend.DROP ? "up" : "down");
		applicationUrlInfoViewModel.setTodayAvailability(urlAvailableInf.getCount() == 0 ? "0" :
				BigDecimal.valueOf(urlAvailableInf.getAvailableCount()).divide(BigDecimal.valueOf(urlAvailableInf.getCount()), 2, RoundingMode.HALF_UP)
				.multiply(BigDecimal.valueOf(100)).toString()
		);
		applicationUrlInfoViewModel.setLatestFailTime(urlAvailableInf.getLatestTime() == null ? "未知" :
				LocalDateTime.fromDateFields(urlAvailableInf.getLatestTime()).toString("yyyy-MM-dd HH:mm:ss"));
		applicationUrlInfoViewModel.setTodayRunningTime(urlAvailableInf.getRunningTime() + "");
		return applicationUrlInfoViewModel;
	}

	public ApplicationUrlHealthAvaViewModel generateUrlHealthAndAvaStaViewModel(String applicationId, String urlId) {
		ApplicationUrlHealthAvaViewModel applicationUrlHealthAvaViewModel = new ApplicationUrlHealthAvaViewModel();
		// 获得最近6小时健康度
		LocalDateTime localDateTime = LocalDateTime.now();

		for(int i=6; i>=1; i--) {
			applicationUrlHealthAvaViewModel.addTime(localDateTime.minusHours(i).toString("HH") + ":00");
		}
		Map<Integer, SeverityLevel> severityLevelMap = healthStaService.healthStaForHours(applicationId, ResourceType.APPLICATION_SCENARIO_URL.name(),
				urlId, 6);
		for(Integer key : severityLevelMap.keySet()) {
			String tempTime = key > 10 ? key + ":00" : "0" + key + ":00";
			applicationUrlHealthAvaViewModel.addUrlHealth(tempTime, severityLevelMap.get(key).name());
		}
		// 获得可用性信息
		List<TimeQuantumAvailableInfo> timeQuantumAvailableInfoList = applicationEmuService.findAvailableStatisticsByUrlId(urlId);

		for(TimeQuantumAvailableInfo timeQuantumAvailableInfo : timeQuantumAvailableInfoList) {
			String tempTime = timeQuantumAvailableInfo.getTimeQuantum();
			tempTime = tempTime.substring(tempTime.indexOf(" ") + 1) + ":00";
			applicationUrlHealthAvaViewModel.addUrlAva(tempTime, evalPercent(timeQuantumAvailableInfo.getAvaCount(), timeQuantumAvailableInfo.getCount())
					+ ":" + evalPercent(timeQuantumAvailableInfo.getFailCount(), timeQuantumAvailableInfo.getCount()));
		}

		return applicationUrlHealthAvaViewModel;
	}

	private BigDecimal evalPercent(int count, int totalCount) {
		if(totalCount == 0) return BigDecimal.ZERO;
		return BigDecimal.valueOf(count).divide(BigDecimal.valueOf(totalCount), 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
	}

	public ApplicationUrlCountViewModel generateUrlCountStaViewModel(String applicationId, String urlId) {
		ApplicationUrlCountViewModel applicationUrlCountViewModel = new ApplicationUrlCountViewModel();
		LocalDateTime localDateTime = LocalDateTime.now();
		Date endDate = localDateTime.toDate();
		Date startDate = localDateTime.minusHours(6).toDate();

		for(int i=6; i>=1; i--) {
			applicationUrlCountViewModel.addTime(localDateTime.minusHours(i).toString("HH") + ":00");
		}

		// 获得最近6小时响应时间
		List<UrlResponseTime> urlResponseTimes = urlResponseTimeRepository.selectUrlResponseTimes(applicationId, urlId, startDate, endDate);
		for(UrlResponseTime urlResponseTime : urlResponseTimes) {
			String tempTime = DateFormatUtils.format(urlResponseTime.getRecordTime(), "HH:00");
			applicationUrlCountViewModel.addUrlResponseTime(tempTime, urlResponseTime.getAvgResponseTime());
		}
		// 获得最近6小时访问数量
		List<UrlVisitsSta> urlVisitsStas = urlVisitsStaRepository.selectUrlVisitsSta(applicationId, urlId, startDate, endDate);
		for(UrlVisitsSta urlVisitsSta : urlVisitsStas) {
			String tempTime = DateFormatUtils.format(urlVisitsSta.getRecordTime(), "HH:00");
			applicationUrlCountViewModel.addUrlVisitNumber(tempTime, urlVisitsSta.getVisitNumber());
		}

		return applicationUrlCountViewModel;
	}

	public Page<UrlTraceLogViewModel> queryUrlTraceLogs(Pageable pageable, String urlId) {
		Date startDate = LocalDate.now().toDate();
		Date endDate = LocalDateTime.now().toDate();

		return urlTraceLogRepository.selectUrlTraceLogs(pageable, urlId, startDate, endDate);
	}

	public List<MethodResponseTime> queryMethodResponseTimes(String urlId) {
		Date startDate = LocalDate.now().toDate();
		Date endDate = LocalDateTime.now().toDate();

		List<Method> methods = methodRepository.selectMethodsOfUrlById(urlId);
		List<MethodResponseTime> methodResponseTimes = new ArrayList<MethodResponseTime>();
		for(Method method : methods) {
			MethodResponseTime methodResponseTime = methodResponseTimeRepository.selectMethodResponseTimes(urlId, method.getId(), startDate, endDate);
			if(methodResponseTime == null) {
				methodResponseTime = new MethodResponseTime();
				methodResponseTime.setMaxResponseTime(0l);
				methodResponseTime.setTotalCount(0);
				methodResponseTime.setMinResponseTime(0l);
			}
			methodResponseTime.setAvgResponseTime(methodResponseTime.getAvgResponseTime());
			methodResponseTime.setUrlId(urlId);
			methodResponseTime.setMethodId(method.getId());
			methodResponseTime.setMethodName(method.getFullName());
			methodResponseTimes.add(methodResponseTime);
		}
		return methodResponseTimes;
	}
}
