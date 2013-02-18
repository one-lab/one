package com.sinosoft.one.log.config;

import com.sinosoft.one.log.Environment;
import com.sinosoft.one.log.statistics.LogStatisticsHandler;
import com.sinosoft.one.monitoragent.notification.MethodInitConfigure;
import com.sinosoft.one.monitoragent.notification.NotificationService;
import com.sinosoft.one.monitoragent.notification.UrlInitConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@ManagedResource(objectName = LogConfigs.MBEAN_NAME, description = "Log Config Management Bean")
public class LogConfigs {
    public static final String MBEAN_NAME = "log:name=LogConfigs";
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private LogStatisticsHandler logStatisticsHandler;

    private List<LogUrl> urls = new ArrayList<LogUrl>();
    private List<LogMethod> methods = new ArrayList<LogMethod>();
    private Environment environment;

    @PostConstruct
    public void init() {
        try {
            initMethods();
            initUrls();
        } catch (Exception e) {
            logger.error("init log config exception.", e);
        }
    }

    private void initMethods() {
        List<MethodInitConfigure> methodInitConfigures = notificationService.getMethodInitConfigure();
        if(methodInitConfigures != null) {
            for(MethodInitConfigure methodInitConfigure : methodInitConfigures) {
                LogMethod logMethod = new LogMethod.Builder(methodInitConfigure.getClassName(), methodInitConfigure.getMethodName())
                        .environment(methodInitConfigure.getEnvironment())
                        .maxExecuteTime(Integer.parseInt(methodInitConfigure.getThreshold()))
                        .interval(Integer.parseInt(methodInitConfigure.getInterval())).build();
                methods.add(logMethod);
            }
        }
//        methods = BeanMapper.mapList(notificationService.getMethodInitConfigure(),
//                LogMethod.class);
    }

    private void initUrls() {
        List<UrlInitConfigure> urlInitConfigures = notificationService.getUrlInitConfigure();
        if(urlInitConfigures != null) {
            for(UrlInitConfigure urlInitConfigure : urlInitConfigures) {
                LogUrl logUrl = new LogUrl();
                logUrl.setUrl(urlInitConfigure.getUrl());
                logUrl.setMaxExecuteTime(Integer.parseInt(urlInitConfigure.getThreshold()));
                logUrl.setInterval(Integer.parseInt(urlInitConfigure.getInterval()));
                logUrl.setEnvironment(urlInitConfigure.getEnvironment());
                urls.add(logUrl);
            }
        }
//        urls = BeanMapper.mapList(notificationService.getUrlInitConfigure(),
//                LogUrl.class);
    }

    @ManagedOperation(description = "Get a url.")
    @ManagedOperationParameter(name = "url", description = "Url to get.")
    public LogUrl getLogUrl(String url) {
        for(LogUrl tempUrl : urls) {
            if(tempUrl.getUrl().equalsIgnoreCase(url)) {
                return tempUrl;
            }
        }
        return null;
    }

    @ManagedOperation(description = "Get a log method.")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "className", description = "Class name of log method to get."),
            @ManagedOperationParameter(name = "methodName", description = "Method name of log method to get.")
    })
    public LogMethod getLogMethod(String className, String methodName) {
        for(LogMethod logMethod : methods) {
            if(logMethod.matches(className, methodName)) {
                return logMethod;
            }
        }
        return null;
    }

    @ManagedAttribute(description = "Log urls")
    public List<LogUrl> getLogUrls() {
        return urls;
    }

    @ManagedOperation(description = "Add a new log url.")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "url", description = "Request url of log url."),
        @ManagedOperationParameter(name = "environment", description = "Environment of log url."),
        @ManagedOperationParameter(name = "maxExecuteTime", description = "Max execute time of log url."),
        @ManagedOperationParameter(name = "interval", description = "Interval time of log url.")
    })
    public void addLogUrl(String url, String environment, int maxExecuteTime, int interval) {
        urls.add(new LogUrl(url, environment, maxExecuteTime, interval));
    }

    @ManagedOperation(description = "Remove a url.")
    @ManagedOperationParameters({ @ManagedOperationParameter(name = "url", description = "Url to remove.") })
    public void removeLogUrl(String url) {
        Iterator<LogUrl> iterator = urls.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getUrl().equalsIgnoreCase(url)) {
                iterator.remove();
                return;
            }
        }
    }

    @ManagedAttribute(description = "Log methods")
    public List<LogMethod> getLogMethods() {
        return methods;
    }

    @ManagedOperation(description = "Add a new log method.")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "className", description = "Class name of log method."),
        @ManagedOperationParameter(name = "methodName", description = "Method name of log method."),
        @ManagedOperationParameter(name = "maxExecuteTime", description = "Max execute time of log method."),
        @ManagedOperationParameter(name = "interval", description = "Interval time of log method."),
        @ManagedOperationParameter(name = "environment", description = "Environment of log method."),
        @ManagedOperationParameter(name = "description", description = "Description of log method.")
    })
    public void addLogMethod(String className, String methodName, int maxExecuteTime, int interval, String environment, String description) {
        methods.add(new LogMethod.Builder(className, methodName)
                .maxExecuteTime(maxExecuteTime).interval(interval).environment(environment).description(description).build());
    }

//    @ManagedOperation(description = "Add a new log method.")
//    @ManagedOperationParameters({
//            @ManagedOperationParameter(name = "className", description = "Class name of log method."),
//            @ManagedOperationParameter(name = "methodName", description = "Method name of log method."),
//            @ManagedOperationParameter(name = "maxExecuteTime", description = "Max execute time of log method.")
//    })
//    public void addMethod(String className, String methodName, int maxExecuteTime) {
//        methods.add(new LogMethod.Builder(className, methodName)
//                .maxExecuteTime(maxExecuteTime).build());
//    }

    @ManagedOperation(description = "Remove a log method.")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "className", description = "Class name of log method to remove."),
        @ManagedOperationParameter(name = "methodName", description = "Method name of log method to remove.")
    })
    public void removeLogMethod(String className, String methodName) {
        Iterator<LogMethod> iterator = methods.iterator();
        while (iterator.hasNext()) {
            LogMethod logMethod = iterator.next();
            if(logMethod.getClassName().equalsIgnoreCase(className)
                    && logMethod.getMethodName().equalsIgnoreCase(methodName)) {
                iterator.remove();
                return;
            }
        }
    }

    @ManagedAttribute(description = "Environment")
    public String getEnvironment() {
        return environment.name();
    }

    @ManagedAttribute(description = "Modify environment.")
    public void setEnvironment(String environment) {
        this.environment = Environment.valueOf(environment);
    }

    @ManagedOperation(description = "Query log statistics.")
    @ManagedOperationParameters(
            { @ManagedOperationParameter(name = "type", description = "type to query."),
              @ManagedOperationParameter(name = "value", description = "value to query.")
            })
    public long queryLogStatisticExecuteTime(String type, String value) {
        return logStatisticsHandler.selectExecuteTime(type, value);
    }

    public boolean checkEnvironment(Environment methodEnv){
        if(environment.equals(methodEnv))
            return true;
        if(environment.equals(Environment.DEVELOP))
            return true;
        if(environment.equals(Environment.TEST) && methodEnv.equals(Environment.DEVELOP)){
            return true;
        }
        return false;
    }

}
