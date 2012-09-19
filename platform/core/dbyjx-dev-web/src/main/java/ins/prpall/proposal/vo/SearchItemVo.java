package ins.prpall.proposal.vo;

import java.util.Date;

public class SearchItemVo {
	
	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性流水号 */
	private String serialNo;

	/** 属性契调项目编号 */
	private String itemNo;
	
	/** 属性契调项目名称 */
	private String itemName;

	/** 属性备用属性字段1 */
	private String standbyFlag1;

	/** 属性备用属性字段2 */
	private String standbyFlag2;

	/** 属性备用属性字段3 */
	private String standbyFlag3;

	/** 属性操作员 */
	private String operator;

	/** 属性入机日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性最后一次修改时间 */
	private String modifyTime;

	/** 属性契调项目内容 */
	private String itemContent;
	
	/**
	 * @title 
	 * @description 构造方法
	 * @author 薛玉强
	 */
	public SearchItemVo(String itemNo,String itemName,String standbyFlag3){
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.standbyFlag3 = standbyFlag3;
	}

	public String getGrpContNo() {
		return grpContNo;
	}

	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getStandbyFlag1() {
		return standbyFlag1;
	}

	public void setStandbyFlag1(String standbyFlag1) {
		this.standbyFlag1 = standbyFlag1;
	}

	public String getStandbyFlag2() {
		return standbyFlag2;
	}

	public void setStandbyFlag2(String standbyFlag2) {
		this.standbyFlag2 = standbyFlag2;
	}

	public String getStandbyFlag3() {
		return standbyFlag3;
	}

	public void setStandbyFlag3(String standbyFlag3) {
		this.standbyFlag3 = standbyFlag3;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	
	
	

}
