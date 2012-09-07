package ins.product.web;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import ins.framework.web.Struts2Action;
import ins.platform.vo.QueryCodeVo;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.service.facade.PDLMRiskDutyFactorService;
import ins.product.vo.PDLMRiskDutyFactorVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Path("/product")
public class PDLMRiskDutyFactorController {
	private static final long serialVersionUID = 1L;
	private PDLMRiskDutyFactorService pdLmRiskDutyFactorService;
    @Autowired
	public void setPdLmRiskDutyFactorService(
			PDLMRiskDutyFactorService pdLmRiskDutyFactorService) {
		this.pdLmRiskDutyFactorService = pdLmRiskDutyFactorService;
	}

	/**
	 * 增加险种责任要素
	 * 
	 * @return
	 */
	public Reply addRiskDutyFactor(@Param("pdLmRiskDutyFactorList")List<PDLMRiskDutyFactor> pdLmRiskDutyFactorList,
                                   @Param("pdLMRiskDutyFactor") PDLMRiskDutyFactor pdLMRiskDutyFactor,Invocation invocation ) {
		if(null != pdLmRiskDutyFactorList && pdLmRiskDutyFactorList.size() > 0){
			pdLmRiskDutyFactorList = pdLmRiskDutyFactorService.addRiskDutyFactor(pdLmRiskDutyFactorList,invocation);
	//		this.writeJSONData(pdLmRiskDutyFactorList, new String[] {"factorOrder", "factorName" });
            return Replys.with(pdLmRiskDutyFactorList).as(Json.class).includes("factorOrder", "factorName" );
		}else{
			pdLmRiskDutyFactorList = new ArrayList<PDLMRiskDutyFactor>();
			pdLMRiskDutyFactor = pdLmRiskDutyFactorService.addRiskDutyFactor(pdLMRiskDutyFactor,invocation);
			pdLmRiskDutyFactorList.add(pdLMRiskDutyFactor);
	//		this.writeJSONData(pdLmRiskDutyFactorList, new String[] {"factorOrder", "factorName" });
            return Replys.with(pdLmRiskDutyFactorList).as(Json.class).includes("factorOrder", "factorName" );
		}

	}
	/**
	 * 根据险种和责任查询出要素
	 * @return
	 */
	public Reply findFactorByRiskAndDuty(@Param("riskCode")String riskCode,@Param("dutyCode")String dutyCode) {
		List<PDLMRiskDutyFactor> resultFactor = pdLmRiskDutyFactorService.findFactorByRiskAndDuty(riskCode, dutyCode);
		String[] factorArray = new String[]{"factorOrder","calFactorType","factorName","id.calFactor","calSQL","factorNoti","standbyflag1","dhtmlType","comFactorCode","comFactorName","id.calFactor"};
	//	this.writeJSONData(resultFactor, factorArray);
		return Replys.with(resultFactor).as(Json.class).includes(factorArray);
	}
	/**
	 * 
	 * @title findFactorDistinct
	 * @description 根据险种和责任查询要素，并且使用distinct去重
	 * @author 朱超
	 * @return
	 */
	public Reply findFactorDistinct(@Param("riskCode")String riskCode,@Param("")String dutyCode){
		List<QueryCodeVo> list = pdLmRiskDutyFactorService.findFactorDistinct(riskCode, dutyCode);
		return Replys.with(list).as(Json.class);
	}
}
