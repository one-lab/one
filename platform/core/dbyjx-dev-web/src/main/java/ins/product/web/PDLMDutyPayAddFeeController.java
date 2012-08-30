package ins.product.web;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMDutyPayAddFee;
import ins.product.model.PDLMDutyPayAddFeeId;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMDutyPayAddFeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Path("/product")
public class PDLMDutyPayAddFeeController {
	private static final long serialVersionUID = 1L;
	
	private PDLMDutyPayAddFeeService pdlmDutyPayAddFeeService;
	private PDBaseFieldService pdBaseFieldService;

	
	@Autowired
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	@Autowired
	public void setPdlmDutyPayAddFeeService(
			PDLMDutyPayAddFeeService pdlmDutyPayAddFeeService) {
		this.pdlmDutyPayAddFeeService = pdlmDutyPayAddFeeService;
	}
	
	/**
	 * @title saveDutyPayAddFee
	 * @description 保存一条加费记录
	 * @author 朱超
	 * @return
	 */
	public Reply saveDutyPayAddFee(@Param("pdlmDutyPayAddFee") PDLMDutyPayAddFee pdlmDutyPayAddFee){
        PDLMDutyPayAddFee pdlmDutyPayAddFeeTarget = pdlmDutyPayAddFeeService.saveDutyPayAddFee(pdlmDutyPayAddFee);
		List<PDLMDutyPayAddFee> pdlmDutyPayAddFees = new ArrayList<PDLMDutyPayAddFee>();
		pdlmDutyPayAddFees.add(pdlmDutyPayAddFeeTarget);
		String[] show = new String[]{"id.riskCode","id.dutyCode","id.addFeeType","id.addFeeObject","addFeeCalCode","addPointLimit"};
		return Replys.with(pdlmDutyPayAddFees).as(Json.class).includes(show);
	}
	
	/**
	 * @title updateDutyPayAddFee
	 * @description 更新一条加费记录
	 * @author 朱超
	 * @return
	 */
	public Reply updateDutyPayAddFee(@Param("pdlmDutyPayAddFee") PDLMDutyPayAddFee pdlmDutyPayAddFee){
        PDLMDutyPayAddFee pdlmDutyPayAddFeeTarget = pdlmDutyPayAddFeeService.updateDutyPayAddFee(pdlmDutyPayAddFee);
		List<PDLMDutyPayAddFee> pdlmDutyPayAddFees = new ArrayList<PDLMDutyPayAddFee>();
		pdlmDutyPayAddFees.add(pdlmDutyPayAddFeeTarget);
		String[] show = new String[]{"id.riskCode","id.dutyCode","id.addFeeType","id.addFeeObject","addFeeCalCode","addPointLimit"};
        return Replys.with(pdlmDutyPayAddFees).as(Json.class).includes(show);
	}
	
	/**
	 * @title deleteDutyPayAddFee
	 * @description 删除一条加费记录
	 * @author 朱超
	 * @return
	 */
	public Reply deleteDutyPayAddFee(@Param("pdlmDutyPayAddFee") PDLMDutyPayAddFee pdlmDutyPayAddFee){
		String flag = pdlmDutyPayAddFeeService.deleteDutyPayAddFee(pdlmDutyPayAddFee);
		return Replys.with(flag).as(Text.class);
	}
	
	/**
	 * @title findRiskDutyAddFeeField
	 * @description 查询pd_lmdutypayaddfee表的字段
	 * @author 朱超
	 * @return
	 */
	public Reply findRiskDutyAddFeeField(){
		String tableCode = "PD_LMDutyPayAddFee";
		List<PDBaseField> fields = pdBaseFieldService.findField(tableCode);
		String[] fieldsArr = new String[]{"id.fieldCode","fieldName","fieldType","officialDesc","busiDesc","displayOrder"}; 
		return Replys.with(fields).as(Json.class).includes(fieldsArr);
	}
	
	public Reply findByPK(@Param("id") PDLMDutyPayAddFeeId id){
		PDLMDutyPayAddFee resultDutyPayAddFee = pdlmDutyPayAddFeeService.findByPK(id);
		List<PDLMDutyPayAddFee> list = new ArrayList<PDLMDutyPayAddFee>();
        list.add(resultDutyPayAddFee);
		return Replys.with(list).as(Json.class);
	}
}
