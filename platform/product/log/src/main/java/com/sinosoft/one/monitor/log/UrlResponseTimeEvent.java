package com.sinosoft.one.monitor.log;

import com.lmax.disruptor.EventFactory;
import com.sinosoft.one.monitor.notification.NotificationModel;

/**
 * 通知事件
 * User: carvin
 * Date: 13-3-2
 * Time: 下午5:25
 * To change this template use File | Settings | File Templates.
 */
final class UrlResponseTimeEvent {
	private UrlResponseTime urlResponseTime;

	private UrlResponseTimeEvent() {}

	public final static EventFactory<UrlResponseTimeEvent> EVENT_FACTORY = new EventFactory<UrlResponseTimeEvent>()
	{
		public UrlResponseTimeEvent newInstance()
		{
			return new UrlResponseTimeEvent();
		}
	};

	public UrlResponseTime getUrlResponseTime() {
		return urlResponseTime;
	}

	public void setUrlResponseTime(UrlResponseTime urlResponseTime) {
		this.urlResponseTime = urlResponseTime;
	}
}
