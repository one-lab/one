package com.sinosoft.one.ams.repositories;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.UserGroup;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsUserGroupRepository extends PagingAndSortingRepository<UserGroup, String>{
	
	//根据用户ID查询用户与组关系表ID
	@SQL("select userGropuId from GE_RMS_USERGROUP where userCode = ?1 and isValidate = '1'")
	List<String> findUserGroupIdByUserCode(String userCode);
	
	//删除相应的用户与组关系记录
	@SQL("delete from GE_RMS_USERGROUP where userGropuId in (?1)")
	void deleteUserPower(List<String> userGropuIds);
	
}
