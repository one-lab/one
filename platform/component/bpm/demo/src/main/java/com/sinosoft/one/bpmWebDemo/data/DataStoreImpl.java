package com.sinosoft.one.bpmWebDemo.data;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.sinosoft.one.bpmWebDemo.domain.Combo;

public class DataStoreImpl extends HibernateDaoSupport implements DataStore {

	public void store(Combo c) throws Exception {
		this.getHibernateTemplate().save(c);
	}

	@SuppressWarnings("unchecked")
	public List<Combo> getCombos() {
		return this.getHibernateTemplate().find("from Combo");
	}
	
	public Combo getCombo(String comboCode) {
		return this.getHibernateTemplate().get(Combo.class, comboCode);
	}

}
