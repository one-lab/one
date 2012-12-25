package com.sinosoft.one.log.queue;

import com.sinosoft.one.log.Loggable;
import com.sinosoft.one.util.queue.QueuesHolder;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

import java.util.concurrent.BlockingQueue;

/**
 * 将Loggable信息添加到队列
 * User: carvin
 * Date: 12-12-13
 * Time: 下午3:12
 * To change this template use File | Settings | File Templates.
 */
public class LoggableQueueAppender {
    private String queueName;

    private BlockingQueue<Loggable> queue;

    /**
     * 将Loggable信息放入Queue.
     */
    public void append(Loggable loggable) {
        if (queue == null) {
            queue = QueuesHolder.getQueue(queueName);
        }
        boolean sucess = queue.offer(loggable);

        if (sucess) {
            LogLog.debug("put event to queue success:" + loggable.convertToString());
        } else {
            LogLog.error("Put event to queue fail:" + loggable.convertToString());
        }
    }


    public String getQueueName() {
        return queueName;
    }

    /**
     * @see #getQueueName()
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
