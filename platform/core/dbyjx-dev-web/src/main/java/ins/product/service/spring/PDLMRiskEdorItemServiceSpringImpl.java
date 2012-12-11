package ins.product.service.spring;

import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDLMRiskEdorItem;
import ins.product.model.PDLMRiskEdorItemId;
import ins.product.service.facade.PDLMRiskEdorItemService;

public class PDLMRiskEdorItemServiceSpringImpl extends GenericDaoHibernate<PDLMRiskEdorItem, PDLMRiskEdorItemId> implements PDLMRiskEdorItemService{
	/**
	 * @title addRiskEdorItem
	 * @description 保存一个保全项
	 * @author 朱超
	 * @param pdlmRiskEdorItem
	 * @return
	 */
	@Override
	public PDLMRiskEdorItem addRiskEdorItem(PDLMRiskEdorItem pdlmRiskEdorItem) {
		this.save(pdlmRiskEdorItem);
		return null;
	}

}
