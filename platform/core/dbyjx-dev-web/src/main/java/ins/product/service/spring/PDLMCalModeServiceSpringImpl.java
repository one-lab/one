package ins.product.service.spring;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMCalMode;
import ins.product.service.facade.PDLMCalModeService;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

public class PDLMCalModeServiceSpringImpl extends GenericDaoHibernate<PDLMCalMode, String> implements PDLMCalModeService {

	@Override
	public PDLMCalMode saveCalMode(PDLMCalMode pdlmCalMode, Invocation invocation) {
		pdlmCalMode.setOperator(((PrpDuser)invocation.getRequest().getSession().getAttribute("user")).getUserCode());
//		pdlmCalMode.setOperator("114000038");
		pdlmCalMode.setMakeDate(new Date());
		pdlmCalMode.setMakeTime(DateUtil.getTime());
		pdlmCalMode.setModifyDate(new Date());
		pdlmCalMode.setModifyTime(DateUtil.getTime());
		this.save(pdlmCalMode);
		return pdlmCalMode;
	}

	@Override
	public PDLMCalMode updateCalMode(PDLMCalMode pdlmCalMode) {
		PDLMCalMode oldPDLMCalMode = this.get(pdlmCalMode.getCalCode());
		oldPDLMCalMode.setCalSQL(pdlmCalMode.getCalSQL());
		oldPDLMCalMode.setRemark(pdlmCalMode.getRemark());
		oldPDLMCalMode.setRiskCode(pdlmCalMode.getRiskCode());
		oldPDLMCalMode.setType(pdlmCalMode.getType());
		oldPDLMCalMode.setModifyDate(new Date());
		oldPDLMCalMode.setModifyTime(DateUtil.getTime());
		return oldPDLMCalMode;
	}

	@Override
	public String deleteCalMode(String calCode) {
		this.deleteByPK(calCode);
		return null;
	}

}
