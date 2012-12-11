package ins.product.service.facade;

import java.util.List;

import ins.product.model.PDLMRiskDutyRate;
import ins.product.vo.PDLMRiskDutyFactorValueVo;

public interface PDLMRiskDutyRateService {
	/**
	 * @title findOnlyOne
	 * @description 通过vo对象获得唯一的一个PDLMRiskDutyRate
	 * @author 朱超
	 * @param vo
	 * @return
	 */
	PDLMRiskDutyRate findOnlyOne(PDLMRiskDutyFactorValueVo vo);
	/**
	 * @title findSomeByFactorValueVo
	 * @description 通过PDLMRiskDutyFactorValueVo的集合得到 PDLMRiskDutyRate的集合
	 * @author 朱超
	 * @param vos PDLMRiskDutyFactorValueVo的集合
	 * @return
	 */
	List<PDLMRiskDutyRate> findSomeByFactorValueVo(
			List<PDLMRiskDutyFactorValueVo> vos);

}
