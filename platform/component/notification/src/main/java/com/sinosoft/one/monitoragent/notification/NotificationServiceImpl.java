package com.sinosoft.one.monitoragent.notification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * @author zhujinwei
 * 
 */
@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {
	
	private NotificationQueueAppender notificationQueueAppender;
		
	private NotificationConfigureDealer notificationCongfigureDealerMethod;

	private NotificationConfigureDealer notificationCongfigureDealerUrl;

	@Autowired
	public void setNotificationCongfigureDealerMethod(@Qualifier("configureDealerMethod")
			NotificationConfigureDealer notificationCongfigureDealerMethod) {
		this.notificationCongfigureDealerMethod = notificationCongfigureDealerMethod;
	}
	@Autowired
	public void setNotificationCongfigureDealerUrl(@Qualifier("configureDealerUrl")
			NotificationConfigureDealer notificationCongfigureDealerUrl) {
		this.notificationCongfigureDealerUrl = notificationCongfigureDealerUrl;
	}

	public void notification(NotificationEvent event) {
		notificationQueueAppender.append(event);
	}

	public NotificationQueueAppender getNotificationQueueAppender() {
		return notificationQueueAppender;
	}

    @Autowired
	public void setNotificationQueueAppender(
			NotificationQueueAppender notificationQueueAppender) {
		this.notificationQueueAppender = notificationQueueAppender;
	}

	public List<MethodInitConfigure> getMethodInitConfigure() {
		String responseText = notificationCongfigureDealerMethod.getConfigureInfo();
		System.out.println("-------------"+responseText+"------------");
		List<MethodInitConfigureImpl > list = JSON.parseArray(responseText,MethodInitConfigureImpl.class);
		List<MethodInitConfigure> list2 = new ArrayList<MethodInitConfigure>();
		if(list.size()!=0)
			for(MethodInitConfigureImpl method:list){
				list2.add(method);
			}
		return list2;
	}
	public List<UrlInitConfigure> getUrlInitConfigure() {
		String responseText = notificationCongfigureDealerUrl.getConfigureInfo();
		if("failed".equals(responseText)){
			return null;
		}
		System.out.println("-------------"+responseText+"------------");
		List<UrlInitConfigureImpl> list = JSON.parseArray(responseText,UrlInitConfigureImpl.class);
		List<UrlInitConfigure> list2 = new ArrayList<UrlInitConfigure>();
		for(UrlInitConfigure url:list){
			list2.add(url);
		}
		return list2;
	}
	static class MethodInitConfigureImpl implements MethodInitConfigure{
		/**
		 * 方法名称
		 */
		private String methodName;
		/**
		 * 类名
		 */
		private String className;
		/**
		 * 阀值
		 */
		private String threshold;
		/**
		 * 环境信息
		 */
		private String environment;
		/**
		 * 统计频率
		 */
		private String interval;

		public String getMethodName() {
			return methodName;
		}

		public String getClassName() {
			return className;
		}

		public String getThreshold() {
			return threshold;
		}

		public String getEnvironment() {
			return environment;
		}

		public String getInterval() {
			return interval;
		}

		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public void setThreshold(String threshold) {
			this.threshold = threshold;
		}

		public void setEnvironment(String environment) {
			this.environment = environment;
		}

		public void setInterval(String interval) {
			this.interval = interval;
		}
	}
	
	
	static class UrlInitConfigureImpl implements UrlInitConfigure{
		/**
		 * url路径
		 */
		private String url;
		/**
		 * url名称
		 */
		private String name;
		/**
		 * 阀值
		 */
		private String threshold;
		/**
		 * 环境信息
		 */
		private String environment;
		/**
		 * 统计频率
		 */
		private String interval;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getThreshold() {
			return threshold;
		}

		public void setThreshold(String threshold) {
			this.threshold = threshold;
		}

		public String getEnvironment() {
			return environment;
		}

		public void setEnvironment(String environment) {
			this.environment = environment;
		}

		public String getInterval() {
			return interval;
		}

		public void setInterval(String interval) {
			this.interval = interval;
		}

}
}

