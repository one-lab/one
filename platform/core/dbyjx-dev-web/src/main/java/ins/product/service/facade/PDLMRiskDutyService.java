package ins.product.service.facade;

import ins.product.model.PDLMDuty;
import ins.product.model.PDLMRiskDuty;

public interface PDLMRiskDutyService {
	/**
	 * @title saveRiskDuty
	 * @description 保存险种责任关联基础信息
	 * @author 朱超
	 * @param pdlmRiskDuty pdlmDuty
	 * @return
	 */
	PDLMRiskDuty saveRiskDuty(PDLMRiskDuty pdlmRiskDuty, PDLMDuty pdlmDuty);
	/**
	 * @title updateDhtml
	 * @description 更新Dhtml字段
	 * @author 朱超
	 * @param pdlmRiskDuty
	 * @return
	 */
	String updateDhtml(PDLMRiskDuty pdlmRiskDuty);

}
