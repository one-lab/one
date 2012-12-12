package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsCompanyRepository extends PagingAndSortingRepository<Company, String> {
	
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode=?1")
	List<Company> findCompanyByUpperComCode(String UpperComCode);
	
	//查询上级机构Id为空的机构
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode is null")
	List<Company> findCompanyByUpperComCode();
	
	@SQL("select * from GE_RMS_COMPANY where ComCode=?1")
	Company findByComCode(String ComCode);
	
	//根据用户ID和UpperComCode查询用户为引入的机构
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode=?1 and comCode not in(select comCode from GE_RMS_USERPOWER where userCode = ?1)")
	List<Company> findCompanyByUpperComCodeUserCode(String UpperComCode,String userCode);
	
	//根据用户ID，且UpperComCode为空，查询用户为引入的机构
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode is null and comCode not in(select comCode from GE_RMS_USERPOWER where userCode = ?1)")
	List<Company> findCompanyByUserCode(String userCode);
	
	
	
	

}	

