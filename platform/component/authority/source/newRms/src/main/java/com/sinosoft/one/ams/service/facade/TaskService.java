package com.sinosoft.one.ams.service.facade;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.uiutil.NodeEntity;
import com.sinosoft.one.uiutil.Treeable;

@Service
public interface TaskService {
	
	/**
	 * 根据TaskId查询出Task对象
	 * 
	 * @param taskId
	 * @return
	 */
	public Task findTaskByTaskId(String taskId);
	
	/**
	 * 新建或修改功能，保存
	 * 
	 * @param task
	 * @param parentId
	 * @param taskAuth
	 */
	public void save(Task task,String parentId, TaskAuth taskAuth);
	
	/**
	 * 查询出全部功能
	 * 
	 * @return
	 */
	public List<Task> findAllTasks();
	
	/**
	 * 根据功能ID集合查询出功能
	 * 
	 * @param taskIds
	 * @param sysFlag
	 * @return
	 */
	public List<Task> findTaskByTaskId(List<String> taskIds,String sysFlag);
	
	/**
	 * 查询当前机构，当前用户组的根权限
	 * 
	 * @param roleids
	 * @param comCode
	 * @return
	 */
	public List<Task> findTaskByRoleIds(List<String> roleids,String comCode);
	
	/**
	 * 查询当前机构，当前用户组的根权限，并标记权限是否赋了给用户
	 * 
	 * @param roleids
	 * @param comCode
	 * @param userCode
	 * @return
	 */
	public List<Task> findTaskByRoleIds(List<String> roleids,String comCode ,String userCode);
	
	/**
	 * 根据角色ID查询功能taskId
	 * 
	 * @param roleids
	 * @return
	 */
	public List<String> findTaskIdByRoleIds(List<String> roleids);
	
	/**
	 * 构建功能树 topTasks父节点 filter所有节点
	 * 
	 * @param topTasks
	 * @param filter
	 * @return
	 */
	public  Treeable<NodeEntity> creatTaskTreeAble(List<Task> topTasks,Map<String,Task> filter);
	
	/**
	 * 查询当前机构的角色的根权限的后代权限
	 * 
	 * @param roleIdStr
	 * @param comCode
	 * @param taskId
	 * @return
	 */
	public Treeable<NodeEntity> getTreeable(String roleIdStr, String comCode,String taskId);
	
	/**
	 * 查询当前机构的角色的当前根权限的后代权限，并检查权限在权限除外表中是否存在
	 * 
	 * @param roleIdStr
	 * @param comCode
	 * @param userCode
	 * @param taskId
	 * @return
	 */
	public Treeable<NodeEntity> getTreeable(String roleIdStr, String comCode,String userCode ,String taskId);
	
	/**
	 * 根据角色的功能ID和机构ID查询出角色在此机构中的功能
	 * 
	 * @param roletaskids
	 * @param comCode
	 * @return
	 */
	public List<Task> getTasks(List<String> roletaskids,String comCode);
	
	/**
	 * 根据子功能ID查询父功能ID
	 * 
	 * @param taskId
	 * @return
	 */
	public String findParentIdBytaskId(String taskId);
}
