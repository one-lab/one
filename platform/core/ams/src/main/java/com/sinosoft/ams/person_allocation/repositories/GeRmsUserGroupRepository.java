package com.sinosoft.ams.person_allocation.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.ams.person_allocation.model.GeRmsUserGroup;
import com.sinosoft.ams.user_group.model.User;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsUserGroupRepository extends PagingAndSortingRepository<GeRmsUserGroup, String>{
	
	@SQL("select t2.* from GE_RMS_USERGROUP t1,GE_RMS_EMPLOYE t2 where t1.groupId = ?1 and t2.usercode = t1.usercode")
	Page<User> findUserByGroupId(String groupId,Pageable pageable);
	
	@SQL("select t2.* from GE_RMS_USERGROUP t1,GE_RMS_EMPLOYE t2 where t1.userCode = ?1 and t2.usercode = t1.usercode")
	Page<User> findUserByUserCode(String userCode,Pageable pageable);
}
