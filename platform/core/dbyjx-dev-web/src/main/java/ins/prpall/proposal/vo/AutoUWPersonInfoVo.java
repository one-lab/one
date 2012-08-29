package ins.prpall.proposal.vo;

import java.util.Date;

public class AutoUWPersonInfoVo {
	
	/** 属性合同号码 */
	private String contNo;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性总单投保单号码 */
	private String proposalContNo;
	
	/** 属性被保人客户号码 */
	private String insuredNo;

	/** 属性被保人名称 */
	private String insuredName;
	
	/** 属性险种编码 */
	private String riskCode;
	
	/** 属性核保顺序号 */
	private int uwSN;
	
	/** 属性核保意见 */
	private String remark;
	
	/** 属性核保完成日期 */
	private Date uwDate;

	public AutoUWPersonInfoVo() {
		
	}

	public AutoUWPersonInfoVo(String contNo, String grpContNo,
			String proposalContNo, String insuredNo, String insuredName,
			String riskCode, int uwSN, String remark, Date uwDate) {
		super();
		this.contNo = contNo;
		this.grpContNo = grpContNo;
		this.proposalContNo = proposalContNo;
		this.insuredNo = insuredNo;
		this.insuredName = insuredName;
		this.riskCode = riskCode;
		this.uwSN = uwSN;
		this.remark = remark;
		this.uwDate = uwDate;
	}



	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	public String getGrpContNo() {
		return grpContNo;
	}

	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	public String getProposalContNo() {
		return proposalContNo;
	}

	public void setProposalContNo(String proposalContNo) {
		this.proposalContNo = proposalContNo;
	}

	public String getInsuredNo() {
		return insuredNo;
	}

	public void setInsuredNo(String insuredNo) {
		this.insuredNo = insuredNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public int getUwSN() {
		return uwSN;
	}

	public void setUwSN(int uwSN) {
		this.uwSN = uwSN;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUwDate() {
		return uwDate;
	}

	public void setUwDate(Date uwDate) {
		this.uwDate = uwDate;
	}

	
	

}
