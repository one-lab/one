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
	/**
	 * 返回一个没clear后的Calender
	 * @return
	 */
	public static Calendar getCalender(){
		Calendar clender = Calendar.getInstance();
		clender.clear();
		return clender;
	}

	/**
	 * 得到整点Date对象
	 * @param sourceDate 原Date对象
	 * @return 整点Date对象
	 */
	public static Date getHoursDate(Date sourceDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(sourceDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	public static Date getCurrentBeginDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getCurrentEndDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 得到最近几小时的Date对象
	 * @param recentHour 最近几小时
	 * @return 最近几小时的Date对象
	 */
	public static Date getRecentHourDate(int recentHour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, recentHour*(-1));
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}


}
