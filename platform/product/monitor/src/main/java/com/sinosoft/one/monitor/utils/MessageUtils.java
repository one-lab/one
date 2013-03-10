package com.sinosoft.one.monitor.utils;

import com.sinosoft.one.monitor.common.Trend;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;

/**
 * 格式化前台输出信息
 * @author Administrator
 *
 */
public class MessageUtils {

	public static String trend2CssClass(Trend available) {
		String usabilityClass = null;
		switch (available) {
		case RISE:
			usabilityClass = "sys_up";
			break;
		case SAME:
			usabilityClass = "sys_normal";
			break;
		case DROP:
			usabilityClass = "sys_down";
			break;
		default:
			usabilityClass = "sys_up";
			break;
		}
		return usabilityClass;
	}
	
	public static String SeverityLevel2CssClass(SeverityLevel health) {
		String healthClass = "";
		switch (health) {
		case INFO:
			healthClass = "fine";
			break;
		/*case WARNING:
		
			break;
		case CRITICAL:
			break;*/
		default:
			healthClass = "poor";
			break;
		}
		return healthClass;
	}
	
	public static String trend2CssClass(String strTrend) {
		Trend trend = Trend.valueOf(strTrend);
		return trend2CssClass(trend);
	}
}
