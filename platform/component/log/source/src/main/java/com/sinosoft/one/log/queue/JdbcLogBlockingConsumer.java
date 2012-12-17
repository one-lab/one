/**
 * Copyright (c) 2005-2009 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: JdbcAppenderTask.java 353 2009-08-22 09:33:28Z calvinxiu
 */
package com.sinosoft.one.log.queue;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sinosoft.one.log.Loggable;
import com.sinosoft.one.log.Loggables;
import com.sinosoft.one.util.queue.BlockingConsumer;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将Queue中的log4j event写入数据库的消费者任务.
 * 
 * 即时阻塞的读取Queue中的事件,达到缓存上限后使用Jdbc批量写入模式. 如需换为定时读取模式,继承于PeriodConsumer稍加改造即可.
 * 
 * @see com.sinosoft.one.util.queue.BlockingConsumer
 *
 * @author qc
 */
public class JdbcLogBlockingConsumer extends BlockingConsumer {

    /**
	 * 消息处理函数,将消息放入buffer,当buffer达到batchSize时执行批量更新函数.
	 */

	@Override
	protected void processMessage(Object message) {
		Loggable loggable = (Loggable) message;
		loggable.doHandler();
	}


	/**
	 * 退出清理函数,完成buffer中未完成的消息.
	 */
	@Override
	protected void clean() {
        Loggables.clean();
	}
}

