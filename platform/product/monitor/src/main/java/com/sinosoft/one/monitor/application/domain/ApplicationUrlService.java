package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.application.model.MethodResponseTime;
import com.sinosoft.one.monitor.application.model.UrlResponseTime;
import com.sinosoft.one.monitor.application.model.UrlTraceLog;
import com.sinosoft.one.monitor.application.model.UrlVisitsSta;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationUrlInfoViewModel;
import com.sinosoft.one.monitor.application.model.viewmodel.UrlTraceLogViewModel;
import com.sinosoft.one.monitor.application.repository.MethodResponseTimeRepository;
import com.sinosoft.one.monitor.application.repository.UrlResponseTimeRepository;
import com.sinosoft.one.monitor.application.repository.UrlTraceLogRepository;
import com.sinosoft.one.monitor.application.repository.UrlVisitsStaRepository;
import com.sinosoft.one.monitor.common.HealthStaService;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.common.Trend;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

	public ApplicationUrlInfoViewModel generateUrlInfoViewModel(String applicationId, String urlId) {
		// 获得健康度
		LocalDateTime localDateTime = LocalDateTime.now();

		SeverityLevel severityLevel  = healthStaService.healthStaForCurrent(applicationId, ResourceType.APPLICATION_SCENARIO_URL,
				urlId, 10);
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

	public void generateUrlHealthAndAvaStaViewModel(String applicationId, String urlId) {
		// 获得最近6小时健康度
		LocalDateTime localDateTime = LocalDateTime.now();

		Map<Integer, SeverityLevel> severityLevelMap = healthStaService.healthStaForHours(applicationId, ResourceType.APPLICATION_SCENARIO_URL.name(),
				urlId, 5);
		// 获得可用性信息
		List<TimeQuantumAvailableInfo> timeQuantumAvailableInfoList = applicationEmuService.findAvailableStatisticsByUrlId(urlId);

	}

	public void generateUrlCountStaViewModel(String applicationId, String urlId) {
		LocalDateTime localDateTime = LocalDateTime.now();
		Date endDate = localDateTime.toDate();
		Date startDate = localDateTime.minusHours(5).toDate();

		// 获得最近6小时响应时间
		List<UrlResponseTime> urlResponseTimes = urlResponseTimeRepository.selectUrlResponseTimes(applicationId, urlId, startDate, endDate);

		// 获得最近6小时访问数量
		List<UrlVisitsSta> urlVisitsStas = urlVisitsStaRepository.selectUrlVisitsSta(applicationId, urlId, startDate, endDate);
	}

	public Page<UrlTraceLogViewModel> queryUrlTraceLogs(Pageable pageable, String urlId) {
		Date startDate = LocalDate.now().toDate();
		Date endDate = LocalDateTime.now().toDate();

		return urlTraceLogRepository.selectUrlTraceLogs(pageable, urlId, startDate, endDate);
	}

	public List<MethodResponseTime> queryMethodResponseTimes(String applicationId, String urlId) {
		Date startDate = LocalDate.now().toDate();
		Date endDate = LocalDateTime.now().toDate();

		return methodResponseTimeRepository.selectMethodResponseTimes(applicationId, urlId, startDate, endDate);
	}
}
