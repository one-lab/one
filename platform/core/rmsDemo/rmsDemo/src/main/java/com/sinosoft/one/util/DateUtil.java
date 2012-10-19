package com.sinosoft.one.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class DateUtil {
	private DateUtil() {}
	
	public enum FormatMode {
		YYYYMMDDHHMMSS("yyyy-MM-dd HH:mm:ss"),
		YYYYMMDDHHMM("yyyy-MM-dd HH:mm"),
		YYYYMMDDHH("yyyy-MM-dd HH"),
		YYYYMMDD("yyyy-MM-dd"),
		YYYYMM("yyyy-MM"),
		HHMMSS("HH:mm:ss"),
		HHMM("HH:mm");
		
		private final String formatString;
		private FormatMode(String formatString) {
			this.formatString = formatString;
		}
		
		public String value() {
			return formatString;
		}
	}
	
	private static Log log = LogFactory.getLog(DateUtil.class);
	
	public static String Date2String(Date date, String formatString) {
		if(date == null) {
			return "";
		}
		if(formatString == null || formatString.equals("")) {
			formatString = "yyyy-MM-dd HH:mm:ss";
		}
		DateFormat dateFormat = new SimpleDateFormat(formatString);
		return dateFormat.format(date);
	}
	
	public static String Date2String(Date date, FormatMode formatMode) {
		if(date == null) {
			return "";
		}
		if(formatMode == null) {
			formatMode = FormatMode.YYYYMMDDHHMMSS;
		}
		DateFormat dateFormat = new SimpleDateFormat(formatMode.value());
		return dateFormat.format(date);
	}
	
	public static String calendar2String(Calendar calendar, String formatString) {
		return Date2String(calendar.getTime(), formatString);
	}
	
	public static String calendar2String(Calendar calendar) {
		return Date2String(calendar.getTime(), "");
	}
	
	public static Calendar date2Calendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	@SuppressWarnings("deprecation")
	public static int getHour(Date date) {
		return date.getHours();
	}
	
	@SuppressWarnings("deprecation")
	public static int getMinute(Date date) {
		return date.getMinutes();
	}
	
	@SuppressWarnings("deprecation")
	public static int getSecond(Date date) {
		return date.getSeconds();
	}
	
	public static long getTime(Date date) {
		return date.getTime();
	}
	public static String Date2String(Date date) {
		return Date2String(date, "");
	}
	
	public static Date String2Date(String str, String formatString) {
		if(str == null || str.equals("")) {
			return new Date();
		}
		if(formatString == null || formatString.equals("")) {
			formatString = "yyyy-MM-dd HH:mm:ss";
		}
		
		DateFormat dateFormat = new SimpleDateFormat(formatString);
		Date d = null;
		try {
			d = dateFormat.parse(str);
		} catch (ParseException e) {
			log.error("parser string to date exception.", e);
		}
		return d;
	}
	
	public static int minus(Date minuendDate, Date subtrahendDate, int type) {
		Calendar minuendCalendar = Calendar.getInstance();
		minuendCalendar.setTime(minuendDate);
		int minuendYear = minuendCalendar.get(Calendar.YEAR);
		int minuendMonth =  minuendCalendar.get(Calendar.MONTH) + 1;
		int minuendDay = minuendCalendar.get(Calendar.DAY_OF_MONTH);
		int minuendHour = minuendCalendar.get(Calendar.HOUR_OF_DAY);
		int minuendMinute = minuendCalendar.get(Calendar.MINUTE);
		int minuendSecond = minuendCalendar.get(Calendar.SECOND);
		
		Calendar subtrahendCalendar = Calendar.getInstance();
		
		subtrahendCalendar.setTime(subtrahendDate);
		int subtrahendYear = subtrahendCalendar.get(Calendar.YEAR);
		int subtrahendMonth =  subtrahendCalendar.get(Calendar.MONTH) + 1;
		int subtrahendDay = subtrahendCalendar.get(Calendar.DAY_OF_MONTH);
		int subtrahendHour = subtrahendCalendar.get(Calendar.HOUR_OF_DAY);
		int subtrahendMinute = subtrahendCalendar.get(Calendar.MINUTE);
		int subtrahendSecond = subtrahendCalendar.get(Calendar.SECOND);
		
		int dayOfYear = (minuendYear - subtrahendYear) * getDayOfYear(subtrahendYear);
		int dayOfMonth = (minuendMonth - subtrahendMonth) * getDayOfMonth(subtrahendYear, subtrahendMonth);
		int hour = (dayOfYear + dayOfMonth + minuendDay - subtrahendDay) * 24 + (minuendHour - subtrahendHour);
		
		switch(type) {
			case Calendar.SECOND : return (hour * 60 + (minuendMinute - subtrahendMinute)) * 60 + (minuendSecond - subtrahendSecond);
			case Calendar.MINUTE : return hour * 60 + (minuendMinute - subtrahendMinute);
			case Calendar.HOUR: return hour;
			case Calendar.HOUR_OF_DAY: return hour;
			case Calendar.DAY_OF_YEAR:return hour/24;
			default: return 0;
		}
	}
	
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0); 
	}
	
	public static int getDayOfYear(int year) {
		return  isLeapYear(year) ? 366 : 365; 
	}
	
	public static int getDayOfMonth(int year, int month) {
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: return 31;
			case 2 : return (isLeapYear(year) ? 29 : 28); 
			default: return 30;
		}
	}
	
	public static Date plus(Date summandDate, int type, int value) {
		Calendar summandCalendar = Calendar.getInstance();
		summandCalendar.setTime(summandDate);
		summandCalendar.set(type, summandCalendar.get(type) + value);
		
		return summandCalendar.getTime(); 
	}
	
	public static int compareTo(Date d1, Date d2) {
		return minus(d1, d2, Calendar.MINUTE);
	}
	public static Timestamp String2Timestamp(String str) {
		return Timestamp.valueOf(str);
	}
	public static boolean dateCompareEqual(Date a, Date b){
		if (a == null && b == null)
            return true;
        if (a == null || b == null)
          return false;
        long na = a.getTime();
        long nb = b.getTime();
        
        if (na == nb)
            return true;
        return false;
	}
	
	public static void main(String[] args) {
//		System.out.println(DateUtil.Date2String(new Date(), DateUtil.FormatMode.YYYYMM));
		//System.out.println(DateUtil.FormatString.YYYYMM);
	}
}
