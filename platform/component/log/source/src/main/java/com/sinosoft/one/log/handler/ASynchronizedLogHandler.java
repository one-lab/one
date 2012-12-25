package com.sinosoft.one.log.handler;

import com.sinosoft.one.log.Loggable;
import org.apache.log4j.Appender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志处理类
 * User: carvin
 * Date: 12-11-27
 * Time: 下午8:30
 * To change this template use File | Settings | File Templates.
 */
public class ASynchronizedLogHandler implements LogHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private List<Loggable> loggableList = new ArrayList<Loggable>();
    private int batchSize = 10;
    private String sql = "";

    private NamedParameterJdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

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
     * 根据注入的monitordataSource创建jdbcTemplate.
     */
    public void setLogMonitorDataSource(DataSource logMonitordataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(logMonitordataSource);
    }

    /**
     * 根据注入的monitorTransactionManager创建transactionTemplate.
     */
    public void setLogMonitorTransactionManager(
            PlatformTransactionManager logMonitorTransactionManager) {
        transactionTemplate = new TransactionTemplate(logMonitorTransactionManager);
    }

    public void doHandler(Loggable loggable) {
        loggableList.add(loggable);
        if(loggableList.size() >= batchSize) {
            updateBranch();
        }
    }

    private void updateBranch() {
        try {
            // 分析事件列表, 转换为jdbc批处理参数.
            int i = 0;
            Map[] paramMapArray = new HashMap[loggableList.size()];
            for (Loggable loggable : loggableList) {
                paramMapArray[i++] = loggable.toMap();
            }
            final SqlParameterSource[] batchParams = SqlParameterSourceUtils
                    .createBatch(paramMapArray);

            // 执行批量插入,如果失败调用失败处理函数.
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(
                        TransactionStatus status) {
                try {
                    jdbcTemplate.batchUpdate(sql, batchParams);

                    if (logger.isDebugEnabled()) {
                        for (Loggable loggable : loggableList) {
                            logger.debug("saved log: {}",
                                    loggable.toString());
                        }
                    }

                } catch (DataAccessException e) {
                    status.setRollbackOnly();
                    handleDataAccessException(e, loggableList);
                }
                }
            });

            // 清除已完成的Buffer
            loggableList.clear();
        } catch (Exception e) {
            logger.error("批量提交任务时发生错误.", e);
        }
    }

    protected void handleDataAccessException(DataAccessException e,
                                             List<Loggable> loggableList) {
        if (e instanceof DataAccessResourceFailureException) {
            logger.error("database connection error", e);
        } else {
            logger.error("other database error", e);
        }

        for (Loggable loggable : loggableList) {
            logger.error("event insert to database error, ignore it: "
                    + loggable.toString(), e);
        }
    }

    public void clean() {
        if(!loggableList.isEmpty()) {
            updateBranch();
        }
        logger.debug("cleaned task {}", this);
    }
}
