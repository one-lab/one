package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Company;

@Service
public interface CompanyService {
	
	//根据Uppercomcode查询出Company对象集合
	public List<Company> findCompanyByUpperComCode(String uppercomcode);


}
