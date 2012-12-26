package com.sinosoft.one.ams.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.BusPower;
import com.sinosoft.one.ams.model.DataRule;
import com.sinosoft.one.ams.model.ExcPower;
import com.sinosoft.one.ams.model.UserGroup;
import com.sinosoft.one.ams.model.UserPower;
import com.sinosoft.one.ams.repositories.GeRmsDataRuleRepository;
import com.sinosoft.one.ams.repositories.GeRmsExcPowerRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.repositories.GeRmsUserGroupRepository;
import com.sinosoft.one.ams.repositories.GeRmsUserPowerRepository;
import com.sinosoft.one.ams.service.facade.StaffingService;

@Component
public class StaffingServiceImpl implements StaffingService{

	@Autowired
	private GeRmsGroupRepository geRmsGroupRepository;
	@Autowired
	private GeRmsUserPowerRepository geRmsUserPowerRepository;
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private GeRmsDataRuleRepository geRmsDataRuleRepository;
	@Autowired
	private GeRmsExcPowerRepository geRmsExcPowerRepository;
	@Autowired
	private GeRmsUserGroupRepository geRmsUserGroupRepository;
	
	//检查用户权限的id是否存在，存在返回yes，否则返回no
		public String checkIdByUserCodeComCode(String userCode, String comCode) {
			System.out.println(userCode);
			System.out.println(comCode);
			String id = geRmsUserPowerRepository.findIdByUserCodeComCode(userCode, comCode);
			String result = "no";
			if(id != null){
				result = "yes";
			}
			return result;
		}
		
		//保存用户的权限除外表、用户权限表和用户与组关系表
		public void savePower(String comCode, String userCode, String groupIdStr, String taskIdStr) {
			
			String userPowerId = geRmsUserPowerRepository.findIdByUserCodeComCode(userCode, comCode);
			if(userPowerId == null){
				UserPower up = new UserPower();
				up.setComCode(comCode);
				up.setUserCode(userCode);
				up.setIsValidate("1");
				geRmsUserPowerRepository.save(up);
				
				String[]groupIds = groupIdStr.split(",");
				if(groupIds.length > 0){
					for(String id : groupIds){
						UserGroup ug = new UserGroup();
						ug.setGroup(geRmsGroupRepository.findOne(id));
						ug.setUserCode(userCode);
						ug.setUserPower(up);
						ug.setIsValidate("1");
						geRmsUserGroupRepository.save(ug);
						
					}
				}
				
				if(!taskIdStr.toString().equals("null")){
					String[] taskId = taskIdStr.split(",");
					if(taskId.length > 0){
						for(String id : taskId){
							ExcPower ep = new ExcPower();
							ep.setTask(geRmsTaskRepository.findOne(id));
							ep.setUserPower(up);
							ep.setIsValidate("1");
							geRmsExcPowerRepository.save(ep);
						}
					}
				}
			}else{
				UserPower userPower = geRmsUserPowerRepository.findOne(userPowerId);
				
				List<UserGroup>userGroups = userPower.getUserGroups();
				//删除关联用户组记录
				geRmsUserGroupRepository.delete(userGroups);
				List<ExcPower> excPowers = userPower.getExcPowers();
				//删除关联权限除外表记录
				geRmsExcPowerRepository.delete(excPowers);
				
				String[]groupIds = groupIdStr.split(",");
				if(groupIds.length > 0){
					for(String id : groupIds){
						UserGroup ug = new UserGroup();
						ug.setGroup(geRmsGroupRepository.findOne(id));
						ug.setUserCode(userCode);
						ug.setUserPower(userPower);
						ug.setIsValidate("1");
						geRmsUserGroupRepository.save(ug);
						
					}
				}
				
				if(!taskIdStr.toString().equals("null")){
					String[] taskId = taskIdStr.split(",");
					if(taskId.length > 0){
						for(String id : taskId){
							ExcPower ep = new ExcPower();
							ep.setTask(geRmsTaskRepository.findOne(id));
							ep.setUserPower(userPower);
							ep.setIsValidate("1");
							geRmsExcPowerRepository.save(ep);
						}
					}
				}
			}

		}
		
		//查询出所有的Rule
		public List<DataRule> getRuleAll(String userPowerId, String taskId) {
			
			List<DataRule> ruleAll = (List<DataRule>) geRmsDataRuleRepository.findAll();
			for(DataRule dataRule : ruleAll){
				dataRule.setBusPowers(null);
			}
//			List<BusPower> busPowerList = accountManager.findByUserPowerIdTaskId(userPowerId, taskId);
//
//			for(BusPower busPower: busPowerList){
//				for(DataRule dataRule : ruleAll){
//					if(busPower.getDataRuleID().equals(dataRule.getDataRuleID())){
//						dataRule.setDataRuleParam(busPower.getDataRuleParam());
//						continue;
//					}
//				}
//			}
			return ruleAll;
		}

		public String saveBusPower(BusPower busPower, String[] ruleIdArr,
				String[] paramArr, String userPowerId, String taskId) {
			// TODO Auto-generated method stub
			return null;
		}	
	
	//保存数据设置
//	public String saveBusPower(BusPower busPower, String[] ruleIdArr,String[] paramArr, String userPowerId, String taskId) {
		
//		List<String> dataRuleIdList = geRmsBusPowerRepository.findDataRuleIdByUserPowerIdTaskId(userPowerId, taskId,"1");
//		
//		if(dataRuleIdList != null){
//			for(int i = 0; i<ruleIdArr.length;i++){
//				if(!dataRuleIdList.contains(ruleIdArr[i])){
//					
//					busPower.setBusPowerID(ruleIdArr[i]+taskId);
//					busPower.setDataRuleID(ruleIdArr[i]);
//					busPower.setUserPowerID(userPowerId);
//					busPower.setTaskID(taskId);
//					busPower.setDataRuleParam(paramArr[i]);
//					busPower.setIsValidate("1");
//					
//					geRmsBusPowerRepository.save(busPower);
//				}else if(dataRuleIdList.contains(ruleIdArr[i])){
//					busPower = geRmsBusPowerRepository.findByUserPowerIdTaskIdDataRuleId(userPowerId, taskId, ruleIdArr[i]);
//					busPower.setDataRuleParam(paramArr[i]);
//					geRmsBusPowerRepository.updateBusPower(paramArr[i], busPower.getBusPowerID());
//				}
//			}
//			for(String dataRuleId : dataRuleIdList){
//				if(!isIn(dataRuleId,ruleIdArr)){
//					busPower = geRmsBusPowerRepository.findByUserPowerIdTaskIdDataRuleId(userPowerId, taskId, dataRuleId);
//					geRmsBusPowerRepository.delete(busPower);
//				}
//			}
//		}
//		
//		return "success";
//	}
//	
//	public static boolean isIn(String substring, String[] arr) {
//		if (arr == null || arr.length == 0) {
//			return false;
//		}
//		for (int i = 0; i < arr.length; i++) {
//			String aSource = arr[i];
//			if (aSource.equals(substring)) {
//				return true;
//			}
//		}
//		return false;
//	}

//	

}
