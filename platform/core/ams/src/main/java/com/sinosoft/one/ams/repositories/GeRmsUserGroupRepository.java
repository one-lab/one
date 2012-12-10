package com.sinosoft.one.ams.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.GeRmsUserGroup;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsUserGroupRepository extends PagingAndSortingRepository<GeRmsUserGroup, String>{
	
	@SQL("select t2.* from GE_RMS_USERGROUP t1,GE_RMS_EMPLOYE t2 where t1.groupId = ?1 and t2.usercode = t1.usercode")
	Page<User> findUserByGroupId(String groupId,Pageable pageable);
	
	@SQL("select * from GE_RMS_EMPLOYE where userCode like ?1 and usercode in (select userCode from GE_RMS_USERGROUP where groupId = ?2)")
	Page<User> findUserByUserCode(String userCode,String groupId,Pageable pageable);
	
	@SQL("update GE_RMS_USERGROUP set isvalidate = '0' where userCode = ?1 and groupId = ?2")
	void updateIsvalidateByUserCodeGroupId(String userCode,String groupId);
}
