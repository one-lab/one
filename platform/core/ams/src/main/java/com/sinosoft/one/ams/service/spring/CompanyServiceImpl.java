package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.repositories.CompanyDao;
import com.sinosoft.one.ams.service.facade.CompanyService;

@Component
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDao companyDao;

	//根据Uppercomcode查询出comCode集合
	public List<Company> findCompanyByUpperComCode(String uppercomcode) {
		
		List<Company> company = new ArrayList<Company>();
		
		if(uppercomcode == null){
			company = (List<Company>) companyDao.findAll();
		}else{
			List<String> childComCode = companyDao.findComCodeByUppercomcode(uppercomcode);
			System.out.println("check---------------1");
			if(!childComCode.isEmpty()){
				company = (List<Company>) companyDao.findAll(childComCode);
			}
			System.out.println("check---------------2");
			
		}
		return company;
	}

}
