package com.sinosoft.one.ams.facade;


import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.User;




/**
 * 外部调用接口、同时为webService接口
 * 创建登陆用户
 * @author Administrator
 *
 */
@Component
public interface RmsClientService {
	 
	public User login(String userCode,String comCode,String sysFalg);
}
