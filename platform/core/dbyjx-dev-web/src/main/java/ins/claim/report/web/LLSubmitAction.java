package ins.claim.report.web;

import ins.claim.manage.model.LLSubmitApply;
import ins.claim.report.service.facade.LLSubmitService;
import ins.framework.web.Struts2Action;

public class LLSubmitAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	/**呈报申请表*/
	private LLSubmitApply llSubmitApply;

	private LLSubmitService llSubmitService;

	public LLSubmitApply getLlSubmitApply() {
		return llSubmitApply;
	}

	public void setLlSubmitApply(LLSubmitApply llSubmitApply) {
		this.llSubmitApply = llSubmitApply;
	}

	public LLSubmitService getLlSubmitService() {
		return llSubmitService;
	}

	public void setLlSubmitService(LLSubmitService llSubmitService) {
		this.llSubmitService = llSubmitService;
	}
	
	public String submitApply(){
		llSubmitService.saveSubmitApply(llSubmitApply);
		return NONE;
	}
	
}
