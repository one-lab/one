package ins.prpall.proposal.service.spring;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLDcode1;
import ins.product.model.PDLMRisk;
import ins.prpall.proposal.model.LCAppnt;
import ins.prpall.proposal.model.LCCont;
import ins.prpall.proposal.model.LCDuty;
import ins.prpall.proposal.model.LCGrpAppnt;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCIssue;
import ins.prpall.proposal.model.LCIssueId;
import ins.prpall.proposal.model.LCPol;
import ins.prpall.proposal.model.LCSingleSearchInfo;
import ins.prpall.proposal.model.LCSingleSearchInfoId;
import ins.prpall.proposal.model.LCSingleSearchItem;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.proposal.model.LDPerson;
import ins.prpall.proposal.service.facade.ArtificalUWService;
import ins.prpall.proposal.vo.ArtificalUWDealVo;
import ins.prpall.proposal.vo.ArtificalUWPolVo;
import ins.prpall.proposal.vo.AutoUWGrpInfoVo;
import ins.prpall.proposal.vo.AutoUWPersonInfoVo;
import ins.prpall.proposal.vo.SearchItemVo;
import ins.prpall.report.model.LCGrpPol;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class ArtificalUWServiceSpringImpl extends GenericDaoHibernate<LCGrpCont, String>
		implements ArtificalUWService {
	
	
	/*
	 * 初始化人工核保界面，即显示个人工作池中的任务
	 * @title initArtificalUWApply
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#initArtificalUWApply()
	 */
	@Override
	public Page initArtificalUWApply(int pageNo,int pageSize) {
		PrpDuser user = (PrpDuser)ActionContext.getContext().getSession().get("user");
		String userName = user.getUserName();
		QueryRule queryRule = QueryRule.getInstance();
		//根据当前用户和状态查询个人工作池中的数据
		queryRule.addEqual("uwOperator", userName)
				 .addEqual("state", FinalCollection.CONT_STATE7);
		Page lcGrpContPage = this.find(LCGrpCont.class, queryRule, pageNo, pageSize); 
		return lcGrpContPage;
	}


	/*
	 * 人工核保中查询团体投保单信息
	 * @title findProposalGrpContInfo
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#findProposalGrpContInfo(ins.prpall.report.model.LCGrpCont)
	 */
	@Override
	public Page findProposalGrpContInfo(LCGrpCont lcGrpCont,int pageNo,int pageSize) {
		StringBuffer findGrpContHql = new StringBuffer();
		findGrpContHql.append("select lcGrpCont from LCGrpCont lcGrpCont where state = '" + FinalCollection.CONT_STATE6 + "'");
		if(null != lcGrpCont.getManageCom() && !"".equals(lcGrpCont.getManageCom())){
			findGrpContHql.append(" and lcGrpCont.manageCom = '" + lcGrpCont.getManageCom().trim() + "'");
		}
		if(null != lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpContNo())){
			findGrpContHql.append(" and lcGrpCont.grpContNo like '" + lcGrpCont.getGrpContNo().trim() + "%'");
		}
		if(null != lcGrpCont.getGrpName() && !"".equals(lcGrpCont.getGrpName())){
			findGrpContHql.append(" and lcGrpCont.grpName like '%" + lcGrpCont.getGrpName().trim() + "%'");
		}
		Page grpContInfo = this.findByHql(findGrpContHql.toString(), pageNo, pageSize, null);
		return grpContInfo;
	}
	
	
	/*
	 * 人工核保中申请团体投保单信息
	 * @title applyProposalGrpContInfo
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#applyProposalGrpContInfo(ins.prpall.report.model.LCGrpCont, int, int)
	 */
	@Override
	public Page applyProposalGrpContInfo(LCGrpCont lcGrpCont, int pageNo,
			int pageSize) {
		StringBuffer findGrpContHql = new StringBuffer();
		findGrpContHql.append("select lcGrpCont from LCGrpCont lcGrpCont where 1=1 ");
		if(null != lcGrpCont.getManageCom() && !"".equals(lcGrpCont.getManageCom())){
			findGrpContHql.append(" and lcGrpCont.manageCom = '" + lcGrpCont.getManageCom().trim() + "'");
		}
		if(null != lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpContNo())){
			findGrpContHql.append(" and lcGrpCont.grpContNo like '" + lcGrpCont.getGrpContNo().trim() + "%'");
		}
		if(null != lcGrpCont.getGrpName() && !"".equals(lcGrpCont.getGrpName())){
			findGrpContHql.append(" and lcGrpCont.grpName like '%" + lcGrpCont.getGrpName().trim() + "%'");
		}
		Page grpContInfo = this.findByHql(findGrpContHql.toString(), pageNo, pageSize, null);
		if(null != grpContInfo && grpContInfo.getTotalCount() > 0){
			List<LCGrpCont> lcGrpContList = (List<LCGrpCont>)grpContInfo.getResult();
			LCGrpCont lcGrpContTemp = lcGrpContList.get(0);
			PrpDuser prpDuser = (PrpDuser)ActionContext.getContext().getSession().get("user");
			lcGrpContTemp.setUwOperator(prpDuser.getUserName());
		}
		
		return grpContInfo;
	}



	/*
	 * 人工核保中查询集体投保单详细信息
	 * @title findArtificalUWDeal
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#findArtificalUWDeal(ins.prpall.report.model.LCGrpCont)
	 */
	@Override
	public Map<String, Object> findArtificalUWDeal(LCGrpCont lcGrpCont) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ArtificalUWPolVo> artificalUWPolVoList = new ArrayList<ArtificalUWPolVo>();
		ArtificalUWDealVo artificalUWDealVo = new ArtificalUWDealVo();
		//查询集体保单表
		QueryRule queryRuleLcGrpCont = QueryRule.getInstance();
		queryRuleLcGrpCont.addEqual("grpContNo", lcGrpCont.getGrpContNo().trim());
		LCGrpCont lcGrpContTemp = this.findUnique(queryRuleLcGrpCont);
		//查询集体险种表
		StringBuffer LcGrpPolHql = new StringBuffer();
		LcGrpPolHql.append("from LCGrpPol lcGrpPol where lcGrpPol.grpContNo = '" + lcGrpContTemp.getGrpContNo() + "'");
		List<LCGrpPol> lcGrpPolList = (List<LCGrpPol>)this.findByHql(LcGrpPolHql.toString(), null);
		
		//查询管理机构表PrpDcompany,并将管理机构名称放入artificalUWDealVo
		StringBuffer prpDcompanyHql = new StringBuffer();
		prpDcompanyHql.append("from PrpDcompany prpDcompany where prpDcompany.comCode = '" + lcGrpContTemp.getManageCom() + "'");
		List<PrpDcompany> prpDcompanyList = (List<PrpDcompany>)this.findByHql(prpDcompanyHql.toString(), null);
		if(null != prpDcompanyList && prpDcompanyList.size() > 0){
			PrpDcompany prpDcompany = prpDcompanyList.get(0);
			artificalUWDealVo.setManageName(prpDcompany.getComCName());
		}
		
		//查询团体客户表
		StringBuffer ldGrpHql = new StringBuffer();
		ldGrpHql.append("from LDGrp ldGrp where ldGrp.customerNo = '" + lcGrpContTemp.getAppntNo() + "'");
		List<LDGrp> ldGrpList = (List<LDGrp>)this.findByHql(ldGrpHql.toString(), null);
		if(null != ldGrpList && ldGrpList.size() > 0){
			LDGrp ldGrp = ldGrpList.get(0);
			artificalUWDealVo.setVipValue(ldGrp.getVipValue());
		}
		
		//查询保单险种责任表（LCDuty）
		StringBuffer lcPolHql = new StringBuffer();
		lcPolHql.append("from LCPol lcPol where lcPol.grpContNo = '" + lcGrpContTemp.getGrpContNo() + "'");
		List<LCPol> lcPolList = (List<LCPol>)this.findByHql(lcPolHql.toString(), null);
		LCPol lcPol = null;
		BigDecimal payIntv = new BigDecimal(0);
		BigDecimal payYears = BigDecimal.valueOf(0);
		if(null != lcPolList && lcPolList.size() > 0){
			lcPol = lcPolList.get(0);
			StringBuffer lcDutyHql = new StringBuffer();
			lcDutyHql.append("from LCDuty lcDuty where lcDuty.contNo = '" + lcPol.getContNo() + "' and lcDuty.id.polNo = '" + lcPol.getPolNo() +"'");
			List<LCDuty> lcDutyList = (List<LCDuty>)this.findByHql(lcDutyHql.toString(), null);
			for(int i = 0;i < lcDutyList.size();i++){
				if(payIntv.doubleValue() < lcDutyList.get(i).getPayIntv().doubleValue()){
					payIntv = lcDutyList.get(i).getPayIntv();
					payYears = lcDutyList.get(i).getPayYears();
				}
			}
		}
		//将属性放入VO中
		artificalUWDealVo.setGrpContNo(lcGrpContTemp.getGrpContNo());
		artificalUWDealVo.setProposalGrpContNo(lcGrpContTemp.getProposalGrpContNo());
		artificalUWDealVo.setReportNo(lcGrpContTemp.getReportNo());
		artificalUWDealVo.setCregistNo(lcGrpContTemp.getCregistNo());
		artificalUWDealVo.setFirstTrialDate(lcGrpContTemp.getFirstTrialDate());
		artificalUWDealVo.setCvaliDate(lcGrpContTemp.getCvaliDate());
		artificalUWDealVo.setManageCom(lcGrpContTemp.getManageCom());
		artificalUWDealVo.setSaleChnl(lcGrpContTemp.getSaleChnl());
		artificalUWDealVo.setAppntNo(lcGrpContTemp.getAppntNo());
		artificalUWDealVo.setGrpName(lcGrpContTemp.getGrpName());
		map.put("artificalUWDealVo", artificalUWDealVo);
		//将集体险种存入	VO
		for(int i = 0;i < lcGrpPolList.size();i++ ){
			ArtificalUWPolVo artificalUWPolVo = new ArtificalUWPolVo();
			artificalUWPolVo.setRiskCode(lcGrpPolList.get(i).getRiskCode());
			//查询PDLMRisk表查找险种名称
			QueryRule queryRule = QueryRule.getInstance();
			queryRule.addEqual("riskCode", lcGrpPolList.get(i).getRiskCode());
			PDLMRisk pdlmRisk = this.findUnique(PDLMRisk.class, queryRule);
			artificalUWPolVo.setRiskName(pdlmRisk.getRiskName());
			artificalUWPolVo.setPayIntv(payIntv);
			artificalUWPolVo.setPayYears(payYears);
			artificalUWPolVo.setPeoples(lcGrpPolList.get(i).getPeopleS2());
			artificalUWPolVo.setAmnt(lcGrpPolList.get(i).getAmnt());
			artificalUWPolVo.setPrem(lcGrpPolList.get(i).getPrem());
			artificalUWPolVo.setFirstPayDate(lcGrpPolList.get(i).getFirstPayDate());
			artificalUWPolVo.setPayEndDate(lcGrpPolList.get(i).getPayEndDate());
			//此时的折扣费率直接指定为0.2
			BigDecimal discontRate = BigDecimal.valueOf(0.2);
			artificalUWPolVo.setDiscountRate(discontRate);
			artificalUWPolVoList.add(artificalUWPolVo);
		}
		map.put("artificalUWPolVoList", artificalUWPolVoList);
		return map;
	}
	
	/*
	 * 申请投保单后更改节点状态
	 * @title saveLcGrpCont
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#saveLcGrpCont(ins.prpall.report.model.LCGrpCont)
	 */
	@Override
	public LCGrpCont saveLcGrpContState(LCGrpCont lcGrpCont){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcGrpCont.getGrpContNo());
		LCGrpCont lcGrpContTemp = this.findUnique(queryRule);
		lcGrpContTemp.setState(FinalCollection.CONT_STATE7);//设置状态问人工核保
		PrpDuser user = (PrpDuser)ActionContext.getContext().getSession().get("user");
		String userName = user.getUserName();
		lcGrpContTemp.setUwOperator(userName);
		this.update(lcGrpContTemp);
		return lcGrpContTemp;
	}

	/*
	 * 保存人工核保中审核意见和核保结论
	 * @title saveArtificalUWResultAndIdea
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#saveArtificalUWResultAndIdea(ins.prpall.report.model.LCGrpCont)
	 */
	@Override
	public boolean saveArtificalUWResultAndIdea(LCGrpCont lcGrpCont) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcGrpCont.getGrpContNo().trim());
		LCGrpCont lcGrpContTemp = this.findUnique(queryRule);
		lcGrpContTemp.setRemark(lcGrpCont.getRemark().trim());
		lcGrpContTemp.setUwFlag(lcGrpCont.getUwFlag().trim());
		ActionContext ac = ActionContext.getContext();
		PrpDuser prpDuser = (PrpDuser)ac.getSession().get("user");
		lcGrpContTemp.setUwOperator(prpDuser.getUserName());
		lcGrpContTemp.setUwDate(new Date());
		lcGrpContTemp.setUwTime(DateUtil.getTime());
		//修改流程状态
		lcGrpContTemp.setState("08");//08代表带签单
		lcGrpContTemp.setModifyDate(new Date());
		lcGrpContTemp.setModifyTime(DateUtil.getTime());
		lcGrpContTemp.setOperator(prpDuser.getUserName());
		this.save(lcGrpContTemp);
		return true;
	}

	/*
	 * 人工核保中查询个人投保单基本信息
	 * @title findArtificalUWContInfo
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#findArtificalUWContInfo(ins.prpall.report.model.LCInsured)
	 */
	@Override
	public Page findArtificalUWContInfo(LCInsured lcInsured,int pageNo,int pageSize) {
		StringBuffer findContInfoHql = new StringBuffer();
		//将查出的数据放到Vo对象中
		findContInfoHql.append("select new ins.prpall.proposal.vo.ArtificalUWContInfoVo(lcCont.contNo,lcCont.grpContNo,lcCont.proposalContNo,lcInsured.uwFlag,lcInsured.name,lcInsured.manageCom,lcInsured.contPlanCode) " +
				" from LCCont lcCont,LCInsured lcInsured where lcCont.contNo = lcInsured.id.contNo and lcCont.grpContNo = '" + lcInsured.getGrpContNo() + "'");
		if(null != lcInsured){
			if(!"".equals(lcInsured.getName())){
				findContInfoHql.append(" and lcInsured.name like '%" + lcInsured.getName().trim() + "%'");
			}
			if(!"".equals(lcInsured.getManageCom())){
				findContInfoHql.append(" and lcInsured.manageCom = '" + lcInsured.getManageCom().trim() + "'");
			}
			if(!"".equals(lcInsured.getIdType())){
				findContInfoHql.append(" and lcInsured.idType = '" + lcInsured.getIdType().trim() + "'");
			}
			if(!"".equals(lcInsured.getIdNo())){
				findContInfoHql.append(" and lcInsured.idNo like '" + lcInsured.getIdNo().trim() + "%'");
			}
			if(!"".equals(lcInsured.getContPlanCode())){
				findContInfoHql.append(" and lcInsured.contPlanCode = '" + lcInsured.getContPlanCode().trim() + "'");
			}
		}
		//TODO:直接使用findByHqlNoLimit
		Page artificalUWContInfoVoPage = this.findByHql(findContInfoHql.toString(), pageNo, pageSize, null);
		return artificalUWContInfoVoPage;
		
	}
	
	/*
	 * 人工核保中查询个人投保单详细信息
	 * @title findArtificalUWPersonDeal
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#findArtificalUWPersonDeal(ins.prpall.report.model.LCCont)
	 */
	@Override
	public Map<String, Object> findArtificalUWPersonDeal(LCCont lcCont) {
		Map<String, Object> map = new HashMap<String, Object>();
		QueryRule queryRule = QueryRule.getInstance();
		//查询个人保单表（LCCont）
		queryRule.addEqual("contNo", lcCont.getContNo().trim());
		LCCont lcContTemp = this.findUnique(LCCont.class, queryRule);
		map.put("lcCont", lcContTemp);
		//查询团单投保人表（LCGrpAppnt）
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcContTemp.getGrpContNo());
		LCGrpAppnt lcGrpAppnt = this.findUnique(LCGrpAppnt.class, queryRule);
		map.put("lcGrpAppnt", lcGrpAppnt);
		//查询个单投保人表（LCAppnt）
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("contNo", lcContTemp.getContNo());
		LCAppnt lcAppnt = this.findUnique(LCAppnt.class, queryRule);
		map.put("lcAppnt", lcAppnt);
		//查询个人险种表（LCPol）
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("contNo", lcContTemp.getContNo());
		List<LCPol> lcPolList = (List<LCPol>)this.find(LCPol.class, queryRule);
		map.put("lcPolList", lcPolList);
		return map;
	}

	/*
	 * 人工核保中保存对个人投保单的核保意见和审核结论
	 * @title saveArtificalUWPersonResultAndIdea
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#saveArtificalUWPersonResultAndIdea(ins.prpall.report.model.LCCont)
	 */
	@Override
	public boolean saveArtificalUWPersonResultAndIdea(LCCont lcCont) {
		//查询原纪录
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("contNo", lcCont.getContNo());
		LCCont lcContTemp = (LCCont)this.findUnique(LCCont.class, queryRule);
		//将核保意见和审核结论放到lcContTemp中
		lcContTemp.setUwFlag(lcCont.getUwFlag().trim());
		lcContTemp.setRemark(lcCont.getRemark().trim());
		lcContTemp.setModifyDate(new Date());
		lcContTemp.setModifyTime(DateUtil.getTime());
		ActionContext ac = ActionContext.getContext();
		PrpDuser prpDuser = (PrpDuser)ac.getSession().get("user");
		lcContTemp.setUwOperator(prpDuser.getUserName());
		lcContTemp.setUwDate(new Date());
		lcContTemp.setUwTime(DateUtil.getTime());
		//修改流程状态
		lcContTemp.setState("08");//08代表带签单
		
		lcContTemp.setOperator(prpDuser.getUserName());
		//保存
		this.save(lcContTemp);
		return true;
	}


	/*
	 * 人工核保中自动核保功能，查询团体投保单核保信息
	 * @title autoUWInfoQuery
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#autoUWInfoQuery(ins.prpall.report.model.LCGrpCont, ins.prpall.report.model.LCCont)
	 */
	@Override
	public List<AutoUWGrpInfoVo> autoUWGrpInfoQuery(LCGrpCont lcGrpCont) {
		//查询集体保单表
		StringBuffer lcGrpContHql = new StringBuffer();
		lcGrpContHql.append("select new ins.prpall.proposal.vo.AutoUWGrpInfoVo(lcGrpCont.grpContNo, lcGrpCont.proposalGrpContNo,lcGrpPol.riskCode, 111, lcGrpCont.remark, lcGrpCont.uwDate) " +
				"from LCGrpCont lcGrpCont,LCGrpPol lcGrpPol where lcGrpCont.grpContNo = lcGrpPol.grpContNo and lcGrpCont.grpContNo = '" + lcGrpCont.getGrpContNo() + "'");
		List<AutoUWGrpInfoVo> autoUWGrpInfoVoList = this.findByHql(lcGrpContHql.toString(), null);
		return autoUWGrpInfoVoList;
	}

	/*
	 * 人工核保中自动核保功能，查询个人投保单核保信息
	 * @title autoUWPersonInfoQuery
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#autoUWPersonInfoQuery(java.util.List)
	 */
	@Override
	public List<AutoUWPersonInfoVo> autoUWPersonInfoQuery(
			List<AutoUWGrpInfoVo> autoUWGrpInfoVoList) {
		List<String> strList = new ArrayList<String>();
		if(null != autoUWGrpInfoVoList && autoUWGrpInfoVoList.size() > 0){
			for(int i = 0;i < autoUWGrpInfoVoList.size();i++){
				AutoUWGrpInfoVo autoUWGrpInfoVo = autoUWGrpInfoVoList.get(i);
				strList.add(autoUWGrpInfoVo.getGrpContNo());
			}
			
		}
		List<AutoUWPersonInfoVo> autoUWPersonInfoVoList = null;
		if(null != strList && strList.size() > 0){
			//使用in查询数据库中的多条数据，其中传的参数为Object数组
			StringBuffer lcContHql = new StringBuffer();
			lcContHql.append("select new ins.prpall.proposal.vo.AutoUWPersonInfoVo(lcCont.contNo, lcCont.grpContNo,lcCont.proposalContNo, lcCont.insuredNo, lcCont.insuredName,lcPol.riskCode, 2222, lcCont.remark, lcCont.uwDate) " +
					"from LCCont lcCont,LCPol lcPol where lcCont.contNo = lcPol.contNo and lcCont.grpContNo in (?)");
			autoUWPersonInfoVoList = this.findByHql(lcContHql.toString(), new Object[]{strList});
		}
		
		return autoUWPersonInfoVoList;
	}
	
	/*
	 * 人工核保中问题件录入
	 * @title saveIssueFile
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#saveIssueFile(ins.prpall.report.model.LCGrpCont)
	 */
	@Override
	public LCIssue saveIssueFile(LCIssue lcIssue,LCGrpCont lcGrpCont) {
		//查询集体保单表并取得合同号
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcGrpCont.getGrpContNo().trim());
		LCGrpCont lcGrpContTemp = this.findUnique(queryRule);
		//new LCIssue并设置属性
		LCIssueId lcIssueId = new LCIssueId();
		lcIssueId.setGrpContNo(lcGrpContTemp.getGrpContNo());
		queryRule = QueryRule.getInstance();
		//生成序列号
		int serialNOMax = 0;
		StringBuffer serialNoMaxHql = new StringBuffer();
		serialNoMaxHql.append("select max(t.id.serialNo) from LCIssue t where t.id.grpContNo = ?");
		List<Integer> serialNOList = this.findByHql(serialNoMaxHql.toString(), new Object[]{lcGrpContTemp.getGrpContNo()});
		if(null != serialNOList && serialNOList.size() > 0){
			if(null != serialNOList.get(0)){
				serialNOMax = serialNOList.get(0) + 1;
			}
			
		}
		lcIssueId.setSerialNo(serialNOMax);
		lcIssue.setId(lcIssueId);
		lcIssue.setContNo(lcGrpContTemp.getGrpContNo());
		lcIssue.setPrtSeq(lcGrpContTemp.getGrpContNo());
		lcIssue.setProposalContNo(lcGrpContTemp.getProposalGrpContNo());
		lcIssue.setState("0");//state表示问题件状态，“0”表示问题件为回复；“1”表示问题件已回复。
		lcIssue.setIsueManageCom(lcGrpContTemp.getManageCom());
		//根据问退回对象类型查询退回对象
		if("1".equals(lcIssue.getBackObjType().trim())){
			lcIssue.setBackObj(lcGrpContTemp.getOperator());
		}else if("2".equals(lcIssue.getBackObjType().trim())){
			lcIssue.setBackObj(lcGrpContTemp.getOperator());
		}else if("3".equals(lcIssue.getBackObjType().trim())){
			lcIssue.setBackObj(lcGrpContTemp.getAgentCode());
		}else if("4".equals(lcIssue.getBackObjType().trim())){
			lcIssue.setBackObj(lcGrpContTemp.getManageCom());
		}
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		String operator = user.getUserName();
		String manageCom = (String)ac.getSession().get("comCode");
		lcIssue.setOperatePos(lcIssue.getOperatePos().trim());//录入位置
		lcIssue.setBackObjType(lcIssue.getBackObjType().trim());//返回对象类型
		lcIssue.setIssueType(lcIssue.getIssueType().trim());//问题件类型
		lcIssue.setIssueCont(lcIssue.getIssueCont().trim());//问题件类型
		lcIssue.setOperator(operator);
		lcIssue.setManageCom(manageCom);
		lcIssue.setPrintCount(BigDecimal.valueOf(0));
		lcIssue.setMakeDate(new Date());
		lcIssue.setMakeTime(DateUtil.getTime());
		lcIssue.setModifyDate(new Date()); 
		lcIssue.setModifyTime(DateUtil.getTime());
		this.save(lcIssue);
		return lcIssue;
	}

	/*
	 * 团体问题件查询
	 * @title findGrpIssue
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#findGrpIssue(ins.prpall.report.model.LCIssue, int, int)
	 */
	@Override
	public List<LCIssue> findGrpIssue(LCIssue lcIssue, int pageNo, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		if(null != lcIssue.getId().getGrpContNo().trim() && !"".equals(lcIssue.getId().getGrpContNo().trim())){
			queryRule.addEqual("id.grpContNo", lcIssue.getId().getGrpContNo().trim());
			List<LCIssue> lcIssueList = this.find(LCIssue.class, queryRule,pageNo,pageSize).getResult();
			queryRule = QueryRule.getInstance();
			queryRule.addEqual("id.codeType", "InputLocation");//codeType类型为录入位置
			List<PDLDcode1> InputLocationList = this.find(PDLDcode1.class, queryRule);
			//循环遍历，将录入位置代码转换为录入位置名称。
			for(int i = 0;i < lcIssueList.size();i++){
				for(int j = 0;j < InputLocationList.size();j++){
					if(lcIssueList.get(i).getOperatePos().equals(InputLocationList.get(j).getId().getCode())){
						lcIssueList.get(i).setOperatePos(InputLocationList.get(j).getCodeName());
						break;
					}
				}
			}
			queryRule = QueryRule.getInstance();
			queryRule.addEqual("id.codeType", "IssueReason");//codeType类型为录入位置
			List<PDLDcode1> IssueReasonList = this.find(PDLDcode1.class, queryRule);
			//循环遍历，将录入问题件类型代码转换为问题件类型名称。
			for(int i = 0;i < lcIssueList.size();i++){
				for(int j = 0;j < IssueReasonList.size();j++){
					if(lcIssueList.get(i).getIssueType().equals(IssueReasonList.get(j).getId().getCode())){
						lcIssueList.get(i).setIssueType(IssueReasonList.get(j).getCodeName());
						break;
					}
				}
			}
//			for(int i = 0;i < lcIssueList.size();i++){
//				queryRule = QueryRule.getInstance();
//				queryRule.addEqual("id.codeType", "InputLocation")//codeType类型为录入位置
//						 .addEqual("id.code", lcIssueList.get(i).getOperatePos());
//				PDLDcode1 pdldCode1 = this.findUnique(PDLDcode1.class, queryRule);
//				lcIssueList.get(i).setOperatePos(pdldCode1.getCodeName());
//			}
			
			return lcIssueList;
		}else{
			return null;
		}
	}

	/*
	 * 契调信息
	 * @title findSearchInfoInput
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#findSearchInfoInput(ins.prpall.report.model.LCCont)
	 */
	@Override
	public Map<String, Object> findSingleSearchInfoInput(LCCont lcCont) {
		Map<String, Object> map = new HashMap<String, Object>();
		//根据contNo查询lcCont表
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("contNo", lcCont.getContNo());
		LCCont lcContTemp = this.findUnique(LCCont.class, queryRule);
		//根据InsuredNo查询ldPerson表
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("customerNo", lcContTemp.getInsuredNo());
		LDPerson ldPerson = this.findUnique(LDPerson.class, queryRule);
		map.put("lcCont", lcContTemp);
		map.put("ldPerson", ldPerson);
		return map;
	}

	/*
	 * 保存契调信息
	 * @title saveSingleSearchInfo
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ArtificalUWService#saveSingleSearchInfo(ins.prpall.report.model.LCCont, ins.prpall.report.model.LDPerson, ins.prpall.report.model.LCSingleSearchInfo, java.util.List)
	 */
	@Override
	public LCSingleSearchInfo saveSingleSearchInfo(LCCont lcCont, LDPerson ldPerson,
			LCSingleSearchInfo lcSingleSearchInfo,
			List<LCSingleSearchItem> lcSingleSearchItemList) {
		//查找LCCont表
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("contNo", lcCont.getContNo());
		LCCont lcContTemp = this.findUnique(LCCont.class, queryRule);
		//查找LCSingleSearchInfo表,生成序列号
		int serialNoMax = 0;
		StringBuffer serialNoMaxHql = new StringBuffer();
		serialNoMaxHql.append("select max(t.id.serialNo) from LCSingleSearchInfo t where t.id.contNo = ? and t.id.grpContNo = ?");
		List<Integer> serialNoList = this.findByHql(serialNoMaxHql.toString(), new Object[]{lcContTemp.getContNo(),lcContTemp.getGrpContNo()});
		if(null != serialNoList && serialNoList.size() > 0){
			if(null != serialNoList.get(0)){
				serialNoMax = serialNoList.get(0) + 1;
			}
			
		}
		//设置LCSingleSearchInfo表中的id
		LCSingleSearchInfoId id = new LCSingleSearchInfoId();
		id.setGrpContNo(lcContTemp.getGrpContNo());
		id.setContNo(lcContTemp.getContNo());
		id.setSerialNo(serialNoMax);
		lcSingleSearchInfo.setId(id);
		
		lcSingleSearchInfo.setCustomerNo(ldPerson.getCustomerNo());
		lcSingleSearchInfo.setCustomerName(ldPerson.getName());
		lcSingleSearchInfo.setUwOperator(lcCont.getUwOperator());
		lcSingleSearchInfo.setReason(lcSingleSearchInfo.getReason().trim());
		lcSingleSearchInfo.setState("01");//设置契调状态“01”：代表契调下发;“02”：代表契调回复
		PrpDuser user = (PrpDuser)ActionContext.getContext().getSession().get("user");
		lcSingleSearchInfo.setUwOperator(user.getUserName());
		lcSingleSearchInfo.setOperator(user.getUserName());
		lcSingleSearchInfo.setMakeDate(new Date());
		lcSingleSearchInfo.setMakeTime(DateUtil.getTime());
		lcSingleSearchInfo.setModifyDate(new Date());
		lcSingleSearchInfo.setModifyTime(DateUtil.getTime());
		
		for(int i = 0;i < lcSingleSearchItemList.size();i++){
			lcSingleSearchItemList.get(i).getId().setGrpContNo(lcContTemp.getGrpContNo());
			lcSingleSearchItemList.get(i).getId().setContNo(lcContTemp.getContNo());
			lcSingleSearchItemList.get(i).getId().setSerialNo(serialNoMax);
			lcSingleSearchItemList.get(i).getId().setItemNo(lcSingleSearchItemList.get(i).getId().getItemNo().trim());
			lcSingleSearchItemList.get(i).setOperator(user.getUserName());
			lcSingleSearchItemList.get(i).setMakeDate(new Date());
			lcSingleSearchItemList.get(i).setMakeTime(DateUtil.getTime());
			lcSingleSearchItemList.get(i).setModifyDate(new Date());
			lcSingleSearchItemList.get(i).setModifyTime(DateUtil.getTime());
		}
		this.save(lcSingleSearchInfo);
		this.saveAll(lcSingleSearchItemList);
		return lcSingleSearchInfo;
	}


	/**
	 * @title viewContentAndReply
	 * @description 团体问题件内容和回复查询
	 * @param lcIssue
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author 薛玉强
	 */
	@Override
	public LCIssue viewContentAndReply(LCIssue lcIssue) {
		QueryRule queryRule=QueryRule.getInstance();
		LCIssue temp = null;
		if(null!=lcIssue.getId().getGrpContNo()&&!"".equals(lcIssue.getId().getGrpContNo())){
			queryRule.addEqual("id.serialNo", lcIssue.getId().getSerialNo());
			queryRule.addEqual("id.grpContNo",lcIssue.getId().getGrpContNo());
			temp=this.findUnique(LCIssue.class, queryRule);
		}
		return temp;
	}

	/*
	 * 查询团体契调结论信息（根据团体投保单号查询个人投保单）
	 * @title findGrpSearchInfoQuery
	 * @author 薛玉强
	 * @see ins.prpall.proposal.service.facade.ArtificalUWService#findGrpSearchInfoQuery(ins.prpall.proposal.model.LCCont)
	 */
	@Override
	public Page findGrpSearchInfoQuery(LCGrpCont lcGrpCont,int pageNo,int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcGrpCont.getGrpContNo());
		Page lcContPage = this.find(LCCont.class, queryRule, pageNo, pageSize);
		return lcContPage;
	}

	/*
	 * 查询个人契调项目列表
	 * @title findGrpSearchItemList
	 * @author 薛玉强
	 * @see ins.prpall.proposal.service.facade.ArtificalUWService#findGrpSearchItemList(ins.prpall.proposal.model.LCCont)
	 */
	@Override
	public Page findGrpSearchItemList(LCCont lcCont,int pageNo,int pageSize) {
		StringBuffer findGrpSearchItemListHql = new StringBuffer();
		findGrpSearchItemListHql.append("select new ins.prpall.proposal.vo.SearchItemVo(t1.id.itemNo,t2.codeName,t1.standbyFlag3) " +
				"from LCSingleSearchItem t1,PDLDcode1 t2 " +
				"where t1.id.itemNo = t2.id.code and t2.id.codeType = 'SearchNo' and t1.id.grpContNo = '" + lcCont.getGrpContNo() + "' and t1.id.contNo = '" + lcCont.getContNo() +"'");
		System.out.println(findGrpSearchItemListHql.toString());
		Page grpSearchItemPage = this.findByHql(findGrpSearchItemListHql.toString(), pageNo, pageSize, null);
		
		//利用单个表（LCSingleSearchItem）查询
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("id.grpContNo", lcCont.getGrpContNo())
//				 .addEqual("id.contNo", lcCont.getContNo());
//		Page grpSearchItemPage = this.find(LCSingleSearchItem.class, queryRule, pageNo, pageSize);
					
		return grpSearchItemPage;
	}	
	
	
	
}
