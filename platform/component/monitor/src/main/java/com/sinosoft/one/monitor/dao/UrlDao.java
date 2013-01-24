package com.sinosoft.one.monitor.dao;
// Generated 2012-12-21 3:31:23 by One Data Tools 1.0.0

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.model.Url;


public interface UrlDao extends PagingAndSortingRepository<Url, String> {
	
	@SQL("select url,name,threshold,environment,interval from ge_monitor_url where 1=1  #if(:appId!=null) {and app_id=:appId}")
	public List<Url> findAllUrlByAppId(@Param("appId")String appId);
}

