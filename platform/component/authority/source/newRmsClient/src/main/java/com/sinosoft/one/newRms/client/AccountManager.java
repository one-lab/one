package com.sinosoft.one.newRms.client;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.User;


/**
 * 公共使用业务接口 人员/机构
 * @author Administrator
 *
 */
@Service
public interface AccountManager {

	User findUserByLoginName(String loginName,String comCode,String sysFlag);

}
