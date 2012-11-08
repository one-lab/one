package com.sinosoft.one.bpm.service.facade;

import java.util.List;
import java.util.Map;

import org.jbpm.task.query.TaskSummary;

public interface BpmService {

	public abstract long createProcess(String processId,
			Map<String, Object> params) throws Exception;

	public abstract List<TaskSummary> getTasks(String user) throws Exception;

	public abstract void submitTask(long taskId, String user, Map<String, Object> data)
			throws Exception;

	public abstract void startTask(long taskId, String user) throws Exception;

	public abstract void releaseTask(long taskId, String user) throws Exception;

	public String getBusinessId(long processInstanceId) throws Exception;

	public long getTaskId(String userId, String businessId) throws Exception;
	
}