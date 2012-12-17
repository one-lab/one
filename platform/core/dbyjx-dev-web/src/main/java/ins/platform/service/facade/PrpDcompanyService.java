package ins.platform.service.facade;


import java.util.Map;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.platform.vo.QueryCodeVo;

public interface PrpDcompanyService {
	/**
	 * 查询机构，返回一个page对象
	 * @param pageNo 页数编码
	 * @param pageSize 每页大小
	 * @param paramsMap 查询参数
	 * @return
	 */
	Page findByPage(int pageNo, int pageSize, Map<String, Object> paramsMap);
	
}
