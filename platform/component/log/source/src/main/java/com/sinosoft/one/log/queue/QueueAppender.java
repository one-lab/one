package com.sinosoft.one.log.queue;


import java.util.concurrent.BlockingQueue;

import com.sinosoft.one.log.Loggable;
import com.sinosoft.one.log.Loggables;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

import com.sinosoft.one.util.queue.QueuesHolder;

/**
 * 轻量级的Log4j异步Appender.
 * 
 * 将所有消息放入QueueManager所管理的Blocking Queue中.
 * 
 * @see QueuesHolder
 * 
 * @author qc
 */
public class QueueAppender extends org.apache.log4j.WriterAppender {

    public QueueAppender() {
        this.threshold = Level.INFO;
        this.layout = new PatternLayout("%d [%t] @@[%l] @@[%C] %-5p %-40.40c -%m%n");
    }

	/**
	 * AppenderSkeleton回调函数, 事件到达时将时间放入Queue.
	 */
	@Override
	public void append(LoggingEvent event) {
        Loggable loggable = Loggables.parseLoggingEvent(event);
		try {
            Loggables.getLogEventSupport().publish(loggable);
        } catch (Exception e) {
            LogLog.error("Put event to queue fail:" + loggable.toString());
        }
	    LogLog.debug("put event to queue success:" + loggable.toString());
	}

	/**
	 * AppenderSkeleton回调函数,关闭Logger时的清理动作.
	 */
	public void close() {
	}

	/**
	 * AppenderSkeleton回调函数, 设置是否需要定义Layout.
	 */
	public boolean requiresLayout() {
		return false;
	}
}
