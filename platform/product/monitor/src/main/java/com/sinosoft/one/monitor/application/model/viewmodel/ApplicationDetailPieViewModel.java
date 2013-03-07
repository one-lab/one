package com.sinosoft.one.monitor.application.model.viewmodel;

/**
 * 应用明细页饼图信息展示实体
 * User: carvin
 * Date: 13-3-6
 * Time: 下午9:51
 */
public class ApplicationDetailPieViewModel {
	private String availabilityValue;

	private int criticalCount = 0;
	private int warningCount = 0;
	private int normalCount = 0;

	public String getAvailabilityValue() {
		return availabilityValue;
	}

	public void setAvailabilityValue(String availabilityValue) {
		this.availabilityValue = availabilityValue;
	}

	public String getHealthValue() {
		return criticalCount + ":" + (warningCount + normalCount);
	}

	public int getCriticalCount() {
		return criticalCount;
	}

	public void setCriticalCount(int criticalCount) {
		this.criticalCount = criticalCount;
	}

	public int getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
	}

	public int getNormalCount() {
		return normalCount;
	}

	public void setNormalCount(int normalCount) {
		this.normalCount = normalCount;
	}
}
