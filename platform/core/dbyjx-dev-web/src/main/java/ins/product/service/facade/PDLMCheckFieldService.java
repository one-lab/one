package ins.product.service.facade;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.product.model.PDLMCheckField;
import ins.product.model.PDLMCheckFieldId;

public interface PDLMCheckFieldService {
	/**
	 * @title saveCheckField
	 * @description 保存投保规则数据
	 * @author 党泽
	 * @param pdlmCheckField
	 * @return
	 */
	PDLMCheckField saveCheckField(PDLMCheckField pdlmCheckField, Invocation invocation);
	/**
	 * @title deleteCheckField
	 * @description 删除投保规则数据
	 * @author 党泽
	 * @param pdlmCheckField
	 * @return
	 */
	PDLMCheckField deleteCheckField(PDLMCheckField pdlmCheckField);
	/**
	 * @title updateCheckField
	 * @description 更新投保规则数据
	 * @author 党泽
	 * @param pdlmCheckField
	 * @return
	 */
	PDLMCheckField updateCheckField(PDLMCheckField pdlmCheckField);
	
	/**
	 * 通过查询条件查询险种信息--分页
	 * @param findRiskRule
	 * @return 
	 */
	Page findRiskByCondition(QueryRule findRiskRule, int pageNo, int pageSize);
	
	/**
	 * 通过riskCode查询险种
	 * @param findRiskRule 查询条件集合
	 * @return
	 */
	PDLMCheckField findCFByID(PDLMCheckFieldId ID);
	
	String deleteCF(PDLMCheckFieldId ID);
}
