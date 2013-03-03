package com.sinosoft.one.monitor.application.domain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.application.model.Method;
import com.sinosoft.one.monitor.application.model.Url;
import com.sinosoft.one.monitor.application.repository.ApplicationRepository;
import com.sinosoft.one.monitor.application.repository.MethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        applicationRepository.delete(id);
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
        List<Application> applications = (List<Application>) applicationRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
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

    /**
     * 返回url和method所对应的json数据.
     * url包括id和地址
     * method包括id，className，methodName
     */
    public String getJsonDataOfUrlsAndMethods(String applicationId,List<Url> urls) {
        JSONObject jsonUrlsObject=new JSONObject();
        JSONArray jsonUrlArray=new JSONArray();
        //返回的json数据包含当前应用的id，这个数据会写入代理端的notification.info文件中
	    jsonUrlsObject.put("applicationId",applicationId);
        for(Url url:urls){
            JSONObject jsonUrlObject=new JSONObject();
            //处理当前url
            jsonUrlObject.put("urlId",url.getId());
            jsonUrlObject.put("urlAddress",url.getUrl());
            List<Method> methods=findAllMethodsOfUrl(url.getId());
	        JSONArray methodArray = new JSONArray();
            //循环处理url中所有的method
            for(Method method:methods){
                JSONObject jsonMethodObject=new JSONObject();
                jsonMethodObject.put("methodId",method.getId());
                jsonMethodObject.put("className",method.getClassName());
                jsonMethodObject.put("methodName",method.getMethodName());
                //此method作为当前url的一个节点
	            methodArray.add(jsonMethodObject);
            }
	        jsonUrlObject.put("methods", methodArray);

            jsonUrlArray.add(jsonUrlObject);
        }
        jsonUrlsObject.put("urls",jsonUrlArray);
        return jsonUrlsObject.toString();
    }
}
