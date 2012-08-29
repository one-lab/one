package ins.prpall.proposal.service.spring;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.prpall.proposal.model.LCCont;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCIssue;
import ins.prpall.proposal.model.LCSearchInfo;
import ins.prpall.proposal.model.LCSearchItem;
import ins.prpall.proposal.model.LCSingleSearchInfo;
import ins.prpall.proposal.model.LCSingleSearchItem;
import ins.prpall.proposal.service.facade.UWModifyService;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class UWModifyServiceSpringImpl extends GenericDaoHibernate<LCGrpCont, String>
		implements UWModifyService {

	/*
	 * 查找将要核保订正的投保单记录
	 * @title findUWResultModify
	 * @author 薛玉强
	 * @see ins.prpall.proposal.service.facade.UWModifyService#findUWResultModify(ins.prpall.proposal.model.LCGrpCont)
	 */
	@Override
	public Page findUWResultModify(LCGrpCont lcGrpCont,int pageNo,int pageSize) {
		//根据查询条件查询投保单记录
		StringBuffer findUWModifyHql = new StringBuffer();
		findUWModifyHql.append("from LCGrpCont t1 where t1.state = '" + FinalCollection.CONT_STATE8 + "'");
		if(null != lcGrpCont && !"".equals(lcGrpCont.getGrpContNo())){
			findUWModifyHql.append(" and t1.grpContNo like '" + lcGrpCont.getGrpContNo().trim() + "%'");
		}
		if(null != lcGrpCont && !"".equals(lcGrpCont.getManageCom())){
			findUWModifyHql.append(" and t1.manageCom like '" + lcGrpCont.getManageCom().trim() + "%'");
		}
		if(null != lcGrpCont && !"".equals(lcGrpCont.getAppntNo())){
			findUWModifyHql.append(" and t1.appntNo like '" + lcGrpCont.getAppntNo().trim() + "%'");
		}
		if(null != lcGrpCont && !"".equals(lcGrpCont.getGrpName())){
			findUWModifyHql.append(" and t1.grpName like '%" + lcGrpCont.getGrpName().trim() + "%'");
		}
		if(null != lcGrpCont && !"".equals(lcGrpCont.getAgentCode())){
			findUWModifyHql.append(" and t1.agentCode like '" + lcGrpCont.getAgentCode().trim() + "%'");
		}
		Page lcGrpContPage = this.findByHql(findUWModifyHql.toString(), pageNo, pageSize, null);
		return lcGrpContPage;
	}

	/*
	 * 进行核保订正
	 * @title uwResultModify
	 * @author 薛玉强
	 * @see ins.prpall.proposal.service.facade.UWModifyService#uwResultModify(ins.prpall.proposal.model.LCGrpCont)
	 */
	@Override
	public void uwResultModify(LCGrpCont lcGrpCont,int pageNo,int pageSize) {
		//查询问题件表（LCIssue）并删除其中的信息
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.grpContNo", lcGrpCont.getGrpContNo());
		List<LCIssue> lcIssueList = (List<LCIssue>)this.find(LCIssue.class, queryRule);
		this.deleteAll(lcIssueList);
		//查询个人契调项目表（LCSingleSearchItem）并删除其中的信息
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.grpContNo", lcGrpCont.getGrpContNo());
		List<LCSingleSearchItem> lcSingleSearchItemList = (List<LCSingleSearchItem>)this.find(LCSingleSearchItem.class, queryRule);
		this.deleteAll(lcSingleSearchItemList);
		//查询个人契调信息表（LCSingleSearchInfo）并删除其中的信息
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.grpContNo", lcGrpCont.getGrpContNo());
		List<LCSingleSearchInfo> lcSingleSearchInfoList = (List<LCSingleSearchInfo>)this.find(LCSingleSearchInfo.class, queryRule);
		this.deleteAll(lcSingleSearchInfoList);
		//查询团体契调项目表（LCSearchItem）并删除其中的信息
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.grpContNo", lcGrpCont.getGrpContNo());
		List<LCSearchItem> lcSearchItemList = (List<LCSearchItem>)this.find(LCSearchItem.class, queryRule);
		this.deleteAll(lcSearchItemList);
		//查询团体契调信息表（LCSearchItem）并删除其中的信息
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.grpContNo", lcGrpCont.getGrpContNo());
		List<LCSearchInfo> lcSearchInfoList = (List<LCSearchInfo>)this.find(LCSearchInfo.class, queryRule);
		this.deleteAll(lcSearchInfoList);
		//查询个人保单表（LCCont）并更新其中的信息
		PrpDuser user = (PrpDuser)ActionContext.getContext().getSession().get("user");
		String operator = user.getUserName();
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcGrpCont.getGrpContNo());
		List<LCCont> lcContList = (List<LCCont>)this.find(LCCont.class, queryRule);
		if(null != lcContList && lcContList.size() > 0){
			for(int i = 0;i < lcContList.size();i++){
				lcContList.get(i).setState(FinalCollection.CONT_STATE6);
				lcContList.get(i).setUwFlag(null);
				lcContList.get(i).setRemark(null);
				lcContList.get(i).setUwOperator(null);
				lcContList.get(i).setUwDate(null);
				lcContList.get(i).setUwTime(null);
				
				lcContList.get(i).setOperator(operator);
				lcContList.get(i).setModifyDate(new Date());
				lcContList.get(i).setModifyTime(DateUtil.getTime());
			}
		}
		this.saveAll(lcContList);
		//查询集体保单表（LCGrpCont）并更新其中的数据
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcGrpCont.getGrpContNo());
		LCGrpCont lcGrpContTemp = (LCGrpCont)this.findUnique(queryRule);
		lcGrpContTemp.setState(FinalCollection.CONT_STATE6);
		lcGrpContTemp.setUwFlag(null);
		lcGrpContTemp.setRemark(null);
		lcGrpContTemp.setUwOperator(null);
		lcGrpContTemp.setUwDate(null);
		lcGrpContTemp.setUwTime(null);
		
		lcGrpContTemp.setOperator(operator);
		lcGrpContTemp.setModifyDate(new Date());
		lcGrpContTemp.setModifyTime(DateUtil.getTime());
		this.update(lcGrpContTemp);
	}

}
