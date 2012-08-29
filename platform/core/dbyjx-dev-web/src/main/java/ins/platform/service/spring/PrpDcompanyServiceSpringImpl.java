package ins.platform.service.spring;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.model.PrpDcompany;
import ins.platform.service.facade.PrpDcompanyService;
import ins.platform.vo.QueryCodeVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrpDcompanyServiceSpringImpl extends GenericDaoHibernate<PrpDcompany, String> implements PrpDcompanyService {
	/**
	 * 查询机构，返回一个page对象
	 * @param pageNo 页数编码
	 * @param pageSize 每页大小
	 * @param paramsMap 查询参数
	 * @return
	 */
	@Override
	public Page findByPage(int pageNo,int pageSize,Map<String, Object> paramsMap) {
		Page page = null;
		String sql = "select * from ( select rownum rn, comcode,comcName from prpdcompany "+   
		" start with comcode = ? "+
		" connect by  prior comcode = uppercomcode and  prior uppercomcode != comcode"+ 
		" order by rownum )  where comcode like ? and rn > ? and rn <= ? ";
		List<Object[]> result = this.findBySql(sql,paramsMap.get("upperComCode"), paramsMap.get("comCode")+"%",(pageNo-1)*pageSize,(pageNo-1)*pageSize+pageSize);
		List<QueryCodeVo> queryCodeVoList = new ArrayList<QueryCodeVo>();
		for(int i = 0 ; i < result.size() ; i++){
			queryCodeVoList.add(new QueryCodeVo((String)result.get(i)[1],(String)result.get(i)[2]));
		}
		String totalSql = "select count(*) from ( select rownum rn, comcode,comcName from prpdcompany "+   
		" start with comcode = ? "+
		" connect by  prior comcode = uppercomcode and  prior uppercomcode != comcode ) where comcode like ?";
		List <Object> total = this.findBySql(totalSql,paramsMap.get("upperComCode"), paramsMap.get("comCode")+"%");
		BigDecimal totalSize = (BigDecimal)total.get(0);
		page = new Page((pageNo-1)*pageSize, totalSize.longValue(), pageSize, queryCodeVoList);
		return page;
	}
}
