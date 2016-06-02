package com.sinosoft.one.test.rule.domain;

import java.io.Serializable;

public class UndwrtRiskKind implements Serializable {

    private static final long serialVersionUID = UndwrtRiskKind.class.hashCode();

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    private String kindCode;
	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	private double amount;
}
