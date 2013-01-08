package com.sinosoft.one.ams.service.facade;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Service
public interface TaskAuthService {
	
	//返回一个Treeable对象
	public Treeable<NodeEntity> treeAble(String comCode);
	
	//保存当前机构的功能
	public void save(String strId,String comCode,TaskAuth taskAuth);
	
	

}
