package com.sinosoft.one.test.rule.service.facade;

/**
 * 投保单套餐选择校验对象
 * @author qc
 *
 */
public class ProposalCheck {

	/**
	 * 上年度终保日期
	 */
	private String lastEndDate;
	
	/**
	 * 今年度起保日期
	 */
	private String startDate;
	
	/**
	 * 车架号
	 */
	private String frameNo;
	
	/**
	 * 新车购置价
	 */
	private String purchasePrice;
	
	/**
	 * 车辆品牌
	 */
	private String brandName;
	
	/**
	 * 车辆登记日期
	 */
	private String enrollDate;
	
	/**
	 * 违章记录次数
	 */
	private String violationCount;
	
	/**
	 * 出险次数
	 */
	private String claimCount;
	
	/**
	 * 座位数
	 */
	private String seatCount;
	
	/**
	 * 车龄
	 */
	private int carAge;
	
	
	public int getCarAge() {
		return carAge;
	}

	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}

	public String getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(String seatCount) {
		this.seatCount = seatCount;
	}

	public String getLastEndDate() {
		return lastEndDate;
	}

	public void setLastEndDate(String lastEndDate) {
		this.lastEndDate = lastEndDate;
	}

	public String getFrameNo() {
		return frameNo;
	}

	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	public String getViolationCount() {
		return violationCount;
	}

	public void setViolationCount(String violationCount) {
		this.violationCount = violationCount;
	}

	public String getClaimCount() {
		return claimCount;
	}

	public void setClaimCount(String claimCount) {
		this.claimCount = claimCount;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}
