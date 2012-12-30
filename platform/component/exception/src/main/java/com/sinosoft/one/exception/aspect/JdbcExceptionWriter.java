/**
 * Copyright (c) 2005-2009 sinosoft.com.cn
 *
 */
package com.sinosoft.one.exception.aspect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.sinosoft.one.util.queue.BlockingConsumer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 将Queue中的event写入数据库的消费者任务.
 *
 * 即时阻塞的读取Queue中的事件,达到缓存上限后使用Jdbc批量写入模式. 如需换为定时读取模式,继承于PeriodConsumer稍加改造即可.
 *
 * @see BlockingConsumer
 *
 * @author qc
 */
public class JdbcExceptionWriter extends BlockingConsumer {

    protected String sql;
    protected String appName;
    protected int batchSize = 10;

    protected List<ExceptionEvent> eventsBuffer = Lists.newArrayList();
    protected NamedParameterJdbcTemplate jdbcTemplate;
    protected TransactionTemplate transactionTemplate;

    /**
     * 带Named Parameter的insert sql.
     *
     * Named Parameter的名称见AppenderUtils中的常量定义.
     */
    public void setSql(String sql) {
        this.sql = sql;
    }

    /**
     * 批量读取事件数量, 默认为10.
     */
    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    /**
     * 根据注入的MonitorDataSource创建jdbcTemplate.
     */
    @Resource
    public void setExceptionMonitorDataSource(DataSource exceptionMonitorDataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(exceptionMonitorDataSource);
    }

    /**
     * 根据注入的MonitorTransactionManager创建transactionTemplate.
     */
    @Resource
    public void setExceptionMonitorTransactionManager(
            PlatformTransactionManager exceptionMonitorTransactionManager) {
        transactionTemplate = new TransactionTemplate(exceptionMonitorTransactionManager);
    }

    /**
     * 消息处理函数,将消息放入buffer,当buffer达到batchSize时执行批量更新函数.
     */
    @Override
    protected void processMessage(Object message) {
        ExceptionEvent event = (ExceptionEvent) message;
        eventsBuffer.add(event);
        if (logger.isDebugEnabled()) {
            logger.debug("get event: {}",
                    new ExceptionEventWrapper(event).convertToString());
        }

        // 已到达BufferSize则执行批量插入操作
        if (eventsBuffer.size() >= batchSize) {
            updateBatch();
        }
    }

    /**
     * 将Buffer中的事件列表批量插入数据库.
     */
    @SuppressWarnings("rawtypes")
    public void updateBatch() {
        try {
            // 分析事件列表, 转换为jdbc批处理参数.
            int i = 0;
            Map[] paramMapArray = new HashMap[eventsBuffer.size()];
            for (ExceptionEvent event : eventsBuffer) {
                paramMapArray[i++] = parseEvent(event);
            }
            final SqlParameterSource[] batchParams = SqlParameterSourceUtils
                    .createBatch(paramMapArray);

            // 执行批量插入,如果失败调用失败处理函数.
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(
                        TransactionStatus status) {
                    try {
                        jdbcTemplate.batchUpdate(getActualSql(), batchParams);
                        if (logger.isDebugEnabled()) {
                            for (ExceptionEvent event : eventsBuffer) {
                                logger.debug("saved event: {}",
                                        new ExceptionEventWrapper(event)
                                                .convertToString());
                            }
                        }
                    } catch (DataAccessException e) {
                        status.setRollbackOnly();
                        handleDataAccessException(e, eventsBuffer);
                    }
                }
            });

            // 清除已完成的Buffer
            eventsBuffer.clear();
        } catch (Exception e) {
            logger.error("批量提交任务时发生错误.", e);
        }
    }

    /**
     * 退出清理函数,完成buffer中未完成的消息.
     */
    @Override
    protected void clean() {
        if (!eventsBuffer.isEmpty()) {
            updateBatch();
        }
        logger.debug("cleaned task {}", this);
    }

    /**
     * 分析Event, 建立Parameter Map, 用于绑定sql中的Named Parameter.
     */
    protected Map<String, Object> parseEvent(ExceptionEvent event) {
        ExceptionEventWrapper eventWrapper = new ExceptionEventWrapper(event);
        eventWrapper.setAppName(appName);
        return eventWrapper.toMap();
    }

    /**
     * 可被子类重载的数据访问错误处理函数,如将出错的事件持久化到文件.
     */
    protected void handleDataAccessException(DataAccessException e,
                                             List<ExceptionEvent> errorEventBatch) {
        if (e instanceof DataAccessResourceFailureException) {
            logger.error("database connection error", e);
        } else {
            logger.error("other database error", e);
        }

        for (ExceptionEvent event : errorEventBatch) {
            logger.error("event insert to database error, ignore it: "
                    + new ExceptionEventWrapper(event).convertToString(), e);
        }
    }

    /**
     * 可被子类重载的sql提供函数,可对sql语句进行特殊处理，如日志表的表名可带日期后缀 LOG_2009_02_31.
     */
    protected String getActualSql() {
        return sql;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

}
