package com.sinosoft.test;

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
import com.sinosoft.one.rms.model.Employe;
import com.sinosoft.one.rms.model.UserPower;

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
		String hql="from Employe where company.comCode='00'";
		Page page= new Page();
		page=super.findByHql(hql, 1, 10);
		return page;
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
	@DataAuthority("RMS001")
	public void testGetAll() {
		super.getAll(UserPower.class);
	}
	@DataAuthority("RMS001")
	public void testFindBySql() {
		testSubMethod2();
//		String sql="select * from ge_rms_company start with comcode = '00' connect by nocycle prior comcode = uppercomcode";
		String sql = "select usercode ,username,comcode  from ( "+
        "select rownum rn, a.usercode ,a.username ,a.comcode from prpduser a " +
        "where not exists (select 1 from ge_rms_userpower b where a.USERCODE = b.comcode or b.comcode = '00' ) " +
        "and a.comcode in (select comcode from ge_rms_company start with comcode = '00' connect by prior comcode = uppercomcode )" + " order by a.comcode ,a.usercode ) " +
        " where rn > 10 and rn < 11 ";
		super.findBySql(sql);
		testSubMethod();
		testSubMethod3();
		testSubMethod();
	}
	@DataAuthority("RMS001")
	void testSubMethod(){
		String sql="select * from testProduct where comcode='11'";
		super.findBySql(sql);
	}
	
	void testSubMethod2(){
		String sql="select * from ge_rms_employe where usercode='11'";
		super.findBySql(sql);
	}
	@DataAuthority("RMS003")
	void testSubMethod3(){
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("userCode", "admin");
		super.find(Employe.class, queryRule);
	}
}
