package com.sinosoft.one.rms.client;

import com.sinosoft.one.rms.client.annotation.DataAuthority;
import com.sinosoft.one.rms.client.arch4.RmsGenericDaoHibernate;
import com.sinosoft.one.rms.model.Employe;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;

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
public class AnnotationTestService extends RmsGenericDaoHibernate<Employe,String>implements TestService  {


    @DataAuthority(value = "RMS012" )
    public List  findUser() {
    	QueryRule queryRule=QueryRule.getInstance();
    	queryRule.addEqual("validStatus", "1");
    	super.find(queryRule);
        return null;
    }

	@DataAuthority(value = "RMS012")
	public Page findUser(int pageNo, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("company.comCode", "00");
        Page page;
        page=super.find(queryRule, pageNo, pageSize);
		return page;
	}
	@DataAuthority(value = "RMS012")
	public List findBySql(){
		String sql="select * from ge_rms_employe where VALIDSTATUS in ('1','0')order by usercode";
		super.findBySql(sql);
		return null;
	}
	
//	@DataAuthority(value = "RMS012" )
	public Page findbyHql(int pageNo, int pageSize) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Employe where userCode='admin' and  company.comCode ='11'");
		return super.findByHql(hql.toString(), pageNo, pageSize);
	}
	
	@DataAuthority(value = "RMS012" )
	public void findBySQL() {
		
	}
	
	
	
}
