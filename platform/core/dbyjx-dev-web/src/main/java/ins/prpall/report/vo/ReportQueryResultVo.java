package ins.prpall.report.vo;

import java.util.Date;


public class ReportQueryResultVo {
	
	private String repNo;
	

	private String repOperator;
	
	
	private String manageCom;
	
	
	private Date repApplyDate;
	

	private String name;


	private String state;
	
	
	private String result;
	
	
	private String repauditoperator;
	
	public ReportQueryResultVo(){
		
	}

	public ReportQueryResultVo(String repNo, String repOperator,
			String manageCom, Date repApplyDate, String name, String state,
			String result, String repauditoperator) {
		super();
		this.repNo = repNo;
		this.repOperator = repOperator;
		this.manageCom = manageCom;
		this.repApplyDate = repApplyDate;
		this.name = name;
		this.state = state;
		this.result = result;
		this.repauditoperator = repauditoperator;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRepauditoperator() {
		return repauditoperator;
	}

	public void setRepauditoperator(String repauditoperator) {
		this.repauditoperator = repauditoperator;
	}
	
	

}
