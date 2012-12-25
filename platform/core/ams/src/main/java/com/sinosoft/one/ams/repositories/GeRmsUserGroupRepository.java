package com.sinosoft.one.ams.repositories;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.UserGroup;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsUserGroupRepository extends PagingAndSortingRepository<UserGroup, String>{
	
	@SQL("select userGropuId from GE_RMS_USERGROUP where userCode = ?1 and isValidate = '1'")
	List<String> findUserGroupIdByUserCode(String userCode);
	
}
