package ins.product.service.facade;

import java.util.List;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.model.PDLMRiskRole;
import ins.product.model.PDLMRiskRoleId;

public interface PDLMRiskRoleService {
	/**
	 * @title findRiskRole
	 * @description 通过险种角色表的主键查询险种角色数据
	 * @author 党泽
	 * @param id 险种角色联合主键
	 * @return PDLMRiskRole 查询出来的一条险种角色的数据
	 */
	PDLMRiskRole findRiskRole(PDLMRiskRoleId id);
	
	/**
	 * @title saveRiskRole
	 * @description 保存险种角色数据
	 * @author 党泽
	 * @param pdlmRiskRole
	 * @return
	 */
	PDLMRiskRole saveRiskRole(PDLMRiskRole pdlmRiskRole);
	/**
	 * @title deleteRiskRole
	 * @description 删除险种角色数据
	 * @author 党泽
	 * @param id 联合主键
	 * @return
	 */
	String deleteRiskRole(PDLMRiskRoleId id);
	/**
	 * @title updateRiskRole
	 * @description 更新险种角色数据
	 * @author 党泽
	 * @param pdlmRiskRole
	 * @return
	 */
	PDLMRiskRole updateRiskRole(PDLMRiskRole pdlmRiskRole);
	/**
	 * @title findRiskByCondition
	 * @description 通过查询条件查询险种角色信息--分页
	 * @author 党泽
	 * @param findRiskRule 查询条件
	 * @param pageNo 页码
	 * @param pageSize 页面大小
	 * @return riskPage 查询到的险种角色信息
	 */
	Page findRiskByCondition(QueryRule findRiskRule, int pageNo, int pageSize);
}
