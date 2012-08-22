package com.sinosoft.one.rms.service.picc;

import java.util.Set;

import com.sinosoft.one.rms.model.Task;

public interface TaskService {
	
	/**
	 * 根据用户组类型，获得功能集合
	 * @param addType
	 * @return
	 */
	public Set<Task> findTaskAuthByType(String addType);
	
}
