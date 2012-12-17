package com.sinosoft.one.notification.service.facade;

import com.sinosoft.one.notification.NotificationEvent;


/**
 * 通知接口
 *
 * @author zhujinwei
 *
 */
public interface NotificationService {
    public void notification(NotificationEvent event);
}
