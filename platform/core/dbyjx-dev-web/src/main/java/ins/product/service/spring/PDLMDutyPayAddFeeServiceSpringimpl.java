package ins.product.service.spring;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMDutyPayAddFee;
import ins.product.model.PDLMDutyPayAddFeeId;
import ins.product.service.facade.PDLMDutyPayAddFeeService;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

public class PDLMDutyPayAddFeeServiceSpringimpl extends GenericDaoHibernate<PDLMDutyPayAddFee, PDLMDutyPayAddFeeId> implements PDLMDutyPayAddFeeService {

	@Override
	public PDLMDutyPayAddFee saveDutyPayAddFee(
			PDLMDutyPayAddFee pdlmDutyPayAddFee, Invocation invocation) {
		pdlmDutyPayAddFee.setOperator(((PrpDuser)invocation.getRequest().getSession().getAttribute("user")).getUserCode());
		//pdLmDutyGet.setOperator("114000038");
		pdlmDutyPayAddFee.setMakeDate(new Date());
		pdlmDutyPayAddFee.setMakeTime(DateUtil.getTime());
		pdlmDutyPayAddFee.setModifyDate(new Date());
		pdlmDutyPayAddFee.setModifyTime(DateUtil.getTime());
		this.save(pdlmDutyPayAddFee);
		return pdlmDutyPayAddFee;
	}

	@Override
	public PDLMDutyPayAddFee updateDutyPayAddFee(
			PDLMDutyPayAddFee pdlmDutyPayAddFee) {
		PDLMDutyPayAddFee odlPDLMDutyPayAddFee = this.get(pdlmDutyPayAddFee.getId());
		odlPDLMDutyPayAddFee.setAddFeeCalCode(pdlmDutyPayAddFee.getAddFeeCalCode());
		odlPDLMDutyPayAddFee.setAddPointLimit(pdlmDutyPayAddFee.getAddPointLimit());
		odlPDLMDutyPayAddFee.setModifyDate(new Date());
		odlPDLMDutyPayAddFee.setModifyTime(DateUtil.getTime());
		return odlPDLMDutyPayAddFee;
	}

	@Override
	public String deleteDutyPayAddFee(PDLMDutyPayAddFee pdlmDutyPayAddFee) {
		try{			
			this.deleteByPK(pdlmDutyPayAddFee.getId());
		}catch(Exception e){
			return e.getMessage();
		}
		return "删除成功！";
	}

	@Override
	public PDLMDutyPayAddFee findByPK(PDLMDutyPayAddFeeId id) {
		PDLMDutyPayAddFee temp = this.get(id);
		return temp;
	}
}
