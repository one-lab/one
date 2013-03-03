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
@Component
public class MessageBaseEventSupport {
	@Autowired
	private MessageBaseEventHandler messageBaseEventHandler;
	private int ringSize = 1024;
	private RingBuffer<MessageBaseEvent> ringBuffer;

	public void setRingSize(int ringSize) {
		this.ringSize = ringSize;
	}

	public MessageBaseEventSupport() {

	}

	@PostConstruct
	public void init() {
		Disruptor<MessageBaseEvent> disruptor =
				new Disruptor<MessageBaseEvent>(MessageBaseEvent.EVENT_FACTORY, Executors.newSingleThreadExecutor(),
						new MultiThreadedClaimStrategy(ringSize),
						new SleepingWaitStrategy());
		disruptor.handleEventsWith(messageBaseEventHandler);
		ringBuffer = disruptor.start();
	}

	public String doMessageBase(MessageBase messageBase) {
		long sequence = ringBuffer.next();
		MessageBaseEvent messageBaseEvent = ringBuffer.get(sequence);
		messageBaseEvent.setMessageBase(messageBase);
		ringBuffer.publish(sequence);
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
