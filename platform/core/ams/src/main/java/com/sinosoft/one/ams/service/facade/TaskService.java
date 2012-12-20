package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;

@Service
public interface TaskService {
	
	//根据TaskId查询出Task对象
	public Task findTaskByTaskId(String taskId);
	
	//新建或修改功能，保存
	public void save(Task task,String parentId, TaskAuth taskAuth);

	//_---------------------------------------//
	
	public List<Task> findAllTasks();
	
	
	public List<Task> findTaskByRoleIds(List<String> roleids,String comCode);
}
