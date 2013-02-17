package com.sinosoft.one.ams.service.facade;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.uiutil.NodeEntity;
import com.sinosoft.one.uiutil.Treeable;

@Service
public interface TaskAuthService {
	
	/**
	 * 根据机构ID，查询机构的功能，保存在一个Treeable对象，并返回
	 * 
	 * @param comCode
	 * @return
	 */
	public Treeable<NodeEntity> treeAble(String comCode);
	
	/**
	 * 保存当前机构的功能
	 * 
	 * @param strId
	 * @param comCode
	 * @param taskAuth
	 */
	public void save(String strId,String comCode,TaskAuth taskAuth);
	
}
