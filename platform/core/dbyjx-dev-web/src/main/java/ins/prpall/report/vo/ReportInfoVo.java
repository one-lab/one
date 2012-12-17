package ins.prpall.report.vo;

import java.util.Date;

public class ReportInfoVo {
	/** 属性序列号 */
	private int serialNo;
	/** 属性呈报申请号 */
	private String repNo;
	/** 属性单位名称 */
	private String name;
	/** 属性管理机构 */
	private String manageCom;
	/** 属性呈报申请人 */
	private String repOperator;
	/** 属性呈报申请日期 */
	private Date repApplyDate;
	/** 属性呈报结论 */
	private String result;
	/** 属性审核意见 */
	private String repAuditIdea;
	
	

	
	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getRepNo() {
		return repNo;
	}

	public void setRepNo(String repNo) {
		this.repNo = repNo;
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

	public String getRepOperator() {
		return repOperator;
	}

	public void setRepOperator(String repOperator) {
		this.repOperator = repOperator;
	}

	public Date getRepApplyDate() {
		return repApplyDate;
	}

	public void setRepApplyDate(Date repApplyDate) {
		this.repApplyDate = repApplyDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRepAuditIdea() {
		return repAuditIdea;
	}

	public void setRepAuditIdea(String repAuditIdea) {
		this.repAuditIdea = repAuditIdea;
	}

	
   public ReportInfoVo(){
		
	}

public ReportInfoVo(int serialNo, String repNo, String name, String manageCom,
		String repOperator, Date repApplyDate, String result,
		String repAuditIdea) {
	super();
	this.serialNo = serialNo;
	this.repNo = repNo;
	this.name = name;
	this.manageCom = manageCom;
	this.repOperator = repOperator;
	this.repApplyDate = repApplyDate;
	this.result = result;
	this.repAuditIdea = repAuditIdea;
}
	
	
	


}
