package com.sinosoft.one.rms.client;

import ins.framework.common.Page;

import java.util.List;

public interface TestService {
	
	List findUser();

	Page findUser(int pageNo, int pageSize);

	Page findbyHql(int pageNo, int pageSize);
	
	public List findBySql();
}
