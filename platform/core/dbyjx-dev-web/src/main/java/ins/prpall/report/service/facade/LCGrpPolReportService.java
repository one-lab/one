package ins.prpall.report.service.facade;

import ins.framework.common.Page;

import java.util.Map;

public interface LCGrpPolReportService {

	Page findRiskByReport(int pageNo, int pageSize,
			Map<String, Object> paramsMap);

}
