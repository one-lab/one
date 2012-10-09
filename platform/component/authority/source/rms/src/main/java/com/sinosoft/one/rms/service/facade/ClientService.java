package com.sinosoft.one.rms.service.facade;

import java.util.List;

import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.model.Company;

/**
 * 服务端包装接口
 * @author Administrator
 *
 */
public interface ClientService {
	 /**
	  * 客户端本地调用
	  * @param userCode
	  * @param password
	  * @param comCode
	  * @return
	  */
	 public User getUserByUserCodeComCode(String userCode,String comCode,String sysFlag);
	 
}
