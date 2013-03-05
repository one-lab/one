package com.sinosoft.one.monitor.application.domain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.application.model.Method;
import com.sinosoft.one.monitor.application.model.Url;
import com.sinosoft.one.monitor.application.repository.ApplicationRepository;
import com.sinosoft.one.monitor.application.repository.MethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-2-27
 * Time: 下午7:41
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    MethodRepository methodRepository;

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
        Application application = applicationRepository.findByApplicationNameAndApplicationIpAndApplicationPort(applicationName,applicationIp,applicationPort);
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
}
