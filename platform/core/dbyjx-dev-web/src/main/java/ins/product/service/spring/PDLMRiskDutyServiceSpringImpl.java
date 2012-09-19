package ins.product.service.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import ins.framework.dao.GenericDaoHibernate;
import ins.framework.exception.BusinessException;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMDuty;
import ins.product.model.PDLMRiskDuty;
import ins.product.model.PDLMRiskDutyId;
import ins.product.service.facade.PDLMRiskDutyService;

public class PDLMRiskDutyServiceSpringImpl extends GenericDaoHibernate<PDLMRiskDuty, PDLMRiskDutyId> implements PDLMRiskDutyService{
	/**
	 * @title saveRiskDuty
	 * @description 保存险种责任关联基础信息
	 * @author 朱超
	 * @param pdlmRiskDuty
	 * @return
	 */
	@Override
	public PDLMRiskDuty saveRiskDuty(PDLMRiskDuty pdlmRiskDuty,PDLMDuty pdlmDuty) {
		try{
			//设置pdlmDuty不为空的字段值
			//pdlmDuty.setOperator(((PrpDuser)ActionContext.getContext().getSession().get("user")).getUserCode());
			pdlmDuty.setOperator("114000038");
			pdlmDuty.setMakeDate(new Date());
			pdlmDuty.setMakeTime(DateUtil.getTime());
			pdlmDuty.setModifyDate(new Date());
			pdlmDuty.setModifyTime(DateUtil.getTime());
			
			//关联起来，做级联操作
			pdlmRiskDuty.setPDLMDuty(pdlmDuty);
			
			//设置pdlmRiskDuty的值
			PDLMRiskDutyId id = new PDLMRiskDutyId();
			id.setDutyCode(pdlmDuty.getDutyCode());
			//id.setRiskCode((String)ActionContext.getContext().getSession().get("riskCode"));
			id.setRiskCode("AUPA");
			pdlmRiskDuty.setId(id);
			
			//pdlmRiskDuty.setOperator(((PrpDuser)ActionContext.getContext().getSession().get("user")).getUserCode());
			pdlmRiskDuty.setOperator("114000038");
			pdlmRiskDuty.setMakeDate(new Date());
			pdlmRiskDuty.setMakeTime(DateUtil.getTime());
			pdlmRiskDuty.setModifyDate(new Date());
			pdlmRiskDuty.setModifyTime(DateUtil.getTime());
			//this.findu
			List<PDLMRiskDuty> list = new ArrayList<PDLMRiskDuty>();
			list.add(pdlmRiskDuty);
			pdlmDuty.setPDLMRiskDuties(list);
			this.save(pdlmDuty);
		}
		catch(BusinessException e){
			return null;
		}
		return pdlmRiskDuty;
		
	}
	/**
	 * @title updateDhtml
	 * @description 更新Dhtml字段
	 * @author 朱超
	 * @param pdlmRiskDuty
	 * @return
	 */
	@Override
	public String updateDhtml(PDLMRiskDuty pdlmRiskDuty) {
		try{
			String dhtml = pdlmRiskDuty.getDhtml();
			pdlmRiskDuty = this.get(pdlmRiskDuty.getId());
			pdlmRiskDuty.setModifyDate(new Date());
			pdlmRiskDuty.setModifyTime(DateUtil.getTime());
			pdlmRiskDuty.setDhtml(dhtml);
			
		}catch(Exception e){
			return e.getMessage();
		}
		return "更新成功";
	}

}
