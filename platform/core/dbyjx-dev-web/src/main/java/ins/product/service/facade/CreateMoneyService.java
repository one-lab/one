package ins.product.service.facade;

import ins.product.model.PDLMCalMode;
import ins.product.vo.PDLMRiskDutyFactorValueVo;
import ins.product.vo.ToRiskDutyFactorVo;

import java.math.BigDecimal;
import java.util.List;

public interface CreateMoneyService {
	/**
	 * @title createPremium(保费计算公式)
	 * @description 通过算法公式和传递进来的要素值得到保费
	 * @author 朱超
	 * @param pdlmCalModes 算法公式集合
	 * @param pdlmRiskDutyFactorValueVos 要素值集合
	 * @return 保费
	 */
	public BigDecimal createPremium(List<PDLMCalMode> pdlmCalModes , List<PDLMRiskDutyFactorValueVo>pdlmRiskDutyFactorValueVos);
	/**
	 * @title createPDLMRiskDutyFactorVoList
	 * @description 通过ToRiskDutyFactorVo的集合得到PDLMRiskDutyFactorValueVo的集合
	 * @author 朱超
	 * @param toRiskDutyFactorVos：ToRiskDutyFactorVo的集合
	 * @return
	 */
	public List<PDLMRiskDutyFactorValueVo> createPDLMRiskDutyFactorVoList(List<ToRiskDutyFactorVo> toRiskDutyFactorVos);
}
