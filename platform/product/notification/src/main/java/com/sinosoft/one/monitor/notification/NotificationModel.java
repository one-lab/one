package com.sinosoft.one.monitor.notification;

/**
 * 发送信息所需数据
 * User: carvin
 * Date: 13-3-2
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
public interface NotificationModel {

	public NotificationType notificationType();

	public String data();

}
