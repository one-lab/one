package com.sinosoft.one.bpm.util;

import org.drools.event.process.DefaultProcessEventListener;
import org.drools.event.process.ProcessCompletedEvent;
import org.drools.runtime.process.ProcessInstance;

public class BpmProcessEventListener extends DefaultProcessEventListener {
	private ProcessInstanceBOCache cache;
	
	public void afterProcessCompleted(ProcessCompletedEvent event) {
		ProcessInstance pi = event.getProcessInstance();
		String processId = pi.getProcessId();
		String processInstanceId = pi.getId() + "";
		
		cache.removeFromCache(processId, processInstanceId);
	}

	public void setCache(ProcessInstanceBOCache cache) {
		this.cache = cache;
	}
}
