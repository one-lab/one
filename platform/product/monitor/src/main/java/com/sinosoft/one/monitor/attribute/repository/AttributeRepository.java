package com.sinosoft.one.monitor.attribute.repository;
// Generated 2013-3-1 10:54:17 by One Data Tools 1.0.0

import com.sinosoft.one.monitor.attribute.model.Attribute;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 属性信息持久化类
 */
public interface AttributeRepository extends PagingAndSortingRepository<Attribute, String> {
	/**
	 * 根据资源类型和属性得到属性对象
	 * @param resourceType 资源类型
	 * @param attribute 属性名
	 * @return 属性对象
	 */
	Attribute findByResourceTypeAndAttribute(String resourceType, String attribute);
}

