package com.sinosoft.one.monitor.os.linux.model.viewmodel;

import java.util.Date;

/**
 * 数据查询接收对象
 * @author Administrator
 *
 */
public class StatiDataModel {
	
	private String maxValue;

	private String minValue;
	
	private String avgValue;
	
	private String maxAvgValue;
	
	private String minAvgValue;
	
	private String normalRun;
	
	private String crashTime;
	
	private String aveRepairTime;
	
	private String aveFaultTime;
	
	private Date date;
	
	public String getNormalRun() {
		return normalRun;
	}

	public void setNormalRun(String normalRun) {
		this.normalRun = normalRun;
	}

	public String getCrashTime() {
		return crashTime;
	}

	public void setCrashTime(String crashTime) {
		this.crashTime = crashTime;
	}

	public String getAveRepairTime() {
		return aveRepairTime;
	}

	public void setAveRepairTime(String aveRepairTime) {
		this.aveRepairTime = aveRepairTime;
	}

	public String getAveFaultTime() {
		return aveFaultTime;
	}

	public void setAveFaultTime(String aveFaultTime) {
		this.aveFaultTime = aveFaultTime;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		if(maxValue==null){
			this.maxValue="0";
		}
		this.maxValue = maxValue;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		if(minValue==null){
			this.minValue="0";
		}
		this.minValue = minValue;
	}

	public String getAvgValue() {
		return avgValue;
	}

	public void setAvgValue(String avgValue) {
		if(avgValue==null){
			this.avgValue="0";
		}
		this.avgValue = avgValue;
	}

	public String getMaxAvgValue() {
		return maxAvgValue;
	}

	public void setMaxAvgValue(String maxAvgValue) {
		if(maxAvgValue==null){
			this.maxAvgValue="0";
		}
		this.maxAvgValue = maxAvgValue;
	}

	public String getMinAvgValue() {
		return minAvgValue;
	}

	public void setMinAvgValue(String minAvgValue) {
		if(minAvgValue==null){
			this.minAvgValue="0";
		}
		this.minAvgValue = minAvgValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	


}
