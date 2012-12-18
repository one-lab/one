/**
 * Copyright (c) 2005-2012 sinosoft.com.cn
 *
 */
package com.sinosoft.one.notification;

import java.io.Serializable;

/**
 * 通知事件对象
 * 
 * @author zhujinwei
 */
public class NotificationEvent implements Serializable {
	
	private String isSendSms;
	private String isSendEmail;
	private String title;
	private String content;
	private NotificationModule notificationModule;
	static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param isSendSms
	 *            是否发送短信 1--发送 0--不发
	 * @param isSendEmail是否发送邮件
	 *            1--发送 0--不发
	 * @param title
	 *            主题
	 * @param content
	 *            内容
	 * @param notificationModule
	 *            从NotificationModule枚举类中选择自己的模块
	 */
	public NotificationEvent(String isSendSms, String isSendEmail,
			String title, String content, NotificationModule notificationModule) {
		// this.tels_iterator = tels_iterator;
		// this.emails_iterator = emails_iterator;
		this.isSendSms = isSendSms;
		this.isSendEmail = isSendEmail;
		this.title = title;
		this.content = content;
		this.notificationModule = notificationModule;
	}

	public String getIsSendEmail() {
		return isSendEmail;
	}

	public String getIsSendSms() {
		return isSendSms;
	}

	public void setIsSendSms(String isSendSms) {
		this.isSendSms = isSendSms;
	}

	public void setIsSendEmail(String isSendEmail) {
		this.isSendEmail = isSendEmail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NotificationModule getNotificationModule() {
		return notificationModule;
	}

	public void setNotificationModule(NotificationModule notificationModule) {
		this.notificationModule = notificationModule;
	}

}
