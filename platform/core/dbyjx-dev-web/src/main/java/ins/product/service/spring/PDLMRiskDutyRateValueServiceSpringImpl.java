package ins.product.service.spring;

import java.util.List;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDLMRiskDutyRate;
import ins.product.model.PDLMRiskDutyRateValue;
import ins.product.model.PDLMRiskDutyRateValueId;
import ins.product.service.facade.PDLMRiskDutyRateValueService;

public class PDLMRiskDutyRateValueServiceSpringImpl extends GenericDaoHibernate<PDLMRiskDutyRateValue, PDLMRiskDutyRateValueId> implements PDLMRiskDutyRateValueService{
	/**
	 * @title findOnlyOne
	 * @description 通过PDLMRiskDutyRate查询到费率值
	 * @author 朱超
	 * @param pdlmRiskDutyRate
	 * @return
	 */
	@Override
	public PDLMRiskDutyRateValue findOnlyOne(PDLMRiskDutyRate pdlmRiskDutyRate) {
		QueryRule rule = QueryRule.getInstance();
		rule.addEqual("id.riskCode", pdlmRiskDutyRate.getId().getRiskCode());
		rule.addEqual("id.dutyCode", pdlmRiskDutyRate.getId().getDutyCode());
		rule.addEqual("id.comFactor", pdlmRiskDutyRate.getId().getCalfactor());
		String comValue = pdlmRiskDutyRate.getStartValue().toString()+"-"+pdlmRiskDutyRate.getEndValue().toString();
		rule.addEqual("id.comValue", comValue);
		PDLMRiskDutyRateValue returnObj = this.findUnique(rule);
		return returnObj;
	}

	/**
	 * @title findFactorValueByList
	 * @description 得到组合要素的费率值
	 * @author 朱超
	 * @param pdlmRiskDutyRates 组合要素
	 * @return 费率对象
	 */
	@Override
	public PDLMRiskDutyRateValue findFactorValueByList(List<PDLMRiskDutyRate> pdlmRiskDutyRates) {
		//select * from pd_lmriskdutyratevalue where riskcode = 'GCAB' and dutyCode = 'G25000' and comfactor = 'age;sex' and comvalue='1-5;0-0';
		//拼接组合要素——comFactor ； 组合要素的取值——comValue
		StringBuffer comFactor = new StringBuffer();
		StringBuffer comValue = new StringBuffer();
		for(PDLMRiskDutyRate pdlmRiskDutyRate : pdlmRiskDutyRates){
			comFactor.append(pdlmRiskDutyRate.getId().getCalfactor());
			comFactor.append(";");
			comValue.append(pdlmRiskDutyRate.getStartValue()+"-"+pdlmRiskDutyRate.getEndValue());
			comValue.append(";");
		}
		comFactor.deleteCharAt(comFactor.length()-1);
		comValue.deleteCharAt(comValue.length()-1);
		
		//创建查询条件rule
		QueryRule rule = QueryRule.getInstance();
		rule.addEqual("id.riskCode", pdlmRiskDutyRates.get(0).getId().getRiskCode());
		rule.addEqual("id.dutyCode", pdlmRiskDutyRates.get(0).getId().getDutyCode());
		rule.addEqual("id.comFactor", comFactor.toString());
		rule.addEqual("id.comValue", comValue.toString());
		
		PDLMRiskDutyRateValue value = this.findUnique(rule);
		return value;
	}

}
