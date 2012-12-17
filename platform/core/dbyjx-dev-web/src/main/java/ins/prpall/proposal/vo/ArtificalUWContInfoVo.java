package ins.prpall.proposal.vo;

public class ArtificalUWContInfoVo {
	

	/** 属性集体合同号码 */
	private String grpContNo;
	
	/**属性合同号码*/
	private String contNo;
	
	/** 属性总单投保单号码 */
	private String proposalContNo;
	
	/** 属性核保状态 */
	private String uwFlag;
	
	/** 属性名称 */
	private String name;
	
	/** 属性管理机构 */
	private String manageCom;
	
	/** 属性保险计划编码 */
	private String contPlanCode;
	
	public ArtificalUWContInfoVo(){
		
	}
	
	public ArtificalUWContInfoVo(String contNo,String grpContNo,String proposalContNo,String uwFlag,String name,String manageCom,String contPlanCode){
		this.contNo = contNo;
		this.grpContNo = grpContNo;
		this.proposalContNo = proposalContNo;
		this.uwFlag = uwFlag;
		this.name = name;
		this.manageCom = manageCom;
		this.contPlanCode = contPlanCode;
	}

	public String getProposalContNo() {
		return proposalContNo;
	}

	public void setProposalContNo(String proposalContNo) {
		this.proposalContNo = proposalContNo;
	}

	public String getUwFlag() {
		return uwFlag;
	}

	public void setUwFlag(String uwFlag) {
		this.uwFlag = uwFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManageCom() {
		return manageCom;
	}

	public void setManageCom(String manageCom) {
		this.manageCom = manageCom;
	}

	public String getContPlanCode() {
		return contPlanCode;
	}

	public void setContPlanCode(String contPlanCode) {
		this.contPlanCode = contPlanCode;
	}

	public String getGrpContNo() {
		return grpContNo;
	}

	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	
	

}
