package com.sinosoft.one.monitor.common;

import com.lmax.disruptor.MultiThreadedClaimStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * 告警消息事件支持类
 * User: carvin
 * Date: 13-3-2
 * Time: 上午10:21
 */
public class MessageBaseEventSupport {
	private static MessageBaseEventSupport messageBaseEventSupport = new MessageBaseEventSupport();
	public static MessageBaseEventSupport build() {
		return messageBaseEventSupport;
	}
	private int ringSize = 1024;
	private RingBuffer<MessageBaseEvent> ringBuffer;

	public void setRingSize(int ringSize) {
		this.ringSize = ringSize;
	}

	private MessageBaseEventSupport() {
		init();
	}

	public void init() {
		Disruptor<MessageBaseEvent> disruptor = new Disruptor<MessageBaseEvent>(MessageBaseEvent.EVENT_FACTORY, Executors.newSingleThreadExecutor(),
						new MultiThreadedClaimStrategy(ringSize),
						new SleepingWaitStrategy());
		disruptor.handleEventsWith(new MessageBaseEventHandler());
		ringBuffer = disruptor.start();
	}

	public String doMessageBase(MessageBase messageBase) {
		long sequence = ringBuffer.next();
		MessageBaseEvent messageBaseEvent = ringBuffer.get(sequence);
		messageBaseEvent.setMessageBase(messageBase);
		String alarmId = UUID.randomUUID().toString().replaceAll("-", "");
		messageBaseEvent.setAlarmId(alarmId);
		ringBuffer.publish(sequence);
		return alarmId;
	}
}
