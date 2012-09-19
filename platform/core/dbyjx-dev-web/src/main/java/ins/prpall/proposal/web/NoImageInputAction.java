package ins.prpall.proposal.web;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.platform.vo.QueryCodeVo;
import ins.prpall.proposal.model.LCBnf;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCRepInfo;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.proposal.service.facade.NoImageInputService;
import ins.prpall.proposal.vo.LCGrpPolVo;
import ins.prpall.proposal.vo.LcGrpContGroupVo;
import ins.prpall.proposal.vo.NoImageInputInitVo;
import ins.prpall.report.model.LCGrpPol;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @title NoImageInputAction
 * @description 无影像录入的Action类
 * @author xu_xinling
 * @version 
 * @create date 2012-8-6
 * @copyright (c) 
 *
 */
public class NoImageInputAction extends Struts2Action {
	
	private static final long serialVersionUID = 1L;
	
	/**服务类*/
	NoImageInputService noImageInputService;
	
	/**集体保单信息的相关对象、变量*/
	private LCGrpCont lcGrpCont; //集体保单类对象
	private LcGrpContGroupVo lcGrpContGroupVo; //无影像录入页面保存中的保单信息封装类
	private LDGrp ldGrp;//团体客户类
	private String grpContNo1;//保单合同号（通过合同号 录入信息时 传的参数）
	private String customerNo1;//客户号（通过客户号查询客户信息）
	
	private Page grpContPage;//分页对象 
	private Page page;//分页对象
	private String manageName;//管理机构名称
	
	/**隐藏域：*/
	private String grpContNoHidden;//集体合同号
	private String customerNoHidden;//客户号
	private String proposalGrpContNoHidden;//集合保单号
	
	/**集体险种信息的相关对象、变量 */
	private LCGrpPol lcGrpPol;//集体险种类
	private List<LCGrpPolVo>  lcGrpPolVoList;//呈报中的集体险种类信息
	private String saveFlag="";//判断险种信息是否已经保存过。1保存过。
	
	/**个单被保人表*/
	private LCInsured lcInsured;
	/**受益人List*/
	private  List<LCBnf> lcBnfList;
	/**投保单告知信息*/
	private LCRepInfo lcRepInfo;
	private List<LCRepInfo> lcRepInfoList;
	
