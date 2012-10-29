package com.sinosoft.one.rms.client;

import ins.framework.common.Page;

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
public class AnnotationTestService implements TestService  {

	
	@DataAuthority("RMS001")
	public Page testFindByHql() {
		testFindByHqlforList();
		testFindByHqlNoLimit();
		return new Page();
	}
	@DataAuthority("RMS002")
	public List testFindByHqlforList() {
		System.out.println("do it---------------------------");
		testFindByHqlNoLimit();
		return null;
	}
	@DataAuthority("RMS001")
	public Page testFindByHqlNoLimit() {
		return null;
	}

	public List testFindTopByHql() {
		return null;
	}

	public void testGetAll() {
		
	}
}
