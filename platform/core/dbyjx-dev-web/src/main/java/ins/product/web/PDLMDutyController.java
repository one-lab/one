package ins.product.web;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import ins.framework.web.Struts2Action;
import ins.product.model.PDLMDuty;
import ins.product.model.PDLMRiskDuty;
import ins.product.service.facade.PDLMDutyService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMDutyController {
	private static final long serialVersionUID = 1L;
	
	private PDLMDutyService pdlmDutyService;
    @Autowired
	public void setPdlmDutyService(PDLMDutyService pdlmDutyService) {
		this.pdlmDutyService = pdlmDutyService;
	}
	/**
	 * @title saveDuty
	 * @description 保存责任
	 * @author Administrator
	 * @return
	 */
	public Reply saveDuty(@Param("pdlmDuty") PDLMDuty pdlmDuty,
                          @Param("pdlmRiskDuty") PDLMRiskDuty pdlmRiskDuty){
		
//		String riskCode = (String)this.getSession().getAttribute("riskCode");
//		pdlmDutyService.saveDuty(pdlmDuty,riskCode);
		return Replys.NO_REPLY;
	}
}
