package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Service
public interface CompanyService {
	
	//根据Uppercomcode查询出Company对象集合
	public List<Company> findCompanyByUpperComCode(String uppercomcode);

	//查询出全部机构
	public Treeable<NodeEntity> getTreeable();

}
