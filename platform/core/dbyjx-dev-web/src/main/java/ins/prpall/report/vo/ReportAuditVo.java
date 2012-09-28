package ins.prpall.report.vo;

import java.util.Date;

public class ReportAuditVo {
	/** 属性呈报申请号 */
	private String repNo;

	/** 属性呈报申请人 */
	private String repOperator;
	
	/** 属性管理机构 */
	private String manageCom;

	/** 属性呈报申请日期 */
	private Date repApplyDate;

	
	/** 属性单位名称 */
	private String name;
	/**属性核保师*/
	private String repAuditOperator;
	/** 属性任务当前状态 */
	private String state;
	
	/**构造函数*/
	public ReportAuditVo(){
		
	}
	public ReportAuditVo(String repNo,String repOperator,String manageCom,Date repApplyDate,String grpName,String repAuditOperator ,String state){
		this.repNo=repNo;
		this.repOperator=repOperator;
		this.manageCom=manageCom;
		this.repApplyDate=repApplyDate;
		this.state=state;
		this.name=grpName;
		this.repAuditOperator=repAuditOperator;
		
	}
	
	public ReportAuditVo(String repNo,String repOperator,String manageCom,Date repApplyDate,String name){
		this.repNo = repNo;
		this.repOperator = repOperator;
		this.manageCom = manageCom;
		this.repApplyDate =repApplyDate;
		this.name = name;
	}
	
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
	public String getName() {
		return name;
	}
	public void setName(String grpName) {
		this.name = grpName;
	}
	public String getRepAuditOperator() {
		return repAuditOperator;
	}
	public void setRepAuditOperator(String repAuditOperator) {
		this.repAuditOperator = repAuditOperator;
	}
	

}
