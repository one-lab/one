package com.sinosoft.one.rms.clientService.facade;

import java.util.List;

import javax.jws.WebService;


import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.model.Company;

@WebService
public interface RmsClientService {
	 
	public List<Company> findCompanysByUserCodeAndPassword(String userCode, String passWord);
	public User login(String userCode,String comCode);
}
