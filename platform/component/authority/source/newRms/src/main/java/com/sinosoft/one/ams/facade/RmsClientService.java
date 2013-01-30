package com.sinosoft.one.ams.facade;


import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.User;

/**
 * 外部调用接口、同时为webService接口
 * 创建登陆用户
 * @author Administrator
 *
 */
@Service
public interface RmsClientService {
	 
	public User login(String userCode,String comCode,String sysFalg);
}
