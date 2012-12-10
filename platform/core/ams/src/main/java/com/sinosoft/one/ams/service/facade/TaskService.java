package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.model.GeRmsTaskAuth;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;

@Service
public interface TaskService {
	
	public void pushTask(NodeEntity nodeEntity, List<GeRmsTask> taskList);
	
	public void recursionTask(NodeEntity nodeEntity, String parentId);
	
	GeRmsTask findTaskByTaskId(String taskId);
	
	public void save(GeRmsTask task, GeRmsTaskAuth taskAuth);
}
