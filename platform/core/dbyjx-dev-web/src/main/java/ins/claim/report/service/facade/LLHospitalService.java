package ins.claim.report.service.facade;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;

public interface LLHospitalService {

	/**
	 * 查询医院编码和名称
	 * @param LLHospitalInfo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author zhangkai
	 */
	Page findHospital(int pageNo, int pageSize);
	
}
