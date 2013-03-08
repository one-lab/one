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

    private String timeQuantum;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TimeQuantumAvailableStatistics(int count, int available, String timeQuantum, String status) {
        this.count = count;
        this.available = available;
        this.timeQuantum = timeQuantum;
		this.status = status;
    }

    public int getCount(){
        return this.count;
    }

    public int getAvailable(){
        return this.available;
    }

    public String getTimeQuantum(){
        return this.timeQuantum;
    }
}
