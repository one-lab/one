package com.sinosoft.one.monitor.application.domain;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.application.model.UrlTraceLog;
import com.sinosoft.one.monitor.application.model.UrlVisitsSta;
import com.sinosoft.one.monitor.application.repository.UrlTraceLogRepository;
import com.sinosoft.one.monitor.application.repository.UrlVisitsStaRepository;
import com.sinosoft.one.monitor.common.MessageBaseEventSupport;
import com.sinosoft.one.monitor.utils.DateUtil;
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
	@Autowired
	private MessageBaseEventSupport messageBaseEventSupport;

	/**
	 * 处理代理端日志消息
	 * @param applicationId 应用系统ID
	 * @param data 日志数据
	 */
	public void handleMessage(String applicationId, String data) {
		UrlTraceLog urlTraceLog = JSON.parseObject(data, UrlTraceLog.class);
		urlTraceLog.setApplicationId(applicationId);
		String alarmId = messageBaseEventSupport.doMessageBase(urlTraceLog);
		urlTraceLog.setAlarmId(alarmId);
		urlTraceLogRepository.save(urlTraceLog);
		UrlVisitsSta urlVisitsSta = urlVisitsStaRepository.findByUrlId(urlTraceLog.getUrlId());
		if(urlVisitsSta != null) {
			urlVisitsSta.increaseVisitNumber();
		} else {
			urlVisitsSta = new UrlVisitsSta();
			urlVisitsSta.setApplicationId(applicationId);
			urlVisitsSta.setRecordTime(DateUtil.getHoursDate(urlTraceLog.getBeginTime()));
			urlVisitsSta.setUrlId(urlTraceLog.getUrlId());
			urlVisitsSta.setVisitNumber(1);
		}

		urlVisitsStaRepository.save(urlVisitsSta);
	}
}
