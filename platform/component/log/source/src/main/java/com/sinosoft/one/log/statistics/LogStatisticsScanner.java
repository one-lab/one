package com.sinosoft.one.log.statistics;

import com.sinosoft.one.util.queue.QueuesHolder;
import com.sinosoft.one.util.thread.ThreadUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日志统计扫描类.
 * User: carvin
 * Date: 13-1-16
 * Time: 下午8:31
 * To change this template use File | Settings | File Templates.
 */
public class LogStatisticsScanner implements Runnable {
    private LogStatisticsHandler logStatisticsHandler;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ExecutorService executor;
    private int shutdownTimeout = Integer.MAX_VALUE;

    public void run() {
        List<LogStatisticsModel> logStatisticsModelList = new ArrayList<LogStatisticsModel>();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                long currentTimeMillis = System.currentTimeMillis();
                Map<String, LogStatisticsModel> logStatisticsModelMap = logStatisticsHandler.getLogStatisticsModelMap();
                if(logStatisticsModelMap == null || logStatisticsModelMap.isEmpty()) {
                    continue;
                }
                for(String key : logStatisticsModelMap.keySet()) {
                    LogStatisticsModel logStatisticsModel = logStatisticsModelMap.get(key);
                    if(logStatisticsModel.isTimeout(currentTimeMillis)) {
                        logStatisticsModelList.add(logStatisticsModel);
                        LogStatisticsModel newLogStatisticsModel = new LogStatisticsModel();
                        try {
                            PropertyUtils.copyProperties(newLogStatisticsModel, logStatisticsModel);
                            newLogStatisticsModel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                            newLogStatisticsModel.setBeginTimeMillis(logStatisticsModel.getEndTimeMillis());
                            newLogStatisticsModel.setEndTimeMillis(logStatisticsModel.getEndTimeMillis() + logStatisticsModel.getInterval());
                        } catch (Exception e) {
                            logger.error("copy log statistics model exception.", e);
                        }
                        logStatisticsModelMap.put(key, newLogStatisticsModel);
                    }
                }
                if(logStatisticsModelList.size() > 0) {
                    logStatisticsHandler.updateBranch(logStatisticsModelList);
                    logStatisticsModelList.clear();
                }
            }
        } catch (Exception e) {
            // Ignore.
            logger.warn("scan log statistics map : " + e.getMessage());
        } finally {
            //退出线程前调用清理函数.
            if(logStatisticsModelList.size() > 0) {
                logStatisticsHandler.updateBranch(logStatisticsModelList);
                logStatisticsModelList.clear();
            }
        }
    }

    public void start() throws InterruptedException {
        if(executor == null) {
            executor = Executors.newSingleThreadExecutor(new ThreadUtils.CustomizableThreadFactory("LogStatisticsScanner"));
            executor .execute(this);
        }
    }

    public void stop() {
        try {
            ThreadUtils.normalShutdown(executor, shutdownTimeout, TimeUnit.MILLISECONDS);
        } finally {

        }
    }

    public void setLogStatisticsHandler(LogStatisticsHandler logStatisticsHandler) {
        this.logStatisticsHandler = logStatisticsHandler;
    }
}
