package com.sinosoft.one.monitor.dao;

// Generated 2012-12-20 9:54:11 by One Data Tools 1.0.0

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.model.Response;

public interface ResponseDao extends PagingAndSortingRepository<Response, String>, QueryDslPredicateExecutor<Response> {
	
	@SQL("select * from ge_monitor_response where url is not null #if(:appId!=null) {and app_id=:appId} order by serialno")
	List<Response> selectResponseForDynamicComplexSql( @Param("appId") String appId);

	@SQL("select * from ge_monitor_response where url is not null order by serialno")
	List<Response> selectResponseForDynamicComplexSql();
}
