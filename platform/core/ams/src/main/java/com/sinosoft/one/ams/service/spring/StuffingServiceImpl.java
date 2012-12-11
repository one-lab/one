package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.GeRmsBusPower;
import com.sinosoft.one.ams.model.GeRmsCompany;
import com.sinosoft.one.ams.model.GeRmsDataRule;
import com.sinosoft.one.ams.model.GeRmsGroup;
import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.model.GeRmsUserPower;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.ams.repositories.GeRmsBusPowerRepository;
import com.sinosoft.one.ams.repositories.GeRmsCompanyRepository;
import com.sinosoft.one.ams.repositories.GeRmsDataRuleRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRepository;
import com.sinosoft.one.ams.repositories.GeRmsRoleRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.repositories.GeRmsUserPowerRepository;
import com.sinosoft.one.ams.repositories.UserDao;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.service.facade.StuffingService;
import com.sinosoft.one.ams.utils.uiutil.Gridable;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;

@Component
public class StuffingServiceImpl implements StuffingService{
	
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private GeRmsBusPowerRepository geRmsBusPowerRepository;
	@Autowired
	private GeRmsCompanyRepository geRmsCompanyRepository;
	@Autowired
	private GeRmsGroupRepository geRmsGroupRepository;
	@Autowired
	private GeRmsRoleRepository geRmsRoleRepository;
	@Autowired
	private GeRmsUserPowerRepository geRmsUserPowerRepository;
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private GeRmsDataRuleRepository geRmsDataRuleRepository;
	@Autowired
	private UserDao userDao;
	
	//保存数据设置
	public String saveBusPower(GeRmsBusPower busPower, String[] ruleIdArr,String[] paramArr, String userPowerId, String taskId) {
		
		List<String> dataRuleIdList = geRmsBusPowerRepository.findDataRuleIdByUserPowerIdTaskId(userPowerId, taskId,"1");
		
		if(dataRuleIdList != null){
			for(int i = 0; i<ruleIdArr.length;i++){
				if(!dataRuleIdList.contains(ruleIdArr[i])){
					
					busPower.setBusPowerID(ruleIdArr[i]+taskId);
					busPower.setDataRuleID(ruleIdArr[i]);
					busPower.setUserPowerID(userPowerId);
					busPower.setTaskID(taskId);
					busPower.setDataRuleParam(paramArr[i]);
					busPower.setIsValidate("1");
					
					geRmsBusPowerRepository.save(busPower);
				}else if(dataRuleIdList.contains(ruleIdArr[i])){
					busPower = geRmsBusPowerRepository.findByUserPowerIdTaskIdDataRuleId(userPowerId, taskId, ruleIdArr[i]);
					busPower.setDataRuleParam(paramArr[i]);
					geRmsBusPowerRepository.updateBusPower(paramArr[i], busPower.getBusPowerID());
				}
			}
			for(String dataRuleId : dataRuleIdList){
				if(!isIn(dataRuleId,ruleIdArr)){
					busPower = geRmsBusPowerRepository.findByUserPowerIdTaskIdDataRuleId(userPowerId, taskId, dataRuleId);
					geRmsBusPowerRepository.delete(busPower);
				}
			}
		}
		
		return "success";
	}
	
