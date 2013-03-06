package com.sinosoft.one.monitor.notification;

import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * 告警消息事件处理类.
 * User: carvin
 * Date: 13-3-2
 * Time: 上午10:14
 */
final class NotificationModelEventHandler implements EventHandler<NotificationModelEvent> {
	private static Logger logger = LoggerFactory.getLogger(NotificationModelEventHandler.class);
	@Override
	public void onEvent(NotificationModelEvent event, long sequence, boolean endOfBatch) throws Exception {
		try {
			final NotificationModel notificationModel = event.getNotificationModel();
			final NotificationConfiguration notificationConfiguration = NotificationConfiguration.getInstance();
			NotificationType notificationType = notificationModel.notificationType();
			String url = notificationConfiguration.getBaseUrl() + notificationType.url();
			String responseStr = NotificationHttpSupport.post(url, new HashMap<String, String>() {
				{
					put("applicationId", notificationConfiguration.getApplicationId());
					put("notificationType", notificationModel.notificationType().name());
					put("data", notificationModel.data());
				}
			});

			if(NotificationResponseType.Exception.name().equalsIgnoreCase(responseStr)) {
				logger.warn("send data to url [" + url + "] has exception.");
			} else if(NotificationResponseType.Success.name().equalsIgnoreCase(responseStr)) {
				logger.debug("send data to url [" + url + "] success.");
			} else if(NotificationResponseType.NotExist.name().equalsIgnoreCase(responseStr)){
				logger.debug("this application was removed in monitor.");
				NotificationConfiguration.getInstance().removeApplication();
			}
		} catch (Throwable throwable) {
			logger.error("send data to moinitor exception.", throwable);
		}

	}
}
