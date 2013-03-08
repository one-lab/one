package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.application.model.*;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationIndexViewModel;
import com.sinosoft.one.monitor.application.repository.*;
import com.sinosoft.one.monitor.common.HealthSta;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import com.sinosoft.one.monitor.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 应用服务类
 * User: zfb
 * Date: 13-2-27
 * Time: 下午7:41
 */
@Component
@Transactional(readOnly = true)
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private MethodRepository methodRepository;
	@Autowired
	private AlarmRepository alarmRepository;
	@Autowired
	private UrlResponseTimeRepository urlResponseTimeRepository;
	@Autowired
	private RequestPerMinuteRepository requestPerMinuteRepository;
	@Autowired
	private UrlVisitsStaRepository urlVisitsStaRepository;
	@Autowired
	private ExceptionInfoRepository exceptionInfoRepository;

    /**
     * 新增一个应用.
     */
    @Transactional(readOnly = false)
    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }

    /**
     * 删除一个应用.
     */
    @Transactional(readOnly = false)
    public void deleteApplication(Application application) {
        applicationRepository.delete(application);
    }

    /**
     * 删除一个应用，通过应用id.
     */
    @Transactional(readOnly = false)
    public void deleteApplication(String id) {
        applicationRepository.deleteApplicationById(id);
    }

    /**
     * 查询一个应用，通过应用id.
     */
    public Application findApplication(String id) {
        Application application = applicationRepository.findOne(id);
        return application;
    }

    /**
     * 查询一个应用，通过应用名.
     */
    public Application findApplicationWithAppInfo(String applicationName,String applicationIp,String applicationPort) {
        Application application = applicationRepository.findByApplicationNameAndApplicationIpAndApplicationPort(applicationName, applicationIp, applicationPort);
        return application;
    }

    /**
     * 查询所有的应用.
     */
    public List<Application> findAllApplication() {
        List<Application> applications = (List<Application>) applicationRepository.findAllActiveApplication();
        return applications;
    }

    /**
     * 查询应用下所有的url.
     */
    public List<Url> findAllUrlsOfApplication(List<String> bizScenarioIds) {
        List<Url> urls=applicationRepository.selectAllUrlsWithBizScenarioIds(bizScenarioIds);
        return urls;
    }

    /**
     * 查询应用下的url中所有的Method.
     */
    public List<Method> findAllMethodsOfUrl(String urlId) {
        List<Method> methods=applicationRepository.selectAllMethodsWithUrlId(urlId);
        return methods;
    }

    public void updateApplicationWithModifyInfo(String appId, String applicationName, String cnName, String applicationIp, String applicationPort, String modifierId, BigDecimal interval) {
        applicationRepository.updateApplication(appId,applicationName,cnName,applicationIp,applicationPort,modifierId,interval);
    }

    public List<Application> findAllApplicationNames() {
        return applicationRepository.findAllApplicationNames();
    }

	/**
	 * 生成首页展示对象
	 * @param recentHour 最近几小时
	 * @return
	 */
	public List<ApplicationIndexViewModel> generateIndexViewModels(int recentHour) {
		Iterable<Application> applicationList = applicationRepository.findAllActiveApplication();
		Iterator<Application> applicationIterator = applicationList.iterator();
		List<ApplicationIndexViewModel> applicationIndexViewModelList = new ArrayList<ApplicationIndexViewModel>();
		while(applicationIterator.hasNext()) {
			Application application = applicationIterator.next();
			ApplicationIndexViewModel applicationIndexViewModel = new ApplicationIndexViewModel();

			applicationIndexViewModel.setApplicationId(application.getId());
			applicationIndexViewModel.setApplicationName(application.getApplicationName());
			applicationIndexViewModel.setApplicationCnName(application.getCnName());

			Date startDate = DateUtil.getRecentHourDate(recentHour - 1);
			Date endDate = Calendar.getInstance().getTime();
			// 计算健康度
			generateHealthBar(application.getId(), startDate, endDate, applicationIndexViewModel);
			// 获取平均响应时间
			generateAvgResponseTime(application.getId(), startDate, endDate, applicationIndexViewModel);
			// 获取吞吐量
			generateRpm(application.getId(), startDate, endDate, applicationIndexViewModel);

			applicationIndexViewModelList.add(applicationIndexViewModel);
		}
		return applicationIndexViewModelList;
	}

	/**
	 * 生成健康度状况
	 * @param applicationId 应用ID
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param applicationIndexViewModel 首页显示对象
	 */
	private void generateHealthBar(String applicationId, Date startDate, Date endDate, ApplicationIndexViewModel applicationIndexViewModel) {
		List<HealthSta> healthStas = alarmRepository.selectHealthStaForMonitor(applicationId, startDate, endDate);
		int criticalCount = 0;
		int warningCount = 0;
		int normalCount = 0;
		for(HealthSta healthSta : healthStas) {
			if(healthSta.getSeverity() == SeverityLevel.CRITICAL) {
				criticalCount = healthSta.getCount();
			} else if(healthSta.getSeverity() == SeverityLevel.WARNING) {
				warningCount = healthSta.getCount();
			} else if(healthSta.getSeverity() == SeverityLevel.INFO) {
				normalCount = healthSta.getCount();
			}
		}
		int totalCount = criticalCount + warningCount + normalCount;
		totalCount = totalCount == 0 ? 1 : totalCount;
		normalCount = normalCount == 0 ? 1 : normalCount;
		BigDecimal totalBigDecimal = BigDecimal.valueOf(totalCount);
		BigDecimal hundredBigDecimal = BigDecimal.valueOf(100);
		applicationIndexViewModel.setGreenBarLength(BigDecimal.valueOf(normalCount).divide(totalBigDecimal, 2, RoundingMode.HALF_UP).multiply(hundredBigDecimal).intValue());
		applicationIndexViewModel.setRedBarLength(BigDecimal.valueOf(criticalCount).divide(totalBigDecimal, 2, RoundingMode.HALF_UP).multiply(hundredBigDecimal).intValue());
		applicationIndexViewModel.setYellowBarLength(BigDecimal.valueOf(warningCount).divide(totalBigDecimal, 2, RoundingMode.HALF_UP).multiply(hundredBigDecimal).intValue());
	}

	/**
	 * 生成平均响应时间
	 * @param applicationId 应用ID
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param applicationIndexViewModel 首页显示对象
	 */
	private void generateAvgResponseTime(String applicationId, Date startDate, Date endDate, ApplicationIndexViewModel applicationIndexViewModel) {
		BigDecimal avgResponseTime = urlResponseTimeRepository.staAvgResponseTimeSta(applicationId, startDate, endDate);
		avgResponseTime = avgResponseTime == null ? BigDecimal.valueOf(0) : avgResponseTime;
		applicationIndexViewModel.setAvgResponseTime(avgResponseTime.intValue());
	}


	/**
	 * 生成吞吐量
	 * @param applicationId 应用ID
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param applicationIndexViewModel 首页显示对象
	 */
	private void generateRpm(String applicationId, Date startDate, Date endDate, ApplicationIndexViewModel applicationIndexViewModel) {
		List<RequestPerMinute> rpms = requestPerMinuteRepository.selectRequestPerMinutes(applicationId, startDate, endDate);
		Calendar calendar = Calendar.getInstance();
		int minute = calendar.get(Calendar.MINUTE);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date currentHourDate = calendar.getTime();
		int rpm = 0;
		for(RequestPerMinute requestPerMinute : rpms) {
			rpm += requestPerMinute.getRequestNumber();
			if(currentHourDate.equals(requestPerMinute.getRecordTime())) {
				continue;
			} else {
				minute += 60;
			}
		}
		BigDecimal rpmBigDecimal = BigDecimal.valueOf(rpm);
		BigDecimal minuteBigDecimal = BigDecimal.valueOf(minute);
		applicationIndexViewModel.setRpm(rpmBigDecimal.divide(minuteBigDecimal, 2, RoundingMode.HALF_UP).doubleValue());
	}


}
