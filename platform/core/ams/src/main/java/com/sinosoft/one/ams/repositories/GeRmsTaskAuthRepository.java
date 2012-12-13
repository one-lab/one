package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsTaskAuthRepository extends PagingAndSortingRepository<TaskAuth, String>{
	
	
	@SQL("delete from GE_RMS_TASK_AUTH where comcode=?1 and taskid=?2")
	void deleteTask(String comCode,String taskId);
	
	//修改功能授权
	@SQL("update GE_RMS_TASK_AUTH set comCode = ?1 where (comcode=?2 or comcode='*') and taskid=?3")
	void updateTaskAuth(String flag,String comCode,String taskId); 
	
	//根据机构ID查询出功能ID
	@SQL("select taskId from GE_RMS_TASK_AUTH where comcode=?1 or comCode='*'")
	List<String> findTaskIdByComCode(String comCode);
	
	//根据角色id查询角色关联的授权
	@SQL("select taskid from GE_RMS_TASK_AUTH where taskAuthID in(select taskAuthID from ge_rms_roletask where roleid=?1)")
	List<String> findTaskAuthByRole(String roleId);
	
	//查询已授权可用功能
	@SQL("select * from GE_RMS_TASK_AUTH where comCode in ('*',?1) and taskID in (?2)")
	List<TaskAuth> findTaskAuthByComCode(String comCode,List<String> taskids);
	
	//根据机构ID和功能ID查出taskAuthID
	@SQL("select taskAuthID from GE_RMS_TASK_AUTH where comCode = ?1 and taskId = ?2")
	String findTaskAuthIdByComCodeTaskId(String comCode , String taskId);
	
	//根据功能id删除TaskAuth对象
	@SQL("delete from GE_RMS_TASK_AUTH where taskid=?2")
	void deleteTaskAuth(String taskId);
	
}
