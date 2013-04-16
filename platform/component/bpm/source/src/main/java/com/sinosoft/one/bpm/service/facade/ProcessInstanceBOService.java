package com.sinosoft.one.bpm.service.facade;

import java.util.List;

import com.sinosoft.one.bpm.model.ProcessInstanceBOInfo;

public interface ProcessInstanceBOService {
	
	void createProcessInstanceBOInfo(ProcessInstanceBOInfo info);
	
	void removeProcessInstanceBOInfo(ProcessInstanceBOInfo info);
	
	ProcessInstanceBOInfo getProcessInstanceBOInfo(String processId, String businessId);
	
	ProcessInstanceBOInfo getProcessInstanceBOInfo(long processInstanceId);
	
	List<ProcessInstanceBOInfo> getAllNormalProcessInstanceBOInfo();
}
