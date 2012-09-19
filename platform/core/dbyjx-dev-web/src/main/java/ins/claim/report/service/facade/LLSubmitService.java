package ins.claim.report.service.facade;

import ins.claim.manage.model.LLSubmitApply;

public interface LLSubmitService {
	
	/**
	 * 发起呈报申请
	 * @param llSubmitApply
	 * @author hesiqi
	 */
	void saveSubmitApply(LLSubmitApply llSubmitApply);
}
