package ins.product.service.facade;

import ins.product.model.PDLMRiskPayIntv;

public interface PDLMRiskPayIntvService {
	/**
	 * @title saveRiskPayIntv
	 * @description 保存险种交费间隔数据
	 * @author 党泽
	 * @param pdlmRiskPayIntv
	 * @return
	 */
	PDLMRiskPayIntv saveRiskPayIntv(PDLMRiskPayIntv pdlmRiskPayIntv);
	/**
	 * @title deleteRiskPayIntv
	 * @description 删除险种交费间隔数据
	 * @author 党泽
	 * @param pdlmRiskPayIntv
	 * @return
	 */
	PDLMRiskPayIntv deleteRiskPayIntv(PDLMRiskPayIntv pdlmRiskPayIntv);
	/**
	 * @title updateRiskPayIntv
	 * @description 更新险种交费间隔数据
	 * @author 党泽
	 * @param pdlmRiskPayIntv
	 * @return
	 */
	PDLMRiskPayIntv updateRiskPayIntv(PDLMRiskPayIntv pdlmRiskPayIntv);
}
