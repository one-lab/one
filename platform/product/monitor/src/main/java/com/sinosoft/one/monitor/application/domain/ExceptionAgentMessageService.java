package com.sinosoft.one.monitor.application.domain;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.application.model.ExceptionInfo;
import com.sinosoft.one.monitor.application.repository.ExceptionInfoRepository;
import com.sinosoft.one.monitor.common.MessageBaseEventSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 异常代理端消息处理服务类.
 * User: carvin
 * Date: 13-3-4
 * Time: 下午5:06
 */
@Service("exceptionAgentMessageService")
public class ExceptionAgentMessageService implements AgentMessageService{
	@Autowired
	private ExceptionInfoRepository exceptionInfoRepository;

	/**
	 * 处理代理端异常消息
	 * @param applicationId 应用系统ID
	 * @param data 异常数据
	 */
	public void handleMessage(String applicationId, String data) {
		ExceptionInfo exceptionInfo = JSON.parseObject(data, ExceptionInfo.class);
		exceptionInfo.setApplicationId(applicationId);
		String alarmId = MessageBaseEventSupport.build().doMessageBase(exceptionInfo);
		exceptionInfo.setAlarmId(alarmId);
		exceptionInfoRepository.save(exceptionInfo);
	}
}
