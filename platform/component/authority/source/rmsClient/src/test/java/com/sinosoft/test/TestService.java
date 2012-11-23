package com.sinosoft.test;


import ins.framework.common.Page;

import java.util.List;

import com.sinosoft.one.rms.model.Employe;

public interface TestService {
	
	public Page testFindByHql();

	public List testFindByHqlforList();

	public void testFindBySql();
	public Page testFindByHqlNoLimit();

	public List testFindTopByHql();

	public void testGetAll();
}
