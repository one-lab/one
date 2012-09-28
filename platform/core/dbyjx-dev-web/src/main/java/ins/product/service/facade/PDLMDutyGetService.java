package ins.product.service.facade;

import ins.product.model.PDLMDutyGet;

public interface PDLMDutyGetService {
	/**
	 * @title saveRiskDutyGet
	 * @description 保存一条险种给付责任定义
	 * @author 朱超
	 * @param pdLmDutyGet
	 * @return
	 */
	PDLMDutyGet saveRiskDutyGet(PDLMDutyGet pdLmDutyGet);
	/**
	 * @title deleteRiskDutyGet
	 * @description 删除一条心险种给付责任定义
	 * @author 朱超
	 * @param getDutyCode
	 * @return
	 */
	String deleteRiskDutyGet(String getDutyCode);
	
}
