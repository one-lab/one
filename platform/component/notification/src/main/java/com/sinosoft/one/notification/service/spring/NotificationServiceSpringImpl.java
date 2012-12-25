package com.sinosoft.one.notification.service.spring;

import com.sinosoft.one.notification.NotificationEvent;
import com.sinosoft.one.notification.NotificationQueueAppender;
import com.sinosoft.one.notification.service.facade.NotificationService;


/**
 * 通知实现类
 *
 * @author zhujinwei
 *
 */
public class NotificationServiceSpringImpl implements NotificationService {

    private NotificationQueueAppender notificationQueueAppender;

    public void notification(NotificationEvent event) {
        notificationQueueAppender.append(event);
    }

    public NotificationQueueAppender getNotificationQueueAppender() {
        return notificationQueueAppender;
    }

    public void setNotificationQueueAppender(
            NotificationQueueAppender notificationQueueAppender) {
        this.notificationQueueAppender = notificationQueueAppender;
    }

}
