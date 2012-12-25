package com.sinosoft.one.log.config;

import com.sinosoft.one.log.Environment;
import org.springframework.jmx.export.annotation.*;

import java.util.*;

@ManagedResource(objectName = LogConfigs.MBEAN_NAME, description = "Log Config Management Bean")
public class LogConfigs {
    public static final String MBEAN_NAME = "log:name=LogConfigs";
    private Set<LogUrl> urls = new HashSet<LogUrl>();
    private Set<LogMethod> methods = new HashSet<LogMethod>();
    private String environment;

    public void init() {
        // TODO 从监控系统取得初始化数据

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
    public Set<LogUrl> getLogUrls() {
        return urls;
    }

    @ManagedOperation(description = "Add a new log url.")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "url", description = "Request url of log url."),
        @ManagedOperationParameter(name = "environment", description = "Environment of log url."),
        @ManagedOperationParameter(name = "maxExecuteTime", description = "Max execute time of log url.")
    })
    public void addLogUrl(String url, String environment, int maxExecuteTime) {
        urls.add(new LogUrl(url, environment, maxExecuteTime));
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
    public Set<LogMethod> getLogMethods() {
        return methods;
    }

    @ManagedOperation(description = "Add a new log method.")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "className", description = "Class name of log method."),
        @ManagedOperationParameter(name = "methodName", description = "Method name of log method."),
        @ManagedOperationParameter(name = "maxExecuteTime", description = "Max execute time of log method."),
        @ManagedOperationParameter(name = "environment", description = "Environment of log method."),
        @ManagedOperationParameter(name = "description", description = "Description of log method.")
    })
    public void addLogMethod(String className, String methodName, int maxExecuteTime, String environment, String description) {
        methods.add(new LogMethod.Builder(className, methodName)
                .maxExecuteTime(maxExecuteTime).environment(environment).description(description).build());
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
        return environment;
    }

    @ManagedAttribute(description = "Modify environment.")
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public boolean checkEnvironment(String methodEnv){
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
