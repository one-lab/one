package ins.product.service.facade;

import ins.product.model.PDLMRiskPay;

public interface PDLMRiskPayService {
	/**
	 * @title saveRiskPay
	 * @description 保存险种缴费数据
	 * @author 党泽
	 * @param pdlmRiskPay
	 * @return
	 */
	PDLMRiskPay saveRiskPay(PDLMRiskPay pdlmRiskPay);
	/**
	 * @title deleteRiskPay
	 * @description 删除一个险种角色
	 * @author 党泽
	 * @param pdlmRiskPay
	 * @return
	 */
	PDLMRiskPay deleteRiskPay(PDLMRiskPay pdlmRiskPay);
	/**
	 * @title updateRiskPay
	 * @description 更新一个险种角色
	 * @author 党泽
	 * @param pdlmRiskPay
	 * @return
	 */
	PDLMRiskPay updateRiskPay(PDLMRiskPay pdlmRiskPay);
}
