package com.sinosoft.one.monitor.dao;
// Generated 2012-12-19 18:00:56 by One Data Tools 1.0.0

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.model.Warn;

public interface WarnDao extends PagingAndSortingRepository<Warn, String>{

	@SQL("select * from ge_monitor_warn where 1=1 #if(:appName!=null) {and app_id=:appId}  order by app_id" )
	List<Warn> findAllByAppId(@Param("appId") String appId);
}

