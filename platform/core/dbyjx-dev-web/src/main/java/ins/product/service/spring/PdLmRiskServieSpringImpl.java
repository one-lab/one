package ins.product.service.spring;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMRisk;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PdLmRiskService;
import ins.prpall.proposal.model.LCNotepad;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class PdLmRiskServieSpringImpl extends
		GenericDaoHibernate<PDLMRisk, String> implements PdLmRiskService {
	private PDBaseFieldService pdBaseFieldService;
	private SerialNoUtil serialNoUtil;

	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}

	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}

	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}

	@Override
	public Page findByPage(int pageNo, int pageSize, HqlQueryRule hqlQueryRule) {
		Page page = null;
		if (null != hqlQueryRule.getHql()
				&& !hqlQueryRule.getHql().trim().equals("")) {
			page = this
					.findByHqlNoLimit(
							"select new ins.platform.vo.QueryCodeVo(risk.riskCode , risk.riskShortName) from PDLMRisk risk where "
									+ hqlQueryRule.getHql(), pageNo, pageSize,
							hqlQueryRule.getValues());
		} else {
			page = this
					.findByHqlNoLimit(
							"select new ins.platform.vo.QueryCodeVo(risk.riskCode , risk.riskShortName) from PDLMRisk risk ",
							pageNo, pageSize, null);
		}
		return page;
	}

	@Override
	public String checkRiskExist(PDLMRisk pdLMRisk) {
		if (null == this.get(pdLMRisk.getRiskCode())) {
			return "N";
		} else {
			return "Y";
		}

	}

	@Override
	public List<PDBaseField> findFieldsByTableCode(String tableCode) {
		List<PDBaseField> fields = pdBaseFieldService.findField(tableCode);
		return fields;
	}

	@Override
	public PDLMRisk findRiskByRiskCode(String riskCode) {
		PDLMRisk risk = this.get(riskCode);
		return risk;
	}

	/**
	 * 通过查询条件查询险种信息--分页
	 * 
	 * @param findRiskRule
	 * @return
	 */
	@Override
	public Page findRiskByCondition(QueryRule findRiskRule, int pageNo,
			int pageSize) {
		Page riskPage = this.find(findRiskRule, pageNo, pageSize);
		return riskPage;
	}

	@Override
	public void saveRisk(PDLMRisk pdLMRisk, Invocation invocation) {
		PDLMRisk pdLMRisk1 = this.get(pdLMRisk.getRiskCode());
		try{
			if (pdLMRisk1 != null) {
					pdLMRisk.setMakeTime(pdLMRisk1.getMakeTime());
					pdLMRisk.setModifyDate(DateUtil.getDate());
					pdLMRisk.setModifyTime(DateUtil.getTime());
					PrpDuser user = (PrpDuser) invocation.getRequest().getSession().getAttribute("user");
					pdLMRisk.setOperator(user.getUserCode());
			} else {
					pdLMRisk.setMakeDate(DateUtil.getDate());
					pdLMRisk.setMakeTime(DateUtil.getTime());
					pdLMRisk.setModifyDate(DateUtil.getDate());
					pdLMRisk.setModifyTime(DateUtil.getTime());
					PrpDuser user = (PrpDuser) invocation.getRequest().getSession().getAttribute("user");
					pdLMRisk.setOperator(user.getUserCode());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		this.save(pdLMRisk);
	}
}
