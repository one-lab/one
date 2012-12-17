package ins.product.service.spring;

import java.math.BigDecimal;
import java.util.List;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDLMRiskDutyRate;
import ins.product.model.PDLMRiskDutyRateId;
import ins.product.service.facade.PDLMRiskDutyRateService;
import ins.product.vo.PDLMRiskDutyFactorValueVo;

public class PDLMRiskDutyRateServiceSpringImpl extends GenericDaoHibernate<PDLMRiskDutyRate, PDLMRiskDutyRateId> implements PDLMRiskDutyRateService {
	/**
	 * @title findOnlyOne
	 * @description 通过vo对象获得唯一的一个PDLMRiskDutyRate
	 * @author 朱超
	 * @param vo
	 * @return
	 */
	@Override
	public PDLMRiskDutyRate findOnlyOne(PDLMRiskDutyFactorValueVo vo) {
		//select * from pd_lmriskdutyrate where riskCode = 'GCAA' and dutyCode ='G25000' and calFactor ='sex' and startvalue <=1 and endvalue >=1;
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.riskCode", vo.getRiskCode());
		queryRule.addEqual("id.dutyCode", vo.getDutyCode());
		queryRule.addEqual("id.calfactor", vo.getCalFactor());
		queryRule.addGreaterEqual("endValue", new BigDecimal(vo.getCalFactorValue()));
		queryRule.addLessEqual("startValue", new BigDecimal(vo.getCalFactorValue()));
		PDLMRiskDutyRate pdlmRiskDutyRate = this.findUnique(queryRule);
		return pdlmRiskDutyRate;
	}
	
	/**
	 * @title findSomeByFactorValueVo
	 * @description 通过PDLMRiskDutyFactorValueVo的集合得到 PDLMRiskDutyRate的集合
	 * @author 朱超
	 * @param vos PDLMRiskDutyFactorValueVo的集合
	 * @return
	 */
	@Override
	public List<PDLMRiskDutyRate> findSomeByFactorValueVo(
			List<PDLMRiskDutyFactorValueVo> vos) {
		/**
		 * sql语句样例：
		    select *
  			from pd_lmriskdutyrate
 			where riskCode = 'GCAA'
   			and dutyCode = 'G25000'
   			and (calFactor = 'age' and startvalue <= 3 and endvalue >= 3 or
       		calFactor = 'sex' and startvalue <= 1 and endvalue >= 1) order by serialno asc
		 */
		StringBuffer hql = new StringBuffer();
		hql.append(" from PDLMRiskDutyRate pdlmRiskDutyRate where ");
		hql.append(" pdlmRiskDutyRate.id.riskCode = '"+vos.get(0).getRiskCode()+"' and pdlmRiskDutyRate.id.dutyCode = '"+vos.get(0).getDutyCode()+"' and ( ");
		for(PDLMRiskDutyFactorValueVo vo :vos){
			hql.append(" pdlmRiskDutyRate.id.calfactor = '"+vo.getCalFactor()+"' and pdlmRiskDutyRate.startValue <= "+vo.getCalFactorValue()+" ");
			hql.append(" and pdlmRiskDutyRate.endValue >= "+vo.getCalFactorValue()+" or ");
		}
		//去掉结尾的"or "
		hql.delete(hql.length()-3,hql.length());
		hql.append(" ) order by pdlmRiskDutyRate.id.serialNo ASC ");
		System.out.println("打印hql语句："+hql.toString());
		List<PDLMRiskDutyRate> pdlmRiskDutyRates = this.findByHql(hql.toString(), null);
		return pdlmRiskDutyRates;
	}

}
