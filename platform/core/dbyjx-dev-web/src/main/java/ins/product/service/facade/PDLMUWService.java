package ins.product.service.facade;

import java.util.List;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMUW;

public interface PDLMUWService {
	/**
	 * 双击域获得的险种
	 * @param pageNo
	 * @param pageSize
	 * @param hqlQueryRule
	 * @return
	 */
	Page findByPage(int pageNo, int pageSize, HqlQueryRule hqlQueryRule);
	/**
	 * 检查该险种是否已经存在
	 * @param pdLMUW
	 * @return
	 */
	String checkRiskExist(PDLMUW pdLMUW);
	/**
	 * 查询产品定义中的字段名称
	 * @param tableCode
	 * @return
	 */
	List<PDBaseField> findFieldsByTableCode(String tableCode);
	/**
	 * 通过riskCode查询险种
	 * @param findRiskRule 查询条件集合
	 * @return
	 */
	PDLMUW findUWByUWCode(String UWCode);
	/**
	 * 通过查询条件查询险种信息--分页
	 * @param findRiskRule
	 * @return 
	 */
	Page findRiskByCondition(QueryRule findRiskRule, int pageNo, int pageSize);
	
	/**
	 * 添加险种
	 *  * @description 保存一条核保规则
	 * @param pdLMUW
	 */
	void saveLMUW(PDLMUW pdLMUW);
	
	
	
	/**
	 * @title deleteLMUW
	 * @description 删除一条核保规则
	 * @param UWCode
	 * @return
	 */
	String deleteLMUW(String UWCode);

}
