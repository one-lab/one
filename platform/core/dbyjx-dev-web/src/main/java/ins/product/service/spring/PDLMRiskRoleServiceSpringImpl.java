package ins.product.service.spring;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMRisk;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.model.PDLMRiskRole;
import ins.product.model.PDLMRiskRoleId;
import ins.product.service.facade.PDLMRiskRoleService;

public class PDLMRiskRoleServiceSpringImpl extends GenericDaoHibernate<PDLMRiskRole, PDLMRiskRoleId> implements PDLMRiskRoleService {
	/**
	 * @title findRiskRole
	 * @description 通过险种角色表的主键查询险种角色数据
	 * @author 党泽
	 * @param id 险种角色联合主键
	 * @return PDLMRiskRole 查询出来的一条险种角色的数据
	 */
	@Override
	public PDLMRiskRole findRiskRole(PDLMRiskRoleId id){
		
		PDLMRiskRole role = this.get(id);;
			return role;
	}
	/**
	 * @title findRiskByCondition
	 * @description 通过查询条件查询险种角色信息--分页
	 * @author 党泽
	 * @param findRiskRule 查询条件
	 * @param pageNo 页码
	 * @param pageSize 页面大小
	 * @return riskPage 查询到的险种角色信息
	 */
	@Override
	public Page findRiskByCondition(QueryRule findRiskRule, int pageNo,
			int pageSize) {
		Page riskPage = this.find(findRiskRule, pageNo, pageSize);
		return riskPage;
	}
	/**
	 * @title saveRiskRole
	 * @description 保存险种角色数据
	 * @author 党泽
	 * @param pdlmRiskRole
	 * @return pdlmRiskRole
	 */
	@Override
	public PDLMRiskRole saveRiskRole(PDLMRiskRole pdlmRiskRole, Invocation invocation) {
		pdlmRiskRole.setOperator(((PrpDuser)invocation.getRequest().getSession().getAttribute("user")).getUserCode());
		pdlmRiskRole.setMakeDate(new Date());
		pdlmRiskRole.setMakeTime(DateUtil.getTime());
		pdlmRiskRole.setModifyDate(new Date());
		pdlmRiskRole.setModifyTime(DateUtil.getTime());
		this.save(pdlmRiskRole);
		return pdlmRiskRole;
	}
    
	/**
	 * @title deleteRiskRole
	 * @description 删除险种角色数据
	 * @author 党泽
	 * @param pdlmRiskRole
	 * @return pdlmRiskRole
	 */
	@Override
	public String deleteRiskRole(PDLMRiskRoleId id) {
		try{			
			this.deleteByPK(id);
		}catch(Exception e){
			return e.getMessage();
		}
		return "删除成功!";
	}
	
	/**
	 * @title updateRiskRole
	 * @description 更新险种角色数据
	 * @author 党泽
	 * @param pdlmRiskRole
	 * @return pdlmRiskRole
	 */
	@Override
	public PDLMRiskRole updateRiskRole(PDLMRiskRole pdlmRiskRole, Invocation invocation) {
		pdlmRiskRole.setOperator(((PrpDuser)invocation.getRequest().getSession().getAttribute("user")).getUserCode());
		pdlmRiskRole.setMakeDate(new Date());
		pdlmRiskRole.setMakeTime(DateUtil.getTime());
		pdlmRiskRole.setModifyDate(new Date());
		pdlmRiskRole.setModifyTime(DateUtil.getTime());
		this.update(pdlmRiskRole);
		return pdlmRiskRole;
	}
}
