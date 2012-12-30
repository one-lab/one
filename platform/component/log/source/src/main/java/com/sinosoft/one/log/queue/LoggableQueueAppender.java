package com.sinosoft.one.log.queue;

import com.sinosoft.one.log.Loggable;
import com.sinosoft.one.log.Loggables;
import com.sinosoft.one.util.queue.QueuesHolder;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private int queueSize = Integer.MAX_VALUE;

    private BlockingQueue<Loggable> queue;

    private static Logger logger = LoggerFactory.getLogger(LoggableQueueAppender.class);

    /**
     * 将Loggable信息放入Queue.
     */
    public void append(Loggable loggable) {
        if(Loggables.hasQueueAppender()) {
            if (queue == null) {
                queue = QueuesHolder.getQueue(queueName);
            }
            boolean sucess = queue.offer(loggable);

            if (sucess) {
                LogLog.debug("put event to queue success:" + loggable.toString());
            } else {
                LogLog.error("Put event to queue fail:" + loggable.toString());
            }
        } else if(Loggables.hasFileAppender()) {
            logger.info(loggable.toString());
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

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }
}
