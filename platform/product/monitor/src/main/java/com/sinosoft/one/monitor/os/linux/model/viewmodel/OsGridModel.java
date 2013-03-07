package com.sinosoft.one.monitor.os.linux.model.viewmodel;

public class OsGridModel {

	
	private String id;
	
	private String name;
	
	private String utilzation;
	
	private String link;
	
	private String used;
	
	private String threshold;

	private String value;
	
	private String stuts;
	
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

	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
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
	
}
