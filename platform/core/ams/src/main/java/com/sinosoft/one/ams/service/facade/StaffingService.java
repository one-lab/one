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
	
	//递归用户未引入的机构，并将机构保存在NodeEntity中
	public void recursionCompany(NodeEntity nodeEntity, String comCode,String userCode);
	
	//将机构保存在NodeEntity对象中
	public void pushCompany(NodeEntity nodeEntity, List<Company> companies) ;
	
	//将功能保存在NodeEntity对象中
	public void pushTask(NodeEntity nodeEntity, List<Task> taskList);
	
	//根据userCode和company查询GeRmsUserPower对象并保存在NodeEntity对象中
	public void pushUserPower(NodeEntity nodeEntity, List<Company> companies,String userCode);
	
	//将数据库中的用户记录查出，并保存在Gridable对象中返回
	public Gridable<Employe> getGridable(Gridable<Employe> gridable,Pageable pageable,List<String> userAttribute);
	
	//根据userCode和comCode，将数据库中的用户记录查出，并保存在Gridable对象中返回
	public Gridable<Employe> getGridable(Gridable<Employe> gridable,String userCode,String comCode,Pageable pageable,List<String> userAttribute);
	
	//根据userCode和comCode,经用户已引入的机构的功能存入相应的机构中
	public NodeEntity getNodeEntity(NodeEntity nodeEntity,String userCode,List<Company> companyList,List<UserPower> userPowerList);
	
	//查询出所有的Rule
	public List<DataRule> getRuleAll(String userPowerId, String taskId);
	
	//-----------hening
	
	//检查用户权限的id是否存在，存在返回yes，否则返回no
	public String checkIdByUserCodeComCode(String userCode,String comCode);
	
	//根据机构Id，查询机构的用户组
	public List<Group> findGroupByComCode(String comCode);
	
	//保存用户的权限除外表、用户权限表和用户与组关系表
	public void savePower(String comCode,String userCode,String groupIdStr,String taskIdStr);
	
	
	
}
