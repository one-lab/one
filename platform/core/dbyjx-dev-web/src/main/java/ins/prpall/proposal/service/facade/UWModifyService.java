package ins.prpall.proposal.service.facade;

import ins.framework.common.Page;
import ins.prpall.proposal.model.LCGrpCont;

public interface UWModifyService {
	/**
	 * @title findUWResultModify
	 * @description 查找将要核保订正的投保单记录
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @return
	 */
	Page findUWResultModify(LCGrpCont lcGrpCont,int pageNo,int pageSize);
	
	/**
	 * @title uwResultModify
	 * @description 进行核保订正
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @return
	 */
	void uwResultModify(LCGrpCont lcGrpCont,int pageNo,int pageSize);

}
