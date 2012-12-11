package ins.product.service.facade;

import java.util.Map;

import ins.framework.common.Page;
import ins.product.model.PDLMDuty;

public interface PDLMDutyService {
	/**
	 * @title saveDuty
	 * @description 报错责任，和责任关联险种
	 * @author 朱超
	 * @param pdlmDuty
	 * @param riskCode
	 */
	void saveDuty(PDLMDuty pdlmDuty, String riskCode);
	
	Page findDutyByRisk(int pageNo, int pageSize, Map<String, Object> paramsMap);
}
