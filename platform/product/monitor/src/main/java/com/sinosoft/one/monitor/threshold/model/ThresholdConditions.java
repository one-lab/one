package com.sinosoft.one.monitor.threshold.model;

/**
 * 阈值条件枚举类.
 * User: carvin
 * Date: 13-3-1
 * Time: 下午6:25
 */
public enum ThresholdConditions {
	EQ("="),
	LT("<"),
	GT(">"),
	LE("<="),
	GE(">="),
	NE("!=");

	private String _symbol;

	private ThresholdConditions(String symbol) {
		this._symbol = symbol;
	}

	public String symbol() {
		return _symbol;
	}
}
