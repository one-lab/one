package ins.product.service.facade;

import ins.product.model.PDLMRiskApp;

public interface PDLMRiskAppService {
	/**
	 * @title findByRiskCode
	 * @description 通过主键查询pdlmRiskApp
	 * @author 朱超
	 * @param riskCode
	 * @return
	 */
	PDLMRiskApp findByRiskCode(String riskCode);
	/**
	 * @title saveRiskApp
	 * @description 增加一个险种承保定义
	 * @author 朱超
	 * @param pdlmRiskApp
	 * @return
	 */
	PDLMRiskApp saveRiskApp(PDLMRiskApp pdlmRiskApp);
	/**
	 * @title deleteRiskApp
	 * @description 删除一条记录通过主键
	 * @author 朱超
	 * @param riskCode
	 * @return
	 */
	String deleteRiskApp(String riskCode);
	
}
