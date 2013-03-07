package com.sinosoft.one.monitor.notification;

/**
 * Notification 服务类.
 * User: carvin
 * Date: 13-3-2
 * Time: 下午4:41
 */
public class NotificationService {
	private String urlData = "";
	NotificationService() {

	}

	void initUrlData(String urlData) {
		this.urlData = urlData;
	}

	public String getUrlData() {
		if(urlData == null || "".equals(urlData)) {
			NotificationConfiguration.getInstance().initUrlData();
		}
		return urlData;
	}


	public void notification(NotificationModel notificationModel) {
		if(NotificationConfiguration.getInstance().isMonitor()) {
			NotificationModelEventSupport.build().notification(notificationModel);
		}
	}




}
