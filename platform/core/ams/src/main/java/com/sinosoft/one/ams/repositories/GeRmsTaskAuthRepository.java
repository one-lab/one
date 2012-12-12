package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsTaskAuthRepository extends PagingAndSortingRepository<TaskAuth, String>{
	
	@SQL("insert into GE_RMS_TASK_AUTH values(?1,?2,?3,?4,'e')")
	void InsertTask(String taskAuthID,String taskID,String comCode, String operateUser);
	
	@SQL("delete from GE_RMS_TASK_AUTH where comcode=?1 and taskid=?2")
	void deleteTask(String comCode,String taskId);
	
	@SQL("update GE_RMS_TASK_AUTH set flag='unempower' where comcode=?1 and taskid=?2")
	void updateTask(String comCode,String taskId);
	
	//根据机构ID查询出功能ID
	@SQL("select taskId from GE_RMS_TASK_AUTH where comcode=?1")
	List<String> findTaskIdByComCode(String comCode);
	
	//根据角色id查询角色关联的授权
	@SQL("select * from GE_RMS_TASK_AUTH where taskAuthID in(select taskAuthID from ge_rms_roletask where roleid=?1)")
	List<TaskAuth> findTaskAuthByRole(String roleId);
	
	//查询已授权可用功能
	@SQL("select * from GE_RMS_TASK_AUTH where comCode in ('*',?1) and taskID in (?2)")
	List<TaskAuth> findTaskAuthByComCode(String comCode,List<String> taskids);
	
}
