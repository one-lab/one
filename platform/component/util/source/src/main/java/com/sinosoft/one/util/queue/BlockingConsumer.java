package com.sinosoft.one.util.queue;

/**
 * 采用即时阻塞读取Queue中消息策略的Consumer.
 */
public abstract class BlockingConsumer<T> extends QueueConsumer<T> {

	/**
	 * 线程执行函数,阻塞获取消息并调用processMessage()进行处理.
	 */
	public void run() {
		//循环阻塞获取消息直到线程被中断.
		try {
			while (!Thread.currentThread().isInterrupted()) {
				T message = queue.take();
				processMessage(message);
			}
		} catch (InterruptedException e) {
			// Ignore.
		} finally {
			//退出线程前调用清理函数.
			clean();
		}
	}

	/**
	 * 消息处理函数.
	 */
	protected abstract void processMessage(T message);

	/**
	 * 退出清理函数.
	 */
	protected abstract void clean();
}
