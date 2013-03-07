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
	private final static String MONITOR_APPLICATION_INIT_URL = "/application/manager/appmanager/match/";

	private NotificationConfiguration() {
		init();
	}
	private Properties notificationProperties;
	private String applicationId = "";
	private int ringBufferSize = 1024;
	private String baseUrl = "";

	public static NotificationConfiguration getInstance() {
		return INSTANCE;
	}

	private void init()  {
		try {
			loadProperties();
		} catch (Exception e) {
			logger.error("Notification configuration init exception.", e);
		}
	}

	private void loadProperties() throws Exception {
		notificationProperties = new Properties();
		notificationProperties.load(this.getClass().getClassLoader().getResourceAsStream(NOTIFICATION_PROPERTIES_FILENAME));
		baseUrl = "http://" + notificationProperties.get("monitor.server.ip") + ":" + notificationProperties.get("monitor.server.port") + "/monitor";
		ringBufferSize = Integer.parseInt(notificationProperties.getProperty("ringbuffer.size"));
	}

	void initUrlData() {
		try {
			loadInitData();
		} catch (Exception e) {
			logger.error("Notification configuration init url exception.", e);
		}
	}

	private void loadInitData() throws Exception {
		String url = baseUrl + MONITOR_APPLICATION_INIT_URL;
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
				if(applicationId != null) {
					String urls = jsonObject.getString("urls");
					if(urls != null && !urls.equals("")) {
						NotificationServiceFactory.buildNotificationService().initUrlData(jsonObject.getString("urls"));
					}

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
			}
		} else {
			reloadApplicationId(file, url);
		}
	}

	private void reloadApplicationId(File file, String url)  {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			Properties agentInfoProperties = new Properties();
			agentInfoProperties.load(inputStream);
			applicationId = agentInfoProperties.get("agent.id").toString();
			String responseStr = NotificationHttpSupport.post(url, new HashMap<String, String>() {
				{
					put("applicationId", applicationId);
				}
			});

			if(NotificationResponseType.Exception.name().equalsIgnoreCase(responseStr)) {
				logger.error("Init data from monitor server url [" + url + "] exception.");
			} else if(NotificationResponseType.NotExist.name().equalsIgnoreCase(responseStr)) {
				removeApplication();
			} else {
				JSONObject jsonObject = JSON.parseObject(responseStr);
				String urls = jsonObject.getString("urls");
				if(urls != null && !urls.equals("")) {
					NotificationServiceFactory.buildNotificationService().initUrlData(jsonObject.getString("urls"));
				}
			}
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
			reloadApplicationId(file, baseUrl + MONITOR_APPLICATION_INIT_URL);
			return true;
		}
	}

	public int getRingBufferSize() {
		return ringBufferSize;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public String getBaseUrl() {
		return baseUrl;
	}
}
