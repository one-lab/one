package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.GeRmsCompany;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsCompanyRepository extends PagingAndSortingRepository<GeRmsCompany, String> {
	
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode=?1")
	List<GeRmsCompany> findCompanyByUpperComCode(String UpperComCode);
	
	//查询上级机构Id为空的机构
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode is null")
	List<GeRmsCompany> findCompanyByUpperComCode();
	
	@SQL("select * from GE_RMS_COMPANY where ComCode=?1")
	GeRmsCompany findByComCode(String ComCode);
	
	//根据用户ID和UpperComCode查询用户为引入的机构
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode=?1 and comCode not in(select comCode from GE_RMS_USERPOWER where userCode = ?1)")
	List<GeRmsCompany> findCompanyByUpperComCodeUserCode(String UpperComCode,String userCode);
	
	//根据用户ID，且UpperComCode为空，查询用户为引入的机构
	@SQL("select * from GE_RMS_COMPANY where Uppercomcode is null and comCode not in(select comCode from GE_RMS_USERPOWER where userCode = ?1)")
	List<GeRmsCompany> findCompanyByUserCode(String userCode);
	
	
	
	

}	

