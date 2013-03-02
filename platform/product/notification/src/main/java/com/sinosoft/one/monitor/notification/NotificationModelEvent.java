package com.sinosoft.one.monitor.notification;

import com.lmax.disruptor.EventFactory;

/**
 * 通知事件
 * User: carvin
 * Date: 13-3-2
 * Time: 下午5:25
 * To change this template use File | Settings | File Templates.
 */
final class NotificationModelEvent {
	private NotificationModel notificationModel;

	private NotificationModelEvent() {}

	public final static EventFactory<NotificationModelEvent> EVENT_FACTORY = new EventFactory<NotificationModelEvent>()
	{
		public NotificationModelEvent newInstance()
		{
			return new NotificationModelEvent();
		}
	};

	public NotificationModel getNotificationModel() {
		return notificationModel;
	}

	public void setNotificationModel(NotificationModel notificationModel) {
		this.notificationModel = notificationModel;
	}
}
