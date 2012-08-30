package ins.claim.report.web;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import ins.claim.manage.model.LLSubmitApply;
import ins.claim.report.service.facade.LLSubmitService;
import ins.framework.web.Struts2Action;
import org.springframework.beans.factory.annotation.Autowired;

@Path("report")
public class LLSubmitController {
	private static final long serialVersionUID = 1L;
	
	/**呈报申请表*/

	private LLSubmitService llSubmitService;
    @Autowired
	public void setLlSubmitService(LLSubmitService llSubmitService) {
		this.llSubmitService = llSubmitService;
	}
	
	public Reply submitApply(@Param("llSubmitApply")LLSubmitApply llSubmitApply){
		llSubmitService.saveSubmitApply(llSubmitApply);
		return Replys.simple().success();
	}
	
}
