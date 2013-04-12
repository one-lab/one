package com.sinosoft.one.bpm.service.spring;

import java.util.List;
import java.util.Map;

import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.task.TaskService;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.ContentData;
import org.jbpm.task.utils.ContentMarshallerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.bpm.aspect.Variable;
import com.sinosoft.one.bpm.service.facade.BpmService;
import com.sinosoft.one.bpm.util.BpmServiceSupport;
import com.sinosoft.one.bpm.variable.VariableHandler;
import com.sinosoft.one.bpm.variable.VariableHandlerFactory;

public class BpmServiceImplement implements BpmService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private BpmServiceSupport bpmServiceSupport;

	/*
	 * 用BpmServiceSupport的session创建流程
	 * 
	 * @see
	 * com.sinosoft.ebusiness.bpm.service.spring.BpmService#createProcess(java
	 * .lang.String, java.util.Map)
	 */
	public long createProcess(String processId, Map<String, Object> params)
			throws Exception {
		StatefulKnowledgeSession ksession = bpmServiceSupport.getSession();
		ProcessInstance pi = ksession.startProcess(processId, params);
		ksession.fireAllRules();
		return pi.getId();
	}

	/*
	 * 用BpmServiceSupport的server获取任务
	 * 
	 * @see
	 * com.sinosoft.ebusiness.bpm.service.spring.BpmService#getTasks(java.lang .String)
	 */
	public List<TaskSummary> getTasks(String user) throws Exception {
		TaskService taskService = bpmServiceSupport.getTaskService();
		List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner(
				user, "en-UK");
		return tasks;
	}

	/*
	 * 用BpmServiceSupport的server提交任务
	 * 
	 * @see
	 * com.sinosoft.ebusiness.bpm.service.spring.BpmService#submitTask(long,
	 * java.lang.String, java.util.HashMap)
	 */
	public void submitTask(long taskId, String user, Map<String, Object> data)
			throws Exception {
		ContentData contentData = null;
		if (data != null) {
			try {
				contentData = ContentMarshallerHelper.marshal(data, bpmServiceSupport.currentEnvironment());
			} catch (Exception e) {
				logger.error("submit task exception. task id : " + taskId, e);
                throw new Exception(e);
			}
		}
		TaskService taskService = bpmServiceSupport.getTaskService();
		taskService.complete(taskId, user, contentData);
	}

	/*
	 * 用bpmServiceSupport的server开启任务
	 * 
	 * @see com.sinosoft.ebusiness.bpm.service.spring.BpmService#startTask(long,
	 * java.lang.String)
	 */
	public void startTask(long taskId, String userId) throws Exception {
		TaskService taskService = bpmServiceSupport.getTaskService();
		taskService.start(taskId, userId);
	}

	/*
	 * 用bpmServiceSupport的server回退任务
	 * 
	 * @see
	 * com.sinosoft.ebusiness.bpm.service.spring.BpmService#releaseTask(long,
	 * java.lang.String)
	 */
	public void releaseTask(long taskId, String userId) throws Exception {
		TaskService taskService = bpmServiceSupport.getTaskService();
		taskService.release(taskId, userId);
	}

	/*
	 * 从session中的流程实例中获取业务id
	 * 
	 * @see
	 * com.sinosoft.ebusiness.bpm.service.spring.BpmService#getBusinessId(long)
	 */
	public String getBusinessId(long processInstanceId) throws Exception {
		return bpmServiceSupport.getBusinessId(processInstanceId);
	}

	/*
	 * 获取与业务id对应的task 编号
	 * 
	 * @see
	 * com.sinosoft.ebusiness.bpm.service.spring.BpmService#getBusinessId(java
	 * .lang.String,java.lang.String)
	 */
	public long getTaskId(String userId, String businessId) throws Exception {
		long taskId = -1;
		List<TaskSummary> tasks = this.getTasks(userId);
		for (TaskSummary task : tasks) {
			long processInstanceId = task.getProcessInstanceId();
			if (businessId.equals(this.getBusinessId(processInstanceId))) {
				taskId = task.getId();
				break;
			}
		}
		if(taskId == -1) {
			throw new RuntimeException("No any task find for userId : " + userId + ", businessId : " + businessId);
		}
		return taskId;
	}
	
	public void doVariable(Object[] args, Variable variable) throws Exception {
		VariableHandler variableHandler = VariableHandlerFactory.buildVariableHandler(variable.type(), bpmServiceSupport);
		variableHandler.handler(args, variable);
	}

	public void setBpmServiceSupport(BpmServiceSupport bpmServiceSupport) {
		this.bpmServiceSupport = bpmServiceSupport;
	}
}
