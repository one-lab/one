package com.sinosoft.one.monitor.common;

import com.lmax.disruptor.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 告警消息事件处理类.
 * User: carvin
 * Date: 13-3-2
 * Time: 上午10:14
 */
public class MessageBaseEventHandler implements EventHandler<MessageBaseEvent> {
	@Override
	public void onEvent(MessageBaseEvent event, long sequence, boolean endOfBatch) throws Exception {
		AlarmMessageHandlerHelpers.getAlarmMessageHandler().doMessage(event.getMessageBase(), event.getAlarmId());
	}
}
