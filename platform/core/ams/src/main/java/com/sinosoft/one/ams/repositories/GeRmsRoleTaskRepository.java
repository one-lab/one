package com.sinosoft.one.ams.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.GeRmsRoleTask;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsRoleTaskRepository extends PagingAndSortingRepository<GeRmsRoleTask, String>{

	@SQL("insert into GE_RMS_ROLETASK values(?1,?2,'1','')")
	void insertRoleTask(String roleId,String taskAuthId);
	
}
