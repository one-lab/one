package ins.product.service.spring;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMRiskPay;
import ins.product.service.facade.PDLMRiskPayService;

public class PDLMRiskPayServiceSpringImpl extends GenericDaoHibernate<PDLMRiskPay, String> implements PDLMRiskPayService {
	/**
	 * @title saveRiskPay
	 * @description 保存险种缴费数据
	 * @author 党泽
	 * @param pdlmRiskPay
	 * @return pdlmRiskPay
	 */
	@Override
	public PDLMRiskPay saveRiskPay(PDLMRiskPay pdlmRiskPay) {
		//pdlmRiskPay.setOperator(((PrpDuser)ActionContext.getContext().getSession().get("user")).getUserCode());
		pdlmRiskPay.setOperator("114000038");
		pdlmRiskPay.setMakeDate(new Date());
		pdlmRiskPay.setMakeTime(DateUtil.getTime());
		pdlmRiskPay.setModifyDate(new Date());
		pdlmRiskPay.setModifyTime(DateUtil.getTime());
		this.save(pdlmRiskPay);
		return pdlmRiskPay;
	}
    
	/**
	 * @title deleteRiskPay
	 * @description 删除险种缴费数据
	 * @author 党泽
	 * @param pdlmRiskPay
	 * @return pdlmRiskPay
	 */
	@Override
	public PDLMRiskPay deleteRiskPay(PDLMRiskPay pdlmRiskPay) {
		this.delete(pdlmRiskPay);
		return pdlmRiskPay;
	}
	
	/**
	 * @title updateRiskPay
	 * @description 更新险种缴费数据
	 * @author 党泽
	 * @param pdlmRiskPay
	 * @return pdlmRiskPay
	 */

	@Override
	public PDLMRiskPay updateRiskPay(PDLMRiskPay pdlmRiskPay) {
		this.update(pdlmRiskPay);
		return pdlmRiskPay;
	}
}
