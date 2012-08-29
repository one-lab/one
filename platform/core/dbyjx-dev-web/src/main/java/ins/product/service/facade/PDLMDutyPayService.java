package ins.product.service.facade;

import ins.product.model.PDLMDutyPay;

public interface PDLMDutyPayService {
	/**
	 * @title saveRiskDutyPay
	 * @description 增加一条险种缴费责任定义
	 * @author 朱超
	 * @param pdLmDutyPay
	 * @return
	 */
	PDLMDutyPay saveRiskDutyPay(PDLMDutyPay pdLmDutyPay);
	
	/**
	 * @title deleteRiskDutyPay
	 * @description 删除一条险种缴费责任
	 * @author 朱超
	 * @param payPlanCode
	 * @return
	 */
	String deleteRiskDutyPay(String payPlanCode);
	/**
	 * @title updateRiskDutyPay
	 * @description 更新险种缴费责任定义
	 * @author 朱超
	 * @param pdLmDutyPay
	 * @return
	 */
	PDLMDutyPay updateRiskDutyPay(PDLMDutyPay pdLmDutyPay);

}
