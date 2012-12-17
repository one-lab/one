package ins.product.service.facade;

import java.util.List;
import java.util.Map;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMRisk;
import ins.prpall.proposal.model.LCNotepad;

public interface PdLmRiskService {
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
	 * @param pdLMRisk
	 * @return
	 */
	String checkRiskExist(PDLMRisk pdLMRisk);
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
	PDLMRisk findRiskByRiskCode(String riskCode);
	/**
	 * 通过查询条件查询险种信息--分页
	 * @param findRiskRule
	 * @return 
	 */
	Page findRiskByCondition(QueryRule findRiskRule, int pageNo, int pageSize);
	/**
	 * 添加险种
	 * @param pdLMRisk
	 */
	void saveRisk(PDLMRisk pdLMRisk, Invocation invocation);
	/**
	 * 添加记事本信息
	 * @param lcNotepad
	 * @return
	 */
}
