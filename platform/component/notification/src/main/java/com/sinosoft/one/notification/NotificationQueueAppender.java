/**
 * Copyright (c) 2005-2012 sinosoft.com.cn
 *
 */
package com.sinosoft.one.notification;

import java.util.concurrent.BlockingQueue;

import com.sinosoft.one.util.queue.QueuesHolder;
import org.apache.log4j.helpers.LogLog;


/**
 * 向队列添加notification消息的类
 * 
 * @author qc
 */
public class NotificationQueueAppender {
	protected String queueName;

	protected BlockingQueue<NotificationEvent> queue;

	/**
	 * Notification放入NotificationQueue.
	 */
	public void append(NotificationEvent event) {
		if (queue == null) {
			queue = QueuesHolder.getQueue(queueName);
		}
		boolean sucess = queue.offer(event);

		if (sucess) {
			LogLog.debug("put notification to " + queueName + " success:"
					+ event.getContent());
		} else {
			LogLog.error("Put notification to " + queueName + " fail:"
					+ event.getContent());
		}
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
}
