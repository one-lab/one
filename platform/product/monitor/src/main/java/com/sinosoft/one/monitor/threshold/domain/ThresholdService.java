package com.sinosoft.one.monitor.threshold.domain;

import com.sinosoft.one.monitor.threshold.model.Threshold;
import com.sinosoft.one.monitor.threshold.repository.ThresholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 阈值信息处理业务逻辑类
 * User: carvin
 * Date: 13-3-1
 * Time: 上午10:38
 *
 */
@Service
public class ThresholdService {
	@Autowired
	private ThresholdRepository thresholdRepository;

	/**
	 * 根据资源ID以及属性ID得到阈值
	 * @param resourceId 资源ID
	 * @param attributeId 属性ID
	 * @return 阈值对象
	 */
	public Threshold queryThreshold(String resourceId, String attributeId) {
		return thresholdRepository.selectByResourceIdAndAttributeId(resourceId, attributeId);
	}
}
