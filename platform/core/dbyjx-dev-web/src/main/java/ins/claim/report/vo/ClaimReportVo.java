package ins.claim.report.vo;

import java.util.Date;

public class ClaimReportVo {
	
	/** 报案号 */
	private String rptNo;

	/** 报案人姓名 */
	private String rptorName;
	
	/** 报案日期 */
	private Date rptDate;

	/** 出险人姓名 */
	private String customerName;

	/** 出险人性别 */
	private String sexValue;
	
	/** 出险日期 */
	private Date accidentDate;
	
	/** 案件有效标识 */
	private String avaiFlagValue;


	public String getRptNo() {
		return rptNo;
	}

	public void setRptNo(String rptNo) {
		this.rptNo = rptNo;
	}

	public String getRptorName() {
		return rptorName;
	}

	public void setRptorName(String rptorName) {
		this.rptorName = rptorName;
	}

	public Date getRptDate() {
		return rptDate;
	}

	public void setRptDate(Date rptDate) {
		this.rptDate = rptDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getSexValue() {
		return sexValue;
	}

	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}

	public String getAvaiFlagValue() {
		return avaiFlagValue;
	}

	public void setAvaiFlagValue(String avaiFlagValue) {
		this.avaiFlagValue = avaiFlagValue;
	}

	public ClaimReportVo(){
		
	}

	public ClaimReportVo(String rptNo, String rptorName, Date rptDate, String customerName, String sexValue,
			Date accidentDate, String avaiFlagValue) {
		super();
		this.rptNo = rptNo;
		this.rptorName = rptorName;
		this.rptDate = rptDate;
		this.customerName = customerName;
		this.sexValue = sexValue;
		this.accidentDate = accidentDate;
		this.avaiFlagValue = avaiFlagValue;
	}
}
