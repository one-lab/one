package com.sinosoft.one.monitor.notification;

/**
 * Notification服务创建工厂.
 * User: carvin
 * Date: 13-3-2
 * Time: 下午4:42
 */
public class NotificationServiceFactory {
	private static NotificationService notificationService = new NotificationService();
	public static NotificationService buildNotificationService() {
		return notificationService;
	}
}
