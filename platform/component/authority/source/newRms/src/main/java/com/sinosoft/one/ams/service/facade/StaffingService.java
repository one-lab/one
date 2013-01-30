package com.sinosoft.one.ams.service.facade;

import java.util.List;

import com.sinosoft.one.ams.model.BusPower;
import com.sinosoft.one.ams.model.DataRule;
import com.sinosoft.one.ams.model.UserPower;

public interface StaffingService {

	//查询出没有赋参数的数据规则
	public List<DataRule> getRules(String comCode, String userCode);
	
	//查询出有参数的数据规则
	public List<DataRule> getRuleParam(String comCode, String userCode);
	
	//查询数据规则的参数
	public List<BusPower> getParams(String comCode, String userCode,String dataRuleIdStr);
	
	//检查用户权限的id是否存在，存在返回yes，否则返回no
	public String checkIdByUserCodeComCode(String userCode,String comCode);
	
	//保存用户的权限除外表、用户权限表和用户与组关系表
	public void savePower(String comCode,String userCode,String groupIdStr,String taskIdStr);
	
	//保存数据设置
	public String saveBusPower(String comCode,String  userCode,String  ruleIdStr,String  paramStr);
	
	//查询用户权限
	public List<UserPower> findUserPowerByUserCode(String userCode);
	
	//查询用户权限
	public UserPower findUserPowerByUserCode(String userCode,String comCode);
	
	public DataRule findDataRuleByDataRuleId(String DataRuleId);
	
}
