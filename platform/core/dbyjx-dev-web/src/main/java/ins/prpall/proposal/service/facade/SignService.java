package ins.prpall.proposal.service.facade;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.prpall.proposal.model.LCGrpCont;

public interface SignService {
	/**查询待签单的投报单
	 * @param LCGrpCont
	 * @author 郭占红
	 */
	Page findProposalSignInfo(LCGrpCont lcGrpCont,int pageNo,int pageSize);
	/**
	 * 根据投报号修改相应的state状态为00(签单功能)
	 * @param LCGrpCont
	 * @author 郭占红
	 */
	boolean saveSignInfo(LCGrpCont lcGrpCont);

}
