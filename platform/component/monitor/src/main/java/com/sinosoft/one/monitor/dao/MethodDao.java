package com.sinosoft.one.monitor.dao;

// Generated 2012-12-21 3:30:59 by One Data Tools 1.0.0

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.model.Method;

public interface MethodDao extends PagingAndSortingRepository<Method, String> {
	@SQL("select class_name, method_name,threshold,environment,interval from ge_monitor_method where 1=1  #if(:appId!=null) {and app_id=:appId} order by id")
	List<Method> findAllByAppId(@Param("appId")String appName);
}
