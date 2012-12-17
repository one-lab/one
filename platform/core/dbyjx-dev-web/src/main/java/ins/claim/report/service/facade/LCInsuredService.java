package ins.claim.report.service.facade;

import ins.framework.common.Page;
import ins.prpall.proposal.model.LCInsured;

public interface LCInsuredService {

	/**
	 *根据页面录入条件查询lcInsured表 
	 * @param lCInsured
	 * @param pageNo
	 * @param pageSize
	 * @author hesiqi
	 */
	
	Page findLCInsuredByCondition(LCInsured lCInsured, int pageNo,
			int pageSize);
	/**
	 * 根据合同号和客户号查一条
	 * @param ciStr
	 * @return
	 * @author hesiqi
	 */
	LCInsured findLCInsuredByContNoInsuredNo(String ciStr);
	
}
