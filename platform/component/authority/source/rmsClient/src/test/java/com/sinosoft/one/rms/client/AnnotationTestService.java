package com.sinosoft.one.rms.client;

import com.sinosoft.one.rms.client.annotation.DataAuthority;
import com.sinosoft.one.rms.client.arch4.RmsGenericDaoHibernate;
import com.sinosoft.one.rms.model.Employe;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AnnotationTestService extends RmsGenericDaoHibernate<Employe,String> implements TestService  {

	@DataAuthority(value = "RMS001" )
	public List<Employe> testfindQueryRule(String user) {
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("validStatus", "1");
		return super.find(queryRule);
	}

	@DataAuthority(value = "RMS001",tabAlias="e")
	public List<Employe> testfindBySql(){
		String sql="select * from ge_rms_employe e where VALIDSTATUS in ('1','0')order by usercode";
		return super.findBySql(sql);
	}
	
	// 如果有内部包含的MODEL属性则需标注 如  hqlMod="Employe.company" 否则不标注
	@DataAuthority(value = "RMS012",hqlMod="Employe.company",tabAlias="a")
	public Page findbyHql(int pageNo, int pageSize) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Employe a where company.comCode='00' and company.comCode=(select comCode from Company where comCode='11') order by company.comCode");
		return super.findByHql(hql.toString(), pageNo, pageSize);
	}
	
	
    @DataAuthority(value = "RMS012" )
    public List  findUser() {
    	QueryRule queryRule=QueryRule.getInstance();
    	queryRule.addEqual("validStatus", "1");
 	  	return super.find(queryRule);
    }

	@DataAuthority(value = "RMS012" )
	public Page findUser(int pageNo, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("validStatus", "1");
        Page page;
        page=super.find(queryRule, pageNo, pageSize);
		return page;
	}
	
	
}
