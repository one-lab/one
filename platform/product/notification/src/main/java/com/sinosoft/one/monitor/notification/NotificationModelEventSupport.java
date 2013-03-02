package com.sinosoft.one.monitor.notification;

import com.lmax.disruptor.MultiThreadedClaimStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import java.util.concurrent.Executors;

/**
 * 告警消息事件支持类
 * User: carvin
 * Date: 13-3-2
 * Time: 上午10:21
 */

public class NotificationModelEventSupport {
	private static NotificationModelEventSupport notificationModelEventSupport = new NotificationModelEventSupport();
	private final static int ringSize = 1024;
	private RingBuffer<NotificationModelEvent> ringBuffer;

	public static NotificationModelEventSupport build() {
		return notificationModelEventSupport;
	}
	private NotificationModelEventSupport() {
		init();
	}

	void init() {
		NotificationModelEventHandler notificationModelEventHandler = new NotificationModelEventHandler();
		Disruptor<NotificationModelEvent> disruptor =
				new Disruptor<NotificationModelEvent>(NotificationModelEvent.EVENT_FACTORY, Executors.newSingleThreadExecutor(),
						new MultiThreadedClaimStrategy(ringSize),
						new SleepingWaitStrategy());
		disruptor.handleEventsWith(notificationModelEventHandler);
		ringBuffer = disruptor.start();
	}

	public void notification(NotificationModel notificationModel) {
		long sequence = ringBuffer.next();
		NotificationModelEvent notificationModelEvent = ringBuffer.get(sequence);
		notificationModelEvent.setNotificationModel(notificationModel);
		ringBuffer.publish(sequence);
	}
}
