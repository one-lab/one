package com.sinosoft.one.monitor.log;


import org.apache.commons.lang3.builder.ToStringBuilder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 方法追踪日志.
 * User: carvin
 * Date: 12-11-28
 * Time: 上午6:12
 */
public class MethodTraceLog {

    private String id;
    private String urlTraceId;
    private String methodName;
    private String className;
    private String inParam;
    private String outParam;
    private Timestamp beginTime;
    private Timestamp endTime;
    private long consumeTime;
    private String logLevel;
    private String logDescription;
    private Timestamp logTime;
	private String userId;

    public MethodTraceLog() {
        userId = Loggables.getUserId();
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

    public String getFullMethodName() {
        return getClassName() + "." + getMethodName();
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
        paramMap.put("userId", userId);

        return paramMap;
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
        };
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
            .append("userId", userId)
            .build();
    }
}
