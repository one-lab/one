package ins.product.service.facade;

import com.sinosoft.one.mvc.web.Invocation;
import ins.platform.vo.QueryCodeVo;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.vo.ToRiskDutyFactorVo;

import java.util.List;

public interface PDLMRiskDutyFactorService {
	/**
	 * 增加险种责任要素记录(组合要素)，返回值为保存的记录，因为页面需要用到这些记录
	 * @param pdLmRiskDutyFactorList
	 * @return
	 */
	List<PDLMRiskDutyFactor> addRiskDutyFactor(
			List<PDLMRiskDutyFactor> pdLmRiskDutyFactorList, Invocation invocation);
	/**
	 * 根据riskCode和dutyCode得到险种责任要素
	 * @param riskCode
	 * @param dutyCode
	 * @return
	 */
	List<PDLMRiskDutyFactor> findFactorByRiskAndDuty(String riskCode,
			String dutyCode);
	/**
	 * 增加险种责任要素记录(单要素)，返回值为保存的记录，因为页面需要用到这些记录
	 * @param pdLMRiskDutyFactor
	 * @return
	 */
	PDLMRiskDutyFactor addRiskDutyFactor(PDLMRiskDutyFactor pdLMRiskDutyFactor, Invocation invocation);
	/**
	 * 
	 * @title findFactorDistinct
	 * @description 根据险种和责任查询要素，并且使用distinct去重
	 * @author 朱超
	 * @param riskCode 险种编码
	 * @param dutyCode 责任编码
	 * @return 通用vo类
	 */
	List<QueryCodeVo> findFactorDistinct(String riskCode, String dutyCode);
	/**
	 * @title findByFactorCodes
	 * @description 通过主键ToRiskDutyFactorVo的list集合里面含有risk,duty,factor得到PDLMRiskDutyFactor
	 * @author 朱超
	 * @param factorCodes
	 * @return
	 */
	List<PDLMRiskDutyFactor> findByFactorCodes(
			List<ToRiskDutyFactorVo> toRiskDutyFactorVos);

}
