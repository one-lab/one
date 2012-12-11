package com.sinosoft.ebusiness.quickprice.domain;

public class KindBOM {
	private String kindCode;
	private String kindName;
	private double premium = 0.0;
	private double amount = 0.0;
	private double BasicPremium = 0.0;
	private double rate = 0.0;

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBasicPremium() {
		return BasicPremium;
	}

	public void setBasicPremium(double basicPremium) {
		BasicPremium = basicPremium;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}