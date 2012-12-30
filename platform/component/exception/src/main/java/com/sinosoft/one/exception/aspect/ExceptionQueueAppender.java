package com.sinosoft.one.exception.aspect;


import java.util.concurrent.BlockingQueue;

import com.sinosoft.one.util.queue.QueuesHolder;
import org.apache.log4j.helpers.LogLog;
/**
 *
 * 将所有消息放入QueueManager所管理的Blocking Queue中.
 *
 * @see QueuesHolder
 *
 * @author qc
 */
public class ExceptionQueueAppender{

    private  String  queueName;

    private int queueSize = Integer.MAX_VALUE;

    private  BlockingQueue<ExceptionEvent> queue;

    /**
     * Exception放入ExceptionQueue.
     */
    public void append(ExceptionEvent event) {
        if (queue == null) {
            queue = QueuesHolder.getQueue(queueName, queueSize);
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

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }
}
