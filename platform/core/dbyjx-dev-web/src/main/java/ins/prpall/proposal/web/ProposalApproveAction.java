/**
 * @ create_date 2012-8-9
 * @ author long
 * @ version 1.0
 */
package ins.prpall.proposal.web;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.prpall.proposal.model.LCCont;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCRepInfo;
import ins.prpall.proposal.model.LDPerson;
import ins.prpall.proposal.service.facade.ProposalApproveService;
import ins.prpall.proposal.vo.GrpRiskVo;
import ins.prpall.report.model.LCGrpPol;

import java.util.List;
import java.util.Map;

/**
 *
 * @title ProposalApproveAction
 * @description 投保单复核Action
 * @author 于文龙
 * @version 1.0
 * @create date 2012-8-9
 * @copyright (c) SINOSOFT
 */
public class ProposalApproveAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	/** 声明类和LIST*/
	/**服务类*/
	ProposalApproveService proposalApproveService;
	/**集体表单类*/
	private LCGrpCont lcGrpCont;
	private List<LCGrpCont> lcGrpContList;
	/**投保单告知信息表类*/
	private LCRepInfo lcRepInfo;
	private List<LCRepInfo> lcRepInfoList;
	/**集体险种表类*/
	private LCGrpPol lcGrpPol;
	private List<LCGrpPol> lcGrpPolList;
	/**个人保单表*/
	LCCont lcCont;
	List<LCCont> lcContList;
	/**个单被保人表*/
	LCInsured lcInsured;
	List<LCInsured> lcInsuredList;
	/**集体险种信息*/
	List<GrpRiskVo> grpRiskVoList;
	/**个人客户表*/
	LDPerson ldPerson;
	List<LDPerson> ldPersonList;
	/**重复客户信息*/
	List<Object> repeatCustomerInfoList;
	/**相应的getter和setter方法*/
	public List<LCGrpCont> getLcGrpContList() {
		return lcGrpContList;
	}
	public void setLcGrpContList(List<LCGrpCont> lcGrpContList) {
		this.lcGrpContList = lcGrpContList;
	}
	public LCGrpCont getLcGrpCont() {
		return lcGrpCont;
	}
	public void setLcGrpCont(LCGrpCont lcGrpCont) {
		this.lcGrpCont = lcGrpCont;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ProposalApproveService getProposalApproveService() {
		return proposalApproveService;
	}
	public void setProposalApproveService(
			ProposalApproveService proposalApproveService) {
		this.proposalApproveService = proposalApproveService;
	}
	public LCRepInfo getLcRepInfo() {
		return lcRepInfo;
	}
	public void setLcRepInfo(LCRepInfo lcRepInfo) {
		this.lcRepInfo = lcRepInfo;
	}
	public List<LCRepInfo> getLcRepInfoList() {
		return lcRepInfoList;
	}
	public void setLcRepInfoList(List<LCRepInfo> lcRepInfoList) {
		this.lcRepInfoList = lcRepInfoList;
	}
	public LCGrpPol getLcGrpPol() {
		return lcGrpPol;
	}
	public void setLcGrpPol(LCGrpPol lcGrpPol) {
		this.lcGrpPol = lcGrpPol;
	}
	public List<LCGrpPol> getLcGrpPolList() {
		return lcGrpPolList;
	}
	public void setLcGrpPolList(List<LCGrpPol> lcGrpPolList) {
		this.lcGrpPolList = lcGrpPolList;
	}
	public LCCont getLcCont() {
		return lcCont;
	}
	public void setLcCont(LCCont lcCont) {
		this.lcCont = lcCont;
	}
	public List<LCCont> getLcContList() {
		return lcContList;
	}
	public void setLcContList(List<LCCont> lcContList) {
		this.lcContList = lcContList;
	}
	public LCInsured getLcInsured() {
		return lcInsured;
	}
	public void setLcInsured(LCInsured lcInsured) {
		this.lcInsured = lcInsured;
	}
	public List<LCInsured> getLcInsuredList() {
		return lcInsuredList;
	}
	public void setLcInsuredList(List<LCInsured> lcInsuredList) {
		this.lcInsuredList = lcInsuredList;
	}
	public List<GrpRiskVo> getGrpRiskVoList() {
		return grpRiskVoList;
	}
	public void setGrpRiskVoList(List<GrpRiskVo> grpRiskVoList) {
		this.grpRiskVoList = grpRiskVoList;
	}
	public LDPerson getLsPerson() {
		return ldPerson;
	}
	public void setLsPerson(LDPerson ldPerson) {
		this.ldPerson = ldPerson;
	}
	public List<LDPerson> getLdPersonList() {
		return ldPersonList;
	}
	public void setLdPersonList(List<LDPerson> ldPersonList) {
		this.ldPersonList = ldPersonList;
	}
	public List<Object> getRepeatCustomerInfoList() {
		return repeatCustomerInfoList;
	}
	public void setRepeatCustomerInfoList(
			List<Object> repeatCustomerInfoList) {
		this.repeatCustomerInfoList = repeatCustomerInfoList;
	}
	/**具体功能实现方法*/
	/**
	 * 集体投保单信息查询
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	public String findGrpContInfo(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize==0){
		pageSize =  FinalCollection.PAGE_SIZE;
		}
		//查询
		lcGrpContList=proposalApproveService.findGrpContInfo(lcGrpCont,pageNo,pageSize);
		
		//条件回写
		this.getRequest().setAttribute("lcGrpCont", lcGrpCont);
		this.getRequest().setAttribute("lcGrpContList", lcGrpContList);
		return SUCCESS;
	}
	/**弃用
	 * @description 集体投保单审核申请
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	public String applyLcGrpCont(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize==0){
			pageSize =  FinalCollection.PAGE_SIZE;
			}
		Page page=proposalApproveService.applyLcGrpCont(lcGrpCont,pageNo,pageSize);
		this.writeJSONData(page, new String[]{"grpContNo","grpName","inputDate","manageCom"});
		return NONE;
	}
	/**
	 * @description 对已申请的投保单进行审核查询
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	public String auditLcGrpCont(){
		Map<String ,Object> map=proposalApproveService.auditLcGrpCont(lcGrpCont);
		lcRepInfoList=(List<LCRepInfo>)map.get("lcRepInfoList");
		grpRiskVoList=(List<GrpRiskVo>)map.get("grpRiskVoList");
		//返回信息
		this.getRequest().setAttribute("lcRepInfoList", lcRepInfoList);
		this.getRequest().setAttribute("grpRiskVoList", grpRiskVoList);
		this.getRequest().setAttribute("lcGrpCont", lcGrpCont);
		return SUCCESS;
	}
	/**
	 * @title 
	 * @description 复审完毕
	 * @return
	 * @author 于文龙
	 */
	public String finishAudit(){
		lcGrpCont =proposalApproveService.finishAudit(lcGrpCont);
		if(null!=lcGrpCont){
			Page page=new Page();
			page.setMessage("success");
			this.writeJSONData(page, new String[]{"success"});
		}
		return NONE;
	}
	/**
	 * @description 已承保保单查询
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	public String findLcContAndInsured(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize==0){
			pageSize =  FinalCollection.PAGE_SIZE;
			}
		//查询
		Map<String,Object> map=proposalApproveService.findLcContAndInsured(lcGrpCont, pageNo, pageSize);
		if(null!=map){
			repeatCustomerInfoList=(List<Object>)map.get("repeatInfoList");
			ldPersonList=(List<LDPerson>)map.get("ldPersonList");
			this.getRequest().setAttribute("ldPersonList", ldPersonList);
			this.getRequest().setAttribute("repeatCustomerInfoList", repeatCustomerInfoList);
		}else{
			this.getRequest().setAttribute("ldPersonList", null);
			this.getRequest().setAttribute("repeatCustomerInfoList", null);
		}
		
		return SUCCESS;
	}
	/**
	 * 
	 * @title initialLcGrpContAudit
	 * @description 初始化方法
	 * @return
	 * @author 于文龙
	 */
	public String initialLcGrpContAudit(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize==0){
			pageSize =  FinalCollection.PAGE_SIZE;
			}
		Page page=proposalApproveService.initialLcGrpContAudit(pageNo, pageSize);
		this.writeJSONData(page, new String[]{"grpContNo","grpName","inputDate","manageCom"});
		return NONE;
	}
	/**
	 * 
	 * @title mergeCustomerNo
	 * @description 合并客户号
	 * @return
	 * @author 于文龙
	 */
	public String mergeCustomerNo(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize==0){
			pageSize =  FinalCollection.PAGE_SIZE;
			}
		//查询
		Map<String,Object> map=proposalApproveService.mergeCustomerNo(ldPerson, lcCont, pageNo, pageSize);
		if(null!=map){
			repeatCustomerInfoList=(List<Object>)map.get("repeatInfoList");
			lcInsuredList=(List<LCInsured>)map.get("lcInsuredList");
			this.getRequest().setAttribute("lcInsuredList", lcInsuredList);
			this.getRequest().setAttribute("repeatCustomerInfoList", repeatCustomerInfoList);
		}else{
			this.getRequest().setAttribute("lcInsuredList", null);
			this.getRequest().setAttribute("repeatCustomerInfoList", null);
		}
		return NONE;
	}
}
