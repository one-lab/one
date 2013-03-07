package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.common.Trend;

import java.util.Date;

/**
 * URL可用性
 * User: ChengQi
 * Date: 13-3-8
 * Time: AM12:18
 * To change this template use File | Settings | File Templates.
 */
public class UrlAvailableInf {

    private Trend trend;

    private int count;

    private int availableCount;

    private long runningTime;

    private Date latestTime;

    /**
     * URL可用性信息
     * @param trend 趋势
     * @param count 访问总数
     * @param availableCount 可用性总数
     * @param runningTime  运行时间（S）
     * @param latestTime  最后一次运行故障时间
     */
    public UrlAvailableInf(Trend trend, int count, int availableCount, long runningTime, Date latestTime) {
        this.trend = trend;
        this.count = count;
        this.availableCount = availableCount;
        this.runningTime = runningTime;
        this.latestTime = latestTime;
    }

    /**
     * 趋势
     * @return
     */
    public Trend getTrend() {
        return trend;
    }

    /**
     * 获取总数
     * @return
     */
    public int getCount() {
        return count;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public long getRunningTime() {
        return runningTime;
    }

    public Date getLatestTime() {
        return latestTime;
    }
}
