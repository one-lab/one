package ins.platform.service.facade;

import java.util.Map;

import ins.framework.common.Page;
import ins.product.model.PDLDcode1;
import ins.product.model.PDLDcode1Id;

public interface PdLdCodeService {
	/**
	 * 查询产品代码表中的数据得到相对应的记录
	 * @param pageNo 第几页
	 * @param pageSize  页面大小
	 * @param hqlQueryRule  对应的字段是哪个,参数
	 * @return
	 */
	Page findByCode(int pageNo, int pageSize,  Map<String, Object> paramsMap);

	PDLDcode1 findByPK(PDLDcode1Id ID); 
}
