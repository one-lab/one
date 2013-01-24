package com.sinosoft.one.log.event;

import com.lmax.disruptor.EventFactory;
import com.sinosoft.one.log.Loggable;

import java.io.Serializable;

/**
 * 日志事件类
 * User: carvin
 * Date: 13-1-16
 * Time: 下午5:18
 */
public final class LogEvent<T extends Loggable> {
    private T logModel;

    private LogEvent() {}
    public final static EventFactory<LogEvent> EVENT_FACTORY = new EventFactory<LogEvent>()
    {
        public LogEvent newInstance()
        {
            return new LogEvent();
        }
    };

    public T getLogModel() {
        return logModel;
    }

    public void setLogModel(T logModel) {
        this.logModel = logModel;
    }
}
