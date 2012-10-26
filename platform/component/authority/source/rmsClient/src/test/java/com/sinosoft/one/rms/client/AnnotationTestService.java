package com.sinosoft.one.rms.client;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.orm.hibernate3.AbstractSessionFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.sinosoft.one.rms.client.annotation.DataAuthority;
import com.sinosoft.one.rms.client.annotation.RmsAspectBeanSelfAware;
import com.sinosoft.one.rms.client.arch4.RmsGenericDaoHibernate;
import com.sinosoft.one.rms.model.Employe;
import com.sinosoft.one.rms.model.Role;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */

public class AnnotationTestService extends RmsGenericDaoHibernate<Employe,String> implements TestService ,RmsAspectBeanSelfAware {

	private TestService self;
	
	public void setSelf(Object proxyBean) {
		if(self==null)
			self=(TestService)proxyBean;
	}
	
	@DataAuthority("RMS001")
	public Page testFindByHql() {
		testFindByHqlforList();
		StringBuffer HQL=new StringBuffer();
		HQL.append("select e from Employe e,Role where e.company.comCode='00' and  userCode in (select r.operateUser from Role r )");
		List<Employe> lEmployes=super.findByHql(HQL.toString());
		//List<Role> roles=super.findByHql(HQL.toString());
		return null;
	}
	@DataAuthority("RMS001")
	public List testFindByHqlforList() {
		System.out.println("do it---------------------------");
		return null;
	}

	public Page testFindByHqlNoLimit() {
		// TODO Auto-generated method stub
		return null;
	}

	public List testFindTopByHql() {
		// TODO Auto-generated method stub
		return null;
	}

	public void testGetAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	private QueryTranslatorFactory queryTranslatorFactory;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	String hqlParser(String originalHql){
		SessionFactoryImplementor realsessionFactory = (SessionFactoryImplementor)sessionFactory;
//		QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(originalHql, originalHql,
//		           Collections.EMPTY_MAP, (org.hibernate.engine.SessionFactoryImplementor)getSessionFactory());
//		        queryTranslator.compile(Collections.EMPTY_MAP, false);
		queryTranslatorFactory = realsessionFactory.getSettings().getQueryTranslatorFactory();
		QueryTranslator queryTranslator=queryTranslatorFactory.createQueryTranslator(originalHql, originalHql, Collections.EMPTY_MAP, (org.hibernate.engine.SessionFactoryImplementor)getSessionFactory());
		queryTranslator.compile(Collections.EMPTY_MAP, false);
		return  queryTranslator.getSQLString() ; 
	}
	
}
