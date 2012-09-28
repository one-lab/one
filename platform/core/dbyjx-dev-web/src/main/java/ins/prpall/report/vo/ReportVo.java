package ins.prpall.report.vo;

import java.util.Date;

public class ReportVo {
	
	/** 属性呈报申请号 */
	private String repNo;

	/** 属性呈报申请人 */
	private String repOperator;
	
	/** 属性管理机构 */
	private String manageCom;

	/** 属性呈报申请日期 */
	private Date repApplyDate;

	/** 属性任务当前状态 */
	private String state;
	
	/** 属性单位名称 */
	private String grpName;

	public String getRepNo() {
		return repNo;
	}

	public void setRepNo(String repNo) {
		this.repNo = repNo;
	}

	public String getRepOperator() {
		return repOperator;
	}

	public void setRepOperator(String repOperator) {
		this.repOperator = repOperator;
	}

	public String getManageCom() {
		return manageCom;
	}

	public void setManageCom(String manageCom) {
		this.manageCom = manageCom;
	}

	public Date getRepApplyDate() {
		return repApplyDate;
	}

	public void setRepApplyDate(Date repApplyDate) {
		this.repApplyDate = repApplyDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}
	
	public ReportVo(){
		
	}

	public ReportVo(String repNo, String repOperator, String manageCom,
			Date repApplyDate, String state, String grpName) {
		super();
		this.repNo = repNo;
		this.repOperator = repOperator;
		this.manageCom = manageCom;
		this.repApplyDate = repApplyDate;
		this.state = state;
		this.grpName = grpName;
	}
	
	public ReportVo(String repNo,String repOperator,String grpName,String manageCom,Date repApplyDate){
		this.repNo=repNo;
		this.repOperator=repOperator;
		this.grpName=grpName;
		this.manageCom=manageCom;
		this.repApplyDate=repApplyDate;
		
	}
}
