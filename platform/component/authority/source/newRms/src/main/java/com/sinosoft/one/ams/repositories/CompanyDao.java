package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface CompanyDao extends PagingAndSortingRepository<Company, String>{
	
	//根据Uppercomcode查询出子机构ID集合
	@SQL("select comCode from GE_RMS_COMPANY where Uppercomcode = ?1")
	List<String> findComCodeByUppercomcode(String Uppercomcode);
	
	//查询出全部机构的ID
	@SQL("select comCode from GE_RMS_COMPANY")
	List<String> findComCodeAll();

}
