package com.sinosoft.one.mvc.web.instruction.reply.transport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.sinosoft.one.mvc.util.DateFormatMode;

public abstract class AbstractTransport implements Transport {
	private String[] excludes;
	private String[] includes;
	private String dateFormatString;
	private DateFormat dateFormat;
	
	public AbstractTransport() {
		dateFormat = new SimpleDateFormat(DateFormatMode.YYYYMMDDHHMMSS.toString());
	}
	
	public String[] getExcludes() {
		return excludes;
	}
	public String[] getIncludes() {
		return includes;
	}
	public String getDateFormatString() {
		return dateFormatString;
	}
	
	public void setExcludes(String[] excludes) {
		this.excludes = excludes;
	}
	public void setIncludes(String[] includes) {
		this.includes = includes;
	}
	public void setDateFormatString(String dateFormatString) {
		this.dateFormatString = dateFormatString;
		this.dateFormat = new SimpleDateFormat(dateFormatString); 
	}
	public DateFormat getDateFormat() {
		return dateFormat;
	}
}
