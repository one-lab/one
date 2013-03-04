package com.sinosoft.one.monitor.application.model;

import com.sinosoft.one.monitor.common.AlarmMessage;
import com.sinosoft.one.monitor.common.AlarmSource;
import com.sinosoft.one.monitor.common.MessageBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 异常信息.
 * User: carvin
 * Date: 13-3-3
 * Time: 上午12:14
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "GE_MONITOR_EXCEPTION_INFO")
public class ExceptionInfo implements MessageBase {
	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * URL追踪ID
	 */
	private String urlTraceId;
	/**
	 * 记录时间
	 */
	private Date recordTime;
	/**
	 * 异常堆栈
	 */
	private String exceptionStackTrace;
	/**
	 * 告警信息ID
	 */
	private String alarmId;
	/**
	 * 应用系统ID
	 */
	private String applicationId;

	public ExceptionInfo() {}


	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "URL_TRACE_LOG_ID")
	public String getUrlTraceId() {
		return urlTraceId;
	}

	public void setUrlTraceId(String urlTraceId) {
		this.urlTraceId = urlTraceId;
	}

	@Column(name = "RECORD_TIME")
	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	@Column(name = "EXCEPTION_STACK_TRACE")
	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
	}

	@Column(name = "ALARM_ID")
	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	@Column(name = "APPLICATION_ID")
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	@Override
	public List<AlarmMessage> alarmMessages() {
		return null;
	}

	@Override
	public AlarmSource alarmSource() {
		return AlarmSource.EXCEPTION;
	}
}