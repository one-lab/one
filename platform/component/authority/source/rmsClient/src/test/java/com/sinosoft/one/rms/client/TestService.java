package com.sinosoft.one.rms.client;


import ins.framework.common.Page;

import java.util.List;

import com.sinosoft.one.rms.model.Employe;

public interface TestService {
	
	public List<Employe> testfindQueryRule(String userCode);

	public  List<Employe> testfindBySql();
	
//	Page findUser(String hql,int pageNo, int pageSize);
//
	public Page findbyHql(int pageNo, int pageSize);
	
	
}
