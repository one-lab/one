package com.sinosoft.one.bpm.util;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sinosoft.one.bpm.model.ProcessInstanceBOInfo;
import com.sinosoft.one.bpm.service.facade.ProcessInstanceBOService;

public class ProcessInstanceBOCache {
	private ProcessInstanceBOService processInstanceBOService;
	private static Logger logger = LoggerFactory.getLogger(ProcessInstanceBOCache.class);
	private LoadingCache<String, Long> processInstanceIdCache = CacheBuilder.newBuilder().build(new CacheLoader<String, Long>() {
		@Override
		public Long load(String key) throws Exception {
			logger.info("fetch from database");
			String[] keys = key.split("_");
			assert keys != null && keys.length == 2;
			ProcessInstanceBOInfo info = processInstanceBOService.getProcessInstanceBOInfo(keys[0], keys[1]);
			return info != null ? info.getProcessInstanceId() : Long.valueOf(-1L);
		}
	});
	
	private LoadingCache<Long, String> businessIdCache = CacheBuilder.newBuilder().build(
		new CacheLoader<Long, String>() {
			@Override
			public String load(Long key) throws Exception {
				return "";
			}
		}
	);
	
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
		try {
			return processInstanceIdCache.get(processId + "_" + businessId);
		} catch (ExecutionException e) {
			logger.warn("get process instance id exception. info : " + e.getLocalizedMessage());
			return Long.valueOf(-1L);
		}
	}
	
	public String getBusinessId(Long processInstanceId) {
		try {
			return businessIdCache.get(processInstanceId);
		} catch (ExecutionException e) {
			logger.warn("get business id exception. info : " + e.getLocalizedMessage());
			return "";
		}
	}

	public void setProcessInstanceBOService(
			ProcessInstanceBOService processInstanceBOService) {
		this.processInstanceBOService = processInstanceBOService;
	}
	
}
