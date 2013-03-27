package com.sinosoft.one.monitor.log;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.notification.NotificationModel;
import com.sinosoft.one.monitor.notification.NotificationServiceFactory;
import com.sinosoft.one.monitor.notification.NotificationType;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * URL响应时间队列.
 * User: carvin
 * Date: 13-3-2
 * Time: 下午10:56
 */
public class UrlResponseTimeQueue implements NotificationModel {
	private UrlResponseTimeQueue() {}
	private String data = "[]";
	private final static int SIZE = 1;
	private final static UrlResponseTimeQueue INSTANCE = new UrlResponseTimeQueue();

	private List<UrlResponseTime> urlResponseTimeList = new CopyOnWriteArrayList<UrlResponseTime>();

	public static UrlResponseTimeQueue build() {
		return INSTANCE;
	}

	public void append(UrlResponseTime urlResponseTime) {
		urlResponseTimeList.add(urlResponseTime);
		if(urlResponseTimeList.size() >= SIZE) {
			data = JSON.toJSONStringWithDateFormat(urlResponseTimeList, "yyyy-MM-dd HH:mm:ss");
			NotificationServiceFactory.buildNotificationService().notification(this);
			urlResponseTimeList.clear();
		}
	}

	@Override
	public NotificationType notificationType() {
		return NotificationType.URLRESPONSETIME;
	}

	@Override
	public String data() {
		return data;
	}
}
