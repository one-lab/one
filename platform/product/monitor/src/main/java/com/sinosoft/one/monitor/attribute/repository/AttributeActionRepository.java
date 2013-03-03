package com.sinosoft.one.monitor.attribute.repository;
// Generated 2013-3-1 10:54:17 by One Data Tools 1.0.0

import com.sinosoft.one.monitor.attribute.model.AttributeAction;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AttributeActionRepository extends PagingAndSortingRepository<AttributeAction, String> {
	/**
	 * 根据资源ID、属性ID、严重程度查询动作信息
	 * @param resourceId 资源ID
	 * @param attributeId 属性ID
	 * @param severity 严重程度
	 * @return 动作信息
	 */
	List<AttributeAction> findByResourceIdAndAttributeIdAndSeverity(String resourceId, String attributeId, String severity);

	/**
	 * 根据资源ID、属性ID、严重程度查询动作信息
	 * @param resourceId 资源ID
	 * @param attributeId 属性ID
	 * @return 动作信息
	 */
	List<AttributeAction> findByResourceIdAndAttributeId(String resourceId, String attributeId);
}

