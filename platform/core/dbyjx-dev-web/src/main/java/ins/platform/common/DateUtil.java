package ins.platform.common;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 日期时间处理类，仅提供静态方法
 * @author 卢吉江
 *
 */
public class DateUtil {

    /**
     * 用默认格式将字符串转换为日期对象
     * @param strDate 字符串（yyyy-MM-dd格式）
     * @return 日期时间对象
     * @throws java.text.ParseException 解析异常
     */
    public static Date strToDate(String strDate) throws ParseException {
    	strDate = strDate.replaceAll("[^0-9\\-]", "");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(strDate);
    }

    /**
     * 用默认格式将字符串转换为日期对象
     * @param strDate 字符串
     * @param strFormat 转换格式字符串
     * @return 日期时间对象
     * @throws java.text.ParseException 解析异常
     */
    public static Date strToDate(String strDate, String strFormat) throws ParseException {
    	SimpleDateFormat format = new SimpleDateFormat(strFormat);
    	return format.parse(strDate);
    }
    
    /**
     * 用默认格式将字符串转换为日历期对象
     * @param strDate 字符串（yyyy-MM-dd格式）
     * @return 日历对象
     * @throws java.text.ParseException 解析异常
     */
    public static Calendar date(String strDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar gc = new GregorianCalendar();
        gc.setTime(format.parse(strDate));
        return gc;
    }
    
