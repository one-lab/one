package com.sinosoft.one.rms.service.spring;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.List;

import org.hibernate.Query;

import com.sinosoft.one.rms.model.Company;


class CompanyService extends GenericDaoHibernate<Company, String> {
	
	/**
	 * 查询下级机构 包含当前机构
	 * @param comCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	List<Company>findComAndNextSubCom(String comCode){
//		QueryRule queryRule = QueryRule.getInstance();
//        queryRule.addEqual("upperComCode", comCode);
//        queryRule.addSql("or comCode='"+comCode+"'");
//        queryRule.addAscOrder("comCode");
        return super.findByHql("from Company c where c.upperComCode='"+comCode+"' or c.comCode='"+comCode+"'");
	}
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
  
}
