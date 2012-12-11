package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.model.GeRmsTaskAuth;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;

@Service
public interface TaskService {
	
	public void pushTask(NodeEntity nodeEntity, List<GeRmsTask> taskList);
	
	//利用递归将全部功能存入NodeEntity对象中
	public void recursionTask(NodeEntity nodeEntity, String parentId);
	
	public GeRmsTask findTaskByTaskId(String taskId);
	
	//新建或修改功能，保存
	public void save(GeRmsTask task, GeRmsTaskAuth taskAuth);
	
	//查询功能名称
	public String findNameByTaskId(String taskId);
}
