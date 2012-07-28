package com.sinosoft.ebusiness.rms.clientService.facade;

import java.util.List;

import javax.jws.WebService;

import com.sinosoft.ebusiness.rms.clientService.User;
import com.sinosoft.ebusiness.rms.model.Company;

@WebService
public interface RmsClientService {
	 
	public List<Company> findCompanysByUserCodeAndPassword(String userCode, String passWord);
	public User login(String userCode,String comCode);
}
