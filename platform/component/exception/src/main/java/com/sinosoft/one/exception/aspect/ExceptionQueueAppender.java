package com.sinosoft.one.exception.aspect;


import java.util.concurrent.BlockingQueue;

import org.apache.log4j.helpers.LogLog;

import com.sinosoft.chinaelife.ebusiness.sys.util.queue.QueuesHolder;

/**
 *
 * 将所有消息放入QueueManager所管理的Blocking Queue中.
 *
 * @see QueuesHolder
 *
 * @author qc
 */
public class ExceptionQueueAppender{

    protected  String  queueName;

    protected  BlockingQueue<ExceptionEvent> queue;

    /**
     * Exception放入ExceptionQueue.
     */
    public void append(ExceptionEvent event) {
        if (queue == null) {
            queue = QueuesHolder.getQueue(queueName);
        }
        boolean sucess = queue.offer(event);

        if (sucess) {
            LogLog.debug("put exception to "+queueName+" success:" + new ExceptionEventWrapper(event).convertToString());
        } else {
            LogLog.error("Put exception to "+queueName+" fail:" + new ExceptionEventWrapper(event).convertToString());
        }
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
