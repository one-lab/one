package com.sinosoft.one.monitor.os.linux.model.viewmodel;

public class OsGridModel {

	
	private String id;
	
	private String name;
	
	private String utilzation;
	
	private String link;
	
	private String used;
	
	private String value;
	
	private String stuts;
	
	private String time;
	
	private String minValue;
	
	private String maxValue;
	
	private String averageValue;
	
	private Long normalRun;
	
	private Long crashTime;
	
	private Long aveRepairTime;
	
	private Long aveFaultTime;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUtilzation() {
		return utilzation;
	}

	public void setUtilzation(String utilzation) {
		this.utilzation = utilzation;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStuts() {
		return stuts;
	}

	public void setStuts(String stuts) {
		this.stuts = stuts;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public String getAverageValue() {
		return averageValue;
	}

	public void setAverageValue(String averageValue) {
		this.averageValue = averageValue;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getNormalRun() {
		return normalRun;
	}

	public void setNormalRun(Long normalRun) {
		this.normalRun = normalRun;
	}

	public Long getCrashTime() {
		return crashTime;
	}

	public void setCrashTime(Long crashTime) {
		this.crashTime = crashTime;
	}

	public Long getAveRepairTime() {
		return aveRepairTime;
	}

	public void setAveRepairTime(Long aveRepairTime) {
		this.aveRepairTime = aveRepairTime;
	}

	public Long getAveFaultTime() {
		return aveFaultTime;
	}

	public void setAveFaultTime(Long aveFaultTime) {
		this.aveFaultTime = aveFaultTime;
	}
	
	
}
