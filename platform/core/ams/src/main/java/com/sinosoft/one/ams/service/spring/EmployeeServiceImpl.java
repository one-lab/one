package com.sinosoft.one.ams.service.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.repositories.CompanyDao;
import com.sinosoft.one.ams.repositories.UserDao;
import com.sinosoft.one.ams.service.facade.EmployeeService;
@Component
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	public Employe findEmployeByUserCode(String userCode) {
		Employe employe =new Employe();
		employe=userDao.findOne(userCode);
		Company company=companyDao.findOne(employe.getCompany().getComCode());
		employe.setCompany(company);
		return employe;
	}

}
