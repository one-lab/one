package com.sinosoft.one.rms.service.picc;

import ins.framework.common.Page;



public interface GroupService {

	/**
	 * 查询用户组下成员(根据类型)
	 * @param groupId
	 * @param Type 0-5
	 * @param isValidate 0/1
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Page findEmployeByGroupType( String Type,String loginComCode,String userName,String comCode,String comCName,String isValidate,int pageSize,int pageNo);

}
