package ins.claim.report.web;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import ins.claim.manage.model.LLInqApply;
import ins.claim.manage.model.LLInqCertificate;
import ins.claim.manage.model.LLInqConClusion;
import ins.claim.manage.model.LLInqCourse;
import ins.claim.manage.model.LLInqFee;
import ins.claim.report.model.LLReport;
import ins.claim.report.model.LLSubReport;
import ins.claim.report.service.facade.LLInqService;
import ins.common.util.DisposeObject;
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;

public class LLInqAction extends Struts2Action {
	private static final long serialVersionUID = 1L;

	/**调查申请表*/
	private LLInqApply llInqApply;
	/**个人报案表*/
	private LLReport llReport;
	/**报案号与调查序号组成的字符串*/
	private String clmInqStr;
	/**分案表*/
	private LLSubReport llSubReport;
	/**已发起的调查*/
	private Page llInqApplyPage;
	/**赔案号、调查序号和操作员组成的字符串*/
	private String cioStr;
	
	private LLInqService llInqService;
	
	public LLInqApply getLlInqApply() {
		return llInqApply;
	}
	
	public void setLlInqApply(LLInqApply llInqApply) {
		this.llInqApply = llInqApply;
	}
	
	public LLReport getLlReport() {
		return llReport;
	}

	public void setLlReport(LLReport llReport) {
		this.llReport = llReport;
	}

	public String getClmInqStr() {
		return clmInqStr;
	}

	public void setClmInqStr(String clmInqStr) {
		this.clmInqStr = clmInqStr;
	}

	public LLSubReport getLlSubReport() {
		return llSubReport;
	}

	public void setLlSubReport(LLSubReport llSubReport) {
		this.llSubReport = llSubReport;
	}

	public Page getLlInqApplyPage() {
		return llInqApplyPage;
	}

	public void setLlInqApplyPage(Page llInqApplyPage) {
		this.llInqApplyPage = llInqApplyPage;
	}

	public String getCioStr() {
		return cioStr;
	}

	public void setCioStr(String cioStr) {
		this.cioStr = cioStr;
	}

	public LLInqService getLlInqService() {
		return llInqService;
	}
	
	public void setLlInqService(LLInqService llInqService) {
		this.llInqService = llInqService;
	}
	/**
	 * 发起调查申请
	 * @return 
	 * @author hesiqi
	 */
	public String saveLLInqApply(){
		List<LLInqApply> inqApplyList = llInqService.saveInqApply(llInqApply);
		JSONObject jsonObject = new JSONObject();
		DisposeObject dis = new DisposeObject();
		jsonObject.put("inqApplyList", JSONArray.fromObject(dis.dispose(inqApplyList, new String[]{"id","customerNo","customerName","initDeptValue","inqRCodeValue","inqDeptName","inqStateValue"})));
		renderHtml(jsonObject.toString());
		return NONE;
	}
	/**
	 * 根据报案号和客户号查已发起的调查(发起调查)
	 * @return
	 * @author hesiqi
	 */
	public String findLLInqApplyByRptNoInsuredNo(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		llInqApplyPage = llInqService.findLLInqApplyByRptNoInsuredNo(llSubReport, llReport, pageNo, pageSize);
		this.getRequest().setAttribute("llSubReport", llSubReport);
		this.getRequest().setAttribute("llReport", llReport);
		return SUCCESS;
	}
	/**
	 * 根据报案号和客户号查询已经发起的调查申请(查看调查)
	 * @return
	 * @author hesiqi
	 */
	public String findLLInqApplyByRptNoInsuredNoTwo(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		llInqApplyPage = llInqService.findLLInqApplyByRptNoInsuredNo(llSubReport, llReport, pageNo, pageSize);
		return SUCCESS;
	}
	/**
	 * 根据报案号和客户号查询已经发起的调查申请(取消调查)
	 * @return
	 * @author hesiqi
	 */
	public String findLLInqApplyByRptNoInsuredNoThree(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		llInqApplyPage = llInqService.findLLInqApplyByRptNoInsuredNo(llSubReport, llReport, pageNo, pageSize);
		return SUCCESS;
	}
	/**
	 * 查询出发起调查的调查结论、调查申请、调查过程、调查过程单证、调查费用
	 * @return
	 * @author hesiqi
	 */
	public String findLLInq(){
		//调查结论
		LLInqConClusion llInqConClusion = llInqService.findLLInqConclusion(clmInqStr);
		List<LLInqConClusion> inqConClusionList = new ArrayList<LLInqConClusion>();
		inqConClusionList.add(llInqConClusion);
		//调查申请
		LLInqApply llInqApply = llInqService.findLLInqApply(clmInqStr);
		List<LLInqApply> inqApplyList = new ArrayList<LLInqApply>();
		inqApplyList.add(llInqApply);
		//调查过程
		LLInqCourse llInqCourse = llInqService.findLLInqCourse(clmInqStr);
		List<LLInqCourse> llInqCourseList = new ArrayList<LLInqCourse>();
		llInqCourseList.add(llInqCourse);
		//调查过程单证
		List<LLInqCertificate> llInqCertificateList = new ArrayList<LLInqCertificate>();
		llInqCertificateList = llInqService.findLLInqCertificate(clmInqStr);
		//调查费用
		List<LLInqFee> llInqFeeList = new ArrayList<LLInqFee>();
		llInqFeeList = llInqService.findLLInqFee(clmInqStr);
		JSONObject jsonObject = new JSONObject();
		DisposeObject dis=new DisposeObject();
		jsonObject.put("inqConClusionList", JSONArray.fromObject(dis.dispose(inqConClusionList, new String[]{"id","inqDept","inqConclusion","remark"})));
		jsonObject.put("inqApplyList", JSONArray.fromObject(dis.dispose(inqApplyList, new String[]{"id","customerName","applyPer","applyDate","initPhase","initPhaseValue","inqDept","inqDeptName","inqItem","inqDesc","initDept","initDeptValue","inqRCode","inqRCodeValue","locFlagValue","inqStateValue"})));
		jsonObject.put("llInqCourseList", JSONArray.fromObject(dis.dispose(llInqCourseList, new String[]{"id","inqDate","inqModeValue","inqSite","inqByPer","inqDept","inqPer1","operator"})));
		jsonObject.put("llInqCertificateList", JSONArray.fromObject(dis.dispose(llInqCertificateList, new String[]{"id","cerType","cerName","oriFlagValue","cerCount","remark"})));
		jsonObject.put("llInqFeeList", JSONArray.fromObject(dis.dispose(llInqFeeList, new String[]{"id","feeSum","inqDeptName","feeTypeValue","feeDate","payee","payeeTypeValue","remark"})));
		renderHtml(jsonObject.toString());
		return NONE;
	}
	/**
	 * 取消调查
	 * @return
	 * @author hesiqi
	 */
	public String cancelSurvey(){
		String str = llInqService.cancelSurvey(cioStr, llInqApply);
		renderHtml(str);
		return NONE;
	}
}
