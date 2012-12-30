package com.sinosoft.one.log.methodtrace;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.log.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-11-28
 * Time: 上午6:12
 * To change this template use File | Settings | File Templates.
 */
public class MethodTraceLog extends AbstractLoggable implements Loggable {
    public static final String FORMAT_STRING_PREFIX = "[@MethodTrace]";
    public static final String FORMAT_STRING = FORMAT_STRING_PREFIX  + SEPARATOR + "{}" + SEPARATOR + "[@traceId=" + SEPARATOR + "{}" + SEPARATOR + "] 在 "+SEPARATOR+"{}"+SEPARATOR+
            " 调用类 "+SEPARATOR+"{}"+SEPARATOR+" 的方法" +SEPARATOR+"{}"+SEPARATOR + " 传入参数 "+SEPARATOR+"{}"+SEPARATOR+" 返回 "+SEPARATOR+
            "{}"+SEPARATOR+" ,在 "+SEPARATOR+"{}"+SEPARATOR+" 结束,经历时常为 "+SEPARATOR+
            "{}"+SEPARATOR+" 内容 "+SEPARATOR+"{} "+SEPARATOR+" 操作人 "+SEPARATOR+"{}"+SEPARATOR
            + " 环境级别 "+SEPARATOR+"{}"+SEPARATOR;

    private String id;
    private String urlTraceId;
    private String methodName;
    private String className;
    private String inParam;
    private String outParam;
    private Timestamp beginTime;
    private Timestamp endTime;
    private long consumeTime;
    private String environment;
    private String logLevel;
    private String logDescription;
    private Timestamp logTime;

    public MethodTraceLog() {
        this.logHandler = Loggables.getMethodTraceLogHandler();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlTraceId() {
        return urlTraceId;
    }

    public void setUrlTraceId(String urlTraceId) {
        this.urlTraceId = urlTraceId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInParam() {
        return inParam;
    }

    public void setInParam(String inParam) {
        this.inParam = inParam;
    }

    public String getOutParam() {
        return outParam;
    }

    public void setOutParam(String outParam) {
        this.outParam = outParam;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(long consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription;
    }

    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }

    public Map<String, Object> toMap() throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("urlTraceId", urlTraceId);
        paramMap.put("methodName", methodName);
        paramMap.put("className", className);
        paramMap.put("inParam", inParam);
        paramMap.put("outParam", outParam);
        paramMap.put("beginTime", beginTime);
        paramMap.put("endTime", endTime);
        paramMap.put("consumeTime", consumeTime);
        paramMap.put("logLevel", logLevel);
        paramMap.put("logDescription", logDescription);
        paramMap.put("logTime", logTime);
        paramMap.put("appName", appName);
        paramMap.put("userId", userId);
        paramMap.put("environment", environment.toString());

        return paramMap;
    }

    public LogType getType() {
        return LogType.methodTraceLog;
    }

    public Object[] toObjectArray() {
        return new Object[]{
                id,
                urlTraceId,
                beginTime,
                className,
                methodName,
                inParam,
                outParam,
                endTime,
                consumeTime,
                logDescription,
                userId,
                environment.toString()
        };
    }

    public static MethodTraceLog valueOf(LoggingEvent loggingEvent) {
        String message = (String)loggingEvent.getMessage();
        MethodTraceLog methodTraceLog = new MethodTraceLog();
        String[] msg = StringUtils.splitByWholeSeparator(message, MethodTraceLog.SEPARATOR);
        methodTraceLog.setId(msg[1]);
        methodTraceLog.setUrlTraceId(msg[3]);
        methodTraceLog.setBeginTime(Timestamp.valueOf(msg[5]));
        methodTraceLog.setClassName(msg[7]);
        methodTraceLog.setMethodName(msg[9]);
        methodTraceLog.setInParam(msg[11]);
        methodTraceLog.setOutParam(msg[13]);
        methodTraceLog.setEndTime(Timestamp.valueOf(msg[15]));
        methodTraceLog.setConsumeTime(Long.parseLong(msg[17]));
        methodTraceLog.setLogDescription(msg[19]);
        methodTraceLog.setUserId(msg[21]);
        methodTraceLog.setEnvironment(msg[23]);
        methodTraceLog.setLogLevel(loggingEvent.getLevel().toString());
        methodTraceLog.setLogTime(new Timestamp(System.currentTimeMillis()));
        return  methodTraceLog;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("urlTraceId", urlTraceId)
            .append("methodName", methodName)
            .append("className", className)
            .append("inParam", inParam)
            .append("outParam", outParam)
            .append("beginTime", beginTime)
            .append("endTime", endTime)
            .append("consumeTime", consumeTime)
            .append("logLevel", logLevel)
            .append("logDescription", logDescription)
            .append("logTime", logTime)
            .append("appName", appName)
            .append("userId", userId)
            .append("environment", environment.toString())
            .build();
    }
}
