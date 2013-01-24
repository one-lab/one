package com.sinosoft.one.monitor.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getFormatDate(String format){
		SimpleDateFormat sdf=new SimpleDateFormat(null==format||"".equals(format)?"yyyyMMddHHmmss":format);
		return sdf.format(new Date());
	}
}
