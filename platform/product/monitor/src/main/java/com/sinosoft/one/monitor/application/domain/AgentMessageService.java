package com.sinosoft.one.monitor.application.domain;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.application.model.ExceptionInfo;
import com.sinosoft.one.monitor.application.model.UrlTraceLog;
import com.sinosoft.one.monitor.application.repository.ExceptionInfoRepository;
import com.sinosoft.one.monitor.application.repository.UrlTraceLogRepository;
import com.sinosoft.one.monitor.common.AlarmSource;
import com.sinosoft.one.monitor.common.MessageBaseEventSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Agent端消息服务类
 * User: carvin
 * Date: 13-3-3
 * Time: 下午11:46
 */
@Service
public class AgentMessageService {
	@Autowired
	private UrlTraceLogRepository urlTraceLogRepository;
	@Autowired
	private ExceptionInfoRepository exceptionInfoRepository;
	@Autowired
	private MessageBaseEventSupport messageBaseEventSupport;

	public void handleMessage(String applicationId, String notificationType, String data) {
		if(AlarmSource.LOG.name().equals(notificationType)) {
			UrlTraceLog urlTraceLog = JSON.parseObject(data, UrlTraceLog.class);
			String alarmId = messageBaseEventSupport.doMessageBase(urlTraceLog);
			urlTraceLog.setAlarmId(alarmId);
			urlTraceLogRepository.save(urlTraceLog);
		} else if(AlarmSource.EXCEPTION.name().equals(notificationType)) {
			ExceptionInfo exceptionInfo = JSON.parseObject(data, ExceptionInfo.class);
			String alarmId = messageBaseEventSupport.doMessageBase(exceptionInfo);
			exceptionInfo.setAlarmId(alarmId);
			exceptionInfoRepository.save(exceptionInfo);
		} else if(AlarmSource.URLRESPONSETIME.name().equals(notificationType)) {
			// 处理响应时间
		}
	}

}
