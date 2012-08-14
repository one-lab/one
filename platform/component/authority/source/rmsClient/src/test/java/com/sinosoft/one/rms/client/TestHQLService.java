package com.sinosoft.one.rms.client;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sinosoft.one.rms.model.Employe;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

public class TestHQLService extends GenericDaoHibernate<Employe, String> {
	
	public List findUser(){
		String str=" from Employe where userCode='admin' and comCode='00' ";
		super.findByHql(str.toString());
		return null;
	}

	public Page findUser(int pageNo, int pageSize) {
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("userCode", "admin");
		super.find(Employe.class,queryRule, pageNo, pageSize);
		return null;
	}
	
	public void findtest(){
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("userCode", "admin");
		super.find(queryRule);
	}
}
