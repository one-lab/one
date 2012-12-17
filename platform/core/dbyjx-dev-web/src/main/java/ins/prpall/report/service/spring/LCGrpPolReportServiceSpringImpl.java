package ins.prpall.report.service.spring;

import java.util.Map;

import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.prpall.report.model.LCGrpPolReport;
import ins.prpall.report.model.LCGrpPolReportId;
import ins.prpall.report.service.facade.LCGrpPolReportService;

public class LCGrpPolReportServiceSpringImpl extends GenericDaoHibernate<LCGrpPolReport, LCGrpPolReportId> implements LCGrpPolReportService {

	@Override
	public Page findRiskByReport(int pageNo, int pageSize,
			Map<String, Object> paramsMap) {
		String hql = "select new ins.platform.vo.QueryCodeVo(gpr.riskCode , risk.riskShortName) from LCGrpPolReport gpr , PDLMRisk risk where gpr.riskCode = risk.riskCode and gpr.id.repNo = ?";
		Page page = this.findByHql(hql, pageNo, pageSize, paramsMap.get("repNo"));
		return page;
	}

}
