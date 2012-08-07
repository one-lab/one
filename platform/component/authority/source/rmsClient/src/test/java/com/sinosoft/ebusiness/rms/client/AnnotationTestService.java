package com.sinosoft.ebusiness.rms.client;

import com.sinosoft.one.rms.client.annotation.DataAuthority;
import com.sinosoft.one.rms.client.arch4.RmsGenericDaoHibernate;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AnnotationTestService extends RmsGenericDaoHibernate<String,String> implements TestService{


    @DataAuthority(value = "004")
    public List  findUser() {
        return null;
    }

	@DataAuthority(value = "004")
	public Page findUser(int pageNo, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("company.comCode", "00");
        Page page=new Page();
        page=super.find(queryRule, pageNo, pageSize);
		return page;
	}

	@DataAuthority(value = "004")
	public Page find(int pageNo, int pageSize) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Employe where comcode='01'");
		return super.findByHql(hql.toString(), pageNo, pageSize);
	}
}
