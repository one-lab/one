package ins.prpall.proposal.web;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.service.facade.UWModifyService;

import java.util.List;

public class UWModifyAction extends Struts2Action {
	
	private static final long serialVersionUID = 1L;
	
	/**集体保单表*/
	private LCGrpCont lcGrpCont;
	
	private boolean flag;
	
	private UWModifyService uwModifyService;

	public LCGrpCont getLcGrpCont() {
		return lcGrpCont;
	}

	public void setLcGrpCont(LCGrpCont lcGrpCont) {
		this.lcGrpCont = lcGrpCont;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public UWModifyService getUwModifyService() {
		return uwModifyService;
	}

	public void setUwModifyService(UWModifyService uwModifyService) {
		this.uwModifyService = uwModifyService;
	}

	/**
	 * @title findUWResultModify
	 * @description 查找将要核保订正的投保单记录
	 * @author 薛玉强
	 * @return
	 */
	public String findUWResultModify(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page lcGrpContPage = this.uwModifyService.findUWResultModify(lcGrpCont, pageNo, pageSize);
		List<LCGrpCont> list = (List<LCGrpCont>)lcGrpContPage.getResult();
		this.getRequest().setAttribute("lcGrpContList", list);
		this.getRequest().setAttribute("pageNo", pageNo);
		this.getRequest().setAttribute("pageSize", pageSize);
		this.getRequest().setAttribute("totalPage", lcGrpContPage.getTotalPageCount());
		this.getRequest().setAttribute("totalCount", lcGrpContPage.getTotalCount());
		//标记是否为空
		if(null != list && list.size() > 0){
			this.getRequest().setAttribute("flag", false);
		}else{
			this.getRequest().setAttribute("flag", true);
		}
		
		//回显的信息
		this.getRequest().setAttribute("lcGrpCont", lcGrpCont);
		return SUCCESS;
	}
	
	/**
	 * @title uwResultModify
	 * @description 进行核保订正
	 * @author 薛玉强
	 * @return
	 */
	public String uwResultModify(){
		this.uwModifyService.uwResultModify(lcGrpCont, pageNo, pageSize);
		this.writeJSONMsg(SUCCESS);
		return NONE;
	}

}
