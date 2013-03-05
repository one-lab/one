package com.sinosoft.one.monitor.utils;

import java.util.Calendar;

public class DateUtil {
	/**
	 * 返回一个没clear后的Calender
	 * @return
	 */
	public static Calendar getCalender(){
		Calendar clender = Calendar.getInstance();
		clender.clear();
		return clender;
	}
}
