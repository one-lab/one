package com.sinosoft.one.monitor.application.model.viewmodel;

import com.sinosoft.one.monitor.threshold.model.SeverityLevel;

import java.util.Date;

/**
 * URL 追踪日志展示信息类.
 * User: carvin
 * Date: 13-3-10
 * Time: 上午12:28
 */
public class UrlTraceLogViewModel {
	private String id;
	private String userIp;
	private String userId;
	private Date recordTime;
	private String state;
	private String operateStr = "";
	private String severity;
	private String excpetionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		operateStr = "<a class=\"eid\" href=\"javascript:void(0);\" onclick=\"operateDetail('" + id + "')\">操作详细</a>";
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOperateStr() {
		return operateStr;
	}

	public void setOperateStr(String operateStr) {
		this.operateStr = operateStr;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
		if(this.state == null) {
			if(severity == null || SeverityLevel.INFO.equals(severity)) {
				this.state = SeverityLevel.INFO.name();
			} else {
				this.state = severity;
			}
		}
	}

	public String getExcpetionId() {
		return excpetionId;
	}

	public void setExcpetionId(String excpetionId) {
		this.excpetionId = excpetionId;
		if(!SeverityLevel.CRITICAL.name().equals(this.state) && excpetionId != null) {
			this.state = SeverityLevel.CRITICAL.name();
		}
	}
}
