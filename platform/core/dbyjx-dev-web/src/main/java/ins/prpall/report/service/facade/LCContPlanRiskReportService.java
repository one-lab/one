package ins.prpall.report.service.facade;

import ins.framework.common.Page;
import ins.prpall.report.model.LCContPlanReport;

import java.util.Map;

public interface LCContPlanRiskReportService {

	Page findByRepNo(int pageNo, int pageSize, Map<String, Object> paramsMap);

}
