package com.sinosoft.one.util.date;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.Assert;

/**
 * DateUtils
 * 处理java util date
 * @author qc
 *
 */
public class DateUtils {
	
	public enum Formatter{
		/**
		 * yyyy-MM-dd
		 */
		YEAR_TO_DAY,
		/**
		 * yyyy-MM-dd HH
		 */
		YEAR_TO_HOUR,
		/**
		 * yyyy-MM-dd HH:mm
		 */
		YEAR_TO_MINUTE,
		/**
		 * yyyy-MM-dd HH:mm:ss
		 */
		YEAR_TO_SECOND;
	}
	
	static Map<Formatter,DateTimeFormatter> formatterMap = new HashMap<Formatter,DateTimeFormatter>();
	
	private static final DateTimeFormatter YEAR_TO_DAY = DateTimeFormat.forPattern("yyyy-MM-dd");
	
	private static final DateTimeFormatter YEAR_TO_HOUR = DateTimeFormat.forPattern("yyyy-MM-dd HH");
	
	private static final DateTimeFormatter YEAR_TO_MINUTE = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
	
	private static final DateTimeFormatter YEAR_TO_SECOND = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	
	static{
		formatterMap.put(Formatter.YEAR_TO_DAY, YEAR_TO_DAY);
		formatterMap.put(Formatter.YEAR_TO_HOUR, YEAR_TO_HOUR);
		formatterMap.put(Formatter.YEAR_TO_MINUTE, YEAR_TO_MINUTE);
		formatterMap.put(Formatter.YEAR_TO_SECOND, YEAR_TO_SECOND);
	}
	
	/**
	 * 根据formatter指定的日期格式，日期转换字符串
	 * @param date
	 * @param formatter
	 * @return
	 */
	public final static String toFormatString(Date date,Formatter formatter){
		Assert.notNull(date);
		Assert.notNull(formatter);
		return formatterMap.get(formatter).print(new DateTime(date.getTime()));
	}
	
	/**
	 * 根据formatter指定的日期格式，字符串转换日期
	 * @param date
	 * @param formatter
	 * @return Date
	 */
	public final static Date toFormatDate(String date,Formatter formatter){
		return DateTime.parse(date, formatterMap.get(formatter)).toDate();
	}
	
	/**
	 * 增加year年，返回一个new Date。
	 * @param date
	 * @param year
	 * @return
	 */
	public final static Date addYear(Date date,int year){
		return new DateTime(date.getTime()).plusYears(year).toDate();
	}
	
	/**
	 * 增加月，返回一个new date
	 * @param date
	 * @param month
	 * @return
	 */
	public final static Date addMonth(Date date,int month){
		return new DateTime(date.getTime()).plusMonths(month).toDate();
	}
	
	/**
	 * 增加日，返回一个new date
	 * @param date
	 * @param day
	 * @return
	 */
	public final static Date addDay(Date date,int day){
        if(day>=0)
		    return new DateTime(date.getTime()).plusDays(day).toDate();
        else
            return new DateTime(date.getTime()).minusDays(day).toDate();
	}
	
	/**
	 * 获取两个date之间的差值
	 * @param start
	 * @param end
	 * @return Period
	 */
	public final static Period getPeriod(Date start,Date end){
		Assert.notNull(start);
		Assert.notNull(end);
		Interval interval = new Interval(new DateTime(start.getTime()),new DateTime(end.getTime()));
		
		return interval.toPeriod();
	}
	
	/**
	 * 获取两个date之间相差天数
	 * @param start
	 * @param end
	 * @return
	 */
	public final static long getDurationDays(Date start,Date end){
		Assert.notNull(start);
		Assert.notNull(end);
		Interval interval = new Interval(new DateTime(start.getTime()),new DateTime(end.getTime()));
		return interval.toDuration().getStandardDays();
	}
}
