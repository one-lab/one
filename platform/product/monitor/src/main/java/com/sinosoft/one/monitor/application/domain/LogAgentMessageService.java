package com.sinosoft.one.monitor.application.domain;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.application.model.UrlTraceLog;
import com.sinosoft.one.monitor.application.model.UrlVisitsSta;
import com.sinosoft.one.monitor.application.repository.UrlTraceLogRepository;
import com.sinosoft.one.monitor.application.repository.UrlVisitsStaRepository;
import com.sinosoft.one.monitor.common.MessageBaseEventSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日志代理端消息处理服务类.
 * User: carvin
 * Date: 13-3-4
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
@Service("logAgentMessageService")
public class LogAgentMessageService implements AgentMessageService {
	@Autowired
	private UrlTraceLogRepository urlTraceLogRepository;
	@Autowired
	private UrlVisitsStaRepository urlVisitsStaRepository;

	/**
	 * 处理代理端日志消息
	 * @param applicationId 应用系统ID
	 * @param data 日志数据
	 */
	public void handleMessage(String applicationId, String data) {
			UrlTraceLog urlTraceLog = JSON.parseObject(data, UrlTraceLog.class);
			urlTraceLog.setApplicationId(applicationId);
			String alarmId = MessageBaseEventSupport.build().doMessageBase(urlTraceLog);
			urlTraceLog.setAlarmId(alarmId);
			urlTraceLogRepository.save(urlTraceLog);
			UrlVisitsSta urlVisitsSta = urlVisitsStaRepository.findByUrlId(urlTraceLog.getUrlId());
			urlVisitsSta.increaseVisitNumber();
			urlVisitsStaRepository.save(urlVisitsSta);
	}
}
