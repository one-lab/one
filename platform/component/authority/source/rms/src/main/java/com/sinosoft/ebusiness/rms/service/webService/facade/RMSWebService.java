package com.sinosoft.ebusiness.rms.service.webService.facade;

import java.util.List;

import javax.jws.WebService;

import com.sinosoft.ebusiness.rms.service.webService.WebServiceDTO;

@WebService
public interface RMSWebService {
	 
	public List<String> webServiceSelectCom(String userCode, String passWord);
	public WebServiceDTO webServiceLogin(String userCode, String passWord,String comCode);
	 
}
