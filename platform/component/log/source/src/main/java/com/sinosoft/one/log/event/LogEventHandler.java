package com.sinosoft.one.log.event;

import com.lmax.disruptor.EventHandler;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 13-1-16
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public class LogEventHandler implements EventHandler<LogEvent> {
    public void onEvent(final LogEvent logEvent, final long sequence, final boolean endOfBatch) throws Exception {
        logEvent.getLogModel().doHandler();
    }
}
