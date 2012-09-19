package ins.prpall.proposal.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import com.opensymphony.xwork2.ActionContext;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.web.Struts2Action;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLDcode1;
import ins.product.model.PDLMRisk;

import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCGrpServInfo;
import ins.prpall.proposal.model.LCNotepad;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.proposal.service.facade.ProposalPreService;
import ins.prpall.report.model.LCReport;
import ins.prpall.report.vo.ReportInfoVo;
import ins.prpall.report.vo.ReportQueryResultVo;


public class ProposalPreAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	/**集体保单表*/
	private LCGrpCont lcGrpCont;
	private LCReport lcReport;
	private ProposalPreService proposalPreService;
	private PDLDcode1 pdLDcode1;
	private LCNotepad lcNotepad;
	private LCGrpServInfo lcGrpServInfo;
	private LDGrp ldGrp;
    private Page ProposalPrePage;
   	private PDLMRisk pdLMRisk;
    private String mark;
    private FinalCollection finalCollection;
    
    public Page getProposalPrePage() {
		return ProposalPrePage;
	}

	public void setProposalPrePage(Page proposalPrePage) {
		ProposalPrePage = proposalPrePage;
	}
	public FinalCollection getFinalCollection() {
		return finalCollection;
	}

	public void setFinalCollection(FinalCollection finalCollection) {
		this.finalCollection = finalCollection;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public PDLMRisk getPdLMRisk() {
		return pdLMRisk;
	}

	public void setPdLMRisk(PDLMRisk pdLMRisk) {
		this.pdLMRisk = pdLMRisk;
	}

	public LDGrp getLdGrp() {
		return ldGrp;
	}
	public void setLdGrp(LDGrp ldGrp) {
		this.ldGrp = ldGrp;
	}
	public LCGrpServInfo getLcGrpServInfo() {
		return lcGrpServInfo;
	}
	public void setLcGrpServInfo(LCGrpServInfo lcGrpServInfo) {
		this.lcGrpServInfo = lcGrpServInfo;
	}
	public LCReport getLcReport() {
		return lcReport;
	}
	public void setLcReport(LCReport lcReport) {
		this.lcReport = lcReport;
	}
	public PDLDcode1 getPdLDcode1() {
		return pdLDcode1;
	}
	public void setPdLDcode1(PDLDcode1 pdLDcode1) {
		this.pdLDcode1 = pdLDcode1;
	}
	public ProposalPreService getProposalPreService() {
		return proposalPreService;
	}
	public void setProposalPreService(ProposalPreService proposalPreService) {
		this.proposalPreService = proposalPreService;
	}
	
	public LCGrpCont getLcGrpCont() {
		return lcGrpCont;
	}
	public void setLcGrpCont(LCGrpCont lcGrpCont) {
		this.lcGrpCont = lcGrpCont;
	}
	
	public LCNotepad getLcNotepad() {
		return lcNotepad;
	}
	public void setLcNotepad(LCNotepad lcNotepad) {
		this.lcNotepad = lcNotepad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @title findProsalPreInfo
	 * @description 根据投保单号、管理机构、初审日期、投保单位、主营业务员查询投保单信息
	 * @param
	 * @author Administrator
	 * @return
	 */
	public String findProsalPreInfo(){
		this.getSession().setAttribute("lcGrpContInfo", lcGrpCont);
		if(this.pageNo == 0){
			this.pageNo = 1;
		}
		if(this.pageSize == 0){
			this.pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRule = QueryRule.getInstance();
		if(null!=lcGrpCont.getManageCom() && !"".equals(lcGrpCont.getManageCom().trim())){
			findRule.addEqual("manageCom",lcGrpCont.getManageCom().trim());
		}
		if(null!=lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpContNo().trim())){
			findRule.addEqual("grpContNo",lcGrpCont.getGrpContNo().trim());
		}
		if(null!=lcGrpCont.getFirstTrialDate() && !"".equals(lcGrpCont.getFirstTrialDate())){
			findRule.addEqual("firstTrialDate",lcGrpCont.getFirstTrialDate());
		}
		if(null!=lcGrpCont.getGrpName()&& !"".equals(lcGrpCont.getGrpName().trim())){
			findRule.addEqual("grpName",lcGrpCont.getGrpName().trim());
		}
		if(null!=lcGrpCont.getHandlerName()&& !"".equals(lcGrpCont.getHandlerName().trim())){
			findRule.addEqual("handlerName",lcGrpCont.getHandlerName().trim());
		}
		findRule.addEqual("state",finalCollection.CONT_STATE1);
		this.getRequest().setAttribute("lcGrpCont",lcGrpCont );
		String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.getRequest().setAttribute("currentTime",time);//保存当前时间
		this.ProposalPrePage = proposalPreService.findProsalPreInfo(findRule,pageNo,pageSize);
		return SUCCESS;
		
		
		
		
		
	}
	/**据客户号查询相关呈报件
	 * @param
	 * @author 郭占红
	 */
	public String findReportInfo(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = 20;
		}
		String appno=lcGrpCont.getAppntNo().trim();
		String grpName=lcGrpCont.getGrpName().trim();
		//如果appno为""或null说明页面上没有客户号，那么就要去团体保单表里根据投保单位查客户号，如果查到就根据查到的客户号查找相关呈报件
		if("".equals(appno)  || null == appno){
			appno=proposalPreService.findCustomerNoByGrpName(grpName);
			if(appno!=null){
				this.ProposalPrePage = proposalPreService.findReportInfo(appno, pageNo, pageSize);
				if( null!= ProposalPrePage.getResult() && ProposalPrePage.getResult().size()>0 ){
					this.renderText("sucess");
					this.getSession().setAttribute("findResult", ProposalPrePage.getResult());
				}else{
					this.renderText("fail");
				}
			}else{
				this.renderText("fail");
			}
		}else{
			this.ProposalPrePage  = proposalPreService.findReportInfo(appno, pageNo, pageSize);
			if( null!= ProposalPrePage.getResult() && ProposalPrePage.getResult().size()>0 ){
				this.renderText("sucess");
				this.getSession().setAttribute("findResult", ProposalPrePage.getResult());
			}else{
				this.renderText("fail");
			}
		}
		
		
		return NONE;
	}
	/**据集体合同号查询投保单
	 * @param lcGrpCont
	 * @author 郭占红
	 */
	public String findProsalPreInfoByGrpContNo(){
		
		lcGrpCont=proposalPreService.findProsalPreInfoByGrpContNo(lcGrpCont.getGrpContNo());
		mark="1";
		return "ok";
	}
	/**根据业务号查看记事本内容
	 * @param  lcNotepad
	 * @author 郭占红
	 */
     public String findNoteInfo(){
    	 this.ProposalPrePage =proposalPreService.findNoteInfo(lcNotepad,pageNo,pageSize);
    	 List<LCNotepad> list=ProposalPrePage.getResult();
       	 this.getSession().setAttribute("bussinessNo", lcNotepad.getId().getBussinessNo());//存储投保单号
    	 this.getSession().setAttribute("inputLocation", lcNotepad.getInputLocation());//存储录入位置
    	 this.getSession().setAttribute("noteInfoResult",list );
    	 this.renderText("success");
      	 return NONE;
     }
     /**保存记事本内容 
 	 * @param  lcNotepad
 	 * @author 郭占红
 	 */
     public String savaNoteInfo(){
    	LCNotepad newLCNotepad= (LCNotepad) proposalPreService.savaNoteInfo(lcNotepad);
    	this.getSession().setAttribute("inputLocation", lcNotepad.getInputLocation());//当前录入位置标志
    	List<LCNotepad> list = new ArrayList<LCNotepad>();
    	list.add(newLCNotepad);
    	this.writeJSONData(list, new String[]{"id","content","inputLocation","operator","modifyDate","modifyTime"});
       	return NONE;
     }
     /**保存投保单初审信息
  	 * @param  lcGrpCont
  	 * @author 郭占红
  	 */
     public String saveProposalInfo(){
    	 String proposalGrpContNo="";
    	 //先判断lcGrpCont的投保单号是否为空，如果为空，说明是新申请的一条保单，要先自动生成一个投保单号再进行下面的保存操作
    	 if("".equals(lcGrpCont.getGrpContNo()) || null ==lcGrpCont.getGrpContNo() ){
    		 proposalGrpContNo=proposalPreService.obtainProposalGrpContNo();
    		 lcGrpCont.setGrpContNo(proposalGrpContNo);
    		 lcGrpServInfo.getId().setGrpContNo(proposalGrpContNo);
    	 }
    	 
    	
    	
    	 String mark=this.getRequest().getParameter("mark");
    	
    	
    	boolean flag=false;
    	if(mark.equals("0")){//mark为0说明点击的是申请按钮后做的保存操作
    		flag=proposalPreService.saveProposalInfo(lcGrpCont);
    		proposalPreService.saveLcGrpServInfo(lcGrpServInfo);//保存或更新团单投保信息
    		if(flag==true){
    		this.renderText(proposalGrpContNo);
    		}
    	}else if(mark.equals("1")){//mark为1说明点击的是查询按钮后做的保存操作
    		flag=proposalPreService.updateProposalInfo(lcGrpCont);
    		proposalPreService.saveLcGrpServInfo(lcGrpServInfo);//保存或更新团单投保信息
    		if(flag==true ){
    			this.renderText("save");
        	}
    	}
    	
    	 return NONE;
     }
     
   
     /**判断投保单号（集体合同号）是否存在
      *  @param  lcGrpCont
  	  * @author 郭占红
      */
     public String isGrpContNoExist(){
    	 boolean flag=false;
    	 flag= proposalPreService.findProposalInfoByGrpContNo(lcGrpCont.getGrpContNo());
    	 if(flag==true){
    		 this.renderText("yes"); 
    	 }else{
    		 this.renderText("no"); 
    	 }
    	
    	 return NONE;
     }
     /**修改投保单信息
      *  @param  lcGrpCont
  	  * @author 郭占红
      */
     public String editProposalInfo(){
    	 boolean flag=false;
    	 flag= proposalPreService.updateProposalInfo(lcGrpCont);
    	 proposalPreService.saveLcGrpServInfo(lcGrpServInfo);
    	 if(flag==true){
    		 this.renderText("success"); 
    	 }
    	 return NONE;
     }
     /**根据投保单位名称查询客户号
      * @param  ldGrp
      * @author 郭占红
      */
     public String findCustomerNoByGrpName(){
    	 String customerNo="";
    	 customerNo=proposalPreService.findCustomerNoByGrpName(ldGrp.getGrpName());
    	 if(customerNo!=null){
    		 this.renderText(customerNo);
    	 }else{
    		 this.renderText("fail");
    	 }
    	 return NONE;
     }
     /**
 	 * 自动生成集体投保单号
 	 * @param lcgrpcont
 	 * @author 郭占红
 	 */
     public String obtainProposalGrpContNo(){
    	 String proposalGrpContNo="";
    	 proposalGrpContNo=proposalPreService.obtainProposalGrpContNo();
    	 if(proposalGrpContNo!=null){
    		 this.renderText(proposalGrpContNo);
    	 }else{
    		 this.renderText("fail");
    	 }
    	 return NONE;
     }
     /**初审确认
      * @param lcgrpcont
      * @author 郭占红
      */
     public String proposalPreConfirm(){
    	 boolean flag=false;
    	 flag= proposalPreService.proposalPreConfirm(lcGrpCont);
    	 if(flag==true){
    		 this.renderText("success");
    	 }else{
    		 this.renderText("fail");
    	 }
    	 return NONE;
     }
     /**
      * 投保单申请
      * @param lcGrpCont
      * @author 郭占红
      */
     public String apply(){
    	 mark="0";
    	 return "ok";
     }
     
}
