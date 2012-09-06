package ins.product.service.spring;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMDutyPay;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.model.PDLMUW;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMUWService;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class PDLMUWServiceSpringImpl extends
		GenericDaoHibernate<PDLMUW, String> implements PDLMUWService {
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
							"select new ins.platform.vo.QueryCodeVo(uw.PDLMRisk.riskCode , uw.riskName) from PDLMUW uw where "
									+ hqlQueryRule.getHql(), pageNo, pageSize,
							hqlQueryRule.getValues());
		} else {
			page = this
					.findByHqlNoLimit(
							"select new ins.platform.vo.QueryCodeVo(uw.PDLMRisk.riskCode , uw.riskName) from PDLMUW uw ",
							pageNo, pageSize, null);
		}
		return page;
	}

	@Override
	public String checkRiskExist(PDLMUW pdLMUW) {
		if (null == this.get(pdLMUW.getPDLMRisk().getRiskCode())) {
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
	public PDLMUW findUWByUWCode(String UWCode) {
		PDLMUW uw = this.get(UWCode);
		return uw;
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
	
	/**
	 * @title saveLMUW
	 * @description  保存一条核保规则
	 * @param PDLMUW
	 * @return
	 */
	@Override
	public void saveLMUW(PDLMUW pdLMUW, Invocation invocation) {
		PDLMUW pdLMUW1 = this.get(pdLMUW.getPDLMRisk().getRiskCode());
		try{
			if (pdLMUW1 != null) {
				    pdLMUW.setUwCode(pdLMUW1.getUwCode());
				    pdLMUW.setPDLMCalMode(pdLMUW1.getPDLMCalMode());
				    pdLMUW.setPDLMRisk(pdLMUW1.getPDLMRisk());
				    pdLMUW.setRiskVer(pdLMUW1.getRiskVer());
				    pdLMUW.setRiskName(pdLMUW1.getRiskName());
				    pdLMUW.setRelaPolType(pdLMUW1.getRelaPolType());
				    pdLMUW.setUwType(pdLMUW1.getUwType());
				    pdLMUW.setUwOrder(pdLMUW1.getUwOrder());
				    pdLMUW.setOthCalCode(pdLMUW1.getOthCalCode());
					pdLMUW.setRemark(pdLMUW1.getRemark());
					pdLMUW.setUwGrade(pdLMUW1.getUwGrade());
					pdLMUW.setUwResult(pdLMUW1.getUwResult());
					pdLMUW.setPassFlag(pdLMUW1.getPassFlag());
					PrpDuser user = (PrpDuser) invocation.getRequest().getSession().getAttribute("user");;
					pdLMUW.setOperator(user.getUserCode());
					pdLMUW.setMakeDate(DateUtil.getDate());
					pdLMUW.setMakeTime(DateUtil.getTime());
					pdLMUW.setModifyDate(DateUtil.getDate());
					pdLMUW.setModifyTime(DateUtil.getTime());
					pdLMUW.setStandbyflag2(pdLMUW1.getStandbyflag2());
					pdLMUW.setStandbyflag1(pdLMUW1.getStandbyflag1());
					pdLMUW.setStandbyflag3(pdLMUW1.getStandbyflag3());
					pdLMUW.setStandbyflag4(pdLMUW1.getStandbyflag4());
					pdLMUW.setStandbyflag6(pdLMUW1.getStandbyflag6());
					pdLMUW.setStandbyflag5(pdLMUW1.getStandbyflag5());
			} else {
					PrpDuser user = (PrpDuser) invocation.getRequest().getSession().getAttribute("user");;
					pdLMUW.setOperator(user.getUserCode());
					pdLMUW.setMakeDate(DateUtil.getDate());
					pdLMUW.setMakeTime(DateUtil.getTime());
					pdLMUW.setModifyDate(DateUtil.getDate());
					pdLMUW.setModifyTime(DateUtil.getTime());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		this.save(pdLMUW);
	}
	
	
	
	/**
	 * @title deleteLMUW
	 * @description  删除一条核保规则
	 * @param UWCode
	 * @return
	 */
	@Override
	public String deleteLMUW(String UWCode) {
		try{			
			this.deleteByPK(UWCode);
		}catch(Exception e){
			return e.getMessage();
		}
		return "记录"+UWCode+"已经删除";
	}

}
