package com.sinosoft.one.monitor.notification;

/**
 * Notification 服务类.
 * User: carvin
 * Date: 13-3-2
 * Time: 下午4:41
 */
public class NotificationService {
	private String urlData = "";
	private String applicationName = "";
	NotificationService() {

	}

	void initData(String urlData, String applicationName) {
		this.urlData = urlData;
		this.applicationName = applicationName;
	}


	public String getUrlData() {
		if(urlData == null || "".equals(urlData)) {
			NotificationConfiguration.getInstance().initUrlData();
		}
		return urlData;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void notification(NotificationModel notificationModel) {
		if(NotificationConfiguration.getInstance().isMonitor()) {
			NotificationModelEventSupport.build().notification(notificationModel);
		}
	}




}
