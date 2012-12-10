package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.GeRmsUserPower;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsUserPowerRepository extends PagingAndSortingRepository<GeRmsUserPower, String>{
	
	@SQL("select comCode from GE_RMS_USERPOWER where userCode = ?1")
	List<String> findComCodeByUserCode(String userCode);
	
	@SQL("select userPowerId from GE_RMS_USERPOWER where userCode = ?1")
	List<String> findUserPowerIdByUserCode(String userCode);
	
	@SQL("select * from GE_RMS_USERPOWER where userCode = ?1 and comCode = ?2")
	GeRmsUserPower findUserPowerByUserCodeComCode(String userCode ,String comCode);
	
	
}
