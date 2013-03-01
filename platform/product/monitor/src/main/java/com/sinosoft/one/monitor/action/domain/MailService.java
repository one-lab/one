package com.sinosoft.one.monitor.action.domain;

import com.sinosoft.one.monitor.action.model.MailAction;
import com.sinosoft.one.monitor.action.model.MailInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 邮件服务类
 * User: carvin
 * Date: 13-3-1
 * Time: 下午8:30
 */
@Service
public class MailService {
	public void doMailAction(List<MailAction> mailActionList, MailInfo mailInfo) {
		// 发送邮件
	}
}
