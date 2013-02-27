package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.TaskAuth;

@Service
public interface TaskAuthService {
	
	
	/**
	 * 根据机构代码查询所有授权功能ID
	 * @param comCode
	 * @return
	 */
	public List<String>findAllTaskIdByComCode(String comCode);
	/**
	 * 保存当前机构的功能
	 * 
	 * @param strId
	 * @param comCode
	 * @param taskAuth
	 */
	public void save(String strId,String comCode,TaskAuth taskAuth);
	
}
