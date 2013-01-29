package com.sinosoft.one.ams.service.facade;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.uiutil.NodeEntity;
import com.sinosoft.one.uiutil.Treeable;

@Service
public interface CompanyService {
	
	/**
	 * 根据Uppercomcode查询出Company对象集合
	 * @param uppercomcode
	 * @return
	 */
	public List<Company> findCompanyByUpperComCode(String uppercomcode);

	/**
	 * 取得全部机构
	 * @return
	 */
	public List<Company> findAll();
	
	/**
	 * 构建机构树
	 * @param topCompany
	 * @param filter
	 * @return
	 */
	public  Treeable<NodeEntity> creatCompanyTreeAble(List<Company> topCompany,Map<String,Company> filter);
	
	/**
	 * 根据父机构ID查询全部子机构
	 * @param uppercomcode
	 * @return
	 */
	public List<Company> findAllNextComBySupper(String uppercomcode);

	/**
	 * 根据机构ID查询机构
	 * @param comCode
	 * @return
	 */
	public Company findCompanyByComCode(String comCode);
	
	/**
	 * 根据userCode查询出用户已被引入的机构
	 * @param userCode
	 * @return
	 */
	public Treeable<NodeEntity> findCompanyByUserCode(String userCode);
	
	/**
	 * 根据userCode查询用户已引入机构
	 * @param userCode
	 * @return
	 */
	public List<Company> findComsByUserCode(String userCode);
}
