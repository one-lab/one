package com.sinosoft.ams.role.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.ams.role.model.GeRmsRole;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsRoleRepository extends PagingAndSortingRepository<GeRmsRole, String>{
	
	@SQL("select * from GE_RMS_ROLE where roleId = ?1")
	GeRmsRole findByRoleId(String roleId);

}
