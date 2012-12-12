package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Service
public interface TaskAuthService {
	
	//将机构集合保存在NodeEntity对象里
	public void push(NodeEntity nodeEntity, List<Company> companies);
	
	//通过递归，将所有机构保存在NodeEntity对象里
	public void recursionCompany(NodeEntity nodeEntity, String comCode);
	
	//将功能集合保存在NodeEntity对象里
	public void pushTask(NodeEntity nodeEntity, List<Task> taskList, String comCode);
	
	//通过递归，将所有功能保存在NodeEntity对象里
	public void recursionTask(NodeEntity nodeEntity, String parentId,String comCode);
	
	//返回一个Treeable对象
	public Treeable<NodeEntity> treeAble(String comCode);
	
	//保存当前机构的功能
	public void save(String strId,String comCode,TaskAuth taskAuth);

}
