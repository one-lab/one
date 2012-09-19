package ins.product.service.spring;

import java.util.Date;

import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.product.model.PDLMRiskApp;
import ins.product.service.facade.PDLMRiskAppService;

public class PDLMRiskAppServiceSpringImpl extends GenericDaoHibernate<PDLMRiskApp, String> implements PDLMRiskAppService {
	/**
	 * @title findByRiskCode
	 * @description 通过主键查询pdlmRiskApp
	 * @author 朱超
	 * @param riskCode
	 * @return
	 */
	@Override
	public PDLMRiskApp findByRiskCode(String riskCode) {
		PDLMRiskApp riskApp = this.get(riskCode);
		return riskApp;
	}
	/**
	 * @title saveRiskApp
	 * @description 增加一个险种承保定义
	 * @author 朱超
	 * @param pdlmRiskApp
	 * @return
	 */
	@Override
	public PDLMRiskApp saveRiskApp(PDLMRiskApp pdlmRiskApp) {
		//pdlmRiskApp.setOperator(((PrpDuser)ActionContext.getContext().getSession().get("user")).getUserCode());
		pdlmRiskApp.setOperator("114000038");
		pdlmRiskApp.setMakeDate(new Date());
		pdlmRiskApp.setMakeTime(DateUtil.getTime());
		pdlmRiskApp.setModifyDate(new Date());
		pdlmRiskApp.setModifyTime(DateUtil.getTime());
		this.save(pdlmRiskApp);
		return pdlmRiskApp;
	}
	/**
	 * @title deleteRiskApp
	 * @description 删除一条记录通过主键
	 * @author 朱超
	 * @param riskCode
	 * @return
	 */
	@Override
	public String deleteRiskApp(String riskCode) {
		try{
			this.deleteByPK(riskCode);
		}catch(Exception e){
			return e.getMessage();
		}
		return "记录"+riskCode+"已经删除";
	}

}
