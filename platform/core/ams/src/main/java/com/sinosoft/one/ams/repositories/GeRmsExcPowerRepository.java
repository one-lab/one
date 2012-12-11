package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.GeRmsExcPower;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsExcPowerRepository extends PagingAndSortingRepository<GeRmsExcPower, String>{
	
	@SQL("select taskId from GE_RMS_EXCPOWER where powerId = ?1")
	List<String> findByPowerId(String powerId);

}
