package com.sinosoft.one.monitor.utils;


import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static long minus(Date minuendDate, Date subtrahendDate, int type) {
		long result = minuendDate.getTime() - subtrahendDate.getTime();

		switch(type) {
			case Calendar.SECOND : return result / 1000;
			case Calendar.MINUTE : return result / (60*1000);
			case Calendar.HOUR: return result / (24*60*1000);
			default: throw new UnsupportedOperationException("this type is not support.");
		}
	}
}
