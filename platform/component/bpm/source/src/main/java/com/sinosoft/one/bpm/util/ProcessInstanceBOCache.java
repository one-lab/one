package com.sinosoft.one.bpm.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.bpm.model.ProcessInstanceBOInfo;
import com.sinosoft.one.bpm.service.facade.ProcessInstanceBOService;

public class ProcessInstanceBOCache {
	private ProcessInstanceBOService processInstanceBOService;
	private static Logger logger = LoggerFactory.getLogger(ProcessInstanceBOCache.class);
	
	private Map<String, Long> processInstanceIdCache = new ConcurrentHashMap<String, Long>(16);
	private Map<Long, String> businessIdCache = new ConcurrentHashMap<Long, String>(16);
	
	public void put(String processId, String businessId, Long processInstanceId) {
		processInstanceIdCache.put(processId + "_" + businessId, processInstanceId);
		businessIdCache.put(processInstanceId, businessId);
	}
	
	public void putAndSave(String processId, String businessId, Long processInstanceId) {
		ProcessInstanceBOInfo info = new ProcessInstanceBOInfo();
		info.setBusinessId(businessId);
		info.setProcessId(processId);
		info.setProcessInstanceId(processInstanceId);
		processInstanceBOService.createProcessInstanceBOInfo(info);
		put(processId, businessId, processInstanceId);
	}
	
	public Long getProcessInstanceId(String processId, String businessId) {
		Long value = processInstanceIdCache.get(processId + "_" + businessId);
		if(value == null) {
			synchronized (ProcessInstanceBOCache.class) {
				if(value == null) {
					logger.info("fetch from database");
					ProcessInstanceBOInfo info = processInstanceBOService.getProcessInstanceBOInfo(processId, businessId);
					value = info != null ? info.getProcessInstanceId() : null;
					if(value != null) {
						put(processId, businessId, value);
					}
				}
			}
		}
		return value;
	}
	
	public String getBusinessId(Long processInstanceId) {
		return businessIdCache.get(processInstanceId);
	}

	public void setProcessInstanceBOService(
			ProcessInstanceBOService processInstanceBOService) {
		this.processInstanceBOService = processInstanceBOService;
	}
	
	public void removeFromCache(String processId, String processInstanceId) {
		String businessId = businessIdCache.get(processInstanceId);
		if(StringUtils.isNotBlank(businessId)) {
			processInstanceIdCache.remove(processId + "_" + businessId);
			businessIdCache.remove(processInstanceId);
		}
	}
	
}
