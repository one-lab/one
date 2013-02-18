package com.sinosoft.one.log.event;

import com.lmax.disruptor.MultiThreadedClaimStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SingleThreadedClaimStrategy;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.sinosoft.one.log.Loggable;

import java.io.Serializable;
import java.util.concurrent.Executors;

/**
 * 日志事件支撑类.
 * User: carvin
 * Date: 13-1-16
 * Time: 下午2:31
 *
 */
public final class LogEventSupport {
    private int ringSize = 256;
    private RingBuffer<LogEvent> ringBuffer;

    public void setRingSize(int ringSize) {
        this.ringSize = ringSize;
    }

    public LogEventSupport() {
        LogEventHandler handler = new LogEventHandler();
        Disruptor<LogEvent> disruptor =
                new Disruptor<LogEvent>(LogEvent.EVENT_FACTORY, Executors.newSingleThreadExecutor(),
                        new MultiThreadedClaimStrategy(ringSize),
                        new SleepingWaitStrategy());
        disruptor.handleEventsWith(handler);
        ringBuffer = disruptor.start();
    }

    public void publish(Loggable loggable) {
        long sequence = ringBuffer.next();
        LogEvent LogEvent = ringBuffer.get(sequence);
        LogEvent.setLogModel(loggable);
        ringBuffer.publish(sequence);
    }
}
