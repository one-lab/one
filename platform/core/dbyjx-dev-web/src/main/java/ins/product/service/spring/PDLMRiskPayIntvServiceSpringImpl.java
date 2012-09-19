package ins.product.service.spring;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMRiskPayIntv;
import ins.product.service.facade.PDLMRiskPayIntvService;

public class PDLMRiskPayIntvServiceSpringImpl extends GenericDaoHibernate<PDLMRiskPayIntv, String> implements PDLMRiskPayIntvService {
	/**
	 * @title saveRiskPayIntv
	 * @description 保存险种交费间隔数据
	 * @author 党泽
	 * @param pdlmRiskPayIntv
	 * @return pdlmRiskPayIntv
	 */
	@Override
	public PDLMRiskPayIntv saveRiskPayIntv(PDLMRiskPayIntv pdlmRiskPayIntv) {
		//pdlmRiskPayIntv.setOperator(((PrpDuser)ActionContext.getContext().getSession().get("user")).getUserCode());
		pdlmRiskPayIntv.setOperator("114000038");
		pdlmRiskPayIntv.setMakeDate(new Date());
		pdlmRiskPayIntv.setMakeTime(DateUtil.getTime());
		pdlmRiskPayIntv.setModifyDate(new Date());
		pdlmRiskPayIntv.setModifyTime(DateUtil.getTime());
		this.save(pdlmRiskPayIntv);
		return pdlmRiskPayIntv;
	}
    
	/**
	 * @title deleteRiskPayIntv
	 * @description 删除险种交费间隔数据
	 * @author 党泽
	 * @param pdlmRiskPayIntv
	 * @return pdlmRiskPayIntv
	 */
	@Override
	public PDLMRiskPayIntv deleteRiskPayIntv(PDLMRiskPayIntv pdlmRiskPayIntv) {
		this.delete(pdlmRiskPayIntv);
		return pdlmRiskPayIntv;
	}
	
	/**
	 * @title updateRiskPayIntv
	 * @description 更新险种交费间隔数据
	 * @author 党泽
	 * @param pdlmRiskPayIntv
	 * @return pdlmRiskPayIntv
	 */
	@Override
	public PDLMRiskPayIntv updateRiskPayIntv(PDLMRiskPayIntv pdlmRiskPayIntv) {
		this.update(pdlmRiskPayIntv);
		return pdlmRiskPayIntv;
	}
}
