/**
 * Copyright (c) 2005-2012 sinosoft.com.cn
 *
 */
package com.sinosoft.one.monitoragent.notification;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NotificationEvent的包装类
 * 
 * @author qc
 */
public class NotificationEventWrapper {
	private final NotificationEvent event;

	public NotificationEventWrapper(NotificationEvent event) {
		this.event = event;

	}

	public String getTitleParam(String param_title) {
		if (null != event && !"".equals(event.getTitle())) {
			return param_title + "=" + encode(event.getTitle()) + "&";
		}
		return param_title + "=" + encode("no title") + "&";
	}
	
	public String getContentParam(String param_content) {
		if (null != event && !"".equals(event.getContent())) {
			return param_content + "=" + encode(event.getContent()) + "&";
		}
		return param_content + "=" + encode("no content") + "&";
	}
	
	public String getNotificationModule(String param_module) {
		if (null != event && null != event.getNotificationModule())
			return param_module + "=" + encode(event.getNotificationModule().toString()) + "&";
		return param_module + "=" + encode("no module") + "&";
	}

	public String convertToString() {
		if (null != event) {
			return "notification [title:" + event.getTitle() + ",content:"
					+ event.getContent() + "]";
		}
		return "notification [event =null]";
	}

	public String getRemark(String param_remark) {
		if (null != event && !"".equals(event.getRemark())) {
			return param_remark + "=" + encode(event.getRemark()) + "&";
		}
		return param_remark + "=" + encode("no remark") + "&";
	}
	public String getGrade(String param_grade) {
		if (null != event && !"".equals(event.getGrade())) {
			return param_grade + "=" + encode(event.getGrade()) + "&";
		}
		return param_grade + "=" + encode("no grade") + "&";
	}
	public String encode(String param) {
		String paramEncode = param;
		try {
			paramEncode = URLEncoder.encode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			Logger logger = LoggerFactory
					.getLogger(NotificationEventWrapper.class);
			logger.error(e.getMessage() + "   param is:" + param, e);
		}
		return paramEncode;
	}

}
