package ins.prpall.proposal.web;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.prpall.proposal.model.LCAppnt;
import ins.prpall.proposal.model.LCCont;
import ins.prpall.proposal.model.LCGrpAppnt;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCIssue;
import ins.prpall.proposal.model.LCPol;
import ins.prpall.proposal.model.LCSingleSearchInfo;
import ins.prpall.proposal.model.LCSingleSearchItem;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.proposal.model.LDPerson;
import ins.prpall.proposal.service.facade.ArtificalUWService;
import ins.prpall.proposal.vo.ArtificalUWDealVo;
import ins.prpall.proposal.vo.ArtificalUWPolVo;
import ins.prpall.proposal.vo.AutoUWGrpInfoVo;
import ins.prpall.proposal.vo.AutoUWPersonInfoVo;
import ins.prpall.report.model.LCGrpPolReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArtificalUWAction extends Struts2Action {
	private static final long serialVersionUID = 1L;

	/**集体保单表*/
	private LCGrpCont lcGrpCont;
	
	/**个人保单表*/
	private LCCont lcCont;
	
	/**个人保单表*/
	private LDPerson ldPerson;
	
	/**团单投保人表*/
	private LCGrpAppnt lcGrpAppnt;
	
	/**个单投保人表*/
	private LCAppnt lcAppnt;
	
	/**个人险种表*/
	private LCPol lcPol;
	
	/**集体险种表*/
	private LCGrpPolReport lcGrpPolReport;
	
	/**团体客户表*/
	private LDGrp ldGrp;
	
	/**个单被保人表*/
	private LCInsured lcInsured;
	
	/**问题件表*/
	private LCIssue lcIssue;
	private List<LCIssue> lcIssueList;
	
	/**个人契调信息表*/
	private LCSingleSearchInfo lcSingleSearchInfo;
	
	/**个人契调项目信息表*/
	private LCSingleSearchItem lcSingleSearchItem;
	
	/**个人投保单信息Page*/
	private Page lcContPage;
	
	/**个人契调项目集合*/
	private List<LCSingleSearchItem> lcSingleSearchItemList;
	
	/**人工核保类*/
	private ArtificalUWService artificalUWService;
	
	
	public Page getLcContPage() {
		return lcContPage;
	}
	public void setLcContPage(Page lcContPage) {
		this.lcContPage = lcContPage;
	}
	public LCGrpCont getLcGrpCont() {
		return lcGrpCont;
	}
	public void setLcGrpCont(LCGrpCont lcGrpCont) {
		this.lcGrpCont = lcGrpCont;
	}
	
	public LCCont getLcCont() {
		return lcCont;
	}
	public void setLcCont(LCCont lcCont) {
		this.lcCont = lcCont;
	}
	
	public LDPerson getLdPerson() {
		return ldPerson;
	}
	public void setLdPerson(LDPerson ldPerson) {
		this.ldPerson = ldPerson;
	}
	public LCGrpAppnt getLcGrpAppnt() {
		return lcGrpAppnt;
	}
	public void setLcGrpAppnt(LCGrpAppnt lcGrpAppnt) {
		this.lcGrpAppnt = lcGrpAppnt;
	}
	public LCAppnt getLcAppnt() {
		return lcAppnt;
	}
	public void setLcAppnt(LCAppnt lcAppnt) {
		this.lcAppnt = lcAppnt;
	}
	public LCPol getLcPol() {
		return lcPol;
	}
	public void setLcPol(LCPol lcPol) {
		this.lcPol = lcPol;
	}
	public LCGrpPolReport getLcGrpPolReport() {
		return lcGrpPolReport;
	}
	public void setLcGrpPolReport(LCGrpPolReport lcGrpPolReport) {
		this.lcGrpPolReport = lcGrpPolReport;
	}
	public LDGrp getLdGrp() {
		return ldGrp;
	}
	public void setLdGrp(LDGrp ldGrp) {
		this.ldGrp = ldGrp;
	}
	
	public LCInsured getLcInsured() {
		return lcInsured;
	}
	public void setLcInsured(LCInsured lcInsured) {
		this.lcInsured = lcInsured;
	}
	
	public LCIssue getLcIssue() {
		return lcIssue;
	}
	public void setLcIssue(LCIssue lcIssue) {
		this.lcIssue = lcIssue;
	}
	
	public List<LCIssue> getLcIssueList() {
		return lcIssueList;
	}
	public void setLcIssueList(List<LCIssue> lcIssueList) {
		this.lcIssueList = lcIssueList;
	}
	public LCSingleSearchInfo getLcSingleSearchInfo() {
		return lcSingleSearchInfo;
	}
	public void setLcSingleSearchInfo(LCSingleSearchInfo lcSingleSearchInfo) {
		this.lcSingleSearchInfo = lcSingleSearchInfo;
	}
	public LCSingleSearchItem getLcSingleSearchItem() {
		return lcSingleSearchItem;
	}
	public void setLcSingleSearchItem(LCSingleSearchItem lcSingleSearchItem) {
		this.lcSingleSearchItem = lcSingleSearchItem;
	}
	
	public List<LCSingleSearchItem> getLcSingleSearchItemList() {
		return lcSingleSearchItemList;
	}
	public void setLcSingleSearchItemList(
			List<LCSingleSearchItem> lcSingleSearchItemList) {
		this.lcSingleSearchItemList = lcSingleSearchItemList;
	}
	public ArtificalUWService getArtificalUWService() {
		return artificalUWService;
	}
	public void setArtificalUWService(ArtificalUWService artificalUWService) {
		this.artificalUWService = artificalUWService;
	}
	
	/**
	 * 
	 * @title initArtificalUWApply
	 * @description 初始化人工核保界面，即显示个人工作池中的任务
	 * @author 薛玉强
	 * @return
	 */
	public String initArtificalUWApply(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page lcGrpContPage = artificalUWService.initArtificalUWApply(pageNo, pageSize);
		this.writeJSONData(lcGrpContPage, new String[]{"grpContNo","grpName","uwOperator","manageCom","uwDate","firstTrialDate"});
		return NONE;
	}

	/**
	 * 查询集体投保单信息
	 * @title findProposalGrpContInfo
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String findProposalGrpContInfo(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page grpContInfo = artificalUWService.findProposalGrpContInfo(lcGrpCont,pageNo,pageSize);
		this.writeJSONData(grpContInfo, new String[]{"grpContNo","grpName","manageCom","uwDate","firstTrialDate","uwFlag"});
		return NONE;
	}
	
	/**
	 * 申请投保单核保（点击申请进入人工核保界面）
	 * @title applyProposal
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String applyProposal(){
		LCGrpCont lcGrpContTemp = artificalUWService.saveLcGrpContState(lcGrpCont);
		Map<String, Object> map = artificalUWService.findArtificalUWDeal(lcGrpContTemp);
		ArtificalUWDealVo artificalUWDealVo = (ArtificalUWDealVo)map.get("artificalUWDealVo");
		List<ArtificalUWPolVo> artificalUWPolVolist = (List<ArtificalUWPolVo>)map.get("artificalUWPolVoList");
		this.getRequest().setAttribute("artificalUWDealVo", artificalUWDealVo);
		this.getRequest().setAttribute("artificalUWPolVolist", artificalUWPolVolist);
		return SUCCESS;
	}
	/**
	 * 查询集体投保单详细信息（点击开始核保进入人工核保界面）
	 * @title findArtificalUWDeal
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String findArtificalUWDeal(){
		Map<String, Object> map = artificalUWService.findArtificalUWDeal(lcGrpCont);
		ArtificalUWDealVo artificalUWDealVo = (ArtificalUWDealVo)map.get("artificalUWDealVo");
		List<ArtificalUWPolVo> artificalUWPolVolist = (List<ArtificalUWPolVo>)map.get("artificalUWPolVoList");
		this.getRequest().setAttribute("artificalUWDealVo", artificalUWDealVo);
		this.getRequest().setAttribute("artificalUWPolVolist", artificalUWPolVolist);
		
		return SUCCESS;
	}
	/**
	 * 查询核保件（点击核保件查看进入核保界面）
	 * @title findArtificalUWFile
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String findArtificalUWFile(){
		Map<String, Object> map = null;
		if(null != lcGrpCont && !"".equals(lcGrpCont.getGrpContNo())){
			map = artificalUWService.findArtificalUWDeal(lcGrpCont);
			ArtificalUWDealVo artificalUWDealVo = (ArtificalUWDealVo)map.get("artificalUWDealVo");
			List<ArtificalUWPolVo> artificalUWPolVolist = (List<ArtificalUWPolVo>)map.get("artificalUWPolVoList");
			this.getRequest().setAttribute("artificalUWDealVo", artificalUWDealVo);
			this.getRequest().setAttribute("artificalUWPolVolist", artificalUWPolVolist);
		}

		return SUCCESS;
	}
	
	/**
	 * 保存人工核保中审核意见和核保结论
	 * @title saveArtificalUWResultAndIdea
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String saveArtificalUWResultAndIdea(){
		boolean flag =artificalUWService.saveArtificalUWResultAndIdea(lcGrpCont);
		if(flag){
			this.writeJSONMsg(SUCCESS);
		}
		return NONE;
	}
	
	/**
	 * 人工核保中查询个人投保单基本信息
	 * @title findArtificalUWContInfo
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String findArtificalUWContInfo(){
		if(pageNo == 0){
			pageNo = 1;
			}
			if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
			}
		Page artificalUWContInfoVoPage = artificalUWService.findArtificalUWContInfo(lcInsured,pageNo,pageSize);
		this.writeJSONData(artificalUWContInfoVoPage, new String[]{"contNo","uwFlag","name","manageCom","contPlanCode"});
		return NONE;
	}
	
	/**
	 * 人工核保中查询个人投保单详细信息
	 * @title findArtificalUWPersonDeal
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String findArtificalUWPersonDeal(){
		Map<String, Object> map = artificalUWService.findArtificalUWPersonDeal(lcCont);
		lcCont = (LCCont)map.get("lcCont");
		lcGrpAppnt = (LCGrpAppnt)map.get("lcGrpAppnt");
		lcAppnt = (LCAppnt)map.get("lcAppnt");
		List<LCPol> lcPolList = (List<LCPol>)map.get("lcPolList");
		this.getRequest().setAttribute("lcPolList", lcPolList);
		
		return SUCCESS;
	}
	
	/**
	 * 人工核保中保存对个人投保单的核保意见和审核结论
	 * @title saveArtificalUWPersonResultAndIdea
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String saveArtificalUWPersonResultAndIdea(){
		boolean flag = artificalUWService.saveArtificalUWPersonResultAndIdea(lcCont);
		if(flag){
			return NONE;
		}
		return null;
	}
	
	/**
	 * 人工核保中自动核保功能
	 * @title autoUWInfoQuery
	 * @description 
	 * @author 薛玉强
	 * @return
	 */
	public String autoUWInfoQuery(){
		
		List<AutoUWGrpInfoVo> grpInfoList = artificalUWService.autoUWGrpInfoQuery(lcGrpCont);
		List<AutoUWPersonInfoVo> personInfoList = artificalUWService.autoUWPersonInfoQuery(grpInfoList);
		this.getRequest().setAttribute("grpInfoList", grpInfoList);
		this.getRequest().setAttribute("personInfoList", personInfoList);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @title saveIssueFile
	 * @description 人工核保中保存问题件
	 * @author 薛玉强
	 * @return
	 */
	public String saveIssueFile(){
		LCIssue lcIssueTemp = artificalUWService.saveIssueFile(lcIssue, lcGrpCont);
		if(null != lcIssueTemp){
			return NONE;
		}
		return null;
	}
	
	/**
	 * 
	 * @title findGrpIssue
	 * @description 团体问题件查询
	 * @author 薛玉强
	 * @return
	 */
	public String findGrpIssue(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		 lcIssueList=artificalUWService.findGrpIssue(lcIssue,pageNo,pageSize);
		if(null != lcIssueList){
			this.getRequest().setAttribute("lcIssueList", lcIssueList);
		}else{
			this.getRequest().setAttribute("lcIssueList", null);
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @title viewContentAndReply
	 * @description 团体问题件内容和回复查询
	 * @return
	 * @author 薛玉强
	 */
	public String viewContentAndReply(){
		LCIssue lcIssuetemp=artificalUWService.viewContentAndReply(lcIssue);
		List<LCIssue> listTemp = new ArrayList<LCIssue>();
		listTemp.add(lcIssuetemp);
		this.writeJSONData(listTemp, new String[]{"issueCont","replyResult"});
		return NONE;
	}
	/**
	 * 
	 * @title findSearchInfoInput
	 * @description 人工核保中个人契调信息录入
	 * @author 薛玉强
	 * @return
	 */
	public String findSingleSearchInfoInput(){
		Map<String, Object> map = artificalUWService.findSingleSearchInfoInput(lcCont);
		lcCont = (LCCont)map.get("lcCont");
		ldPerson = (LDPerson)map.get("ldPerson");
		return SUCCESS;
	}
	
	/**
	 * 
	 * @title saveSearchInfo
	 * @description 人工核保中保存个人契调信息
	 * @author 薛玉强
	 * @return
	 */
	public String saveSingleSearchInfo(){
		LCSingleSearchInfo lcSingleSearchInfoTemp = artificalUWService.saveSingleSearchInfo(lcCont, ldPerson, lcSingleSearchInfo, lcSingleSearchItemList);
		if(null != lcSingleSearchInfoTemp){			
			this.writeJSONMsg(SUCCESS);
		}
		return NONE;
	}
	
	/**
	 * @title findGrpSearchInfoQuery
	 * @description 团体契调结论查询
	 * @author 薛玉强
	 * @return
	 */
	public String findGrpSearchInfoQuery(){
		lcContPage = this.artificalUWService.findGrpSearchInfoQuery(lcGrpCont, pageNo, pageSize);
		return SUCCESS;
	}
	
	/**
	 * @title findGrpSearchItemList
	 * @description 查询个人契调项目列表
	 * @author 薛玉强
	 * @return
	 */
	public String findGrpSearchItemList(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page grpSearchItemPage = this.artificalUWService.findGrpSearchItemList(lcCont, pageNo, pageSize);
		this.writeJSONData(grpSearchItemPage, new String[]{"itemNo","itemName","standbyFlag3"});
		return NONE;
	}
}
