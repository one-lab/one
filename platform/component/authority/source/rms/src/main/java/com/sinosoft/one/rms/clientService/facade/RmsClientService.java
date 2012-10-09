package com.sinosoft.one.rms.clientService.facade;


import javax.jws.WebService;


import com.sinosoft.one.rms.clientService.User;

@WebService
public interface RmsClientService {
	 
	public User login(String userCode,String comCode,String sysFalg);
}
