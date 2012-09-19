package ins.product.web;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMDutyPay;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMDutyPayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Path("/product")
public class PDLMDutyPayController {
	private static final long serialVersionUID = 1L;
	
	private PDBaseFieldService pdBaseFieldService;
	private PDLMDutyPayService pdLmDutyPayService;

	@Autowired
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}

    @Autowired
	public void setPdLmDutyPayService(PDLMDutyPayService pdLmDutyPayService) {
		this.pdLmDutyPayService = pdLmDutyPayService;
	}
	/**
	 * 查询缴费字段
	 * @return
	 */
	public String findDutyPayField(Invocation invocation){
		String tableCode = "PD_LMDutyPay";
		List<PDBaseField> dutyPayFields = pdBaseFieldService.findField(tableCode);
		invocation.addModel("dutyPayFields", dutyPayFields);
		invocation.addModel("dutyPayFlag", "false");
		return "/product/pddefine/baseinfodefine/pdLMRiskDutyPayEdit.jsp";
	}
	/**
	 * 保存缴费记录
	 * @return
	 */
	public Reply saveRiskDutyPay(@Param("pdLmDutyPay") PDLMDutyPay pdLmDutyPay,Invocation invocation){
		pdLmDutyPayService.saveRiskDutyPay(pdLmDutyPay,invocation);
		return Replys.simple().success();
	}
	/**
	 * @title deleteRiskDutyPay
	 * @description 删除一条缴费责任定义
	 * @author 朱超
	 * @return
	 */
	public Reply deleteRiskDutyPay(@Param("payPlanCode") String payPlanCode){
		String flag = pdLmDutyPayService.deleteRiskDutyPay(payPlanCode);
		return Replys.with(flag).as(Text.class);
	}
	
	public Reply  updateRiskDutyPay(@Param("pdLmDutyPay") PDLMDutyPay pdLmDutyPay){
		pdLmDutyPayService.updateRiskDutyPay(pdLmDutyPay);
		return Replys.with("").as(Text.class);
	}
}
