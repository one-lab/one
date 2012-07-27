package com.sinosoft.ebusiness.rms.service.facade;

import java.util.List;

import com.sinosoft.ebusiness.rms.clientService.User;
import com.sinosoft.ebusiness.rms.model.Company;

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
	 public User getUserByUserCodeComCode(String userCode,String comCode);
	 /**
	  * 客户端远程调用 获得机构
	  * @param userCode
	  * @param passWord
	  * @return
	  */
	 public List<Company> findCompanysByUserCodeAnyPassword(String userCode, String passWord);
}
