package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.alarm.domain.AlarmService;
import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.application.model.*;
import com.sinosoft.one.monitor.application.model.viewmodel.IndexViewModel;
import com.sinosoft.one.monitor.application.repository.*;
import com.sinosoft.one.monitor.common.HealthSta;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import com.sinosoft.one.monitor.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

	public List<IndexViewModel> generateIndexViewModels(int recentHour) {
		Iterable<Application> applicationList = applicationRepository.findAll();
		Iterator<Application> applicationIterator = applicationList.iterator();
		while(applicationIterator.hasNext()) {
			Application application = applicationIterator.next();
			IndexViewModel indexViewModel = new IndexViewModel();

			Date startDate = DateUtil.getCurrentBeginDate();
			Date endDate = DateUtil.getCurrentEndDate();
			// 计算健康度
			generateHealthBar(application.getId(), indexViewModel, startDate, endDate);
			// 获取平均响应时间

			// 获取吞吐量

		}
		return null;

	}

	private void generateHealthBar(String applicationId, IndexViewModel indexViewModel, Date startDate, Date endDate) {
		List<HealthSta> healthStas = alarmRepository.selectHealthSta(applicationId, startDate, endDate);
		int criticalCount = 0;
		int warningCount = 0;
		for(HealthSta healthSta : healthStas) {
			if(healthSta.getSeverityLevel() == SeverityLevel.CRITICAL) {
				criticalCount = healthSta.getCount();
			} else if(healthSta.getSeverityLevel() == SeverityLevel.WARNING) {
				warningCount = healthSta.getCount();
			}
		}
	}

	private void generateAvgResponseTime(String applicationId, Date startDate, Date endDate) {


	}
}
