package com.sinosoft.one.monitor.attribute.domain;

import com.sinosoft.one.monitor.attribute.model.Attribute;
import com.sinosoft.one.monitor.attribute.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理属性业务逻辑类
 * User: carvin
 * Date: 13-3-1
 * Time: 上午11:34
 */
@Service
public class AttributeService {
	@Autowired
	private AttributeRepository attributeRepository;
	/**
	 * 根据资源类型以及属性名获取属性ID
	 * @param resourceType 资源类型
	 * @param attributeName 属性名
	 * @return 属性ID
	 */
	public String getAttributeId(String resourceType, String attributeName) {
		return attributeRepository.findByResourceTypeAndAttribute(resourceType, attributeName).getId();
	}

	/**
	 * 根据资源类型以及属性名获取属性对象
	 * @param resourceType 资源类型
	 * @param attributeName 属性名
	 * @return 属性对象
	 */
	public Attribute getAttribute(String resourceType, String attributeName) {
		return attributeRepository.findByResourceTypeAndAttribute(resourceType, attributeName);
	}
}