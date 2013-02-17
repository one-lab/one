package com.sinosoft.one.ams.service.facade;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.User;

/**
 * 服务端包装接口
 * @author Administrator
 *
 */
@Service
public interface GetUserService {
	 /**
	  * 获取用户接口
	  * @param userCode
	  * @param password
	  * @param comCode
	  * @return
	  */
	 public User getUserByUserCodeComCode(String userCode,String comCode,String sysFlag);
	 
}
