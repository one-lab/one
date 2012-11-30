package com.sinosoft.one.rms.service.spring;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.sinosoft.one.rms.model.Company;
import com.sinosoft.one.rms.service.facade.CompanyModelService;


public class CompanyServiceInterfaceImpl extends GenericDaoHibernate<Company, String> implements CompanyModelService {
	
	/**
	 * 查询下级机构 包含当前机构
	 * @param comCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Company> findComAndNextSubCom(String comCode) {
		 return super.findByHql("from Company c where c.upperComCode='"+comCode+"' or c.comCode='"+comCode+"'");
	}
	
	 /**
     * 查询下级直属机构获得机构对象
     * @param comCode
     * @return
     */
	public List<Company> findNextSubCompany(String comCode) {
		QueryRule queryRule = QueryRule.getInstance();
        queryRule.addEqual("upperComCode", comCode);
        queryRule.addAscOrder("comCode");
        return super.find(queryRule);
	}
	
	/**
     * 查询下级直属机构获得机构代码
     * @param comCode
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<String>findNextSubComCodes(String comCode){
		StringBuffer sql=new StringBuffer();
		sql.append("select comCode from ge_rms_company c where c.upperComCode='"+comCode+"'");
		List<String> comcodes=new ArrayList<String>();
		comcodes=(List<String>)getSession().createSQLQuery(sql.toString()).list();
		return comcodes;
	}
	
	
	/**
	 * 判断是否有下属机构
	 * @return
	 */
	public boolean isExtSubCom(String comCode) {
		String sql="select count(1) from ge_rms_company t where t.uppercomcode='"+comCode+"'";
		Query query= super.getSession().createSQLQuery(sql);
		Object obj=(Object)query.uniqueResult();
		if(!obj.toString().equals("0")){
			return true;
		}
		return false;
	}
	 /**
     *	根据机构代码查询其归属的4级机构
     * @param comCode
     * @return
     */
	public List<Company> findLevFourCom(String comCode) {
		if(comCode.length()<6){
    		return findNextSubCompany(comCode);
    	}
    	QueryRule querycom = QueryRule.getInstance();
    	querycom.addLike("comCode", ""+comCode+"%D0");
    	return super.find(querycom);
	}
	
	/**
     * 根据机构代码查询机构对象
     * @param <T>
     * @param comCode
     * @return
     */
	
	@SuppressWarnings("unchecked")
	public Company findCompanyByComCode(String comCode) {
		return  super.get(comCode);
	}
	
	/**
     * 根据机构代码查询所有下级机构的机构代码
     * @param comCode
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<String>findAllNextSubComCodesByComCode(String comCode){
		StringBuffer sql=new StringBuffer();
		sql.append("select comCode from ge_rms_company start with comCode='"+comCode+"' connect by prior comcode=upperComcode");
		List<String> comcodes=new ArrayList<String>();
		comcodes=(List<String>)getSession().createSQLQuery(sql.toString()).list();
		return comcodes;
	} 
	
	
    /**
     * 根据机构代码查询所有下级机构 
     * @param comCode
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<Company> findAllNextLevelCompanybyComCode(
			String comCode) {
		StringBuffer sql=new StringBuffer();
		sql.append("select comCode from ge_rms_company start with comCode='"+comCode+"' connect by prior comcode=upperComcode");
		Query query=super.getSession().createSQLQuery(sql.toString());
		sql.setLength(0);
		List<String>comCodes=new ArrayList<String>();
		comCodes=(List<String>)query.list();
		comCodes.add(comCode);
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
	
	 /**
     * 根据父类机构代码集合查询下级机构获得机构代码
     * @param comCode
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<String> findComCodebySuperComCode(List<String> comCodes) {
		StringBuffer comCodesSQL = new StringBuffer();
		comCodesSQL.append("select comCode from ge_rms_company where uppercomcode in (");
		int i=0;
		for (i = 0; i < comCodes.size(); i++) {
			comCodesSQL.append(" '" + comCodes.get(i) + "',");
			//每如果到了1000则用OR处理
			if(i%999==0&&i>=999){
				comCodesSQL.delete(comCodesSQL.length() - 1,comCodesSQL.length());
				comCodesSQL.append(")");
				comCodesSQL.append(" or uppercomcode in(");
			}
		}
		comCodesSQL.delete(comCodesSQL.length() - 1,comCodesSQL.length());
		comCodesSQL.append(")");
		List<String> subcomCodes=new ArrayList<String>();
		subcomCodes = (List<String>) getSession().createSQLQuery(comCodesSQL.toString()).list();
		return subcomCodes;
	}
	
	/**
     * 根据父机构代码 ，机构类型查询机构集合
     * @param SuppercomCode
     * @param comType
     * @return
     */
	public List<Company> findCompanyBySuperAndType(
			String SuppercomCode, String comType) {
		QueryRule queryRule =QueryRule.getInstance();
		queryRule.addEqual("upperComCode", SuppercomCode);
		queryRule.addEqual("comType", comType);
		return super.find(queryRule);
	}

	 /**
     * 根据机构代码集合查询机构
     * @param comCodes
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<Company> findCompanysByComcodes(
			List<String> comCodes) {
		QueryRule queryRuleComcode=QueryRule.getInstance();
		queryRuleComcode.addIn("comCode", comCodes);
		return super.find(Company.class, queryRuleComcode);
	}


}
