package ins.product.service.facade;

import java.util.Map;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;

public interface PDLMRiskRelaService {

	Page findRelaRisk(int pageNo, int pageSize, HqlQueryRule hqlQueryRule);
	
	/**
	 * 
	 * @title findMainRisk
	 * @description 根据附加险编码查询主险
	 * @author xu_xinling
	 * @create date 2012-8-21
	 * @param pageNo
	 * @param pageSize
	 * @param paramsMap 
	 * @return
	 */
	Page findMainRisk(int pageNo, int pageSize, Map<String, Object> paramsMap);
}
