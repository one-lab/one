package com.sinosoft.one.monitor.common;

import com.lmax.disruptor.EventFactory;

/**
 * 告警消息事件类
 * User: carvin
 * Date: 13-3-2
 * Time: 上午10:11
 */
public class MessageBaseEvent {
	private MessageBase messageBase;

	private MessageBaseEvent() {}

	public final static EventFactory<MessageBaseEvent> EVENT_FACTORY = new EventFactory<MessageBaseEvent>()
	{
		public MessageBaseEvent newInstance()
		{
			return new MessageBaseEvent();
		}
	};

	public MessageBase getMessageBase() {
		return messageBase;
	}

	public void setMessageBase(MessageBase messageBase) {
		this.messageBase = messageBase;
	}
}
