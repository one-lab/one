package com.sinosoft.one.ams.service.facade;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Service
public interface CompanyService {
	
	//根据Uppercomcode查询出Company对象集合
	public List<Company> findCompanyByUpperComCode(String uppercomcode);

	public List<Company> findAll();
	
	//构建功能树
	public  Treeable<NodeEntity> creatCompanyTreeAble(List<Company> topCompany,Map<String,Company> filter);
	
	public List<Company> findAllNextComBySupper(String uppercomcode);

	public Company findCompanyByComCode(String comCode);
	
	//根据userCode查询出用户已被引入的机构
	public Treeable<NodeEntity> findCompanyByUserCode(String userCode);
}
