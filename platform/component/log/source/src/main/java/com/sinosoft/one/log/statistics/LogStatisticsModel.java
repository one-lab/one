package com.sinosoft.one.log.statistics;

import com.alibaba.fastjson.serializer.UUIDSerializer;
import com.sinosoft.one.log.Loggable;
import com.sinosoft.one.log.config.LogMethod;
import com.sinosoft.one.log.config.LogUrl;
import com.sinosoft.one.log.urltrace.URLTraceLog;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.id.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 日志统计实体类.
 * User: carvin
 * Date: 13-1-11
 * Time: 上午9:31
 * .
 */
public class LogStatisticsModel {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String id;
    private LogStatisticsType type;
    private String value;
    private long executeTime;
    private int interval;
    private long beginTimeMillis;
    private long endTimeMillis;
    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LogStatisticsType getType() {
        return type;
    }

    public void setType(LogStatisticsType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public int getInterval() {
        return interval * 60 * 1000;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public long getBeginTimeMillis() {
        return beginTimeMillis;
    }

    public void setBeginTimeMillis(long beginTimeMillis) {
        this.beginTimeMillis = beginTimeMillis;
    }

    public long getEndTimeMillis() {
        return endTimeMillis;
    }

    public void setEndTimeMillis(long endTimeMillis) {
        this.endTimeMillis = endTimeMillis;
    }

    public void increamentCount() {
        count++;
    }

    public void addExecuteTime(long executeTime) {
        this.executeTime += executeTime;
    }

    public long getAvgExecuteTime() {
        return count > 0 ? this.executeTime / count : 0;
    }

    public static LogStatisticsModel valueOf(LogUrl logUrl) {
        return createLogStatisticsModel(logUrl.getUrl(), LogStatisticsType.URL, logUrl.getInterval());
    }

    public static LogStatisticsModel valueOf(LogMethod logMethod) {
        return createLogStatisticsModel(logMethod.getFullMethodName(), LogStatisticsType.METHOD, logMethod.getInterval());
    }

    private static LogStatisticsModel createLogStatisticsModel(String value,
                                                               LogStatisticsType logStatisticsType,
                                                               int interval) {
        LogStatisticsModel logStatisticsModel = new LogStatisticsModel();
        logStatisticsModel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        logStatisticsModel.setValue(value);
        logStatisticsModel.setInterval(interval);
        logStatisticsModel.setType(logStatisticsType);
        long beginTimeMillis = System.currentTimeMillis();
        long endTimeMillis = beginTimeMillis + (interval * 60 * 1000);
        logStatisticsModel.setBeginTimeMillis(beginTimeMillis);
        logStatisticsModel.setEndTimeMillis(endTimeMillis);
        return logStatisticsModel;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("value", value);
        paramMap.put("type", type.name());
        paramMap.put("interval", interval);
        paramMap.put("executeTime", getAvgExecuteTime());
        paramMap.put("beginTime", new Timestamp(beginTimeMillis));
        paramMap.put("endTime", new Timestamp(endTimeMillis));
        return paramMap;
    }

    public boolean isTimeout(long currentTimeMillis) {
        return currentTimeMillis > endTimeMillis;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
