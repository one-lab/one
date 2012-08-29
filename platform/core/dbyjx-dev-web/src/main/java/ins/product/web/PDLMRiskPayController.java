package ins.product.web;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import ins.framework.web.Struts2Action;
import ins.product.model.PDLMRiskPay;
import ins.product.service.facade.PDLMRiskPayService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMRiskPayController {
	private static final long serialVersionUID = 1L;
	
	private PDLMRiskPayService pdlmRiskPayService;
	/**
	 * @title saveRiskPay
	 * @description 保存险种缴费数据
	 * @author 党泽
	 * @return
	 */
	public Reply saveRiskPay(@Param("pdlmRiskPay")PDLMRiskPay pdlmRiskPay){
		 pdlmRiskPayService.saveRiskPay(pdlmRiskPay);
		//this.writeJSONData(list, args);
		return Replys.simple().success();
	}
	/**
	 * @title deletRiskPay
	 * @description 删除险种缴费数据
	 * @author 党泽
	 * @return
	 */
	public Reply deleteRiskPay(@Param("pdlmRiskPay")PDLMRiskPay pdlmRiskPay){
		 pdlmRiskPayService.deleteRiskPay(pdlmRiskPay);
		return Replys.simple().success();
	}
	/**
	 * @title updateRiskPay
	 * @description 更新险种缴费数据
	 * @author 党泽
	 * @return
	 */
	public Reply updateRiskPay(@Param("pdlmRiskPay")PDLMRiskPay pdlmRiskPay){
		pdlmRiskPay = pdlmRiskPayService.updateRiskPay(pdlmRiskPay);
		return Replys.simple().success();
	}
    @Autowired
	public void setPdlmRiskPayService(PDLMRiskPayService pdlmRiskPayService) {
		this.pdlmRiskPayService = pdlmRiskPayService;
	}
}
