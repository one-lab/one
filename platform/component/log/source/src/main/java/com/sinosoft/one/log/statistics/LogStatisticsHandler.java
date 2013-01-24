package com.sinosoft.one.log.statistics;

import com.sinosoft.one.log.Loggable;
import com.sinosoft.one.log.config.LogConfigs;
import com.sinosoft.one.log.config.LogMethod;
import com.sinosoft.one.log.config.LogUrl;
import com.sinosoft.one.log.handler.LogHandler;
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
import java.util.concurrent.ConcurrentHashMap;

/**
 * 日志统计处理类.
 * User: carvin
 * Date: 13-1-16
 * Time: 下午7:18
 */
public class LogStatisticsHandler {
    private Map<String, LogStatisticsModel> logStatisticsModelMap = new ConcurrentHashMap<String, LogStatisticsModel>();

    private LogConfigs logConfigs;

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String insertSQL = "";

    private String selectSQL = "";

    private NamedParameterJdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    private LogStatisticsScanner logStatisticsScanner;

    public void init() {
        logStatisticsModelMap.clear();
        List<LogUrl> urls = logConfigs.getLogUrls();
        List<LogMethod> methods = logConfigs.getLogMethods();

        for(LogUrl logUrl : urls) {
            logStatisticsModelMap.put(logUrl.getUrl(), LogStatisticsModel.valueOf(logUrl));
        }

        for(LogMethod logMethod : methods) {
            logStatisticsModelMap.put(logMethod.getFullMethodName(), LogStatisticsModel.valueOf(logMethod));
        }

        try {
            logStatisticsScanner.start();
        } catch (InterruptedException e) {
            logger.error("start log statistics scanner exception.", e);
        }
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

    public void doHandler(String value, long executeTime) {
        LogStatisticsModel destLogStatisticsModel = logStatisticsModelMap.get(value);
        destLogStatisticsModel.increamentCount();
        destLogStatisticsModel.addExecuteTime(executeTime);
    }

    public void updateBranch(final List<LogStatisticsModel> logStatisticsModels) {
        try {
            // 分析事件列表, 转换为jdbc批处理参数.
            int i = 0;
            Map[] paramMapArray = new HashMap[logStatisticsModels.size()];
            for (LogStatisticsModel loggable : logStatisticsModels) {
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
                        jdbcTemplate.batchUpdate(insertSQL, batchParams);

                        if (logger.isDebugEnabled()) {
                            for (LogStatisticsModel loggable : logStatisticsModels) {
                                logger.debug("saved log statistics: {}",
                                        loggable.toString());
                            }
                        }

                    } catch (DataAccessException e) {
                        status.setRollbackOnly();
                        handleDataAccessException(e, logStatisticsModels);
                    }
                }
            });
        } catch (Exception e) {
            logger.error("批量提交任务时发生错误.", e);
        }
    }

    public long selectExecuteTime(final String type, final String value) {
        Long result =  jdbcTemplate.queryForLong(selectSQL, new HashMap<String, String>() {
            {
                put("type", type);
                put("value", value);
            }
        });
        return result == null ? 0 : result.longValue();
    }

    protected void handleDataAccessException(DataAccessException e,
                                             List<LogStatisticsModel> logStatisticsModels) {
        if (e instanceof DataAccessResourceFailureException) {
            logger.error("database connection error", e);
        } else {
            logger.error("other database error", e);
        }

        for (LogStatisticsModel loggable : logStatisticsModels) {
            logger.error("event insert to database error, ignore it: "
                    + loggable.toString(), e);
        }
    }

    public Map<String, LogStatisticsModel> getLogStatisticsModelMap() {
        return logStatisticsModelMap;
    }

    public void setLogConfigs(LogConfigs logConfigs) {
        this.logConfigs = logConfigs;
    }

    public String getInsertSQL() {
        return insertSQL;
    }

    public void setInsertSQL(String insertSQL) {
        this.insertSQL = insertSQL;
    }

    public String getSelectSQL() {
        return selectSQL;
    }

    public void setSelectSQL(String selectSQL) {
        this.selectSQL = selectSQL;
    }

    public void setLogStatisticsScanner(LogStatisticsScanner logStatisticsScanner) {
        this.logStatisticsScanner = logStatisticsScanner;
    }
}
