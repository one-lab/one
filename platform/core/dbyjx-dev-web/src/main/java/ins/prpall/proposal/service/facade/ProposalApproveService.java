/**
 * @ create_date 2012-8-9
 * @ author long
 * @ version 1.0
 */
package ins.prpall.proposal.service.facade;

import java.util.List;
import java.util.Map;

import ins.framework.common.Page;
import ins.prpall.proposal.model.LCCont;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LDPerson;

/**
 * @title ProposalApproveService
 * @description 投保单复核Service
 * @author 于文龙
 * @version 1.0
 * @create date 2012-8-9
 * @copyright (c) SINOSOFT
 */
public interface ProposalApproveService {

	/**
	 * @title 
	 * @description 查询集体投保单信息
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	List<LCGrpCont> findGrpContInfo(LCGrpCont lcGrpCont, int pageNo,int pageSize);
	/**
	 * 
	 * @title 
	 * @description 集体投保单审核申请
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	Page applyLcGrpCont(LCGrpCont lcGrpCont,int pageNo,int pageSize);
	/**
	 * @description 对已申请投保单进行审核查询
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	Map<String, Object> auditLcGrpCont(LCGrpCont lcGrpCont);
	/**
	 * @description 审核完毕进行
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	LCGrpCont finishAudit(LCGrpCont lcGrpCont);
	/**
	 * @description 已承保保单查询
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	Map<String,Object> findLcContAndInsured(LCGrpCont lcGrpCont,int pageNo,int pageSize);
	/**
	 * 
	 * @title initialLcGrpContAudit
	 * @description 初始化方法
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author 于文龙
	 */
	Page initialLcGrpContAudit(int pageNo,int pageSize);
	/**
	 * 
	 * @title mergeCustomerNo
	 * @description 合并客户号
	 * @param lcInsured
	 * @param lcCont
	 * @param pageNo
	 * @param pageSize
	 * @author 于文龙
	 */
	Map<String,Object> mergeCustomerNo(LDPerson ldPerson,LCCont lcCont ,int pageNo,int pageSize);
}
