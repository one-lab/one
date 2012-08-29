package ins.product.web;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
import ins.common.util.DisposeObject;
import ins.framework.web.Struts2Action;
import ins.product.model.PDLMDuty;
import ins.product.model.PDLMRiskDuty;
import ins.product.service.facade.PDLMRiskDutyService;

import java.sql.Date;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMRiskDutyController {

	private static final long serialVersionUID = 1L;
	private PDLMRiskDutyService pdlmRiskDutyService;

    @Autowired
	public void setPdlmRiskDutyService(PDLMRiskDutyService pdlmRiskDutyService) {
		this.pdlmRiskDutyService = pdlmRiskDutyService;
	}
	/**
	 * @title saveRiskDuty
	 * @description 保存险种责任定义，和险种责任关联的定义
	 * @author 朱超
	 * @return
	 */
	public Reply saveRiskDuty(@Param("pdlmRiskDuty")PDLMRiskDuty pdlmRiskDuty,@Param("pdlmDuty")PDLMDuty pdlmDuty ){
		pdlmRiskDuty = pdlmRiskDutyService.saveRiskDuty(pdlmRiskDuty,pdlmDuty);
		pdlmRiskDuty.setPDLMDuty(null);
		DisposeObject dis = new DisposeObject();
		Map map = dis.dispose(pdlmRiskDuty, new String[]{"id.riskCode","id.dutyCode","riskVer"});
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pdlmRiskDuty", JSONArray.fromObject(map));
		return Replys.with(jsonObject.toString()).as(Json.class);
	}
	/**
	 * @title updateDhtml
	 * @description 更新riskDuty表中的dhtml字段，为契约使用
	 * @author 朱超
	 * @return
	 */
	public Reply updateDhtml(@Param("pdlmRiskDuty")PDLMRiskDuty pdlmRiskDuty){
		String flag = pdlmRiskDutyService.updateDhtml(pdlmRiskDuty);
	//	this.renderText(flag);
		return Replys.with(flag).as(Text.class);
	}
	
	public Reply deleteRiskDuty(){
		//String flag = pdlmRiskDutyService.deleteRiskDuty();
		return Replys.simple().success();
	}
	//直接跳转页面
	public String showDefine(){
		
		return "/product/pddefine/policydefine/pdpolicyedit.jsp";
	}
}
