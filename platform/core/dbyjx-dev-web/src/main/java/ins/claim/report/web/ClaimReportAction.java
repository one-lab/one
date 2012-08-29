package ins.claim.report.web;

import ins.claim.report.model.LLAccident;
import ins.claim.report.model.LLReport;
import ins.claim.report.model.LLReportReason;
import ins.claim.report.model.LLReportRela;
import ins.claim.report.model.LLSubReport;
import ins.claim.report.service.facade.ClaimReportService;
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ClaimReportAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	/**理赔服务类*/
	private ClaimReportService claimReportService;
	
	/**个人报案表*/
	private LLReport llReport;
	
	/**报案分案表*/
	private LLSubReport llSubReport;
	private List<LLSubReport> llSubReportList;
	
	/**报案理赔类型表*/
	private LLReportRela llReportReasonList;
	
	/**报案事件关联表*/
	private LLReportRela llReportRela;
	
	/**事件表*/
	private List<LLAccident> llAccidentList;
	private LLAccident llAccident;
	
	/**报案理赔类型表*/
	private List<LLReportReason> reasonCodeList;
	
	/**出险起始日期*/
	private Date appntStartDate;
	
	/**出险终止日期*/
	private Date appntEndDate;
	
	/**报案查询返回*/
	private Page page;
	
	/**报案起始日期*/
	private Date rptStartDate;
	
	/**报案终止日期*/
	private Date rptEndDate;
	
	private Page reportPage;

	public LLReport getLlReport() {
		return llReport;
	}

	public void setLlReport(LLReport llReport) {
		this.llReport = llReport;
	}

	public LLSubReport getLlSubReport() {
		return llSubReport;
	}

	public void setLlSubReport(LLSubReport llSubReport) {
		this.llSubReport = llSubReport;
	}

	public LLReportRela getLlReportRela() {
		return llReportRela;
	}

	public void setLlReportRela(LLReportRela llReportRela) {
		this.llReportRela = llReportRela;
	}

	public ClaimReportService getClaimReportService() {
		return claimReportService;
	}

	public void setClaimReportService(ClaimReportService claimReportService) {
		this.claimReportService = claimReportService;
	}

	public Date getAppntStartDate() {
		return appntStartDate;
	}

	public void setAppntStartDate(Date appntStartDate) {
		this.appntStartDate = appntStartDate;
	}

	public Date getAppntEndDate() {
		return appntEndDate;
	}

	public void setAppntEndDate(Date appntEndDate) {
		this.appntEndDate = appntEndDate;
	}

	public Date getRptStartDate() {
		return rptStartDate;
	}

	public void setRptStartDate(Date rptStartDate) {
		this.rptStartDate = rptStartDate;
	}

	public Date getRptEndDate() {
		return rptEndDate;
	}

	public void setRptEndDate(Date rptEndDate) {
		this.rptEndDate = rptEndDate;
	}

	public List<LLAccident> getLlAccidentList() {
		return llAccidentList;
	}

	public void setLlAccidentList(List<LLAccident> llAccidentList) {
		this.llAccidentList = llAccidentList;
	}

	public List<LLReportReason> getReasonCodeList() {
		return reasonCodeList;
	}

	public void setReasonCodeList(List<LLReportReason> reasonCodeList) {
		this.reasonCodeList = reasonCodeList;
	}

	public Page getReportPage() {
		return reportPage;
	}

	public void setReportPage(Page reportPage) {
		this.reportPage = reportPage;
	}

	public LLReportRela getLlReportReasonList() {
		return llReportReasonList;
	}

	public void setLlReportReasonList(LLReportRela llReportReasonList) {
		this.llReportReasonList = llReportReasonList;
	}

	public List<LLSubReport> getLlSubReportList() {
		return llSubReportList;
	}

	public void setLlSubReportList(List<LLSubReport> llSubReportList) {
		this.llSubReportList = llSubReportList;
	}

	public LLAccident getLlAccident() {
		return llAccident;
	}

	public void setLlAccident(LLAccident llAccident) {
		this.llAccident = llAccident;
	}
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * @title findClaimReport
	 * @关联llRreport、llSubRepot和llReportRela表查询数据
	 * @author zhangkai
	 * @create date 2012-8-16
	 * @return
	 */
	public String findClaimReport(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		page = claimReportService.findClaimReport(llReport, llSubReport, rptStartDate, rptEndDate, appntStartDate, appntEndDate, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * @title findReportInfo
	 * @根据报案号关联llRreport、llSubRepot和llReportRela表查询数据
	 * @author zhangkai
	 * @create date 2012-8-16
	 * @return
	 */
	public String findReportInfo(){
		Map<String ,Object> map = claimReportService.findReportInfo(llReport);
		//返回信息
		llReport = (LLReport) map.get("llReport");
		llAccidentList = (List<LLAccident>) map.get("llAccidentList");
		llSubReportList = (List<LLSubReport>) map.get("llSubReportList");
//		llReportReasonList = (List<LLReportReason>map.get("llReportReasonList"));
		
		this.getRequest().setAttribute("llReport", llReport);
		this.getRequest().setAttribute("llAccidentList", llAccidentList);
		this.getRequest().setAttribute("llSubReportList", llSubReportList);
//		this.getRequest().setAttribute("llReportReasonList", llReportReasonList);
		
		return SUCCESS;
	}	
	
	/**
	 * @title saveClaimReportInfo
	 * @param llReport 个人报案表
	 * @param llReportRela 报案事件关联表
	 * @param llSubReport 分案表
	 * @param LLCaseRela 分案事件关联表
	 * @param LLAccident 事件表
	 * @param LLAccidentSub 分事件表
	 * @param LLReportReason 报案理赔类型
	 * @author zhangkai
	 * @create date 2012-8-16
	 * @return
	 */
	public String saveClaimReportInfo(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page page = claimReportService.saveBaseInfo(llReport, llSubReport, llAccident, 
				reasonCodeList, pageNo, pageSize);
		this.writeJSONData(page, new String[]{"CustomerNo","CustomerName","CustomerSex","CustBirthday","IDType","IDNo"});
		return NONE;
	}
	/**
	 * 修改报案基本信息，客户出险信息,事件信息，理赔类型信息
	 * @return
	 * @author hesiqi
	 */
	public String udpateClaimReportInfo(){
		claimReportService.updateBaseInfo(llReport, llSubReport, llAccident,reasonCodeList);
		return NONE;
	}
	
}
