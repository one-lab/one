package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.ExcPower;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsExcPowerRepository extends PagingAndSortingRepository<ExcPower, String>{
	
	//根据用户权限ID，查询功能ID
	@SQL("select taskId from GE_RMS_EXCPOWER where powerId = ?1 and isValidate = '1'")
	List<String> findTaskIdByPowerId(String powerId);
	
	//删除相应的权限除外表
	@SQL("delete from GE_RMS_EXCPOWER where excPowerId in (?1)")
	void deleteExcPower(List<String> excPowerIds);

}
