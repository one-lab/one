package com.sinosoft.one.rms.service.spring;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.model.Company;
import com.sinosoft.one.rms.service.facade.CompanyServiceInterface;


class CompanyService extends GenericDaoHibernate<Company, String> {
	
	/**
     * 查询下级直属机构
     * @param comCode
     * @return
     */
    List<Company>findNextSubCom(String comCode){
    	QueryRule queryRule = QueryRule.getInstance();
        queryRule.addEqual("upperComCode", comCode);
        queryRule.addAscOrder("comCode");
        return super.find(queryRule);
    }
	/**
	 * 判断是否有下属机构
	 * @return
	 */
	boolean isExtSubCom(String comCode){
		String sql="select count(1) from ge_rms_company t where t.uppercomcode='"+comCode+"'";
		Query query= super.getSession().createSQLQuery(sql);
		Object obj=(Object)query.uniqueResult();
		if(!obj.toString().equals("0")){
			return true;
		}
		return false;
	}
   
    /**
     *	查询4及机构 配送模块
     * @param comCode
     * @return
     */
    List<Company> findLevFourCom(String comCode){
    	if(comCode.length()<6){
    		return findNextSubCom(comCode);
    	}
    	QueryRule querycom = QueryRule.getInstance();
    	querycom.addLike("comCode", ""+comCode+"%D0");
    	return super.find(querycom);
    }
    
	public Company findCompanyByComCode(String comCode) {
		return super.get(comCode);
	} 
  

	List<Company> findAllNextLevelCompanybyComCode(String comCode){
		StringBuffer sql=new StringBuffer();
		sql.append("select comCode from ge_rms_company start with comCode='"+comCode+"' connect by prior comcode=upperComcode");
		Query query=super.getSession().createSQLQuery(sql.toString());
		sql.setLength(0);
		List<String>comCodes=new ArrayList<String>();
		comCodes=(List<String>)query.list();
		sql.append("from Company c where c.comCode in(");
		int i=0;
		for (i = 0; i < comCodes.size(); i++) {
			sql.append(" '" + comCodes.get(i) + "',");
			//每如果到了1000则用OR处理
			if(i%999==0&&i>=999){
				sql.delete(sql.length() - 1,sql.length());
				sql.append(")");
				sql.append(" or c.comCode in(");
			}
		}
		sql.delete(sql.length() - 1,sql.length());
		sql.append(")");
		return super.findByHql(sql.toString());
	}
	
	List<Company> findCompanyBySuperAndType(String SuppercomCode,String comType){
		QueryRule queryRule =QueryRule.getInstance();
		queryRule.addEqual("upperComCode", SuppercomCode);
		queryRule.addEqual("comType", comType);
		return super.find(queryRule);
	}
	
}
