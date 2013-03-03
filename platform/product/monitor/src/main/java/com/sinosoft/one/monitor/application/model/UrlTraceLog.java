package com.sinosoft.one.monitor.application.model;


import com.sinosoft.one.monitor.common.AlarmMessage;
import com.sinosoft.one.monitor.common.AlarmSource;
import com.sinosoft.one.monitor.common.MessageBase;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * URL 追踪类
 * User: carvin
 * Date: 12-11-28
 * Time: 上午1:57
 * 用于记录URL追踪信息.
 */
@Entity
@Table(name = "GE_MONITOR_URL_TRACE_LOG")
public class UrlTraceLog implements MessageBase {
	/**
	 * 主键ID
	 */
    private String id;
	/**
	 * URL地址
	 */
    private String url;
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
	 * 会话ID
	 */
    private String sessionId;
	/**
	 * 用户IP
	 */
    private String userIp;
	/**
	 * 请求参数信息
	 */
    private String requestParams;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 业务场景追踪ID
	 */
	private String traceId;
	/**
	 * 所属业务场景ID
	 */
	private String bizScenarioId;
	/**
	 * 告警信息ID
	 */
	private String alarmId;


	List<MethodTraceLog> methodTraceLogList = new ArrayList<MethodTraceLog>();

	@Column(name = "USER_IP")
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	@Column(name = "URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	@Column(name = "BEGIN_TIME")
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

	@Column(name = "END_TIME")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

	@Column(name = "CONSUME_TIME")
    public long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(long consumeTime) {
        this.consumeTime = consumeTime;
    }

	@Column(name = "SESSION_ID")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

	@Column(name = "REQUEST_PARAMS")
	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

	@Column(name = "URL_ID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "TRACE_ID")
	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	@Column(name = "BIZ_SCENARIO_ID")
	public String getBizScenarioId() {
		return bizScenarioId;
	}

	public void setBizScenarioId(String bizScenarioId) {
		this.bizScenarioId = bizScenarioId;
	}

	@Column(name = "ALARM_ID")
	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public void setMethodTraceLogList(List<MethodTraceLog> methodTraceLogList) {
		this.methodTraceLogList = methodTraceLogList;
	}

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "URL_TRACE_LOG_ID")
	public List<MethodTraceLog> getMethodTraceLogList() {
		return methodTraceLogList;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("url", url)
            .append("beginTime", beginTime)
            .append("endTime", endTime)
            .append("consumeTime", consumeTime)
            .append("sessionId", sessionId)
            .append("userId", userId)
            .append("userIp", userIp)
            .build();
    }

	@Override
	public List<AlarmMessage> alarmMessages() {
		return null;
	}

	@Override
	public AlarmSource alarmSource() {
		return AlarmSource.LOG;
	}
}
