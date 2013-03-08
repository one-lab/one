package com.sinosoft.one.monitor.application.domain;

/**
 * 不可用统计
 * User: ChengQi
 * Date: 13-3-8
 * Time: PM4:33
 * To change this template use File | Settings | File Templates.
 */
public class TimeQuantumAvailableStatistics {

    private int count;

    private int available;

    private int timeQuantum;

    public AvailableStatistics(int count, int available, int timeQuantum) {
        this.count = count;
        this.available = available;
        this.timeQuantum = timeQuantum;
    }

    public int getCount(){
        return this.count;
    }

    public int getAvailable(){
        return this.available;
    }

    public int getTimeQuantum(){
        return this.timeQuantum;
    }
}
