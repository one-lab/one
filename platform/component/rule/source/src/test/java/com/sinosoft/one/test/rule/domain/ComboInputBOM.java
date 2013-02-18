package com.sinosoft.one.test.rule.domain;

public class ComboInputBOM {
	private int updateFlag=2;
	public int getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(int updateFlag) {
		this.updateFlag = updateFlag;
	}

	private String areaCode;
	private String modeCode;
	private String purchasePrice;
	private String useYears;
	
	public String getAreaCode() {
		return areaCode;
	}
	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getModeCode() {
		return modeCode;
	}
	
	public void setModeCode(String modeCode) {
		this.modeCode = modeCode;
	}
	
	public String getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public String getUseYears() {
		return useYears;
	}
	
	public void setUseYears(String useYears) {
		this.useYears = useYears;
	}

}