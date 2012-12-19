package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.repositories.CompanyDao;
import com.sinosoft.one.ams.service.facade.CompanyService;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Component
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDao companyDao;

	//根据Uppercomcode查询出comCode集合
	public List<Company> findCompanyByUpperComCode(String uppercomcode) {
		
		List<Company> company = new ArrayList<Company>();
		
		if(uppercomcode == null){
			company = (List<Company>) companyDao.findAll();
		}else{
			List<String> childComCode = companyDao.findComCodeByUppercomcode(uppercomcode);
			if(!childComCode.isEmpty()){
				company = (List<Company>) companyDao.findAll(childComCode);
			}
			
		}
		return company;
	}
	
	//查询出全部机构
	public Treeable<NodeEntity> getTreeable() {
		
		List<Company> topCompany = new ArrayList<Company>();
		Map<String,Company> filter = new HashMap<String,Company>();
		List<Company> showCompany = (List<Company>) companyDao.findAll();
		for(Company company : showCompany){
			if(company.getUpperComCode() == null){
				topCompany.add(company);
			}
			filter.put(company.getComCode(), company);
			
		}
		
		return creatCompanyTreeAble(topCompany, filter);
	}
	
	
	/**
	 * 构建功能树 topCompany父节点 filter所有节点
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Treeable<NodeEntity> creatCompanyTreeAble(List<Company> topCompany,Map<String,Company> filter){
		List<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		nodeEntitys=creatSubNode(topCompany, filter);
		Treeable<NodeEntity> treeable =new Treeable.Builder(nodeEntitys,"id", "title", "children", "state").classField("classField").urlField("urlField").builder();
		return treeable;
	}
	
	List<NodeEntity> creatSubNode(List<Company> topCompany,Map<String,Company> filter){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		for (Company company : topCompany) {
			if(!filter.containsKey(company.getComCode()))
                continue;
			NodeEntity nodeEntity = new NodeEntity();
			nodeEntity.setId(company.getComCode());
			nodeEntity.setTitle(company.getComCName());
			List<Company> childCompany = findCompanyByUpperComCode(company.getComCode());
			if(!childCompany.isEmpty()){
				nodeEntity.setChildren(creatSubNode(childCompany,filter));
				
			}
				nodeEntitys.add(nodeEntity);
			}
		return nodeEntitys;
	}



	

}
