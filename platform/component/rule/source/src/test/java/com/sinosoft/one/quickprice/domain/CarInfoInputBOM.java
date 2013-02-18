package com.sinosoft.one.quickprice.domain;

public class CarInfoInputBOM {
	private String areaCode;
	private double replacementValue;
	private int vehicleAge;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public double getReplacementValue() {
		return replacementValue;
	}

	public void setReplacementValue(double replacementValue) {
		this.replacementValue = replacementValue;
	}

	public int getVehicleAge() {
		return vehicleAge;
	}

	public void setVehicleAge(int vehicleAge) {
		this.vehicleAge = vehicleAge;
	}

}