	/**
	 * 
	 * @description 根据条件查询投保单信息部分信息
	 * @author xu_xinling
	 * @create date 2012-8-6
	 */
	public String findLcGrpContInfo(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		//根据条件查询出集体投保单信息
		this.page =noImageInputService.findGrpContInfo(lcGrpCont,pageNo,pageSize);
		//回写信息（管理机构、初审日期）
		//TODO 徐新玲　左侧导航栏是直接链接的jsp页面，所以目前只能这样回写。觉得不合格。
		this.getRequest().setAttribute("manageCom",lcGrpCont.getManageCom());
		this.getRequest().setAttribute("firstTrialDate",lcGrpCont.getFirstTrialDate());
		return SUCCESS;
	}
	/**
	 * @title findGrpContDetailInfo
	 * @description 根据保单号查询投保单的详细信息
	 * @author xu_xinling
	 * @create date 2012-8-6
	 * @return
	 */
	public String findGrpContDetailInfo(){
		//将状态改为开始录入
		noImageInputService.updateGrpInfoByGrpContNo(grpContNo1,FinalCollection.CONT_STATE3);
		//根据投保单号查询该保单详细信息
		lcGrpCont.setGrpContNo(grpContNo1);
		lcGrpContGroupVo=noImageInputService.findGrpContDetailInfo(lcGrpCont);
		//通过保单合同号查询集体险种信息
		List<LCGrpPolVo> lcGrpPolVoList=noImageInputService.findGrpRiskInfoByGrpContNo(lcGrpCont.getGrpContNo());
		lcGrpContGroupVo.setLcGrpPolList(lcGrpPolVoList);
		//this.getRequest().setAttribute("lcGrpContGroupVo",lcGrpContGroupVo); 
		return SUCCESS;
	}
	/**
	 * 
	 * @title saveGrpBaseInfo
	 * @description 保存集体保单信息，呈报团体客户信息，呈报团单投保人信息，投保告知单信息
	 * @author xu_xinling
	 * @create date 2012-8-7
	 * @return
	 */
	public String saveGrpBaseInfo(){
		//保存页面信息
		 noImageInputService.saveGrpBaseInfo(lcGrpContGroupVo);
		 return NONE;
	}
	/**
	 * 
	 * @title findSubRiskIsOr
	 * @description 判断是否附加险
	 * @author xu_xinling
	 * @create date 2012-8-21
	 * @return
	 */
	public String findSubRiskIsOr(){
		String subRiskIsOr=noImageInputService.findSubRiskIsOr(lcGrpPol);//检查是否是附加险
		String returnStrFlag="";//返回标志
		if("Y".equals(subRiskIsOr))
		{//是附加险
			List<QueryCodeVo> listVo= noImageInputService.findMRiskBySRisk(lcGrpPol, lcGrpCont);
			if(null!=listVo&&listVo.size()>0)//并且主险已经存在
			{
				returnStrFlag="YY";
			}
			else//主险不存在
			{
				returnStrFlag="YN";
			}
		}
		else
		{//不是附加险
			returnStrFlag="N";
		}
		this.writeJSONMsg(returnStrFlag);
		//TODO:徐新玲 为什么renderText不行
		//this.renderText(returnStrFlag);
		return NONE;
	}
	/**
	 * 
	 * @title saveGrpRiskInfo
	 * @description 保存信息险种信息
	 * @author xu_xinling
	 * @create date 2012-8-16
	 * @return
	 */
	public String saveGrpRiskInfo(){
		//集合合同号，用于保存险种信息。
		String grpContNo=lcGrpContGroupVo.getLcGrpCont().getGrpContNo();
		
		//如果险种信息保存过，将呈报带出的险种信息（lcGrpPolVoList中的信息）置空，只需要保存新添加的集体险种信息。
		if("1".equals(saveFlag)){
			this.setLcGrpPolVoList(null);
		}
		//有呈报号时，先将呈报带出的险种信息（lcGrpPolVoList中的信息）保存，再保存新添加的集体险种信息（lcGrpPol中的信息）。
		noImageInputService.saveGrpRiskInfo(grpContNo,lcGrpPol,lcGrpPolVoList);
		this.setLcGrpPolVoList(null);
		
		//通过保单合同号查询集体险种信息  即（时时刷新险种信息）
		List<LCGrpPolVo> lcGrpPolVoList=noImageInputService.findGrpRiskInfoByGrpContNo(grpContNo);
		this.writeJSONData(lcGrpPolVoList, new String[]{"grpPolNo","riskCode","riskName","prem","amnt","floatRate"});
		return NONE;
	}
	
