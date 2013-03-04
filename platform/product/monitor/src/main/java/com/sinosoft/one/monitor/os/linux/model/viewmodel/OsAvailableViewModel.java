package com.sinosoft.one.monitor.os.linux.model.viewmodel;

/**
 * 可用性传输对象
 * @author Administrator
 *
 */
public class OsAvailableViewModel {
	
	/**
	 * 颜色序号
	 */
	private int index;
	
	/**
	 * 状态值
	 */
	private String status;
	
	/**
	 * 百分比
	 */
	private String percentage;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	
}
