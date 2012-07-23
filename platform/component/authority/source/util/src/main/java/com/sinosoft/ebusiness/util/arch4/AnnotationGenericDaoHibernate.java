package com.sinosoft.ebusiness.util.arch4;

import ins.framework.dao.GenericDaoHibernate;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 
 * 用于支持SessionFactory,且name必须为sessionFactory的autowired
 * @author qc
 * 
 */
public class AnnotationGenericDaoHibernate<T,PK> extends GenericDaoHibernate<Serializable,Serializable>{
	
	@Autowired
	public void init(@Qualifier(value="sessionFactory")SessionFactory factory) {
	    super.setSessionFactory(factory);
	}

}