	/**
	 * 
	 * @title writeFinishByState
	 * @description 录入集体保单信息完毕，修改状态
	 * @author xu_xinling
	 * @create date 2012-8-16
	 * @return
	 */
	public String writeFinishByState(){
		//将状态改为待复核状态。
		lcGrpCont=noImageInputService.updateGrpInfoByGrpContNo(lcGrpCont.getGrpContNo(),FinalCollection.CONT_STATE4);
		return NONE;
	}
	/**
	 * 
	 * @title deleGrpRiskInfo
	 * @description 删除险种信息
	 * @author xu_xinling
	 * @create date 2012-8-17
	 * @return
	 */
	public String deleGrpRiskInfo(){
		
		noImageInputService.deleteGrpInfoByGrpContNo(lcGrpPol);
		//通过保单合同号查询集体险种信息  即（时时刷新险种信息）
		List<LCGrpPolVo> lcGrpPolVoList=noImageInputService.findGrpRiskInfoByGrpContNo(lcGrpCont.getGrpContNo());
		if(null!=lcGrpPolVoList){
			this.writeJSONData(lcGrpPolVoList, new String[]{"grpPolNo","riskCode","riskName","prem","amnt","floatRate"});
		}
		return 	NONE;
	}
	/**
	 * 
	 * @title findCustomerInfoByCondition
	 * @description 通过多条件查询客户信息
	 * @author xu_xinling
	 * @create date 2012-8-13
	 * @return
	 */
	public String findCustomerInfoByCondition(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		//根据条件查询出集体投保单信息
		this.page =noImageInputService.findCustomerInfoByCondition(ldGrp,pageNo,pageSize);
		//回写保单合同号
		this.getRequest().setAttribute("grpContNoHidden",grpContNoHidden);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @title chooseClertStart
	 * @description 根据客户号查询单位信息
	 * @author xu_xinling
	 * @create date 2012-8-13
	 * @return
	 */
	public String findClertInfoByCustomerNo(){
		LcGrpContGroupVo lGrpContGroupVo=new LcGrpContGroupVo();
		//通过保单号查询保单部分信息
		LCGrpCont lcGrpCont=noImageInputService.findLcGrpContByGrpContNO(grpContNoHidden);
		//页面回写保单的部分信息
		lGrpContGroupVo.setLcGrpCont(lcGrpCont);
		//页面初始化团体客户信息
		lGrpContGroupVo.setLdGrp(noImageInputService.findClertInfoByCustomerNo(customerNo1));
		this.setLcGrpContGroupVo(lGrpContGroupVo);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @title findClertPage
	 * @description TODO
	 * @author xu_xinling
	 * @create date 2012-8-14
	 * @return
	 */
	public String findClertPage(){
		this.getRequest().setAttribute("grpContNoHidden",lcGrpContGroupVo.getLcGrpCont().getGrpContNo()); 
		return SUCCESS;
	}
	
	
	/**
	 * 告知单、受益人、被保险人信息保存
	 * @param lcInsured
	 * @param lcRepInfoList
	 * @param lcBnfList
	 * @author 于文龙
	 */
	@SuppressWarnings("unchecked")
	public String saveAllInfo(){
		ActionContext ac=ActionContext.getContext();
		PrpDuser user=(PrpDuser)ac.getSession().get("user");
		PrpDcompany company=(PrpDcompany)ac.getSession().get("prpDcompany");
		//lcInsured信息整理
		lcInsured.setOperator(user.getUserName());
		lcInsured.setManageCom(company.getComCode());
		//信息保存
		Map<String,Object> map=noImageInputService.saveAllInfo(lcInsured, lcRepInfoList, lcBnfList);
		//返回信息
		lcInsured =(LCInsured)map.get("lcInsured");
		lcRepInfoList=(List<LCRepInfo>)map.get("lcRepInfoList");
		lcBnfList=(List<LCBnf>)map.get("lcBnfList");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lcInsured", JSONArray.fromObject(lcInsured));
		jsonObject.put("lcRepInfoList", JSONArray.fromObject(lcRepInfoList));
	    jsonObject.put("lcBnfList", JSONArray.fromObject(lcBnfList));
	    renderHtml(jsonObject.toString());
		return NONE;
	}
	
	/**
	 * 被保险人信息查询
	 * @param 被保险人表
	 * 
	 */
	public String findInsuredInfo(){
		Page page = noImageInputService.findInsuredInfo(lcInsured);
		this.writeJSONData(page, new String[]{"grpContNo","name","manageCom","idNo","birthday","sex","contPlanCode","executeCom","idType"});
		System.out.println(page.getPageSize()+"action");
		return NONE;
	}

	
	
	/**
	 * @return the noImageInputService
	 */
	public NoImageInputService getNoImageInputService() {
		return noImageInputService;
	}

	/**
	 * @param noImageInputService the noImageInputService to set
	 */
	public void setNoImageInputService(NoImageInputService noImageInputService) {
		this.noImageInputService = noImageInputService;
	}

	/**
	 * @return the lcInsured
	 */
	public LCInsured getLcInsured() {
		return lcInsured;
	}

	/**
	 * @param lcInsured the lcInsured to set
	 */
	public void setLcInsured(LCInsured lcInsured) {
		this.lcInsured = lcInsured;
	}

	/**
	 * @return the lcBnfList
	 */
	public List<LCBnf> getLcBnfList() {
		return lcBnfList;
	}

	/**
	 * @param lcBnfList the lcBnfList to set
	 */
	public void setLcBnfList(List<LCBnf> lcBnfList) {
		this.lcBnfList = lcBnfList;
	}

	/**
	 * @return the lcRepInfo
	 */
	public LCRepInfo getLcRepInfo() {
		return lcRepInfo;
	}

	/**
	 * @param lcRepInfo the lcRepInfo to set
	 */
	public void setLcRepInfo(LCRepInfo lcRepInfo) {
		this.lcRepInfo = lcRepInfo;
	}

	/**
	 * @return the lcRepInfoList
	 */
	public List<LCRepInfo> getLcRepInfoList() {
		return lcRepInfoList;
	}

	/**
	 * @param lcRepInfoList the lcRepInfoList to set
	 */
	public void setLcRepInfoList(List<LCRepInfo> lcRepInfoList) {
		this.lcRepInfoList = lcRepInfoList;
	}
	/**
	 * 流水号
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the lcGrpCont
	 */
	public LCGrpCont getLcGrpCont() {
		return lcGrpCont;
	}

	/**
	 * @param lcGrpCont the lcGrpCont to set
	 */
	public void setLcGrpCont(LCGrpCont lcGrpCont) {
		this.lcGrpCont = lcGrpCont;
	}
	/**
	 * @return the lcGrpContGroupVo
	 */
	public LcGrpContGroupVo getLcGrpContGroupVo() {
		return lcGrpContGroupVo;
	}
	/**
	 * @param lcGrpContGroupVo the lcGrpContGroupVo to set
	 */
	public void setLcGrpContGroupVo(LcGrpContGroupVo lcGrpContGroupVo) {
		this.lcGrpContGroupVo = lcGrpContGroupVo;
	}
	/**
	 * @return the ldGrp
	 */
	public LDGrp getLdGrp() {
		return ldGrp;
	}
	/**
	 * @param ldGrp the ldGrp to set
	 */
	public void setLdGrp(LDGrp ldGrp) {
		this.ldGrp = ldGrp;
	}
	/**
	 * @return the grpContNoHidden
	 */
	public String getGrpContNoHidden() {
		return grpContNoHidden;
	}
	/**
	 * @param grpContNoHidden the grpContNoHidden to set
	 */
	public void setGrpContNoHidden(String grpContNoHidden) {
		this.grpContNoHidden = grpContNoHidden;
	}
	public LCGrpPol getLcGrpPol() {
		return lcGrpPol;
	}
	public void setLcGrpPol(LCGrpPol lcGrpPol) {
		this.lcGrpPol = lcGrpPol;
	}
	public List<LCGrpPolVo> getLcGrpPolVoList() {
		return lcGrpPolVoList;
	}
	public void setLcGrpPolVoList(List<LCGrpPolVo> lcGrpPolVoList) {
		this.lcGrpPolVoList = lcGrpPolVoList;
	}
	public String getCustomerNoHidden() {
		return customerNoHidden;
	}
	public void setCustomerNoHidden(String customerNoHidden) {
		this.customerNoHidden = customerNoHidden;
	}
	public String getProposalGrpContNoHidden() {
		return proposalGrpContNoHidden;
	}
	public void setProposalGrpContNoHidden(String proposalGrpContNoHidden) {
		this.proposalGrpContNoHidden = proposalGrpContNoHidden;
	}
	public Page getGrpContPage() {
		return grpContPage;
	}
	public void setGrpContPage(Page grpContPage) {
		this.grpContPage = grpContPage;
	}
	public String getGrpContNo1() {
		return grpContNo1;
	}
	public void setGrpContNo1(String grpContNo1) {
		this.grpContNo1 = grpContNo1;
	}

	public String getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}
	public String getManageName() {
		return manageName;
	}
	public void setManageName(String manageName) {
		this.manageName = manageName;
	}
	public String getCustomerNo1() {
		return customerNo1;
	}
	public void setCustomerNo1(String customerNo1) {
		this.customerNo1 = customerNo1;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	


	
}