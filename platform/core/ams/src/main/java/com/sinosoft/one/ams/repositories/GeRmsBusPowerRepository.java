package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.BusPower;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsBusPowerRepository extends PagingAndSortingRepository<BusPower, String>{
	
	//根据用户权限ID和数据规则ID，查询人员数据权限ID
	@SQL("select busPowerId from GE_RMS_BUSPOWER where userPowerId = ?1 and dataRuleId in(?2) and isValidate = '1'")
	List<String> findBusPowerIdByUserPowerIdTaskId(String userPowerId,String[] dataRuleIds);
	
	//根据用户权限ID，查询busPowerId
	@SQL("select busPowerId from GE_RMS_BUSPOWER where userPowerId = ?1 and isValidate = '1'")
	List<String> findBusPowerIdByUserPowerId(String userPowerId);
	
	
	
}
