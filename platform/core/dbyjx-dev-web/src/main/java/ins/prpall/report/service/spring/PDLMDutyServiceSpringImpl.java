package ins.prpall.report.service.spring;

import java.util.Map;

import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDLMDuty;
import ins.prpall.report.service.facade.PDLMDutyService;

public class PDLMDutyServiceSpringImpl extends GenericDaoHibernate<PDLMDuty,String> implements PDLMDutyService {

	@Override
	public Page findDutyByRisk(int pageNo, int pageSize,
			Map<String, Object> paramsMap) {
		String hql = "select new ins.platform.vo.QueryCodeVo(duty.dutyCode , duty.dutyName) from PDLMDuty duty , PDLMRiskDuty rd  where duty.dutyCode = rd.id.dutyCode and rd.id.riskCode = ?";
		Page page = this.findByHql(hql, pageNo, pageSize, paramsMap.get("riskCode"));
		return page;
	}

}
