package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.BusPower;
import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.DataRule;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.UserPower;
import com.sinosoft.one.ams.utils.uiutil.Gridable;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Service
public interface StaffingService {
	
	//保存数据设置
	public String saveBusPower(BusPower busPower,String[]ruleIdArr,String[]paramArr,String userPowerId,String taskId);
	
	//查询出所有的Rule
	public List<DataRule> getRuleAll(String userPowerId, String taskId);
	
	//检查用户权限的id是否存在，存在返回yes，否则返回no
	public String checkIdByUserCodeComCode(String userCode,String comCode);
	
	//保存用户的权限除外表、用户权限表和用户与组关系表
	public void savePower(String comCode,String userCode,String groupIdStr,String taskIdStr);
	
	
	
}
