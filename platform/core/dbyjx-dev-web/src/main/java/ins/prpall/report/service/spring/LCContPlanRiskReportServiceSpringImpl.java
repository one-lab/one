package ins.prpall.report.service.spring;

import java.util.Map;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.prpall.report.model.LCContPlanReport;
import ins.prpall.report.model.LCContPlanRiskReport;
import ins.prpall.report.model.LCContPlanRiskReportId;
import ins.prpall.report.service.facade.LCContPlanRiskReportService;

public class LCContPlanRiskReportServiceSpringImpl extends GenericDaoHibernate<LCContPlanRiskReport, LCContPlanRiskReportId>
	implements LCContPlanRiskReportService{

	@Override
	public Page findByRepNo(int pageNo, int pageSize, Map<String, Object> paramsMap) {
		String hql = "select new ins.platform.vo.QueryCodeVo(cprr.id.contPlanCode , cprr.contPlanName) from LCContPlanRiskReport cprr where cprr.id.repNo = ?";
		Page page = this.findByHql(hql, pageNo, pageSize, paramsMap.get("repNo"));
		return page;
	}
	
}
