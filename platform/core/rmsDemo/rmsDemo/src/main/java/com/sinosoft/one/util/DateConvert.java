package com.sinosoft.one.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class DateConvert implements Converter {
	private String formatter = "yyyy-MM-dd";
	
	public DateConvert() {}
	public DateConvert(String formatter) {
		this.formatter = formatter;
	}
	
	public Object convert(Class clazz, Object obj) {
		if(obj == null) return null;
		if(obj instanceof String){
			String p = (String) obj;
			if (p == null || p.trim().length() == 0) {
				return null;
			}
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return df.parse(p.trim());
			} catch (Exception e) {
				try {
					SimpleDateFormat df = new SimpleDateFormat(formatter);
					return df.parse(p.trim());
				} catch (ParseException ex) {
					return null;
				}
			}
		} else if(obj instanceof Date) {
			Date d = (Date)obj;
			return d;
		} 
		return null;
	}
}   