	public static boolean isIn(String substring, String[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			String aSource = arr[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
		return false;
	}

	//递归机构，并将机构保存在NodeEntity中
	public void recursionCompany(NodeEntity nodeEntity, String comCode,String userCode) {
		// TODO Auto-generated method stub
		List<GeRmsCompany> companies = null;
		if(comCode != null){
			companies = geRmsCompanyRepository.findCompanyByUpperComCodeUserCode(comCode, userCode);
			
		}else{
			companies = geRmsCompanyRepository.findCompanyByUserCode(userCode);
		}
		
		if (companies != null) {
			pushCompany(nodeEntity, companies);
			for (NodeEntity ne : nodeEntity.getChildren()) {
				recursionCompany(ne, ne.getId(), userCode);
			}
		}
		
	}
	
	//将机构保存在NodeEntity对象中
	public void pushCompany(NodeEntity nodeEntity, List<GeRmsCompany> companies) {
		// TODO Auto-generated method stub
		List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();
		for (GeRmsCompany company : companies) {

			NodeEntity ne = new NodeEntity();
			ne.setId(company.getComCode());
			ne.setTitle(company.getComCName());
			nodeEntities.add(ne);
		}
		nodeEntity.setChildren(nodeEntities);
	}

	public List<GeRmsGroup> findGroupByComCode(String comCode) {
		// TODO Auto-generated method stub
		List<GeRmsGroup> groupList = geRmsGroupRepository.findGroupByComCode(comCode);
		return groupList;
	}

	public List<GeRmsRole> findRoleByGroupId(String groupId) {
		// TODO Auto-generated method stub
		List<GeRmsRole> groupRoleList = geRmsRoleRepository.findRoleByGroupId(groupId);
		System.out.println(groupRoleList.size()+"===================================");
		return groupRoleList;
	}
	
	//将数据库中的用户记录查出，并保存在Gridable对象中返回
	public Gridable<User> getGridable(Gridable<User> gridable, Pageable pageable, List<String> userAttribute) {
		// TODO Auto-generated method stub
		
		Page<User> page = userDao.findAll(pageable);
		List<User> userList = page.getContent();
		String button = "<a href='javascript:;' class='set' onclick='openQX(this);'>权限设置</a><a href='#' class='set' onclick='openSJ(this);'>数据设置</a>";
		String button2 = "<a href='#' class='agency' onclick='openWindow()'></a>";
		for(User user: userList){
			user.setButton(button);
			user.setButton2(button2);
			String comCode = user.getComCode();
			GeRmsCompany com = geRmsCompanyRepository.findOne(comCode);
			user.setComCName(com.getComCName());
		}
		gridable.setPage(page);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("comCName");
		userAttribute.add("button2");
		userAttribute.add("button");
		gridable.setCellListStringField(userAttribute);
		
		return gridable;
	}

	//根据userCode和comCode，将数据库中的用户记录查出，并保存在Gridable对象中返回
	//可以进行模糊查询
	public Gridable<User> getGridable(Gridable<User> gridable, String userCode,
			String comCode, Pageable pageable, List<String> userAttribute) {
		// TODO Auto-generated method stub
		
		Page<User> page = null;
		
		if(userCode.equals("null") && comCode.equals("null")){
			
			page = userDao.findAll(pageable);
		}else if(!userCode.equals("null") && comCode.equals("null")){
			
			page = userDao.searchUserByUserCode("%"+userCode+"%", pageable);
		}else if(userCode.equals("null") && !comCode.equals("null")){
			
			page = userDao.searchUserByComCode("%"+comCode+"%", pageable);
		}else {
			
			page = userDao.searchUserByComCodeUserCode(comCode, userCode, pageable);
		}
		List<User> userList = page.getContent();
		String button = "<a href='javascript:;' class='set' onclick='openQX(this);'>权限设置</a><a href='#' class='set' onclick='openSJ(this);'>数据设置</a>";
		String button2 = "<a href='#' class='agency' onclick='openWindow()'></a>";
		for(User user: userList){
			user.setButton(button);
			user.setButton2(button2);
			String comCodeUser = user.getComCode();
			GeRmsCompany com = geRmsCompanyRepository.findOne(comCodeUser);
			user.setComCName(com.getComCName());
		}
		gridable.setPage(page);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("comCName");
		userAttribute.add("button2");
		userAttribute.add("button");
		gridable.setCellListStringField(userAttribute);
		
		return gridable;
	}

	//将功能保存在NodeEntity对象中
	public void pushTask(NodeEntity nodeEntity, List<GeRmsTask> taskList) {
		// TODO Auto-generated method stub
		
		List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();
		for (GeRmsTask task : taskList) {
			
			NodeEntity ne = new NodeEntity();
			ne.setId(task.getTaskID());
			ne.setTitle(task.getName());
			nodeEntities.add(ne);
		}
		nodeEntity.setChildren(nodeEntities);
	}

	//根据userCode和company查询GeRmsUserPower对象并保存在NodeEntity对象中
	public void pushUserPower(NodeEntity nodeEntity, List<GeRmsCompany> companies,
			String userCode) {
		// TODO Auto-generated method stub
		
		List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();
		for (GeRmsCompany company : companies) {
			
			GeRmsUserPower userPower = geRmsUserPowerRepository.findUserPowerByUserCodeComCode(userCode, company.getComCode());
			NodeEntity ne = new NodeEntity();
			ne.setId(userPower.getUserPowerID());
			ne.setTitle(company.getComCName());
			ne.setFlag(company.getComCode());
			nodeEntities.add(ne);
		}
		nodeEntity.setChildren(nodeEntities);
		
	}
	
	//根据userCode和comCode,经用户已引入的机构的功能存入相应的机构中
	public NodeEntity getNodeEntity(NodeEntity nodeEntity, String userCode,
			List<GeRmsCompany> companyList, List<GeRmsUserPower> userPowerList) {
		// TODO Auto-generated method stub
		
		List<String> comCodeList = geRmsUserPowerRepository.findComCodeByUserCode(userCode);
		for(String comCode : comCodeList){
			GeRmsCompany company = geRmsCompanyRepository.findOne(comCode);
			companyList.add(company);
			
			GeRmsUserPower userPower = geRmsUserPowerRepository.findUserPowerByUserCodeComCode(userCode, comCode);
			userPowerList.add(userPower);
		}
		
		pushUserPower(nodeEntity, companyList,userCode);
		
		for(GeRmsUserPower userPower : userPowerList){
			List<GeRmsTask> taskList = geRmsTaskRepository.findTaskByPowerIdComCode(userPower.getUserPowerID(), userPower.getComCode());
			for(NodeEntity ne : nodeEntity.getChildren()){
				if(ne.getFlag().equals(userPower.getComCode())){
					pushTask(ne, taskList);
					continue;
				}
			}
		}
		return nodeEntity;
	}

	//查询出所有的Rule
	public List<GeRmsDataRule> getRuleAll(String userPowerId, String taskId) {
		// TODO Auto-generated method stub
		
		List<GeRmsDataRule> ruleAll = (List<GeRmsDataRule>) geRmsDataRuleRepository.findAll();
		List<GeRmsBusPower> busPowerList = accountManager.findByUserPowerIdTaskId(userPowerId, taskId);
		
		for(GeRmsDataRule dataRule : ruleAll){
			dataRule.setDataRuleParam("");
		}
		
		for(GeRmsBusPower busPower: busPowerList){
			for(GeRmsDataRule dataRule : ruleAll){
				if(busPower.getDataRuleID().equals(dataRule.getDataRuleID())){
					dataRule.setDataRuleParam(busPower.getDataRuleParam());
					continue;
				}
			}
		}
		return ruleAll;
	}


}
