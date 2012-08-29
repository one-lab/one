package ins.product.service.spring;

import java.util.Map;

import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDLMDuty;
import ins.product.model.PDLMRisk;
import ins.product.service.facade.PDLMDutyService;
import ins.product.service.facade.PdLmRiskService;

public class PDLMDutyServiceSpringImpl extends GenericDaoHibernate<PDLMDuty, String> implements PDLMDutyService {
	private PdLmRiskService pdlmRiskService;
	
	public PdLmRiskService getPdlmRiskService() {
		return pdlmRiskService;
	}

	public void setPdlmRiskService(PdLmRiskService pdlmRiskService) {
		this.pdlmRiskService = pdlmRiskService;
	}

	/**
	 * @title saveDuty
	 * @description 报存责任，和责任关联险种
	 * @author 朱超
	 * @param pdlmDuty
	 * @param riskCode
	 */
	@Override
	public void saveDuty(PDLMDuty pdlmDuty, String riskCode) {
		//PDLMRisk pdlmRisk = pdlmRiskService.findRiskByRiskCode(riskCode);
		
	}
	
	@Override
	public Page findDutyByRisk(int pageNo, int pageSize,
			Map<String, Object> paramsMap) {
		String hql = "select new ins.platform.vo.QueryCodeVo(duty.dutyCode , duty.dutyName) from PDLMDuty duty , PDLMRiskDuty rd  where duty.dutyCode = rd.id.dutyCode and rd.id.riskCode = ?";
		Page page = this.findByHql(hql, pageNo, pageSize, paramsMap.get("riskCode"));
		return page;
	}

}
