package com.sinosoft.one.monitor.application.model;


import com.sinosoft.one.monitor.common.HealthStaCache;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 响应时间.
 * User: carvin
 * Date: 13-3-2
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "GE_MONITOR_URL_RESPONSE_TIME")
public class UrlResponseTime {
	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * URL
	 */
	private String url;
	/**
	 * URLID
	 */
	private String urlId;
	/**
	 * 所属应用系统ID
	 */
	private String applicationId;
	/**
	 * 最小响应时间
	 */
	private Long minResponseTime;
	/**
	 * 最大响应时间
	 */
	private Long maxResponseTime;
	/**
	 * 平均响应时间
	 */
	private Long avgResponseTime;
	/**
	 * 响应时间
	 */
	private long responseTime;

	/**
	 * 记录时间
	 */
	private Date recordTime;
	/**
	 * 健康度
	 */
	private String healthBar;

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

	@Column(name = "URL_ID")
	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	@Column(name = "APPLICATION_ID")
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	@Column(name = "MIN_RESPONSE_TIME")
	public Long getMinResponseTime() {
		return minResponseTime == null ? 0l : minResponseTime;
	}

	public void setMinResponseTime(Long minResponseTime) {
		this.minResponseTime = minResponseTime;
	}

	@Column(name = "MAX_RESPONSE_TIME")
	public Long getMaxResponseTime() {
		return maxResponseTime == null ? 0l : maxResponseTime;
	}


	public void setMaxResponseTime(Long maxResponseTime) {
		this.maxResponseTime = maxResponseTime;
	}

	@Column(name = "AVG_RESPONSE_TIME")
	public Long getAvgResponseTime() {
		return avgResponseTime == null ? 0l : avgResponseTime;
	}

	public void setAvgResponseTime(Long avgResponseTime) {
		this.avgResponseTime = avgResponseTime;
	}

	@Column(name = "RECORD_TIME")
	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	@Transient
	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * 获得健康度条
	 */
	@Transient
	public String getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(String healthBar) {
		this.healthBar = healthBar;
	}

}
