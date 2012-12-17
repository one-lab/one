package ins.product.service.spring;

import java.util.List;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.model.PDLMRiskDutyFactorId;
import ins.product.service.facade.PDLMDutyParamsService;

public class PDLMDutyParamsServiceSpringImpl extends GenericDaoHibernate<PDLMRiskDutyFactor, PDLMRiskDutyFactorId>
	implements PDLMDutyParamsService{

	@Override
	public List<PDLMRiskDutyFactor> findDutyParams(String dutyCode) {
		QueryRule qr = QueryRule.getInstance();
		qr.addEqual("id.dutyCode", dutyCode);
		List<PDLMRiskDutyFactor> list = this.find(qr);
		return list;
	}

}
