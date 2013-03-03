package com.sinosoft.one.monitor.log;

import com.lmax.disruptor.EventHandler;


/**
 * 告警消息事件处理类.
 * User: carvin
 * Date: 13-3-2
 * Time: 上午10:14
 */
final class UrlResponseTimeEventHandler implements EventHandler<UrlResponseTimeEvent> {
	@Override
	public void onEvent(UrlResponseTimeEvent event, long sequence, boolean endOfBatch) throws Exception {
		UrlResponseTimeQueue.build().append(event.getUrlResponseTime());
	}
}
