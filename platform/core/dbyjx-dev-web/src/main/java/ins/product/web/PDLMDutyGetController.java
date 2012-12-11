package ins.product.web;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
import ins.common.util.DisposeObject;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMDutyGet;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMDutyGetService;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMDutyGetController {
	private static final long serialVersionUID = 1L;
	
	private PDBaseFieldService pdBaseFieldService;
	private PDLMDutyGetService pdLmDutyGetService;

    @Autowired
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}

    @Autowired
	public void setPdLmDutyGetService(PDLMDutyGetService pdLmDutyGetService) {
		this.pdLmDutyGetService = pdLmDutyGetService;
	}

	public String findDutyGetField(Invocation invocation){
		String tableCode = "PD_LMDutyGet";
		List<PDBaseField> dutyGetFields = pdBaseFieldService.findField(tableCode);
        invocation.addModel("dutyGetFields", dutyGetFields);
        invocation.addModel("dutyGetFlag", "false");
		return "/product/pddefine/baseinfodefine/pdLMRiskDutyGetEdit.jsp";
	}
	/**
	 * @title saveRiskDutyGet
	 * @description 保存一条险种给付责任
	 * @author 朱超
	 * @return
	 */
	public Reply saveRiskDutyGet(@Param("pdLmDutyGet") PDLMDutyGet pdLmDutyGet){
		//保存注意pdlmCalMode和PDLMDuty的引用
        PDLMDutyGet pdLmDutyGetTarget = pdLmDutyGetService.saveRiskDutyGet(pdLmDutyGet);
		DisposeObject dis = new DisposeObject();
		dis.dispose(pdLmDutyGetTarget, null);
		List<PDLMDutyGet> pdlmDutyGets = new ArrayList<PDLMDutyGet>();
		pdlmDutyGets.add(pdLmDutyGetTarget);
		return Replys.with(pdlmDutyGets).as(Json.class);
	}
	
	public Reply deleteRiskDutyGet(@Param("getDutyCode") String getDutyCode){
		String flag = pdLmDutyGetService.deleteRiskDutyGet(getDutyCode);
		return Replys.with(flag).as(Text.class);
	}
}
