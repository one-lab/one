package com.sinosoft.one.log.handler;

import com.sinosoft.one.log.Loggable;
import com.sinosoft.one.log.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 同步日志处理类.
 * User: carvin
 * Date: 12-12-11
 * Time: 上午10:28
 * 同步日志处理用于同步处理相关日志，同步处理即以同步的方式处理日志.
 */
public class SynchronizedLogHandler implements LogHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String sql;

    private NamedParameterJdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    public void doHandler(final Loggable loggable) {
        try {
            final Map<String, Object> paramMap = loggable.toMap();

            // 执行插入,如果失败调用失败处理函数.
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(
                        TransactionStatus status) {
                    try {
                        jdbcTemplate.update(sql, paramMap);
                        if (logger.isDebugEnabled()) {
                            logger.debug("saved log info : {}",
                                    loggable.toString());
                        }
                    } catch (DataAccessException e) {
                        status.setRollbackOnly();
                        handleDataAccessException(e, loggable);
                    }
                }
            });
        } catch (Exception e) {
            logger.error("保存日志时发生错误.", e);
        }
    }

    protected void handleDataAccessException(DataAccessException e,
                                             Loggable loggable) {
        if (e instanceof DataAccessResourceFailureException) {
            logger.error("database connection error", e);
        } else {
            logger.error("other database error", e);
        }
    }

    public void clean() {}

    public void setSql(String sql) {
        this.sql = sql;
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
}
