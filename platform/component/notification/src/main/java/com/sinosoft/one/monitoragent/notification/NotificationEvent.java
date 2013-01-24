/**
 * Copyright (c) 2005-2012 sinosoft.com.cn
 *
 */
package com.sinosoft.one.monitoragent.notification;

import java.io.Serializable;

/**
 * 通知事件对象
 */
public class NotificationEvent implements Serializable {
	static final long serialVersionUID = 1L;
	private String title;
	private String content;
	private String remark;
	private String grade;
	private NotificationModule notificationModule;
	

	/**
	 * 
	 * @param appName
	 *            应用名称
	 * @param title
	 *            主题
	 * @param content
	 *            内容
	 * @param notificationModule
	 *            从NotificationModule枚举类中选择自己的模块
	 */
	public NotificationEvent(String title, String content,String remark, NotificationModule notificationModule,String grade) {
		this.title = title;
		this.content = content;
		this.notificationModule = notificationModule;
		this.remark=remark;
		this.grade=grade;
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
	
	public String getRemark() {
		return remark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setNotificationModule(NotificationModule notificationModule) {
		this.notificationModule = notificationModule;
	}

}
