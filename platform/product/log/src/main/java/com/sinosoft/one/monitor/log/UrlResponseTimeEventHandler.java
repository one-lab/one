package com.sinosoft.one.monitor.log;

import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 告警消息事件处理类.
 * User: carvin
 * Date: 13-3-2
 * Time: 上午10:14
 */
final class UrlResponseTimeEventHandler implements EventHandler<UrlResponseTimeEvent> {
	private Logger logger = LoggerFactory.getLogger(UrlResponseTimeEventHandler.class);
	@Override
	public void onEvent(UrlResponseTimeEvent event, long sequence, boolean endOfBatch) throws Exception {
		try {
			UrlResponseTimeQueue.build().append(event.getUrlResponseTime());
		} catch (Throwable throwable) {
			logger.error("append url response time event to queue exception.", throwable);
		}

	}
}
