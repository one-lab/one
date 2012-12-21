package com.sinosoft.one.ams.service.facade;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Service
public interface TaskService {
	
	//根据TaskId查询出Task对象
	public Task findTaskByTaskId(String taskId);
	
	//新建或修改功能，保存
	public void save(Task task,String parentId, TaskAuth taskAuth);

	//_---------------------------------------//
	
	public List<Task> findAllTasks();
	
	
	public List<Task> findTaskByRoleIds(List<String> roleids,String comCode);
	
	//构建功能树 topTasks父节点 filter所有节点
	public  Treeable<NodeEntity> creatTaskTreeAble(List<Task> topTasks,Map<String,Task> filter);
	
	//查询当前机构的角色的当前根权限的后代权限
	public Treeable<NodeEntity> getTreeable(String roleIdStr, String comCode,String taskId);
}
