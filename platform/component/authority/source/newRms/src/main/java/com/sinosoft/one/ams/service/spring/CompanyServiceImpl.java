package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.UserPower;
import com.sinosoft.one.ams.repositories.CompanyDao;
import com.sinosoft.one.ams.repositories.GeRmsUserPowerRepository;
import com.sinosoft.one.ams.service.facade.CompanyService;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Component
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private GeRmsUserPowerRepository geRmsUserPowerRepository;

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
	
	public Company findCompanyByComCode(String comCode) {
		return companyDao.findOne(comCode);
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

	public List<Company> findAll() {
		return (List<Company>) companyDao.findAll();
	}

	public List<Company> findAllNextComBySupper(String uppercomcode) {
		List<Company> companies=new ArrayList<Company>();
		iteratorComapny(companies, uppercomcode);
		return companies;
	}

	
	void iteratorComapny(List<Company> campanys,String SupercomCode){
		
		List<String> comCodes=companyDao.findComCodeByUppercomcode(SupercomCode);
		if(comCodes.size()>0){
			List<Company> coms=(List<Company>) companyDao.findAll(comCodes);
			campanys.addAll(coms);
			for (String comCode : comCodes) {
				iteratorComapny(campanys, comCode);
			}
		}
		
	}

	//根据userCode查询出用户已被引入的机构
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Treeable<NodeEntity> findCompanyByUserCode(String userCode) {
		List<String> userPowerIds = geRmsUserPowerRepository.findUserPowerIdByUserCode(userCode);
		List<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		Treeable<NodeEntity> treeable =new Treeable.Builder(nodeEntitys,"id", "title", "children", "state").builder();
		
		if(!userPowerIds.isEmpty()){
			List<UserPower> userPowers = (List<UserPower>) geRmsUserPowerRepository.findAll(userPowerIds);
			
			List<String> comCodes = new ArrayList<String>();
			for(UserPower userPower : userPowers){
				comCodes.add(userPower.getComCode());
			}
			List<Company> companies = (List<Company>) companyDao.findAll(comCodes);
			
			for(Company company : companies){
				NodeEntity nodeEntity = new NodeEntity();
				nodeEntity.setId(company.getComCode());
				nodeEntity.setTitle(company.getComCName());
				nodeEntitys.add(nodeEntity);
			}
			
			
		}
		return treeable;
	}

	

}
