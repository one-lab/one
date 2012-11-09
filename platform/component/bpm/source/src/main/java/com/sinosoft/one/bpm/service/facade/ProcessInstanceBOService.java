package com.sinosoft.one.bpm.service.facade;

import com.sinosoft.one.bpm.model.ProcessInstanceBOInfo;

public interface ProcessInstanceBOService {
	
	void createProcessInstanceBOInfo(ProcessInstanceBOInfo info);
	
	ProcessInstanceBOInfo getProcessInstanceBOInfo(String processId, String businessId);
	
	ProcessInstanceBOInfo getProcessInstanceBOInfo(Long processInstanceId);
}
