package ins.platform.service.spring;

import java.util.Map;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.service.facade.PdLdCodeService;
import ins.product.model.PDLDcode1;
import ins.product.model.PDLDcode1Id;

public class PdLdCodeServiceSpringImpl extends GenericDaoHibernate<PDLDcode1, PDLDcode1Id> implements PdLdCodeService {
	/**
	 * 查询产品代码表中的数据得到相对应的记录
	 * @param pageNo 第几页
	 * @param pageSize  页面大小
	 * @param hqlQueryRule  对应的字段是哪个,参数
	 * @return
	 */
	@Override
	public Page findByCode(int pageNo, int pageSize,  Map<String, Object> paramsMap) {
		String hql = "select new ins.platform.vo.QueryCodeVo(c.id.code , c.codeName) from PDLDcode1 c where c.id.codeType = '"+paramsMap.get("codeType")+"'";
		Page page = this.findByHqlNoLimit(hql,pageNo,pageSize,null);
		return page;
	}

	
	public PDLDcode1 findByPK(PDLDcode1Id ID) {
		PDLDcode1 code = this.get(ID);
		return code;
	}
	
	
}
