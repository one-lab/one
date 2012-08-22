package com.sinosoft.one.mvc.util;

public enum DateFormatMode {
	YYYYMMDDHHMMSS("yyyy-MM-dd HH:mm:ss"),
	YYYYMMDDHHMM("yyyy-MM-dd HH:mm"),
	YYYYMMDDHH("yyyy-MM-dd HH"),
	YYYYMMDD("yyyy-MM-dd"),
	YYYYMM("yyyy-MM"),
	YYYY("yyyy"),
	HHMMSS("HH:mm:ss"),
	MM("MM"),
	dd("dd"),
	HH("HH"),
	mm("mm"),
	ss("ss");
	
	private String formatString;
	private DateFormatMode(String formatString) {
		this.formatString = formatString;
	}
	
	public String toString() {
		return this.formatString;
	}
}
