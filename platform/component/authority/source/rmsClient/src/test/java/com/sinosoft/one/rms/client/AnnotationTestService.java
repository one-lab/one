package com.sinosoft.one.rms.client;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.Collections;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.one.rms.client.annotation.DataAuthority;
import com.sinosoft.one.rms.client.arch4.RmsGenericDaoHibernate;
import com.sinosoft.one.rms.model.Employe;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class AnnotationTestService extends GenericDaoHibernate<Employe, String>implements TestService  {

	
	@DataAuthority("RMS001")
	public Page testFindByHql() {
		testFindByHqlforList();
		return new Page();
	}
	@DataAuthority("RMS002")
	public List testFindByHqlforList() {
		System.out.println("do it---------------------------");
		return null;
	}
	public Page testFindByHqlNoLimit() {
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("validStatus", "1");
		super.find(queryRule, 1, 10);
		return null;
	}

	public List testFindTopByHql() {
		
		return null;
	}

	public void testGetAll() {
		
	}
}
