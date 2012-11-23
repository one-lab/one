package com.sinosoft.one.rms.clientService.facade;


import javax.jws.WebService;


import com.sinosoft.one.rms.clientService.User;

/**
 * 外部调用接口、同时为webService接口
 * 创建登陆用户
 * @author Administrator
 *
 */
@WebService
public interface RmsClientService {
	 
	public User login(String userCode,String comCode,String sysFalg);
}
