package ins.prpall.proposal.web;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.web.Struts2Action;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.service.facade.SignService;

public class SignAction extends Struts2Action{
	private static final long serialVersionUID = 1L;
	private LCGrpCont lcGrpCont;
    private SignService signService;
    private FinalCollection finalCollection;
    private Page ProposalSignPage;
    
    
	public Page getProposalSignPage() {
		return ProposalSignPage;
	}

	public void setProposalSignPage(Page proposalSignPage) {
		ProposalSignPage = proposalSignPage;
	}

	public FinalCollection getFinalCollection() {
		return finalCollection;
	}

	public void setFinalCollection(FinalCollection finalCollection) {
		this.finalCollection = finalCollection;
	}

	public SignService getSignService() {
		return signService;
	}

	public void setSignService(SignService signService) {
		this.signService = signService;
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
	
	public String findProposalInfo(){
		
		return SUCCESS;
	}

	/**查询待签单的投报单
	 * @param LCGrpCont
	 * @author 郭占红
	 */
	public String findProposalSignInfo() {
		this.ProposalSignPage = signService.findProposalSignInfo(lcGrpCont,pageNo,pageSize);
		this.getRequest().setAttribute("lcGrpCont", lcGrpCont);
		return SUCCESS;
	}
	/**
	 * 签单功能
	 * @author 郭占红
	 */
     public String saveSignInfo(){
    	boolean flag=false;
    	flag=signService.saveSignInfo(lcGrpCont);
    	if(flag==true){
    		this.ProposalSignPage = signService.findProposalSignInfo(lcGrpCont,pageNo,pageSize);
    		this.getRequest().setAttribute("lcGrpCont", lcGrpCont);	
    	}
    	 return SUCCESS;
     }
	
	

}
