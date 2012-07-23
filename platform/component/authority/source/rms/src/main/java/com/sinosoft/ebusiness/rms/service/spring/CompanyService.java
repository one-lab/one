package com.sinosoft.ebusiness.rms.service.spring;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.List;

import org.hibernate.Query;

import com.sinosoft.ebusiness.rms.model.Company;


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
  
//    /**
//     * 添加数据库数据
//     * @param str
//     */
//    void addData(List<String> str,int i){
//    	Session session = super.getSession();
//    	Company company=new Company();
//		company.setComCode(convert(str.get(0)));
//		company.setComCName(convert(str.get(2)));
//		company.setComEName(convert(str.get(1)));
//		company.setUpperComCode(convert(str.get(3)));
//		company.setComType(convert(str.get(4)));
//		company.setValidStatus(convert(str.get(5)));
//		session.save(company);
////		if (i % 10 == 0) {
////			session.flush();
////			session.clear();
////		}
//    }
//    
//    public String convert(String str) {
//    	String str1 = str.replace('"', ' ');
//    	return str1.trim();
//    }
}
