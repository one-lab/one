package ins.product.service.facade;

import ins.product.model.PDLMDutyPayAddFee;
import ins.product.model.PDLMDutyPayAddFeeId;

public interface PDLMDutyPayAddFeeService {
	/**
	 * @title saveDutyPayAddFee
	 * @description 保存一条加费记录
	 * @author 朱超
	 * @param pdlmDutyPayAddFee
	 * @return
	 */
	PDLMDutyPayAddFee saveDutyPayAddFee(PDLMDutyPayAddFee pdlmDutyPayAddFee);
	/**
	 * @title updateDutyPayAddFee
	 * @description 更新一条加费记录
	 * @author 朱超
	 * @param pdlmDutyPayAddFee
	 * @return
	 */
	PDLMDutyPayAddFee updateDutyPayAddFee(PDLMDutyPayAddFee pdlmDutyPayAddFee);
	/**
	 * @title deleteDutyPayAddFee
	 * @description 删除一条加费记录
	 * @author 朱超
	 * @param pdlmDutyPayAddFee
	 * @return
	 */
	String deleteDutyPayAddFee(PDLMDutyPayAddFee pdlmDutyPayAddFee);
	/**
	 * @title findByPK
	 * @description T
	 * 
	 * @author Administrator
	 * @param id
	 * @return
	 */
	PDLMDutyPayAddFee findByPK(PDLMDutyPayAddFeeId id);

}
