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
	/**
	 * 主键ID
	 */
    private String id;
	/**
	 * URL追踪ID
	 */
    private String urlTraceId;
	/**
	 * 方法名
	 */
    private String methodName;
	/**
	 * 方法所属类名
	 */
    private String className;
	/**
	 * 方法参数
	 */
    private String inParam;
	/**
	 * 方法返回值
	 */
    private String outParam;
	/**
	 * 开始时间
	 */
    private Timestamp beginTime;
	/**
	 * 结束时间
	 */
    private Timestamp endTime;
	/**
	 * 花费时间
	 */
    private long consumeTime;
	/**
	 * 记录时间
	 */
    private Timestamp logTime;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 异常堆栈信息
	 */
	private String exceptionStackTrace;

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

    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }

    public String getFullMethodName() {
        return getClassName() + "." + getMethodName();
    }

	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
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
            .append("logTime", logTime)
            .append("userId", userId)
            .build();
    }
}
