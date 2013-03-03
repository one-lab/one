package com.sinosoft.one.monitor.notification;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * Notification配置信息.
 * User: carvin
 * Date: 13-3-2
 * Time: 下午3:16
 * To change this template use File | Settings | File Templates.
 */
public final class NotificationConfiguration {
	private static Logger logger = LoggerFactory.getLogger(NotificationConfiguration.class);
	private final static NotificationConfiguration INSTANCE = new NotificationConfiguration();
	public final static String NOTIFICATION_INFO_FILENAME = "notification.info";
	private final static String NOTIFICATION_PROPERTIES_FILENAME = "notification.properties";
	private final static String MONITOR_APPLICATION_INIT_URL = "/application/manager/appManager/match/";

	private NotificationConfiguration() {}
	private Properties notificationProperties;
	private static String applicationId = "";
	private static String baseUrl = "";

	public static NotificationConfiguration getInstance() {
		return INSTANCE;
	}

	public void init()  {
		try {
			loadProperties();
		} catch (Exception e) {
			logger.error("Notification configuration init exception.", e);
		}
	}

	private void loadProperties() throws Exception {
		notificationProperties = new Properties();
		notificationProperties.load(this.getClass().getResourceAsStream(NOTIFICATION_PROPERTIES_FILENAME));
		baseUrl = "http://" + notificationProperties.get("monitor.server.ip") + ":" + notificationProperties.get("monitor.server.port") + "/monitor";
		loadInitData(baseUrl + MONITOR_APPLICATION_INIT_URL);
	}

	private void loadInitData(String url) throws Exception {
		File file = new File(NOTIFICATION_INFO_FILENAME);
		if(!file.exists()) {
			String responseStr = NotificationHttpSupport.post(url, new HashMap<String, String>() {
				{
					put("ip", notificationProperties.get("application.ip").toString());
					put("port", notificationProperties.get("application.port").toString());
					put("appName", notificationProperties.get("application.name").toString());
				}
			});

			if(NotificationResponseType.Exception.name().equalsIgnoreCase(responseStr)) {
				logger.error("Init data from monitor server url [" + url + "] exception.");
			} else if(NotificationResponseType.NotExist.name().equalsIgnoreCase(responseStr)) {
				return;
			} else {
				JSONObject jsonObject = JSON.parseObject(responseStr);
				applicationId = jsonObject.getString("applicationId");
				NotificationServiceFactory.buildNotificationService().initUrlData(jsonObject.getString("urls"));

				file.createNewFile();
				OutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(file);
					outputStream.write(("agent.enable=true\nagent.id=" + applicationId).getBytes());
					outputStream.flush();
				} catch (Exception e) {
					logger.error("write file " + NOTIFICATION_INFO_FILENAME + "exception.", e);
				} finally {
					if(null != outputStream) {
						outputStream.close();
					}
				}
			}
		} else {
			reloadApplicationId(file);
		}
	}

	public void reloadApplicationId(File file)  {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			Properties agentInfoProperties = new Properties();
			agentInfoProperties.load(inputStream);
			applicationId = agentInfoProperties.get("agent.id").toString();
		} catch (Exception e) {
			logger.error("read file " + NOTIFICATION_INFO_FILENAME + "exception.", e);
		} finally {
			if(null != inputStream) {
				try {
					inputStream.close();
				} catch(Exception e) {
					logger.error("input stream close exception.", e);
				}
			}
		}
	}

	public void removeApplication() {
		applicationId = null;
		File file = new File(NOTIFICATION_INFO_FILENAME);
		if(file.exists()) {
			file.delete();
		}
	}

	public boolean isMonitor() {
		if(applicationId != null && !applicationId.equals("")) {
			return true;
		} else {
			File file = new File(NOTIFICATION_INFO_FILENAME);
			if(!file.exists()) {
				return false;
			}
			reloadApplicationId(file);
			return true;
		}
	}

	public String getApplicationId() {
		return applicationId;
	}

	public String getBaseUrl() {
		return baseUrl;
	}
}