    /**
     * 用指定的格式将字符串转换为日历对象
     * @param strDate 字符串
     * @param strFormat 转换格式字符串
     * @return 日历对象
     * @throws java.text.ParseException 解析异常
     */
    public static Calendar strToCalendar(String strDate, String strFormat) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        Calendar gc = new GregorianCalendar();
        gc.setTime(format.parse(strDate));
        return gc;
    }

    /**
     * 转换日期时间对象为指定格式的将字符串
     * @param iDate 日期时间对象
     * @return 字符串对象
     * @throws Exception 解析异常
     */
    public static String format(Date iDate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(iDate);
    }

    /**
     * 转换日历对象为指定格式的将字符串
     * @param iCalendar 日历对象
     * @return 字符串对象
     * @throws Exception 解析异常
     */
    public static String format(Calendar iCalendar) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(iCalendar.getTime());
    }
    
    /**
     * 转换日期时间对象为指定格式的将字符串
     * @param iDate 日期时间对象
     * @param strFormat 转换格式字符串
     * @return 字符串对象
     * @throws Exception 解析异常
     */
    public static String format(Date iDate, String strFormat) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        return format.format(iDate);
    }

    /**
     * 转换日期时间对象为指定格式的将字符串
     * @param iCalendar 日期时间对象
     * @param strFormat 转换格式字符串
     * @return 字符串对象
     * @throws Exception 解析异常
     */
    public static String format(Calendar iCalendar, String strFormat) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        return format.format(iCalendar.getTime());
    }
    
    /**
     * 转换日期时间对象为指定格式的将字符串
     * @param iCalendar 日期时间对象
     * @param strFormat 转换格式字符串
     * @return 字符串对象
     * @throws Exception 解析异常
     */
    public static String formatCalendar(Calendar iCalendar) throws Exception {
    	DecimalFormat numberForm =  new DecimalFormat("00");
//  	StringBuffer returnValue = new StringBuffer();
//    	returnValue.append(String.valueOf(getYear(iCalendar)));
//    	returnValue.append(numberForm.format(getMonth(iCalendar)));
//    	returnValue.append(numberForm.format(getDay(iCalendar)));
//    	returnValue.append(numberForm.format(getHour(iCalendar)));
//    	returnValue.append(numberForm.format(getMinute(iCalendar)));
//    	returnValue.append(numberForm.format(getSecond(iCalendar)));
//    	returnValue.append(numberForm.format(getMillisecond(iCalendar)));
    	
    	return String.valueOf(getYear(iCalendar))
    		+numberForm.format(getMonth(iCalendar))
    		+numberForm.format(getDay(iCalendar))
    		+numberForm.format(getHour(iCalendar))
    		+numberForm.format(getMinute(iCalendar))
    		+numberForm.format(getSecond(iCalendar))
    		+numberForm.format(getMillisecond(iCalendar));
    }
     
    /**
     * 添加年份
     * @param idate 返回增加了年份的日期
     * @param year 要增加的年份
     * @return 增加了年份的日期对象
     */
    public static Date addYear(Date idate, int year){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	gc.add(Calendar.YEAR, year);
    	return gc.getTime();
    }

    /**
     * 添加年份
     * @param iCalendar 返回增加了年份的日期
     * @param year 要增加的年份
     * @return 增加了年份的日历对象
     */
    public static Calendar addYear(Calendar iCalendar, int year){
    	Calendar gc = iCalendar; 
    	gc.add(Calendar.YEAR, year);
    	return gc;
    }
    
    /**
     * 添加月份
     * @param idate 返回增加了年份的月份
     * @param month 要增加的月份
     * @return 增加了月份的日期对象
     */
    public static Date addMonth(Date idate, int month){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	gc.add(Calendar.MONTH, month);
    	return gc.getTime();
    }
    
    /**
     * 添加月份
     * @param iCalendar 返回增加了年份的月份
     * @param month 要增加的月份
     * @return 增加了月份的日历对象
     */
    public static Calendar addMonth(Calendar iCalendar, int month){
    	Calendar gc = iCalendar; 
    	gc.add(Calendar.MONTH, month);
    	return gc;
    }
    
    /**
     * 添加天数
     * @param idate 返回增加了天数的日期
     * @param day 要增加的天数
     * @return 增加了天数的日期对象
     */
    public static Date addDay(Date idate,int day){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	gc.add(Calendar.DATE, day);
    	return gc.getTime();
    }
    
    /**
     * 添加天数
     * @param iCalendar 返回增加了天数的日期
     * @param day 要增加的天数
     * @return 增加了天数的日历对象
     */
    public static Calendar addDay(Calendar iCalendar,int day){
    	Calendar gc = iCalendar; 
    	gc.add(Calendar.DATE, day);
    	return gc;
    }
    
    /**
     * 添加秒数
     * @param idate 返回增加了秒数的日期
     * @param second 要增加的秒数
     * @return 增加了秒数的日期对象
     */ 
    public static Date addSecond(Date idate,int second){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	gc.add(Calendar.SECOND, second);
    	return gc.getTime();
    }
    
    /**
     * 取得日历对象中的年份
     * @param iCalendar 需要取年份的日历对象
     * @return 取得的年份
     */
    public static int getYear(Calendar iCalendar){
    	return iCalendar.get(Calendar.YEAR);
    }
    
    /**
     * 取得日历对象中的月份
     * @param iCalendar 需要取月份的日历对象
     * @return 取得的月份
     */
    public static int getMonth(Calendar iCalendar){
    	return iCalendar.get(Calendar.MONTH) + 1;
    }
    
    /**
     * 取得日历对象中的日
     * @param iCalendar 需要取日的日历对象
     * @return 取得的日
     */
    public static int getDay(Calendar iCalendar){
    	return iCalendar.get(Calendar.DATE);
    }

    /**
     * 取得日历对象中的小时
     * @param iCalendar 需要取小时的日历对象
     * @return 取得的小时
     */
    public static int getHour(Calendar iCalendar){
    	return iCalendar.get(Calendar.HOUR_OF_DAY);
    }
    
    /**
     * 取得日历对象中的分钟
     * @param iCalendar 需要取分钟的日历对象
     * @return 取得的分钟
     */
    public static int getMinute(Calendar iCalendar){
    	return iCalendar.get(Calendar.MINUTE);
    }
    
    /**
     * 取得日历对象中的秒数
     * @param iCalendar 需要取秒数的日历对象
     * @return 取得的秒数
     */
    public static int getSecond(Calendar iCalendar){
    	return iCalendar.get(Calendar.SECOND);
    }
    
    /**
     * 取得日历对象中的毫秒
     * @param iCalendar 需要取毫秒的日历对象
     * @return 取得的毫秒
     */
    public static int getMillisecond(Calendar iCalendar){
    	return iCalendar.get(Calendar.MILLISECOND);
    }
    
    /**
     * 取得日期对象中的年份
     * @param idate 需要取年份的日期对象
     * @return 取得的年份
     */
    public static int getYear(Date idate){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	return gc.get(Calendar.YEAR);
    }
    
    /**
     * 取得日期对象中的月份
     * @param idate 需要取月份的日期对象
     * @return 取得的月份
     */
    public static int getMonth(Date idate){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	return gc.get(Calendar.MONTH) + 1;
    }
    
    /**
     * 取得日期对象中的日
     * @param idate 需要取日的日期对象
     * @return 取得的日
     */
    public static int getDay(Date idate){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	return gc.get(Calendar.DATE);
    }

    /**
     * 取得日期对象中的小时
     * @param idate 需要取小时的日期对象
     * @return 取得的小时
     */
    public static int getHour(Date idate){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	return gc.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 取得日期对象中的分钟
     * @param idate 需要取分钟的日期对象
     * @return 取得的分钟
     */
    public static int getMinute(Date idate){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	return gc.get(Calendar.MINUTE);
    }
    
    /**
     * 取得日期对象中的秒数
     * @param idate 需要取秒数的日期对象
     * @return 取得的秒数
     */
    public static int getSecond(Date idate){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	return gc.get(Calendar.SECOND);
    }

    /**
     * 取得日期对象中的毫秒数
     * @param idate 需要取毫秒数的日期对象
     * @return 取得的毫秒数
     */
    public static int getMillisecond(Date idate){
    	Calendar gc = new GregorianCalendar(); 
    	gc.setTime(idate);
    	return gc.get(Calendar.MILLISECOND);
    }
    
    /**
     * 转换日期时间对象为指定格式的日期时间对象
     * @param iDate 日期时间对象
     * @return 日期时间对象(yyyy-MM-dd)
     * @throws Exception 解析异常
     */
    public static Date formatDate(Date iDate) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return strToDate(format.format(iDate));
    }
    
    /**
     * 获取日历对象中的星期元素
     * @param iCalendar
     * @return 1:星期一   依次类推
     * @throws Exception
     */
    public static String getWeek(Calendar iCalendar) throws Exception {
    	
    	   String weekFlag = "1";
    	   if(iCalendar == null){
    		   weekFlag = "1";
    	   }
    	   if(Calendar.MONDAY == iCalendar.get(Calendar.DAY_OF_WEEK)){
    		   weekFlag = "1";
    	   }
    	   if(Calendar.TUESDAY == iCalendar.get(Calendar.DAY_OF_WEEK)){
    		   weekFlag = "2";
    	   }
    	   if(Calendar.WEDNESDAY == iCalendar.get(Calendar.DAY_OF_WEEK)){
    		   weekFlag = "3";
    	   }
    	   if(Calendar.THURSDAY == iCalendar.get(Calendar.DAY_OF_WEEK)){
    		   weekFlag = "4";
    	   }
    	   if(Calendar.FRIDAY == iCalendar.get(Calendar.DAY_OF_WEEK)){
    		   weekFlag = "5";
    	   }
    	   if(Calendar.SATURDAY == iCalendar.get(Calendar.DAY_OF_WEEK)){
    		   weekFlag = "6";
    	   }
    	   if(Calendar.SUNDAY == iCalendar.get(Calendar.DAY_OF_WEEK)){
    		   weekFlag = "7";
    	   }
    	   
    	return weekFlag;
    }
    
    /**
     * 获取本月最后一天
     * @return
     */
    public static Date getMonthEnd() {     
        Calendar c = Calendar.getInstance();    
        c.set(Calendar.DATE,1);//设为当前月的1号    
        c.add(Calendar.MONTH,1);//加一个月，变为下月的1号    
        c.add(Calendar.DATE,-1);//减去一天，变为当月最后一天      
        return c.getTime();    
    }    
    /**   
     * 获取今天在本月中的号码   
     * @return   
     */   
    public static int getDateOfMoth() {    
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);    
    }    
    /**   
     * 获取本月第一天   
     * @param day   
     * @return   
     */   
    public static Date firstDayMonth(){    
        Calendar c = Calendar.getInstance();        
        c.set(Calendar.DATE, 1);    
        c.set(Calendar.HOUR, 0);    
        c.set(Calendar.MINUTE, 0);    
        c.set(Calendar.SECOND, 0);    
        return c.getTime();    
    }   
    /**
     * 计算两个日期差多少天
     * @param startTime
     * @param endTime
     * @param format
     * @throws java.text.ParseException
     * @throws java.text.ParseException
     */
	public double dateDiff(String startTime, String endTime, String format) throws ParseException, ParseException {

		//按照传入的格式生成一个simpledateformate对象

		SimpleDateFormat sd = new SimpleDateFormat(format);

		long nd = 1000*24*60*60;//一天的毫秒数

		long nh = 1000*60*60;//一小时的毫秒数

		long nm = 1000*60;//一分钟的毫秒数

		long ns = 1000;//一秒钟的毫秒数

		long diff;

		diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();

		long day = diff/nd;//计算差多少天

		long hour = diff%nd/nh;//计算差多少小时

		long min = diff%nd%nh/nm;//计算差多少分钟

		long sec = diff%nd%nh%nm/ns;//计算差多少秒

		//输出结果

		System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");
		return day;

		}
	/**
	 * 得到当前时间的年月日，格式为"yyyy-MM-dd"
	 * @return
	 * @throws java.text.ParseException
	 */
	public static Date getDate() throws ParseException{
		Date nowDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return strToDate(df.format(nowDate));
		
	}
	
	public static String getTime(){
		Date nowTime = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(nowTime);
	}
}
