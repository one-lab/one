package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsTaskRepository extends PagingAndSortingRepository<Task, String>{
	
	@SQL("select parentId from GE_RMS_TASK where taskId=?1")
	String findParentIdByTaskId(String taskId);
	
	//根据功能ID查询功能对象
	@SQL("select * from GE_RMS_TASK where taskId in (?1) and isValidate='1'")
	List<Task>findTaskByTaskIds(List<String> taskIds);
		
}
