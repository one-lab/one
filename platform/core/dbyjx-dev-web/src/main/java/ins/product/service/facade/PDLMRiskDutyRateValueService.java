package ins.product.service.facade;

import java.util.List;

import ins.product.model.PDLMRiskDutyRate;
import ins.product.model.PDLMRiskDutyRateValue;

public interface PDLMRiskDutyRateValueService {
	/**
	 * @title findOnlyOne
	 * @description 通过PDLMRiskDutyRate查询到费率值
	 * @author 朱超
	 * @param pdlmRiskDutyRate
	 * @return
	 */
	PDLMRiskDutyRateValue findOnlyOne(PDLMRiskDutyRate pdlmRiskDutyRate);
	/**
	 * @title findFactorValueByList
	 * @description 得到组合要素的费率值
	 * @author 朱超
	 * @param pdlmRiskDutyRates 组合要素
	 * @return 费率对象
	 */
	PDLMRiskDutyRateValue findFactorValueByList(
			List<PDLMRiskDutyRate> pdlmRiskDutyRates);

}
