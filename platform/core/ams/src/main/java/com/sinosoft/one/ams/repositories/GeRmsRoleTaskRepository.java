package com.sinosoft.one.ams.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.RoleTask;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsRoleTaskRepository extends PagingAndSortingRepository<RoleTask, String>{

	@SQL("insert into GE_RMS_ROLETASK values(?1,?2,'1','')")
	void insertRoleTask(String roleId,String taskAuthId);
	
}
