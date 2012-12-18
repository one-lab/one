package com.sinosoft.one.log;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-11-27
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public enum LogType {
    userBehaviorLog("用户行为日志"),
    urlTraceLog("URL追踪日志"),
    methodTraceLog("方法追踪日志");

    private String logType;

    private LogType(String logType) {
        this.logType = logType;
    }

    public String toString() {
        return logType;
    }
}
