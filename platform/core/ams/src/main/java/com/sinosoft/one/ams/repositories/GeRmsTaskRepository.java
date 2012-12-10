package com.sinosoft.one.ams.repositories;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsTaskRepository extends PagingAndSortingRepository<GeRmsTask, String>{
	@SQL("select * from GE_RMS_TASK where taskId in(select taskId from GE_RMS_TASK where parentId = 'RMS001')")
	List<GeRmsTask> findTackByTaskId();
	
	@SQL("select * from GE_RMS_TASK where taskId in(select taskId from GE_RMS_TASK where parentId = 'RMS001' or taskId = 'RMS001')")
	List<GeRmsTask> findTaskByTaskId();
	
	//根据parentId为空查询出Task集合
	@SQL("select * from GE_RMS_TASK where parentId is null")
	List<GeRmsTask> findTaskByParentId();
	
	//根据ParentId查询Task集合
	@SQL("select * from GE_RMS_TASK where parentId=?1")
	List<GeRmsTask> findTaskByParentId(String parentId);
	
	@SQL("select * from GE_RMS_TASK where parentId = ?1 and taskid in(select taskid from GE_RMS_TASK_AUTH where comcode=?2)")
	List<GeRmsTask> findChildTaskByParentId(String parentId,String upperComCode);
	
	@SQL("select * from GE_RMS_TASK where parentId is null")
	List<GeRmsTask> findChildTaskByParentId(String upperComCode);
	
	@SQL("select * from GE_RMS_TASK where parentid=?1 and taskid in(select taskid from GE_RMS_TASK_AUTH where comcode=?2)")
	List<GeRmsTask> findByParentIdTaskId(String parentId,String comCode);
	
	@SQL("select parentId from GE_RMS_TASK where taskId=?1")
	String findParentIdByTaskId(String taskId);
	
	//根据功能Id查询出功能对象
	@SQL("select * from GE_RMS_TASK where taskId = ?1")
	GeRmsTask findTaskByTaskId(String taskId);
	
	//根据powerId和comCode查出相应的功能
	@SQL("select * from GE_RMS_TASK where taskId not in(select taskId from GE_RMS_EXCPOWER where powerId = ?1) and taskId in(select taskId from GE_RMS_TASK_AUTH where comCode = ?2 or comCode = '*')")
	List<GeRmsTask> findTaskByPowerIdComCode(String powerId , String comCode);
	
	//根据功能ID查询功能对象
	@SQL("select * from GE_RMS_TASK where taskId in (?1)")
	List<GeRmsTask>findTaskByTaskAuthIds(List<String> taskIds);
		
	//查询机构下所有可用的功能
	@SQL("select * from GE_RMS_TASK where taskId in (select taskId from GE_RMS_TASK_AUTH where comcode=?1 or comCode='*')")
	List<GeRmsTask> findTaskByComCode(String comCode);
	
}
