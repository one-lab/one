package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;

@Service
public interface TaskService {
	
	public void pushTask(NodeEntity nodeEntity, List<Task> taskList);
	
	//利用递归将全部功能存入NodeEntity对象中
	public void recursionTask(NodeEntity nodeEntity, String parentId);
	
	public Task findTaskByTaskId(String taskId);
	
	//新建或修改功能，保存
	public void save(Task task, TaskAuth taskAuth);
}
