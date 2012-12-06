package com.sinosoft.ams.task_auth.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.ams.task_auth.model.GeRmsTaskAuth;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsTaskAuthRepository extends PagingAndSortingRepository<GeRmsTaskAuth, String>{
	
	@SQL("insert into GE_RMS_TASK_AUTH values(?1,?2,?3,?4,'e')")
	void InsertTask(String taskAuthID,String taskID,String comCode, String operateUser);
	
	@SQL("delete from GE_RMS_TASK_AUTH where comcode=?1 and taskid=?2")
	void deleteTask(String comCode,String taskId);
	
	@SQL("update GE_RMS_TASK_AUTH set flag='unempower' where comcode=?1 and taskid=?2")
	void updateTask(String comCode,String taskId);
	
	@SQL("select taskId from GE_RMS_TASK_AUTH where comcode=?1")
	List<String> findByComCode(String comCode);
	
	//根据角色id查询角色关联的授权
	@SQL("select * from GE_RMS_TASK_AUTH where taskAuthID in(select taskAuthID from ge_rms_roletask where roleid=?1)")
	List<GeRmsTaskAuth> findTaskAuthByRole(String roleId);
}
