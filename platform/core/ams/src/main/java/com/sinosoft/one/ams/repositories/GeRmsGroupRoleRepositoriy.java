package com.sinosoft.one.ams.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.GeRmsGroupRole;
import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsGroupRoleRepositoriy extends
		PagingAndSortingRepository<GeRmsGroupRole, String> {

	@SQL("select t2.* from GE_RMS_GROUPROLE t1,GE_RMS_ROLE t2 where t1.groupId = ?1 and t2.roleId = t1.roleId")
	Page<GeRmsRole> findByGroupId(String groupId, Pageable pageable);
	
	@SQL("update GE_RMS_GROUPROLE set isvalidate = '0' where groupId = ?1")
	void updateIsvalidateByGroupId(String groupId);

}
