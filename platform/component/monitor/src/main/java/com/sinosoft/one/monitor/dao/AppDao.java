package com.sinosoft.one.monitor.dao;
// Generated 2013-1-4 10:34:23 by One Data Tools 1.0.0

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.model.App;

public interface AppDao extends PagingAndSortingRepository<App, String> {
	
	@SQL("select * from ge_monitor_app where 1=1 #if(:appName!=null) {and name=:appName}")
	public App findOneByName(@Param("appName")String appName);
}

