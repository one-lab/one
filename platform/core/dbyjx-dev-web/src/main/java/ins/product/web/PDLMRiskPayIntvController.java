package ins.product.web;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import ins.framework.web.Struts2Action;
import ins.product.model.PDLMRiskPayIntv;
import ins.product.service.facade.PDLMRiskPayIntvService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMRiskPayIntvController {
	private static final long serialVersionUID = 1L;
	
	private PDLMRiskPayIntvService pdlmRiskPayIntvService;
	/**
	 * @title saveRiskPayIntv
	 * @description 保存险种交费间隔数据
	 * @author 党泽
	 * @return
	 */
	public Reply saveRiskPayIntv(@Param("pdlmRiskPayIntv") PDLMRiskPayIntv pdlmRiskPayIntv){
		pdlmRiskPayIntv = pdlmRiskPayIntvService.saveRiskPayIntv(pdlmRiskPayIntv);
		//this.writeJSONData(list, args);
		return Replys.simple().success();
	}
	/**
	 * @title deletRiskPayIntv
	 * @description 删除险种交费间隔数据
	 * @author 党泽
	 * @return
	 */
	public Reply deleteRiskPayIntv(@Param("pdlmRiskPayIntv") PDLMRiskPayIntv pdlmRiskPayIntv){
		pdlmRiskPayIntv = pdlmRiskPayIntvService.deleteRiskPayIntv(pdlmRiskPayIntv);
		return Replys.simple().success();
	}
	/**
	 * @title updateRiskPayIntv
	 * @description 更新险种交费间隔数据
	 * @author 党泽
	 * @return
	 */
	public Reply updateRiskPayIntv(@Param("pdlmRiskPayIntv") PDLMRiskPayIntv pdlmRiskPayIntv){
		pdlmRiskPayIntv = pdlmRiskPayIntvService.updateRiskPayIntv(pdlmRiskPayIntv);
		return Replys.simple().success();
	}
    @Autowired
	public void setPdlmRiskPayIntvService(
			PDLMRiskPayIntvService pdlmRiskPayIntvService) {
		this.pdlmRiskPayIntvService = pdlmRiskPayIntvService;
	}
	
}
