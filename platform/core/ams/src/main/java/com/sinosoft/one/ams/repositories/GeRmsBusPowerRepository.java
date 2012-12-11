package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.GeRmsBusPower;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsBusPowerRepository extends PagingAndSortingRepository<GeRmsBusPower, String>{
	
	@SQL("select * from GE_RMS_BUSPOWER where userPowerId = ?1 and taskId = ?2 and isValidate = '1'")
	List<GeRmsBusPower> findByUserPowerIdTaskId(String userPowerId,String taskId);
	
	@SQL("select dataRuleId from GE_RMS_BUSPOWER where userPowerId = ?1 and taskId = ?2 and isValidate = ?3")
	List<String> findDataRuleIdByUserPowerIdTaskId(String userPowerId,String taskId,String isValidate);
	
	@SQL("select * from GE_RMS_BUSPOWER where userPowerId = ?1 and taskId = ?2 and dataRuleId = ?3")
	GeRmsBusPower findByUserPowerIdTaskIdDataRuleId(String userPowerId,String taskId,String dataRuleId);
	
	@SQL("update GE_RMS_BUSPOWER set dataRuleParam = ?1 where busPowerId = ?2")
	public void updateBusPower(String dataRuleParam,String busPowerId);
	
	
}
