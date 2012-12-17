package ins.product.service.spring;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMCheckField;
import ins.product.model.PDLMCheckFieldId;
import ins.product.service.facade.PDLMCheckFieldService;

public class PDLMCheckFieldServiceSpringImpl extends GenericDaoHibernate<PDLMCheckField, PDLMCheckFieldId> implements PDLMCheckFieldService {
	/**
	 * @title saveCheckField
	 * @description 保存险种投保规则数据
	 * @author 党泽
	 * @param pdlmCheckField
	 * @return pdlmCheckField
	 */
	@Override
	public PDLMCheckField saveCheckField(PDLMCheckField pdlmCheckField, Invocation invocation) {
		try{
			PrpDuser user = (PrpDuser) invocation.getRequest().getSession().getAttribute("user");
			pdlmCheckField.setOperator(user.getUserCode());
			pdlmCheckField.setMakeDate(DateUtil.getDate());
			pdlmCheckField.setMakeTime(DateUtil.getTime());
			pdlmCheckField.setModifyDate(DateUtil.getDate()); 
			pdlmCheckField.setModifyTime(DateUtil.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		this.save(pdlmCheckField);
		return pdlmCheckField;
	}
    
	/**
	 * @title deleteCheckField
	 * @description 删除险种投保规则数据
	 * @author 党泽
	 * @param pdlmCheckField
	 * @return pdlmCheckField
	 */
	@Override
	public PDLMCheckField deleteCheckField(PDLMCheckField pdlmCheckField) {
		this.delete(pdlmCheckField);
		return pdlmCheckField;
	}
	
	/**
	 * @title updateCheckField
	 * @description 更新险种投保规则数据
	 * @author 党泽
	 * @param pdlmCheckField
	 * @return pdlmCheckField
	 */

	@Override
	public PDLMCheckField updateCheckField(PDLMCheckField pdlmCheckField) {
		this.update(pdlmCheckField);
		return pdlmCheckField;
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
	public PDLMCheckField findCFByID(PDLMCheckFieldId ID) {
		PDLMCheckField cf = this.get(ID);
		return cf;
	} 
	
	
	
	/**
	 * @title deleteLMUW
	 * @description  删除一条核保规则
	 * @param UWCode
	 * @return
	 */
	@Override
	public String deleteCF(PDLMCheckFieldId ID) {
		try{			
			this.deleteByPK(ID);
		}catch(Exception e){
			return e.getMessage();
		}
		return "记录已经删除";
	}

}
