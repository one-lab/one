package ins.prpall.proposal.vo;

import java.util.Date;

public class AutoUWGrpInfoVo {
	
	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性集体投保单号码 */
	private String proposalGrpContNo;
	
	/** 属性险种编码 */
	private String riskCode;
	
	/** 属性核保顺序号 */
	private int uwSN;
	
	/** 属性核保意见 */
	private String remark;
	
	/** 属性核保完成日期 */
	private Date uwDate;
	
	public AutoUWGrpInfoVo(){
		
	}

	public AutoUWGrpInfoVo(String grpContNo, String proposalGrpContNo,
			String riskCode, int uwSN, String remark, Date uwDate) {
		super();
		this.grpContNo = grpContNo;
		this.proposalGrpContNo = proposalGrpContNo;
		this.riskCode = riskCode;
		this.uwSN = uwSN;
		this.remark = remark;
		this.uwDate = uwDate;
	}


	public String getGrpContNo() {
		return grpContNo;
	}

	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	public String getProposalGrpContNo() {
		return proposalGrpContNo;
	}

	public void setProposalGrpContNo(String proposalGrpContNo) {
		this.proposalGrpContNo = proposalGrpContNo;
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
