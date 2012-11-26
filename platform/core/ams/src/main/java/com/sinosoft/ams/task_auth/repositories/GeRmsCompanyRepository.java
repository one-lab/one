package com.sinosoft.ams.task_auth.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.ams.task_auth.model.GeRmsCompany;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsCompanyRepository extends PagingAndSortingRepository<GeRmsCompany, String> {
	
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode=?1")
	List<GeRmsCompany> findByUpperComCode(String UpperComCode);

	@SQL("select * from GE_RMS_COMPANY where ComCode=?1")
	GeRmsCompany findByComCode(String ComCode);
	
	


}	

