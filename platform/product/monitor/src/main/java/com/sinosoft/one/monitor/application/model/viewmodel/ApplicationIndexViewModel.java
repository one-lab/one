package com.sinosoft.one.monitor.application.model.viewmodel;

/**
 * 应用首页模型.
 * User: carvin
 * Date: 13-3-5
 * Time: 下午10:00
 */
public class ApplicationIndexViewModel {
	private String applicationId;
	private String applicationName;
	private String applicationCnName;
	private int greenBarLength;
	private int yellowBarLength;
	private int redBarLength;
	private int avgResponseTime;
	private double rpm;

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationCnName() {
		return applicationCnName;
	}

	public void setApplicationCnName(String applicationCnName) {
		this.applicationCnName = applicationCnName;
	}

	public int getGreenBarLength() {
		return greenBarLength;
	}

	public void setGreenBarLength(int greenBarLength) {
		this.greenBarLength = greenBarLength;
	}

	public int getYellowBarLength() {
		return yellowBarLength;
	}

	public void setYellowBarLength(int yellowBarLength) {
		this.yellowBarLength = yellowBarLength;
	}

	public int getRedBarLength() {
		return redBarLength;
	}

	public void setRedBarLength(int redBarLength) {
		this.redBarLength = redBarLength;
	}

	public int getAvgResponseTime() {
		return avgResponseTime;
	}

	public void setAvgResponseTime(int avgResponseTime) {
		this.avgResponseTime = avgResponseTime;
	}

	public double getRpm() {
		return rpm;
	}

	public void setRpm(double rpm) {
		this.rpm = rpm;
	}
}
