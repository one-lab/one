package ins.prpall.report.service.facade;

import ins.framework.common.Page;
import ins.prpall.report.model.LCGrpInsuredInfoReport;

import java.io.File;
import java.text.ParseException;
import java.util.List;

public interface LCInsuredReportService {
	/** excel上传 */
	boolean importInsured(File insuredFile) throws Exception;
	/**集体被保人模糊信息保存
	 * @throws java.text.ParseException */
	Page saveGrpInsurInfor(List<LCGrpInsuredInfoReport> lcGrpInsuredInfoReport, int pageNo, int pageSize) throws ParseException;
}
