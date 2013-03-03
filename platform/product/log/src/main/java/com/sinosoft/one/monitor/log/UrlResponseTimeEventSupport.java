package com.sinosoft.one.monitor.log;

import com.lmax.disruptor.MultiThreadedClaimStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.sinosoft.one.monitor.notification.NotificationModel;

import java.util.concurrent.Executors;

/**
 * 告警消息事件支持类
 * User: carvin
 * Date: 13-3-2
 * Time: 上午10:21
 */

final class UrlResponseTimeEventSupport {
	private static UrlResponseTimeEventSupport urlResponseTimeEventSupport = new UrlResponseTimeEventSupport();
	private final static int ringSize = 1024;
	private RingBuffer<UrlResponseTimeEvent> ringBuffer;

	public static UrlResponseTimeEventSupport build() {
		return urlResponseTimeEventSupport;
	}
	private UrlResponseTimeEventSupport() {
		init();
	}

	void init() {
		UrlResponseTimeEventHandler urlResponseTimeEventHandler = new UrlResponseTimeEventHandler();
		Disruptor<UrlResponseTimeEvent> disruptor =
				new Disruptor<UrlResponseTimeEvent>(UrlResponseTimeEvent.EVENT_FACTORY, Executors.newSingleThreadExecutor(),
						new MultiThreadedClaimStrategy(ringSize),
						new SleepingWaitStrategy());
		disruptor.handleEventsWith(urlResponseTimeEventHandler);
		ringBuffer = disruptor.start();
	}

	public void publish(UrlResponseTime urlResponseTime) {
		long sequence = ringBuffer.next();
		UrlResponseTimeEvent urlResponseTimeEvent = ringBuffer.get(sequence);
		urlResponseTimeEvent.setUrlResponseTime(urlResponseTime);
		ringBuffer.publish(sequence);
	}
}
