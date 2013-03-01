package com.sinosoft.one.monitor.action.domain;

import com.sinosoft.one.monitor.action.model.MailAction;
import com.sinosoft.one.monitor.action.model.SmsAction;
import com.sinosoft.one.monitor.action.repository.MailActionRepository;
import com.sinosoft.one.monitor.action.repository.SmsActionRepository;
import com.sinosoft.one.monitor.attribute.model.AttributeAction;
import com.sinosoft.one.monitor.attribute.repository.AttributeActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理动作业务逻辑类.
 * User: carvin
 * Date: 13-3-1
 * Time: 上午11:30
 */
@Service
public class ActionService {
	@Autowired
	private MailActionRepository mailActionRepository;
	@Autowired
	private SmsActionRepository smsActionRepository;
	@Autowired
	private AttributeActionRepository attributeActionRepository;

	/**
	 * 根据邮件ID列表查询邮件列表
	 * @param ids 邮件ID列表
	 * @return 邮件列表
	 */
	public Iterable<MailAction> queryMailActions(List<String> ids) {
		return mailActionRepository.findAll(ids);
	}

	/**
	 * 根据短信ID列表查询短信列表
	 * @param ids 短信ID列表
	 * @return 短信列表
	 */
	public Iterable<SmsAction> querySmsActions(List<String> ids) {
		return smsActionRepository.findAll(ids);
	}

	/**
	 * 根据资源ID、属性ID、严重程度查询动作信息
	 * @param resourceId 资源ID
	 * @param attributeId 属性ID
	 * @param severity 严重程度
	 * @return 动作信息
	 */
	public List<AttributeAction> queryAttributeActions(String resourceId, String attributeId, String severity) {
		return attributeActionRepository.findByResourceIdAndAttributeIdAndSeverity(resourceId, attributeId, severity);
	}

	/**
	 * 根据资源ID、属性ID、严重程度查询动作信息
	 * @param resourceId 资源ID
	 * @param attributeId 属性ID
	 * @return 动作信息
	 */
	public List<AttributeAction> queryAttributeActions(String resourceId, String attributeId) {
		return attributeActionRepository.findByResourceIdAndAttributeId(resourceId, attributeId);
	}
}
