package ins.product.service.spring;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMDutyPay;
import ins.product.service.facade.PDLMDutyPayService;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

public class PDLMDutyPayServiceSpringImpl extends GenericDaoHibernate<PDLMDutyPay, String> implements PDLMDutyPayService {
	/**
	 * @title saveRiskDutyPay
	 * @description 增加一条险种缴费责任定义
	 * @author 朱超
	 * @param pdLmDutyPay
	 * @return
	 */
	@Override
	public PDLMDutyPay saveRiskDutyPay(PDLMDutyPay pdLmDutyPay, Invocation invocation) {
		pdLmDutyPay.setOperator(((PrpDuser)invocation.getRequest().getSession().getAttribute("user")).getUserCode());
		//pdLmDutyPay.setOperator("114000038");
		pdLmDutyPay.setMakeDate(new Date());
		pdLmDutyPay.setMakeTime(DateUtil.getTime());
		pdLmDutyPay.setModifyDate(new Date());
		pdLmDutyPay.setModifyTime(DateUtil.getTime());
		this.save(pdLmDutyPay);
		return pdLmDutyPay;
	}
	/**
	 * @title deleteRiskDutyPay
	 * @description 删除一条险种缴费责任
	 * @author 朱超
	 * @param payPlanCode
	 * @return
	 */
	@Override
	public String deleteRiskDutyPay(String payPlanCode) {
		try{			
			this.deleteByPK(payPlanCode);
		}catch(Exception e){
			return e.getMessage();
		}
		return "记录"+payPlanCode+"已经删除";
	}
	/**
	 * @title updateRiskDutyPay
	 * @description 更新险种缴费责任定义
	 * @author 朱超
	 * @param pdLmDutyPay
	 * @return
	 */
	@Override
	public PDLMDutyPay updateRiskDutyPay(PDLMDutyPay pdLmDutyPay) {
		pdLmDutyPay.setModifyDate(new Date());
		pdLmDutyPay.setModifyTime(DateUtil.getTime());
		this.update(pdLmDutyPay);
		return pdLmDutyPay;
	}

}
