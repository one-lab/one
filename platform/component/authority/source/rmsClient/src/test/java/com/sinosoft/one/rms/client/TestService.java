package com.sinosoft.one.rms.client;


import ins.framework.common.Page;

import java.util.List;

import com.sinosoft.one.rms.model.Employe;

public interface TestService {
	
	public Page testFindByHql();

	public List testFindByHqlforList();

	
	public Page testFindByHqlNoLimit();

	public List testFindTopByHql();

	public void testGetAll();
}
