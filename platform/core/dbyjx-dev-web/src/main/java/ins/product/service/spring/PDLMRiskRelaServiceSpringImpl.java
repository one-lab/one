package ins.product.service.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.vo.QueryCodeVo;
import ins.product.model.PDLMRiskRela;
import ins.product.model.PDLMRiskRelaId;
import ins.product.service.facade.PDLMRiskRelaService;
import ins.prpall.proposal.vo.LCGrpPolVo;

public class PDLMRiskRelaServiceSpringImpl extends GenericDaoHibernate<PDLMRiskRela, PDLMRiskRelaId> implements PDLMRiskRelaService {

	@Override
	public Page findRelaRisk(int pageNo, int pageSize, HqlQueryRule hqlQueryRule) {
		hqlQueryRule.addEqual("rr.id.relaCode", "01");
		Page page = this.findByHql("select new ins.platform.vo.QueryCodeVo(r.riskCode , r.riskShortName) from PDLMRiskRela rr , PDLMRisk r " +
				"where rr.id.riskCode = r.riskCode and "+hqlQueryRule.getHql(), pageNo, pageSize, hqlQueryRule.getValues());
		return page;
	}
	/*
	 * 
	 * @title findMainRisk
	 * @author xu_xinling
	 * @see ins.product.service.facade.PDLMRiskRelaService#findMainRisk(int, int, java.util.Map)
	 */
	public Page findMainRisk(int pageNo, int pageSize, Map<String, Object> paramsMap){
		String relaCode="04";//01-主附,02-主主,03-产品组合,	04-附附
		
		List<String> strList=new ArrayList<String>();
		StringBuffer lcGrpPolByhql=new StringBuffer();//根据保单合同号查询出添加的险种信息
		lcGrpPolByhql.append("select new ins.prpall.proposal.vo.LCGrpPolVo(l.grpPolNo,l.riskCode,p.riskName,l.prem,l.amnt,l.amnt) from LCGrpPol l,PDLMRisk p where l.riskCode=p.riskCode " +
				"and l.grpContNo='"+paramsMap.get("grpContNo")+"'" );
		List<LCGrpPolVo> lcGrpPolList=this.findByHql(lcGrpPolByhql.toString(), null);
		for(LCGrpPolVo ls:lcGrpPolList){
			strList.add(ls.getRiskCode());
		}
		//查询出附加险对应该保单已经有的主险
		StringBuffer lcMainRiskHql = new StringBuffer();
		lcMainRiskHql.append( "select new ins.platform.vo.QueryCodeVo(rr.id.relaRiskCode, r.riskName) " +
				"from PDLMRiskRela rr  ,PDLMRisk r where rr.id.riskCode = r.riskCode and rr.id.relaCode='"+relaCode+"' " +
						"and rr.id.riskCode = '"+paramsMap.get("subRiskCode")+"' and rr.id.relaRiskCode in (?)");
		return this.findByHql(lcMainRiskHql.toString(), pageNo, pageSize, new Object[]{strList});
	}
	
	
}
