package com.sinosoft.one.monitor.controllers.application.agent;

import com.sinosoft.one.monitor.application.domain.AgentMessageService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 代理端消息处理Controller.
 * User: carvin
 * Date: 13-3-3
 * Time: 下午10:31
 */
@Path("/agent")
public class AgentMessageController {
	@Autowired
	private AgentMessageService agentMessageService;
	@Post("/message")
	public Reply handleMessage(Invocation invocation) {
		String applicationId = invocation.getParameter("applicationId");
		String notificationType = invocation.getParameter("notificationType");
		String data = invocation.getParameter("data");

		try {
			agentMessageService.handleMessage(applicationId, notificationType, data);
		} catch (Throwable throwable) {
			return Replys.with("Exception");
		}
		return Replys.with("Success");
	}
}
