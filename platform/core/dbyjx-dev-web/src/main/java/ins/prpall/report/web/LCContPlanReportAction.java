package ins.prpall.report.web;

import ins.framework.web.Struts2Action;
import ins.prpall.report.model.LCContPlanDutyParamReport;
import ins.prpall.report.model.LCContPlanReport;
import ins.prpall.report.model.LCContPlanRiskReport;
import ins.prpall.report.model.LCDutyReport;
import ins.prpall.report.model.LCGrpContReport;
import ins.prpall.report.service.facade.LCContPlanReportService;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class LCContPlanReportAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	/**服务类*/
	private LCContPlanReportService lcContPlanReportService;
	/**呈报集体保单表*/
	private LCGrpContReport lcGrpContReport;
	
	/**责任表*/
	private LCDutyReport lcDutyReport;
	private List<LCDutyReport> lcDutyReportList;
	/**呈报保单保障计划险种表*/
	private List<LCContPlanRiskReport> lcContPlanRiskReportList;
	/**呈报保单保障计划表*/
	private LCContPlanReport lcContPlanReport;
	private List<LCContPlanReport> lcContPlanReportList;
	/**要素表*/
	private List<LCContPlanDutyParamReport> lcContPlanDutyParamReportList;

	public LCContPlanReport getLcContPlanReport() {
		return lcContPlanReport;
	}
	public void setLcContPlanReport(LCContPlanReport lcContPlanReport) {
		this.lcContPlanReport = lcContPlanReport;
	}
	public List<LCContPlanDutyParamReport> getLcContPlanDutyParamReportList() {
		return lcContPlanDutyParamReportList;
	}
	public void setLcContPlanDutyParamReportList(
			List<LCContPlanDutyParamReport> lcContPlanDutyParamReportList) {
		this.lcContPlanDutyParamReportList = lcContPlanDutyParamReportList;
	}
	public List<LCDutyReport> getLcDutyReportList() {
		return lcDutyReportList;
	}
	public void setLcDutyReportList(List<LCDutyReport> lcDutyReportList) {
		this.lcDutyReportList = lcDutyReportList;
	}
	public List<LCContPlanRiskReport> getLcContPlanRiskReportList() {
		return lcContPlanRiskReportList;
	}
	public void setLcContPlanRiskReportList(
			List<LCContPlanRiskReport> lcContPlanRiskReportList) {
		this.lcContPlanRiskReportList = lcContPlanRiskReportList;
	}
	public LCContPlanReportService getLcContPlanReportService() {
		return lcContPlanReportService;
	}
	public void setLcContPlanReportService(
			LCContPlanReportService lcContPlanReportService) {
		this.lcContPlanReportService = lcContPlanReportService;
	}
	public LCGrpContReport getLcGrpContReport() {
		return lcGrpContReport;
	}
	public void setLcGrpContReport(LCGrpContReport lcGrpContReport) {
		this.lcGrpContReport = lcGrpContReport;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<LCContPlanReport> getLcContPlanReportList() {
		return lcContPlanReportList;
	}
	public void setLcContPlanReportList(List<LCContPlanReport> lcContPlanReportList) {
		this.lcContPlanReportList = lcContPlanReportList;
	}
	public LCDutyReport getLcDutyReport() {
		return lcDutyReport;
	}
	public void setLcDutyReport(LCDutyReport lcDutyReport) {
		this.lcDutyReport = lcDutyReport;
	}
	/**
	 * 保存保障计划和相关类
	 * @return
	 */
	public String saveContPlan(){
		
		boolean result=lcContPlanReportService.saveContPlan(lcContPlanReport,lcContPlanRiskReportList,lcDutyReportList,lcContPlanDutyParamReportList);
		if(result){
			this.writeJSONMsg("success");
		}
		return NONE;
	}
	/**
	 * 呈报保险计划初始化页面方法
	 * @param repNo 呈报申请号
	 * @author 于文龙
	 */
	public String initializeEnsurePlan(){
		
		Map<String,Object> map=lcContPlanReportService.initializeEnsurePlan(lcGrpContReport);
		lcGrpContReport=(LCGrpContReport)map.get("lcGrpContReport");
		lcContPlanReportList=(List<LCContPlanReport>)map.get("lcContPlanReportList");
		return SUCCESS;
	}
	/**
	 * 呈报保障计划及其相关表的删除
	 * @param
	 * @param
	 * @author 于文龙
	 */
	public String deleteConPlan(){
		Map<String,Object> page=lcContPlanReportService.deleteConPlan(lcContPlanReport);
		lcContPlanReport=(LCContPlanReport)page.get("lcContPlanReport");
		JSONObject jsonObject = new JSONObject();
	    jsonObject.put("lcContPlanReport", JSONArray.fromObject(lcContPlanReport));
	    renderHtml(jsonObject.toString());
		return NONE;
	}
	/**
	 * 
	 * @title findCalMode
	 * @description 查找计算公式
	 * @return
	 * @author 于文龙
	 */
	public String findCalMode(){
		
		String dhtml=lcContPlanReportService.findCalMode(lcDutyReport);
		this.writeJSONMsg(dhtml);
		return NONE;
	}
}
