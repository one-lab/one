package com.sinosoft.ams.task.repositories;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.sinosoft.ams.task.model.GeRmsTask;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsTaskRepository extends PagingAndSortingRepository<GeRmsTask, String>{
	@SQL("select * from GE_RMS_TASK where taskId in(select parentid from GE_RMS_TASK where parentid!='RMS001' group by parentid)")
	List<GeRmsTask> findByTaskId();
	
	@SQL("select * from GE_RMS_TASK where parentId=?1")
	List<GeRmsTask> findByParentId(String parentId);
	
	@SQL("select * from GE_RMS_TASK where isasmenu='1' and taskid in(select taskid from GE_RMS_TASK_AUTH where comcode=?1)")
	List<GeRmsTask> findByIsasmenuTaskId(String comCode);
	
	@SQL("select * from GE_RMS_TASK where parentid=?1 and taskid in(select taskid from GE_RMS_TASK_AUTH where comcode=?2)")
	List<GeRmsTask> findByParentIdTaskId(String parentId,String comCode);
	
	@SQL("select parentId from GE_RMS_TASK where taskId=?1")
	String findByTaskId(String taskId);
	
}
